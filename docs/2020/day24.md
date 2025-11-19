{% aoc.day = 24 %}

# Day 24: Lobby Layout

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `List[List[HexDir]]`
2. Calculate Set of black tiles
3. For part 2, perform conway steps on this set

## Part 1

Let's first model our input. We are on a hexagonal grid, with our pointy bits on the Y axis (up and down),
so we have our actual directions East, South East, South West, West, North West, and North East.

Let's model these:
```scala 3
enum HexDir:
  case East
  case SouthEast
  case SouthWest
  case West
  case NorthWest
  case NorthEast
```


Now parsing is actually a tiny bit difficult here. You could do it imperatively, but I decided to
just pull in parsley and use parser combinators. Yes, a bit overkill, but saves me a headache.

```scala 3
object HexDir:
  import parsley.*
  import parsley.character.strings
  lazy val parser =
    strings(
      "se",
      "sw",
      "nw",
      "ne",
      "w",
      "e"
    ).map:
      case "e"  => East
      case "se" => SouthEast
      case "sw" => SouthWest
      case "w"  => West
      case "nw" => NorthWest
      case "ne" => NorthEast
  lazy val parseMany = Parsley.some(parser)

def parse(str: String): List[List[HexDir]] =
  str.linesIterator.map: line =>
    HexDir.parseMany.parse(line).get
  .toList
```

Now we'll actually have to figure out how to represent our coordinates. I found this [excellent guide](https://www.redblobgames.com/grids/hexagons/)
on hexagonal grids, and I'll be using the cube coordinate system. 

This system is based on a diagonal slice of a Cube at @:latex x + y + z = 0 @:@. There aren't "traditional axes",
as every movement changes at least two coordinates, but I don't think I need to explain this too explicitly -
if you're interested in specifics look at the website I linked.

All that matters for us is that we can uniquely identify each tile with a hex coordinate, starting from 0, 0, 0.
Here's a definition of the class, including movement and a way to convert an input line `List[HexDir]` into a coordinate

```scala 3
final case class HexCoord(q: Int, r: Int, s: Int):
  def move(dir: HexDir): HexCoord =
    dir match
      // Note that each move, one stays the same, one is +1, other is -1
      // This is to preserve the x + y + z = 0 invariant from our above
      // definition
      case HexDir.East      => HexCoord(q + 1, r, s - 1)
      case HexDir.SouthEast => HexCoord(q, r + 1, s - 1)
      case HexDir.SouthWest => HexCoord(q - 1, r + 1, s)
      // You will also notice that inverse directions add the inverse values
      case HexDir.West      => HexCoord(q - 1, r, s + 1)
      case HexDir.NorthWest => HexCoord(q, r - 1, s + 1)
      case HexDir.NorthEast => HexCoord(q + 1, r - 1, s)
  
object HexCoord:
  def identify(from: List[HexDir]): HexCoord =
    from.foldLeft(HexCoord(0, 0, 0))((a, dir) => a.move(dir))
```

Part 1 and part 2 will both have to get the set of black tiles, so let's just extract that logic into a common function:
```scala 3
def determineStart(input: List[List[HexDir]]): Set[HexCoord] =
  input.foldLeft(Set.empty[HexCoord]): (blackUp, tile) =
    val realCoord = HexCoord.identify(tile)
    if blackUp(realCoord) then blackUp - realCoord else blackUp + realCoord
```

Then part 1 is a simple call to `determineStart`:
```scala 3
def part1(input: List[List[HexDir]]): Int =
  determineStart(input).size
```

## Part 2

Conway's game of life is something we've [done before this year](/2020/day17.md), and
I've already defined a common function `conwayStep`:
```scala 3
def conwayStep[A](
  neighbors: A => Iterable[A],
  testKeepAlive: Int => Boolean,
  testBorn: Int => Boolean)(state: Set[A]): Set[A]
```

First, we'll need to define our neighbors function.
```scala 3
// inserting...
final case class HexCoord(q: Int, r: Int, s: Int):
  // ...
  def neighbors: List[HexCoord] = HexDir.values.map(this.move).toList
```

Then, we'll plug in our problem values to `conwayStep`:

```scala 3
val step = conwayStep[HexCoord](_.neighbors, it => it == 1 || it == 2, _ == 2)
```

Then our part 2 is simple from there:
```scala 3
def part2(input: List[List[HexDir]]): Int =
  val state = determineStart(input)
  step.repeated(100)(state).size
```

## Final Code

```scala 3
enum HexDir:
  case East
  case SouthEast
  case SouthWest
  case West
  case NorthWest
  case NorthEast
object HexDir:
  import parsley.*
  import parsley.character.strings
  lazy val parser =
    strings(
      "se",
      "sw",
      "nw",
      "ne",
      "w",
      "e"
    ).map:
      case "e"  => East
      case "se" => SouthEast
      case "sw" => SouthWest
      case "w"  => West
      case "nw" => NorthWest
      case "ne" => NorthEast
  lazy val parseMany = Parsley.some(parser)

def parse(str: String): List[List[HexDir]] =
  str.linesIterator.map: line =>
    HexDir.parseMany.parse(line).get
  .toList

final case class HexCoord(q: Int, r: Int, s: Int):
  def move(dir: HexDir): HexCoord =
    dir match
      case HexDir.East      => HexCoord(q + 1, r, s - 1)
      case HexDir.SouthEast => HexCoord(q, r + 1, s - 1)
      case HexDir.SouthWest => HexCoord(q - 1, r + 1, s)
      case HexDir.West      => HexCoord(q - 1, r, s + 1)
      case HexDir.NorthWest => HexCoord(q, r - 1, s + 1)
      case HexDir.NorthEast => HexCoord(q + 1, r - 1, s)
  def neighbors: List[HexCoord] = HexDir.values.map(this.move).toList
object HexCoord:
  def identify(from: List[HexDir]): HexCoord =
    from.foldLeft(HexCoord(0, 0, 0))((a, dir) => a.move(dir))

def determineStart(input: List[List[HexDir]]): Set[HexCoord] =
  input.foldLeft(Set.empty[HexCoord]): (blackUp, tile) =
    val realCoord = HexCoord.identify(tile)
    if blackUp(realCoord) then blackUp - realCoord else blackUp + realCoord

def part1(input: List[List[HexDir]]): Int =
  determineStart(input).size

val step = conwayStep[HexCoord](_.neighbors, it => it == 1 || it == 2, _ == 2)

def part2(input: List[List[HexDir]]): Int =
  val state = determineStart(input)
  step.repeated(100)(state).size
```

@:benchmarkSection {
    overrideP1 = us
    overrideP2 = ms
}

@:solution