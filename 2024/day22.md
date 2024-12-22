---
title: "Day 22: Monkey Market"
year: 2024
day: 22
layout: solution
---

## Solution Summary

1. Parse input into a `List[Int]`
2. Make a function that advances the hidden number

Part 1 and part 2 are pretty disjoint after this.

For part 1, then:
1. For each value in the input, apply this function 2000 times, and convert to `Long` at the end
2. Sum all these values

For part 2, then:
1. For each value, get the first 2000 numbers in the sequence, and modulo them by 10.
2. Get a list of all possible valid combinations of diffs (so `-9 to 9` * 4)
3. For all of the sequences of the first 2000 numbers, get a sequence of all diffs in the list and what number they result in
4. Go through each valid combination and sum the resulting number from each sequence for that combination
5. Pick the max of these


## Part 1

First, let's get parsing out of the way:

```scala
def parse(str: String): List[Int] =
  str.linesIterator.map(_.toInt).toList
```

Next, the bulk of part 1: The seed function.

The wording in the puzzle description isn't very helpful, so let's simplify it a bit.

It's worth noting that all the numbers used in advancing are powers of two, so bitwise operations can replace the 
multiplying, dividing, and moduloing.

Now for the actual process:

1. Save the secret number to a temporary register (`x`)
2. Set `x` to `x` xor  `x` times 64 (or `x` bitshift left by 6)
3. Set `x` to `x` modulo 16777216 (or `x` bitwise and 16777216 - 1)
3. Set `x` to `x` xor  `x` divided by 32, rounded down (or `x` bitshift right by 5)
4. Set `x` to `x` modulo 16777216 (or `x` bitwise and 16777216 - 1)
5. Set `x` to `x` xor `x` times 2048 (or `x` bitshift left by 11)
6. Set `x` to `x` modulo 16777216 (or `x` bitwise and 16777216 - 1)
7. Return the new secret number as `x`'s value.

Here's the real code:
```scala
val pow2to24minus1 = 16777216 - 1
def advance(i: Int): Int =
  var x = i

  x ^= (x << 6)
  x &= pow2to24minus1

  x ^= (x >> 5)
  x &= pow2to24minus1

  x ^= (x << 11)
  x &= pow2to24minus1

  x
```

Let's also make a helper function for applying a function `n` times:

```scala
extension[A](f: A => A)
  def repeated(n: Int): A => A = (x: A) =>
    Iterator.iterate(x)(f).drop(n).next()
```

Now we can solve part 1:

```scala
def part1(input: List[Int]): Long =
  input.map: l =>
    advance.repeated(2000)(l).toLong
  .sum
```

## Part 2

Part 2 is kind of a lot, but it's all in the `part2` function, so let's step through the part 2 function bit by bit.

```scala
def part2(input: List[Int]): Long =
```

First, let's get the list of sequences of the first 2000 prices.
```scala
  val sequences = input.map: l =>
    Iterator.iterate(l)(advance).take(2000).map(_ % 10).toList
```

Then, let's get all of the valid combinations of difference sequences:

```scala
  val validDiffSequences =
    for {
      x <- -9 to 9
      y <- -9 to 9
      z <- -9 to 9
      w <- -9 to 9
    } yield Vector(x, y, z, w)
```

Now here is the somewhat hard part to optimize correctly, but I found that calculating the sum of all the sequences here is the fastest.
Let's make a map of all of the sums for all the valid combinations.
```scala
  val diffMap =
```
For each sequence, we have to make a map of the first time we see each difference sequence and what value it results in. A simple
`sliding` with a `foldLeft` works for this.

Note the updatedWith never overrides a value if it's already present, as we only want the _first_ value we see with that difference sequence.
```scala
    sequences.map: seq =>
      seq.sliding(5).foldLeft(Map[Vector[Int], Int]()):
        case (acc, Seq(x, y, z, w, v)) =>
          acc.updatedWith(Vector(y - x, z - y, w - z, v - w)):
            case Some(value) => Some(value)
            case None => Some(v)
```
Then we have to sum all of these together. Two more `foldLeft`s work here:
```scala
    .foldLeft(Map[Vector[Int], Long]()): (acc, oldMap) =>
      oldMap.foldLeft(acc):
        case (c, (k, v)) =>
          c.updatedWith(k):
            case Some(value) => Some(value + v.toLong)
            case _ => Some(v.toLong)
```

Now we actually have our map of diffs, we just find the maximum.


```scala
  validDiffSequences.flatMap: i =>
    diffMap.get(i).map(v => (i, v))
  .maxBy(_._2)._2
```

And that's `part2`. 

Final code:

```scala
  def parse(str: String): List[Int] =
    str.linesIterator.map(_.toInt).toList

  // 16777216 == 2 ^ 24
  val pow2to24minus1 = 16777216 - 1
  def advance(i: Int): Int =
    var x = i
    x ^= (x << 6)
    x &= pow2to24minus1
    
    x ^= (x >> 5)
    x &= pow2to24minus1
    
    x ^= (x << 11)
    x &= pow2to24minus1

    x

  def part1(input: List[Int]): Long =
    input.map: l =>
      advance.repeated(2000)(l).toLong
    .sum

  def part2(input: List[Int]): Long =
    val sequences = input.map: l =>
      Iterator.iterate(l)(advance).take(2000).map(_ % 10).toList
    val validDiffSequences =
      for {
        x <- -9 to 9
        y <- -9 to 9
        z <- -9 to 9
        w <- -9 to 9
      } yield Vector(x, y, z, w)
    val diffMap =
      sequences.map: seq =>
        seq.sliding(5).foldLeft(Map[Vector[Int], Int]()):
          case (acc, Seq(x, y, z, w, v)) =>
            acc.updatedWith(Vector(y - x, z - y, w - z, v - w)):
              case Some(value) => Some(value)
              case None => Some(v)
      .foldLeft(Map[Vector[Int], Long]()): (acc, oldMap) =>
        oldMap.foldLeft(acc):
          case (c, (k, v)) =>
            c.updatedWith(k):
              case Some(value) => Some(value + v.toLong)
              case _ => Some(v.toLong)



    validDiffSequences.flatMap: i =>
      diffMap.get(i).map(v => (i, v))
    .maxBy(_._2)._2
```

On my machine this only takes 3 seconds.

[Full github code](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/src/main/scala/Day22.scala)
