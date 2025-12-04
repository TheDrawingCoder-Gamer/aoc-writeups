{% aoc.day = 2 %}
# Day 2: Gift Shop

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into list of start end pairs
2. Find all invalid numbers and sum them

## Part 1

Parsing is a tiny bit difficult, as we can't use the neat and nice `Range` type to store it (we need `Long`s)

It's ok though, we can just use `(Long, Long)`

```scala 3
def parse(str: String): List[(Long, Long)] =
  str.trim.split(",").map:
    case s"$l-$r" => (l.toLong, r.toLong)
  .toList
```

Now, let's first get started on detecting an invalid number.

For part 1, it's actually rather easy to detect it.

Obviously, if our number is an odd number of digits, it can't be a number repeated two times.
Then, if it is an even number of digits, compare the two halves.

```scala
def invalidP1(n: Long): Boolean =
  val str = n.toString
  val len = str.length
  (len % 2) == 0 && str.take(len / 2) == str.drop(len / 2)
```

@:callout(info)
My actual code uses bitwise operations here, as everything is in terms of two.
Modulo and division is used here for clarity, but any time `len % 2` is written,
it's actually `len & 1`, and anytime `len / 2` is written, it's actually `len >> 1`.
@:@

Then our part 1 is easy:

```scala 3
def part1(input: List[(Long, Long)]): Long =
  input.map: (l, r) =>
    Iterator.range(l, r).filter(invalidP1).sum
  .sum
```

## Part 2

Part 2 is more difficult, but because we are working with numbers that are so short its not too hard to just brute force a solution.

Obviously we now need to detect all repetitions. I started with the size of the repetition, because we can easily constrain that:
a minimum length of 1 and a maximum length of half the string length. We then have to get rid of any sizes that don't cleanly divide
the length.

We only need to find one proof of repetition, so `exists` is our best choice. The rest should be simple:

```scala 3
def invalidP2(n: Long): Boolean =
  val str = n.toString
  val len = str.length
  (1 to len / 2).filter(len % _ == 0).exists: size =>
    val rep = len / size
    val bit = str.take(size)
    (bit * rep) == str
```

Then our `part2` function is easy:

```scala 3
def part2(input: List[(Long, Long)]): Long =
  input.map: (l, r) =>
    Iterator.range(l, r).filter(invalidP2).sum
  .sum
```

## Final Code

```scala 3
def parse(str: String): List[(Long, Long)] =
  str.trim.split(",").map:
    case s"$l-$r" => (l.toLong, r.toLong)
  .toList

def invalidP1(n: Long): Boolean =
  val str = n.toString
  val len = str.length
  (len % 2) == 0 && str.take(len / 2) == str.drop(len / 2)

def part1(input: List[(Long, Long)]): Long =
  input.map: (l, r) =>
    Iterator.range(l, r).filter(invalidP1).sum
  .sum

def invalidP2(n: Long): Boolean =
  val str = n.toString
  val len = str.length
  (1 to len / 2).filter(len % _ == 0).exists: size =>
    val rep = len / size
    val bit = str.take(size)
    (bit * rep) == str

def part2(input: List[(Long, Long)]): Long =
  input.map: (l, r) =>
    Iterator.range(l, r).filter(invalidP2).sum
  .sum
```