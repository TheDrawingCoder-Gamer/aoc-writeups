{% aoc.day = 3 %}
# Day 3: Lobby

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a list of list of numbers
2. Find the maximum bank value in each bank, then sum them all
  * For part 1 we only take 2 batteries
  * For part 2 we take 12

## Part 1

Let's parse our input:

```scala
def parse(str: String): List[List[Int]] =
  str.linesIterator.map:
    _.map(_.asDigit).toList
  .toList
```

Now our logic is inside of a `maxBank` function.
We want the biggest number at the start, but we can't make the first number the last number is the bank. We'll drop the last number
and zip with indices to find the maximum number we can put first.

Then, using the index we got, we exclude all numbers before and including that index and find the greatest number there.

```scala 3
def maxBank(bank: List[Int]): Int =
  val (maxFirst, maxFirstIdx) = bank.dropRight(1).zipWithIndex.maxBy(_._1)
  val maxLast = bank.drop(maxFirstIdx + 1).max
  maxFirst * 10 + maxLast
```

Part 1 is simple with our `maxBank` function:

```scala
def part1(input: List[List[Int]]): Long = input.map(maxBank).sum.toLong
```

## Part 2

Part 2 needs 12 batteries, so we take 12 digits. We can extrapolate our above 2 batteries case by using tail recursion.

For each step, we'll need to reserve N - 1 batteries at the end of the list, so we don't make it impossible to take N batteries.
Then, in the unreserved section, we'll find the biggest number, and its index. We'll then recurse with N - 1 batteries left,
all numbers before and including the chosen number excluded, and the number we just chose "appended" to our running total.

```scala 3
def maxBankP2(bank: List[Int], batteries: Int): Long =
  @tailrec
  def go(bank: List[Int], batteries: Int, acc: Long): Long =
    if batteries == 0 then acc
    else
      val (bit, index) =
        bank.dropRight(batteries - 1).zipWithIndex.maxBy(_._1)
      go(bank.drop(index + 1), batteries - 1, acc * 10 + bit)
  go(bank, batteries, 0L)
```

If you want, you could also replace part 1's implementation with this. However, we'll just use it for part 2 today.

```scala 3
def part2(input: List[List[Int]]): Long = input.map(maxBankP2(_, 12)).sum
```

## Final Code

```scala 3
def parse(str: String): List[List[Int]] =
  str.linesIterator.map:
    _.map(_.asDigit).toList
  .toList

def maxBank(bank: List[Int]): Int =
  val (maxFirst, maxFirstIdx) = bank.dropRight(1).zipWithIndex.maxBy(_._1)
  val maxLast = bank.drop(maxFirstIdx + 1).max
  maxFirst * 10 + maxLast

def part1(input: List[List[Int]]): Long = input.map(maxBank).sum.toLong

def maxBankP2(bank: List[Int], batteries: Int): Long =
  @tailrec
  def go(bank: List[Int], batteries: Int, acc: Long): Long =
    if batteries == 0 then acc
    else
      val (bit, index) =
        bank.dropRight(batteries - 1).zipWithIndex.maxBy(_._1)
      go(bank.drop(index + 1), batteries - 1, acc * 10 + bit)
  go(bank, batteries, 0L)

def part2(input: List[List[Int]]): Long = input.map(maxBankP2(_, 12)).sum
```