{% aoc.day = 5 %}

# Day 5: Hydrothermal Venture

Skipping over day 4 for now (the original folder is empty), let's move on to Day 5.

## Solution Summary

1. Parse input into a `List[Line]`
2. Calculate overlapping points
   * For part 1, we ignore diagonal lines
   * For part 2, we include diagonal lines

## Part 1

I want to note how different our Scala and Haskell solutions are today. Scala uses mutability because the
immutable version was very slow (50s on JS!). This version solves in under a second. Haskell is immutable because
it's Haskell : ).

Let's define our types of `Line`, and we'll also define what orientation a line can be with `LineOrientation`


@:select(language)
@:choice(scala)
```scala 3
import common.Vec2i

case class Line(start: Vec2i, end: Vec2i)

enum LineOrientation:
  case Horizontal, Vertical, Diagonal, Point
```
@:choice(haskell)
```haskell
newtype Line = Line (Int, Int, Int, Int)
type Point = (Int, Int)
data LineOrientation = Horizontal | Vertical | Diagonal | Point deriving (Eq, Show)
```
@:@

Now let's move on to parsing the lines:

@:select(language)
@:choice(scala)
```scala 3
def parse(input: String): List[Line] =
  input.linesIterator.map:
    case s"$x1,$y1 -> $x2,$y2" => Line(Vec2i(x1.toInt, y1.toInt), Vec2i(x2.toInt, y2.toInt))
  .toList
```
@:choice(haskell)
```haskell
parse :: String -> [Line]
parse str =
    let 
        daLines = lines str
    in
        map parseLine daLines

parseLine :: String -> Line
parseLine str = 
    let (first:xs) = splitOn "->" (trim str)
        lastElem = head xs 
        nums1 = splitOn "," $ trim first
        nums2 = splitOn "," $ trim lastElem 
        x1 = read $ head nums1
        y1 = read $ last nums1 
        x2 = read $ head nums2
        y2 = read $ last nums2 in
            Line (x1, y1, x2, y2)
```
@:@

We have to make a line figure out its orientation, so let's do that now.

@:select(language)
@:choice(scala)
```scala 3
case class Line(start: Vec2i, end: Vec2i):
  def orientation: LineOrientation =
    if start == end then
      LineOrientation.Point
    else if start.x == end.x then
      LineOrientation.Vertical
    else if start.y == end.y then
      LineOrientation.Horizontal
    else
      LineOrientation.Diagonal
```
@:choice(haskell)
```haskell
getLineOrientation :: Line -> LineOrientation 
getLineOrientation (Line (x1, y1, x2, y2))
    | x1 == x2 && y1 == y2 = Point
    | x1 == x2 = Vertical 
    | y1 == y2 = Horizontal 
    | otherwise = Diagonal
```
@:@

Now let's calculate what a line covers. For part 1 we don't know enough about diagonal lines, and we are ignoring them
anyway, so let's just error if we encounter one.

@:select(language)
@:choice(scala)
```scala 3
case class Line(start: Vec2i, end: Vec2i):
  // ...
  def covers: Set[Vec2i] =
    orientation match
      case LineOrientation.Point      => Set(this.start)
      case LineOrientation.Horizontal => (math.min(start.x, end.x) to math.max(start.x, end.x)).map(x => Vec2i(x, start.y)).toSet
      case LineOrientation.Vertical   => (math.min(start.y, end.y) to math.max(start.y, end.y))
        .map(y => Vec2i(start.x, y)).toSet
      case LineOrientation.Diagonal   => ???
```
@:choice(haskell)
```haskell
lineCovers :: Line -> Set.Set Point
lineCovers ln@(Line (x1, y1, x2, y2)) =
    case getLineOrientation ln of
        Horizontal -> Set.fromList [(x, y2) | x <- [min x1 x2..max x1 x2]] 
        Vertical   -> Set.fromList [(x1, y) | y <- [min y1 y2..max y1 y2]]
        Point      -> Set.singleton (x1, y1)
        Diagonal   -> undefined
```
@:@

Here's the significant difference between the two languages: calculating the points where there is overlap. Scala is mutable,
but Haskell is immutable. Scala performs better here being mutable and it's unusably slow on JS if you try to make it immutable.

