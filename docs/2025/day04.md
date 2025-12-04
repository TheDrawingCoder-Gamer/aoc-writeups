{% aoc.day = 4 %}
# Day 4: Printing Department

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `Set[Vec2[Int]]`
2. Determine available paper rolls
3. For part 2, iteratively remove these rolls until you can't no more

## Part 1

To parse, I used my common Grid as a shortcut for building a set.
```scala
def parse(str: String): Set[Vec2[Int]] =
  Grid.fromString(str)(_ == '@').zipWithIndices.filter(_._1).map(_._2).toSet
```

I had just done 2020 last month and that had quite a bit of Conway's game of life,
and this had reminded me of that. Parsing into a Set was a wise choice then, and it's a wise choice now.

We'll abstract our "accessible" metric so we can reuse it:
```scala 3
def accessible(universe: Set[Vec2[Int]])(p: Vec2[Int]): Boolean =
  p.allNeighbors.count(universe) < 4
```

Part 1 is now easy, as we just count the accessible nodes.
```scala 3
def part1(input: Set[Vec2[Int]]): Int = input.count(accessible(input))
```

## Part 2

Given that we've already implemented `accessible` and we are experienced in Conway's game of life, it's not very hard
to determine the total accessible count.

Others had used `unfold`, but I found that tail recursion was a better choice today.

To put it simply, we `partition` our current set based on accessibility. If nothing is accessible, then we are done. Otherwise,
recurse with the inaccessible set and add the size of the accessible set to our accumulator.

```scala 3
def part2(input: Set[Vec2[Int]]): Int =
  @tailrec
  def step(in: Set[Vec2[Int]], acc: Int): Int =
    val (accessibleIn, inaccessibleIn) = in.partition(accessible(in))
    if accessibleIn.isEmpty then acc
    else step(inaccessibleIn, acc + accessibleIn.size)
  step(input, 0)
```

## Final Code

```scala 3
def parse(str: String): Set[Vec2[Int]] =
  Grid.fromString(str)(_ == '@').zipWithIndices.filter(_._1).map(_._2).toSet

def accessible(universe: Set[Vec2[Int]])(p: Vec2[Int]): Boolean =
  p.allNeighbors.count(universe) < 4

def part1(input: Set[Vec2[Int]]): Int = input.count(accessible(input))

def part2(input: Set[Vec2[Int]]): Int =
  @tailrec
  def step(in: Set[Vec2[Int]], acc: Int): Int =
    val (accessibleIn, inaccessibleIn) = in.partition(accessible(in))
    if accessibleIn.isEmpty then acc
    else step(inaccessibleIn, acc + accessibleIn.size)
  step(input, 0)
```