{%
aoc.day = 1
%}

# Day 1: Secret Entrance

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into list of direction and number
2. Calculate "password number"
    * For part 1, we only need to calculate when we hit 0 exactly
    * For part 2, we'll need to calculate everytime we pass 0

## Part 1

Let's start with parsing:

```scala 3
def parse(str: String): List[(Boolean, Int)] =
  str.linesIterator.map:
    case s"R$n" => (true, n.toInt)
    case s"L$n" => (false, n.toInt)
  .toList
```

There are likely better datatypes to parse this into, but for now a boolean and int is fine.

This problem will require a remainder that is positive -
the stdlib comes with `math.floorMod`, which will work because our divisor is positive, but I ended up using the eucledian remainder from my common library.

Here's the `rem` definition:

```scala 3
extension (self: Int)
  infix def rem(that: Int): Int =
    val mod = self % that
    if mod < 0 then mod + math.abs(that) else mod
```

Let's actually do part 1 now. I'll be using `foldLeft`, but some others 
had success with `scanLeft`. `foldLeft` is just what always comes to mind for me.

We're counting the amount of times we hit exactly zero, and
we also need to keep track of the current pointer, so that will be what we're folding on.

```scala 3
def part1(input: List[(Boolean, Int)]): Int =
  input.foldLeft((50, 0)):
    case ((cur, passZero), (right, by)) =>
      val newValue =
        if right then (cur + by) rem 100
        else (cur - by) rem 100

      (newValue, if newValue == 0 then passZero + 1 else passZero)
  ._2
```

We start at 50, and haven't hit a zero yet. We'll get the new value by adding or subtracting our input,
depending on the direction. Then we'll take it modulo 100.

We'll then continue folding with this new value, and if we hit zero then we'll add 1 to our count.

## Part 2

Part 2 is a bit more difficult and requires some careful programming to not get off by one errors.

We'll still be using `foldLeft`, but now we have to be a bit more careful in how we detect zero.

```scala 3
def part2(input: List[(Boolean, Int)]): Int =
  input.foldLeft((50, 0)):
    case ((cur, passZero), (right, by)) =>
      val (forcedWrap, byN) = (by / 100, by % 100)
      val byV = if right then byN else -byN
      val unwrapped = cur + byV
      val newValue = unwrapped rem 100
      val passV =
        forcedWrap + locally:
          if cur != 0 && (unwrapped >= 100 || unwrapped <= 0) then 1
          else 0
      (newValue, passZero + passV)
  ._2
```

To handle the edge case that is explicitly pointed out in the puzzle text, I first divide the turning magnitude by 100, and
modulo it by 100 as well. The division by 100 will give us how many times we are forced to pass zero, and the modulo 100 will give us the remainder after
doing those forced passes.

Then I get the actual new value, but this time I don't modulo it immediately - I'll need to do some inspection on
the unwrapped value.

Now for this part:
```scala 3
val passV =
  forcedWrap + locally:
    if cur != 0 && (unwrapped >= 100 || unwrapped <= 0) then 1
    else 0
```

`forcedWrap` is what we know we'll end up doing anyway due to our magnitude being greater than 100. If we start at zero, then we can never pass 0 again
with less than 100 magnitude, so we fail out early if we start at 0. Then, we check if we went outside the bounds, and if we did then we add 1 to our pass count.

That's part 2, and that wasn't so bad now was it? : )

## Final Code

```scala 3
def parse(str: String): List[(Boolean, Int)] =
  str.linesIterator.map:
    case s"R$n" => (true, n.toInt)
    case s"L$n" => (false, n.toInt)
  .toList

extension (self: Int)
  infix def rem(that: Int): Int =
    val mod = self % that
    if mod < 0 then mod + math.abs(that) else mod

def part1(input: List[(Boolean, Int)]): Int =
  input.foldLeft((50, 0)):
    case ((cur, passZero), (right, by)) =>
      val newValue =
        if right then (cur + by) rem 100
        else (cur - by) rem 100

      (newValue, if newValue == 0 then passZero + 1 else passZero)
  ._2

def part2(input: List[(Boolean, Int)]): Int =
  input.foldLeft((50, 0)):
    case ((cur, passZero), (right, by)) =>
      val (forcedWrap, byN) = (by / 100, by % 100)
      val byV = if right then byN else -byN
      val unwrapped = cur + byV
      val newValue = unwrapped rem 100
      val passV =
        forcedWrap + locally:
          if cur != 0 && (unwrapped >= 100 || unwrapped <= 0) then 1
          else 0
      (newValue, passZero + passV)
  ._2