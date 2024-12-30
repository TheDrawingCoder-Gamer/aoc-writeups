{%
aoc.day = 6
%}

# Day 6: Lanternfish

@:include(/inc/solutionHeader.md)

I've decided to come back to 2021 to writeup some of my favorite days - day 6 is one of my favorites and
its second part uses a data structure that is very useful for these types of problems.

As with other 2021 days, I'm going to write haskell and scala at the same time. I'm going to mostly
cover my Scala solution, but my haskell solution has the same idea.

## Solution Summary

1. Parse input into a `Vector[Int]`
2. Advance this state `n` times
    * In part 1, `n` is 80
    * In part 2, `n` is 256

## Part 1

Let's make a helper function to iterate `n` times:

@:select(language)
@:choice(scala)
```scala 3
extension[A] (f: A => A)
  def repeated(n: Int): A => A = { (x: A) =>
    Iterator.iterate(x)(f).drop(n).next()
  }
```
@:choice(haskell)
The haskell version of the above code is so concise that I don't even bother making a special function for it.
We iterate, and index into the `n`th position. 
```haskell
iterate advance fish !! 80
```

@:@

Then let's parse our input:

@:select(language)
@:choice(scala)
```scala 3
def parse(str: String): Vector[Int] =
   str.split(",").map(_.toInt).toVector
```
@:choice(haskell)
For haskell 2022 me decided to just use `read`.
```haskell
parse :: Read a => String -> [a]
parse str = read ("[" ++ str ++ "]")
```
@:@

Now let's make our `advance` function:

@:select(language)
@:choice(scala)
```scala 3
def advance(fish: Vector[Int]): Vector[Int] =
   fish.map {
      case 0 => 6
      case 1 => 0
      case 2 => 1
      case 3 => 2
      case 4 => 3
      case 5 => 4
      case 6 => 5
      case 7 => 6
      case 8 => 7
      case _ => assert(false)
   }.prependedAll(List.fill(fish.count(_ == 0))(8))
```
@:choice(haskell)
This is a bit of a spoiler, but this is new 2024 code that is just the above code translated.
I didn't bother to leave my old naive solution when writing this in 2022.
```haskell
mapFish :: Int -> Int
mapFish 0 = 6
mapFish 1 = 0
mapFish 2 = 1
mapFish 3 = 2
mapFish 4 = 3
mapFish 5 = 4
mapFish 6 = 5
mapFish 7 = 6
mapFish 8 = 7
mapFish _ = undefined

advance :: [Int] -> [Int]
advance fish =
   replicate (length (filter (== 0) fish)) 8 ++ map mapFish fish
```
@:@

Now we can solve part 1:

@:select(language)
@:choice(scala)
```scala 3
def part1(fish: Vector[Int]): Long =
   advance.repeated(80)(input).size
```
@:choice(haskell)
```haskell
part1 :: [Int] -> Int
part1 fish =
   length (iterate advance fish !! 80)
```
@:@

## Part 2

Part 2 breaks this - too many lanternfish. Even if we waited as long as would be required, 
it exceeds the Int limit anyway. We have to try something else.

Something that is useful in many problems (the most recent AoC as of writing is day 11 2024) is a
frequency map. This is especially useful here as there are only 9 valid states. A frequency map can substitute
a list of values whenever the order doesn't matter. 

The haskell and scala solutions differ slightly. The Haskell solution uses a List of length 9, while
scala just uses a Map. I tried using a Tuple in scala but I found it too cumbersome to construct compared to a map.

We're going to write new functions for advancing the frequency map:

@:select(language)
@:choice(scala)
```scala 3
def advanceP2(map: Map[Int, Long]): Map[Int, Long] =
   Map(
      0 -> map.getOrElse(1, 0L),
      1 -> map.getOrElse(2, 0L),
      2 -> map.getOrElse(3, 0L),
      3 -> map.getOrElse(4, 0L),
      4 -> map.getOrElse(5, 0L),
      5 -> map.getOrElse(6, 0L),
      6 -> (map.getOrElse(0, 0L) + map.getOrElse(7, 0L)),
      7 -> map.getOrElse(8, 0L),
      8 -> map.getOrElse(0, 0L)
   )
```
@:choice(haskell)
```haskell
advanceP2 :: [Int] -> [Int]
advanceP2 [n0, n1, n2, n3, n4, n5, n6, n7, n8] =
   [n1, n2, n3, n4, n5, n6, n0 + n7, n8, n0]
advanceP2 _ = undefined
```
@:@

Then we can make part 2 functions that assemble the map and advance it 256 times.

@:select(language)
@:choice(scala)
```scala 3
def part2(input: Vector[Int]): Long =
   val fishMap = input.groupBy(identity).map(it => it._1 -> it._2.length.toLong)
   advanceP2.repeated(256)(fishMap).foldLeft(0L):
      case (acc, (_, v)) => acc + v
```
@:choice(haskell)
```haskell
part2 :: [Int] -> Int
part2 fish =
   sum $ iterate advanceP2 fish' !! 256
   where
      fish' = map (subtract 1 . length) ((group . sort) ([0..8] ++ fish))
```
This haskell code needs some explaining. To ensure all slots are in correct places, I add `[0..8]` to the list, then
subtract 1 from the final count.
@:@

@:solution