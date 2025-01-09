{% aoc.day = 3 %}

# Day 3: Binary Diagnostic

@:include(/inc/solutionHeader.md)

## Solution Summary
1. Parse input into a `List[Int]` and keep track of binary number size
2. Calculate result
   * In `part1` this is fairly easy, we just calculate the most common one and do a partial negate using xor
   * `part2` is more difficult, but a `foldLeft` is adequate.

Today was an Elixir day, and I may eventually write an Elixir version, but the solution I wrote was basically 
unusable now, so I only have Scala today.

## Part 1

Let's parse our input into a `(List[Int], Int)`. We need to keep track of the binary size because converting to int
loses our left padding. 

```scala 3
def parse(input: String): (List[Int], Int) =
    (input.linesIterator.map(Integer.parseInt(_, 2)).toList, input.linesIterator.next().trim.length)
```

Now let's do part 1:

```scala 3
def part1(input: (List[Int], Int)): Int =
  val (is, bitSize) = input
  val halfCount = is.length / 2
  val gamma = (0 until bitSize).reverse.foldLeft(0):
    case (acc, bit) =>
      val num = 1 << bit
      val is1 = is.count(it => (num & it) != 0) > halfCount
      (acc << 1) + (if is1 then 1 else 0)

  val epsilon = gamma ^ ((1 << bitSize) - 1)

  epsilon * gamma
```

Ok, let's go through this. For each bit (going from left to right order) we calculate what the most common bit is, then
append that to the right of the ongoing binary number.

Epsilon is just the inverse of gamma, but only within our bitsize, so we do `(1 << bitSize) - 1`, which will make a
binary number of length `bitSize` but of all 1s. 

We then multiply these together to get our result.

## Part 2

Part 2 was kind of hard to get right with ints but if you take it slow it's not too bad.

I wanted to reuse some of the logic of detecting the most common number, but now our list can sometimes be of even length
with an even split, so we have to account for the middle case. Even worse, this edge case has different results on each side.
To detect it, let's do the count function and convert it to a double and compare it to the length (as a double) divided by 2.
On odd numbered lengths, the half-length will be N.5 so we will never get the equal comparison. On even ones it's N.0, so it's possible
there is an even split, but that's nothing a `compareTo` with a `match` can't fix.

This is a core part of this and is what kept me from solving it for half an hour, so I'm going to showcase how we step through this for the sample input.

Here's the small sample for just "o2":

```scala mdoc:invisible
val inputStr =
   """
     |00100
     |11110
     |10110
     |10111
     |10101
     |01111
     |00111
     |11100
     |10000
     |11001
     |00010
     |01010
     |""".stripMargin
val input = (inputStr.trim.linesIterator.map(Integer.parseInt(_, 2)).toList, 5)
```

@:callout(info)
This page has Scala compiled and tested using mdoc, so you can actually view the output of this code!
@:@

```scala mdoc
val (is, bitSize) = input


val o2 = (0 until bitSize).reverseIterator.foldLeft(is):
   case (r @ List(_), _) => r
   case (o2r, bit) =>
     val num = 1 << bit
     println(o2r.map(_.toBinaryString))
     val compared = o2r.count(it => (num & it) != 0).toDouble `compareTo` (o2r.length.toDouble / 2)
     compared match
        case -1 =>
          println("0 was more common")
          o2r.filter(it => (num & it) == 0)
        case 0 | 1 =>
          if compared == 0 then
            println("Neither was more common, picking 1")
          else println("1 was more common")
          o2r.filter(it => (num & it) != 0)
    
```

```scala mdoc:invisible
assert(o2.head == 23)
```

This shows that yes our code does in fact work ; ), and also walks us through the process. The co2 is _basically_ the inverse
of this, so we can do them both at the same time (with some extra code to prevent recomputing if we already finished):


```scala 3
def part2(input: (List[Int], Int)): Int =
  val (is, bitSize) = input

  val (o2, co2) = (0 until bitSize).reverseIterator.foldLeft((is, is)):
    case (z @ (List(_), List(_)), _) => z
    case ((o2r, co2r), bit) =>
      val num = 1 << bit

      val newO2 =
        if o2r.tail.nonEmpty then
          val compared = o2r.count(it => (num & it) != 0).toDouble `compareTo` (o2r.length.toDouble / 2)
          compared match
            case -1 =>
              o2r.filter(it => (num & it) == 0)
            case 0 | 1 =>
              o2r.filter(it => (num & it) != 0)
        else
          o2r
      val newCO2 =
        if co2r.tail.nonEmpty then
          val compared = co2r.count(it => (num & it) != 0).toDouble `compareTo` (co2r.length.toDouble / 2)

          compared match
            case -1 => co2r.filter(it => (num & it) != 0)
            case  1 | 0 => co2r.filter(it => (num & it) == 0)
        else
          co2r

      (newO2, newCO2)

  o2.head * co2.head
```

Ok, that was surprisingly a lot for a day 3 ; ). As I said it's not too bad if you take it slow, but I was going too fast
and hit that stupid comparison jank.

## Final Code

```scala 3
lazy val input = FileIO.getInput(2021, 3)

def parse(input: String): (List[Int], Int) =
  (input.linesIterator.map(Integer.parseInt(_, 2)).toList, input.linesIterator.next().trim.length)

def part1(input: (List[Int], Int)): Int =
  val (is, bitSize) = input
  val halfCount = is.length / 2
  val gamma = (0 until bitSize).reverse.foldLeft(0): 
    case (acc, bit) =>
      val num = 1 << bit
      val is1 = is.count(it => (num & it) != 0) > halfCount
      (acc << 1) + (if is1 then 1 else 0)

  val epsilon = gamma ^ ((1 << bitSize) - 1)

  epsilon * gamma

def part2(input: (List[Int], Int)): Int =
  val (is, bitSize) = input
  val halfCount = is.length / 2


  val (o2, co2) = (0 until bitSize).reverseIterator.foldLeft((is, is)):
    case (z @ (List(_), List(_)), _) => z
    case ((o2r, co2r), bit) =>
      val num = 1 << bit

      val newO2 =
        if o2r.tail.nonEmpty then
          val compared = o2r.count(it => (num & it) != 0).toDouble `compareTo` (o2r.length.toDouble / 2)
          compared match
            case -1 =>
              o2r.filter(it => (num & it) == 0)
            case 0 | 1 =>
              o2r.filter(it => (num & it) != 0)
        else
          o2r
      val newCO2 =
        if co2r.tail.nonEmpty then
          val compared = co2r.count(it => (num & it) != 0).toDouble `compareTo` (co2r.length.toDouble / 2)

          compared match
            case -1 => co2r.filter(it => (num & it) != 0)
            case  1 | 0 => co2r.filter(it => (num & it) == 0)
        else
          co2r

      (newO2, newCO2)

  o2.head * co2.head
```

@:benchmarkSection

@:solution