@:select(language)
@:choice(scala)
```scala 3
import scala.collection.mutable as mut

extension (map: mut.HashMap[Vec2i, Int])
  def updateInPlaceField(line: Line): Unit =
    val daSet = line.covers
    daSet.foreach: p =>
      map.updateWith(p):
        case Some(v) => Some(v + 1)
        case None => Some(1)

  def countDanger: Int = map.count((_, i) => i >= 2)
```
@:choice(haskell)
```haskell
updateField :: M.Map Point Int -> Set.Set Point -> M.Map Point Int
updateField daMap pts = 
    let ptsMap = M.fromSet (const 1) pts in
            M.unionWith (+) daMap ptsMap

getDangerField :: M.Map Point Int -> [Line] -> M.Map Point Int
getDangerField =
    foldl $ \x y -> updateField x (lineCovers y)

countDanger :: M.Map Point Int -> [Line] -> Int
countDanger field lns = M.size $ M.filter (>= 2) $ getDangerField field lns
```
@:@

Now we can do part 1:

@:select(language)
@:choice(scala)
```scala 3
def part1(input: List[Line]): Int =
  val daMap = mut.HashMap.empty[Vec2i, Int]
  input.filter(_.orientation != LineOrientation.Diagonal).foreach(daMap.updateInPlaceField)

  daMap.countDanger
```
@:choice(haskell)
```haskell
part1 :: [Line] -> Int
part1 lines =
    countDanger M.empty $ filter (\x -> getLineOrientation x /= Diagonal) lines
```
@:@

## Part 2

Part 2's difference is just including diagonal lines. We'll only have to update `Line#covers` to calculate the covered points.

