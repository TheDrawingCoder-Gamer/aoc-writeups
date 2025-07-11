{% aoc.day = 7 %}

# Day 7: The Treachery of Whales

@:include(/inc/solutionHeader.md)

This day is a fun one because the solution (for part 2 at least) isn't immediately obvious. My Haskell solution was incorrect for part 2,
with a code comment stating that it was solved with GHCi. I was able to find a solution though.

## Solution Summary

1. Parse input into `List[Int]`
2. Find the point that requires the least fuel to align all crabs to

## Part 1

Part 1 isn't too bad. We have to find the point where the crabs will have to move the least. The median (for some reason,
I don't remember the reasoning) is this point.

Let's first parse our input:

@:select(language)
@:choice(scala)
```scala 3
def parse(input: String): List[Int] =
  input.trim.split(",").map(_.toInt).toList
```
@:choice(haskell)
```haskell
parse :: String -> [Int]
parse str = read ("[" ++ str ++ "]")
```
@:@

Let's then find the median:

@:select(language)
@:choice(scala)
```scala 3
def median(input: List[Int]): Int =
  val len = input.length
  val l = len.toDouble / 2.0
  val ll = l.floor.toInt
  val lu = l.ceil.toInt
  val sorted = input.sorted
  if ll == lu then
    sorted(ll)
  else
    math.max(sorted(ll), sorted(lu))
```
@:choice(haskell)
```haskell
median :: [Int] -> Int
median xs = let len = length xs 
                l = fromIntegral len / 2
                ll = floor l
                lu = ceiling l 
                sorted = sort xs in
                  if ll == lu then 
                      sorted !! ll 
                else 
                    max (sorted !! ll) (sorted !! lu)
```
@:@

Then let's calculate the amount of fuel requires to align to a point:

@:select(language)
@:choice(scala)
```scala 3
def sumDistance(crabs: List[Int], pt: Int): Int =
  crabs.map(it => math.abs(it - pt)).sum
```
@:choice(haskell)
```haskell
sumDistance :: [Int] -> Int -> Int
sumDistance xs pt = 
    sum $ map (abs . subtract pt) xs
```
@:@

Part 1 is just a matter of chaining these two functions together:

@:select(language)
@:choice(scala)
```scala 3
def part1(input: List[Int]): Int =
  sumDistance(input, median(input))
```
@:choice(haskell)
```haskell
part1 :: [Int] -> Int
part1 crabs =
    let 
        med = median crabs 
    in
        sumDistance crabs med

```
@:@

## Part 2

Apparently crabs move with sumtorials. How sad for them. This changes what we want to align to - we need to find the point that
all crabs are the closest to, which is the average.

There's a small hitch though: average works with floating point numbers while the point must be integral. We'll test the points
from the floor and ceiling of the average.

Let's calculate the average of the positions, which is just

@:latex
\frac{n_1 + n_2 + ... + n_k}{k}
@:@

@:select(language)
@:choice(scala)
```scala 3
def average(ls: List[Int]): Double =
  ls.sum.toDouble / ls.length.toDouble
```
@:choice(haskell)
```haskell
average :: [Int] -> (Int, Int)
average l = 
    let 
        avg = fromIntegral (sum l) / fromIntegral (length l) 
    in
        (floor avg, ceiling avg)
```
@:@

Then let's calculate the distance, which is just a sum of all sumtorials (sumtorial is the sum of all natural numbers
preceding and including this number. This is also called the nth triangle number.)

@:select(language)
@:choice(scala)
```scala 3
def sumtorial(p: Int): Int =
  if p < 0 then
    0
  else
    (1 to p).sum

def distanceP2(crabs: List[Int], pt: Int): Int =
  crabs.map(it => sumtorial(math.abs(it - pt))).sum
```
@:choice(haskell)
```haskell
sumtorial :: Int -> Int
sumtorial n
    | n < 0 = 0
    | otherwise = sum [1..n]

distanceP2 :: [Int] -> Int -> Int
distanceP2 xs pt = 
    sum $ map (sumtorial . abs . subtract pt) xs
```
@:@

As with part 1, we just hook up the results to part 2.

@:select(language)
@:choice(scala)
```scala 3
def part2(input: List[Int]): Int =
  val pt = average(input)
  math.min(distanceP2(input, pt.floor.toInt), distanceP2(input, pt.ceil.toInt))
```
@:choice(haskell)
```haskell
part2 :: [Int] -> Int
part2 crabs =
    let 
        (avg1, avg2) = average crabs
    in
        min (distanceP2 crabs avg1) (distanceP2 crabs avg2)
```
@:@

## Final Code

@:select(language)
@:choice(scala)
```scala 3

def parse(input: String): List[Int] =
  input.trim.split(",").map(_.toInt).toList

def median(input: List[Int]): Int =
  val len = input.length
  val l = len.toDouble / 2.0
  val ll = l.floor.toInt
  val lu = l.ceil.toInt
  val sorted = input.sorted
  if ll == lu then
    sorted(ll)
  else
    math.max(sorted(ll), sorted(lu))

def average(ls: List[Int]): Double =
  ls.sum.toDouble / ls.length.toDouble

def sumDistance(crabs: List[Int], pt: Int): Int =
  crabs.map(it => math.abs(it - pt)).sum

def part1(input: List[Int]): Int =
  sumDistance(input, median(input))

def sumtorial(p: Int): Int =
  if p < 0 then
    0
  else
    (1 to p).sum

def distanceP2(crabs: List[Int], pt: Int): Int =
  crabs.map(it => sumtorial(math.abs(it - pt))).sum

def part2(input: List[Int]): Int =
  val pt = average(input)
  math.min(distanceP2(input, pt.floor.toInt), distanceP2(input, pt.ceil.toInt))
```
@:choice(haskell)
```haskell
import Data.List (group, sort)

parse :: String -> [Int]
parse str = read ("[" ++ str ++ "]")

median :: [Int] -> Int
median xs = let len = length xs 
                l = fromIntegral len / 2
                ll = floor l
                lu = ceiling l 
                sorted = sort xs in
                  if ll == lu then 
                      sorted !! ll 
                else 
                    max (sorted !! ll) (sorted !! lu)

average :: [Int] -> (Int, Int)
average l = 
    let 
        avg = fromIntegral (sum l) / fromIntegral (length l) 
    in
        (floor avg, ceiling avg)


sumDistance :: [Int] -> Int -> Int
sumDistance xs pt = 
    sum $ map (abs . subtract pt) xs

sumtorial :: Int -> Int
sumtorial n
    | n < 0 = 0
    | otherwise = sum [1..n]
distanceP2 :: [Int] -> Int -> Int
distanceP2 xs pt = 
    sum $ map (sumtorial . abs . subtract pt) xs

part1 :: [Int] -> Int
part1 crabs =
    let 
        med = median crabs 
    in
        sumDistance crabs med

part2 :: [Int] -> Int
part2 crabs =
    let 
        (avg1, avg2) = average crabs
    in
        min (distanceP2 crabs avg1) (distanceP2 crabs avg2)

main :: IO ()
main = do 
    input <- readFile "realinput.txt" 
    let crabs = parse input
    print $ part1 crabs

    print $ part2 crabs
```
@:@

@:benchmarkSection {
    overrideP1 = us
    overrideP2 = us
}

@:solution