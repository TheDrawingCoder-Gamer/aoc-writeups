{%
aoc.day = 25
%}

# Day 25: Code Chronicle

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into list of locks and keys
2. Count combinations of locks and keys where they don't overlap

## Part 1

Let's define the `KeyOrLock` class (I know, that name sucks)

```scala
case class KeyOrLock(isKey: Boolean, pinHeights: Vector[Int])
```

Then parse the input:

```scala
def parse(str: String): List[KeyOrLock] =
  str.split("\n\n").map: str =>
    val goodGrid: Vector[Vector[Char]] = str.linesIterator.map(_.toVector).toVector
    val isKey = goodGrid(0)(0) != '#'
    val pinHeights = goodGrid.transpose.map(_.count(_ == '#') - 1)
    KeyOrLock(isKey, pinHeights)
  .toList
```

Then to do part 1, we can add a function to `KeyOrLock` that tests if a key and lock overlap:

```scala
case class KeyOrLock(isKey: Boolean, pinHeights: Vector[Int])
  def compatibleWith(that: KeyOrLock): Boolean =
    assert(this.isKey ^ that.isKey)
    this.pinHeights.zip(that.pinHeights).forall((l, r) => l + r <= 5)
```

And now we can do part 1 in full:

```scala
def part1(input: List[KeyOrLock]): Long =
  val (keys, locks) = input.partition(_.isKey)

  keys.flatMap: key =>
    locks.filter: lock =>
      key.compatibleWith(lock)
  .size
```

For Christmas, there is no part 2. Happy advent of code everyone, and see you next year!

@:benchmarkSection {
    overrideP1 = us
}

@:solution