I get to show off a feature of cats that I find really cool: `Parallel`. This encodes types that have a `Monad`, and an alternative type
with the same structure that has an `Applicative` instance. `List`'s instance turns it into `ZipList`, which is an applicative functor based on zipping.
Haskell's `ZipList` has the same `Applicative` implementation as Cats' `ZipList`. Using `parMapN` on a tuple of `M[T]` converts all the `M`'s into the
`Parallel`'s alternative type (so `A[T]`) and `ap`s them all together. In Haskell we just use `zip` because it's not that hard to do and its more cumbersome to use
`ZipList`'s applicative instance. This is kind of a lot, so feel free to look at [Cats' docs for `Parallel`](https://typelevel.org/cats/typeclasses/parallel.html)

Let's update `Line#covers` to account for diagonal lines:

@:select(language)
@:choice(scala)
```scala 3
import cats.syntax.all.*

case class Line(start: Vec2i, end: Vec2i):
  def covers: Set[Vec2i] =
    orientation match
      case LineOrientation.Point => Set(this.start)
      case LineOrientation.Horizontal => (math.min(start.x, end.x) to math.max(start.x, end.x)).map(x => Vec2i(x, start.y)).toSet
      case LineOrientation.Vertical => (math.min(start.y, end.y) to math.max(start.y, end.y))
        .map(y => Vec2i(start.x, y)).toSet
      case LineOrientation.Diagonal =>
        ((start.x to end.x by math.signum(end.x - start.x)).toList,
          (start.y to end.y by math.signum(end.y - start.y)).toList).parMapN(Vec2i.apply)
        .toSet
```
@:choice(haskell)
```haskell
lineCovers :: Line -> Set.Set Point
lineCovers ln@(Line (x1, y1, x2, y2)) =
    case getLineOrientation ln of
        Horizontal -> Set.fromList [(x, y2) | x <- [min x1 x2..max x1 x2]] 
        Vertical   -> Set.fromList [(x1, y) | y <- [min y1 y2..max y1 y2]]
        Point      -> Set.singleton (x1, y1)
        Diagonal   -> Set.fromList $ zip [x1, x1 + signum (x2 - x1) .. x2] [y1, y1 + signum (y2 - y1) .. y2]
```
@:@

Now we can do part 2:

@:select(language)
@:choice(scala)
```scala 3
def part2(input: List[Line]): Int =
   val daMap = mut.HashMap.empty[Vec2i, Int]
   input.foreach(daMap.updateInPlaceField)

   daMap.countDanger
```
@:choice(haskell)
```haskell
part2 :: [Line] -> Int
part2 = countDanger M.empty
```
@:@

## Final Code

@:select(language)
@:choice(scala)
```scala 3
import common.Vec2i
import cats.syntax.all.*

import scala.collection.mutable as mut

case class Line(start: Vec2i, end: Vec2i):
  def orientation: LineOrientation =
    if start == end then
      LineOrientation.Point
    else if start.x == end.x then
      LineOrientation.Vertical
    else if start.y == end.y then
      LineOrientation.Horizontal
    else
      LineOrientation.Diagonal

  def covers: Set[Vec2i] =
    orientation match
      case LineOrientation.Point => Set(this.start)
      case LineOrientation.Horizontal => (math.min(start.x, end.x) to math.max(start.x, end.x)).map(x => Vec2i(x, start.y)).toSet
      case LineOrientation.Vertical => (math.min(start.y, end.y) to math.max(start.y, end.y))
        .map(y => Vec2i(start.x, y)).toSet
      case LineOrientation.Diagonal =>
        ((start.x to end.x by math.signum(end.x - start.x)).toList,
          (start.y to end.y by math.signum(end.y - start.y)).toList).parMapN(Vec2i.apply)
        .toSet
enum LineOrientation:
  case Horizontal, Vertical, Diagonal, Point

def parse(input: String): List[Line] =
  input.linesIterator.map:
    case s"$x1,$y1 -> $x2,$y2" => Line(Vec2i(x1.toInt, y1.toInt), Vec2i(x2.toInt, y2.toInt))
  .toList

extension[A, B] (map: Map[A, B])
  def unionWith(that: Map[A, B])(f: (B, B) => B): Map[A, B] =
    map.padZipWith(that):
      case (Some(v), None) => v
      case (None, Some(v)) => v
      case (Some(v), Some(w)) => f(v, w)

extension (map: mut.HashMap[Vec2i, Int])
  def updateInPlaceField(line: Line): Unit =
    val daSet = line.covers
    daSet.foreach: p =>
      map.updateWith(p):
        case Some(v) => Some(v + 1)
        case None => Some(1)

  def countDanger: Int = map.count((_, i) => i >= 2)

def part1(input: List[Line]): Int =
  val daMap = mut.HashMap.empty[Vec2i, Int]
  input.filter(_.orientation != LineOrientation.Diagonal).foreach(daMap.updateInPlaceField)

  daMap.countDanger

def part2(input: List[Line]): Int =
  val daMap = mut.HashMap.empty[Vec2i, Int]
  input.foreach(daMap.updateInPlaceField)

  daMap.countDanger
```
@:choice(haskell)
```haskell
{-# LANGUAGE ImportQualifiedPost #-}


import Data.List.Extra (splitOn, trim)
import Data.Ix (range)
import Data.Map.Strict qualified as M
import Data.Set qualified as Set


newtype Line = Line (Int, Int, Int, Int) deriving (Show)
type Point = (Int, Int)
data LineOrientation = Horizontal | Vertical | Diagonal | Point deriving (Eq, Show)


parse :: String -> [Line]
parse str =
    let 
        daLines = lines str
    in
        map parseLine daLines

parseLine :: String -> Line
parseLine str = 
    let (first:xs) = splitOn "->" (trim str)
        lastElem = head xs 
        nums1 = splitOn "," $ trim first
        nums2 = splitOn "," $ trim lastElem 
        x1 = read $ head nums1
        y1 = read $ last nums1 
        x2 = read $ head nums2
        y2 = read $ last nums2 in
            Line (x1, y1, x2, y2)

updateField :: M.Map Point Int -> Set.Set Point -> M.Map Point Int
updateField daMap pts = 
    let ptsMap = M.fromSet (const 1) pts in
            M.unionWith (+) daMap ptsMap
getLineOrientation :: Line -> LineOrientation 
getLineOrientation (Line (x1, y1, x2, y2))
    | x1 == x2 && y1 == y2 = Point
    | x1 == x2 = Vertical 
    | y1 == y2 = Horizontal 
    | otherwise = Diagonal

lineCovers :: Line -> Set.Set Point
lineCovers ln@(Line (x1, y1, x2, y2)) =
    case getLineOrientation ln of
        Horizontal -> Set.fromList [(x, y2) | x <- [min x1 x2..max x1 x2]] 
        Vertical   -> Set.fromList [(x1, y) | y <- [min y1 y2..max y1 y2]]
        Point      -> Set.singleton (x1, y1)
        Diagonal   -> Set.fromList $ zip [x1, x1 + signum (x2 - x1) .. x2] [y1, y1 + signum (y2 - y1) .. y2]

getDangerField :: M.Map Point Int -> [Line] -> M.Map Point Int
getDangerField =
    foldl $ \x y -> updateField x (lineCovers y)

countDanger :: M.Map Point Int -> [Line] -> Int
countDanger field lns = M.size $ M.filter (>= 2) $ getDangerField field lns

part1 :: [Line] -> Int
part1 lines =
    countDanger M.empty $ filter (\x -> getLineOrientation x /= Diagonal) lines

part2 :: [Line] -> Int
part2 = countDanger M.empty
```
@:@

@:solution