{% aoc.day = 13 %}

# Day 13: Shuttle Search

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into an `Int` and `List[Option[Int]]`
2. Solve
   * For part 1, find the id of the bus that we can get on earliest, and multiply it by time needed to wait
   * For part 2, find the earliest timestamp that has a sequence of arrivals matching our input list

## Part 1

Let's start our with parsing:
```scala 3
def parse(str: String): (Int, List[Option[Int]]) =
  str.linesIterator.toList match
    case List(s, xs) => (s.toInt, xs.split(",").map(_.toIntOption).toList)
    case _ => ???
```

I take advantage of `List.unapply` to make parsing it easier.

The bulk of part 1 is finding the smallest number greater than our input timestamp. Here's a function to do that:

```scala 3
def leastMultipleGreaterThan(threshold: Int, multiplier: Int): Int =
  Iterator.iterate(multiplier)(_ + multiplier).find(threshold < _).get
```

Then we can do part 1:
```scala 3
def part1(input: (Int, List[Option[Int]])): Int =
  val (start, ids) = input
  // remove options
  normalIds = ids.flatten
  val (busId, t) = normalIds.zip(normalIds.map(it => leastMultipleGreaterThan(start, it))).minBy(_._2)
  busId * (t - start)
```

## Part 2

Part 2 had me stumped, even after looking up a hint. Let's get a few things out of the way:

* All input numbers are prime
* Our input will loop at the product of all these primes

If our input loops we could consider our solution to be in a modular arithmetic space around the product of our inputs.
Time to get around to that hint I looked up: The Chinese Remainder Theorem (CRT for short).

The CRT statement goes like this:

Let @:latex n_1, \ldots, n_k @:@ be integers greater than 1, and let @:latex N @:@ be the product of @:latex n_i @:@.

If these are all pairwise coprime (this is true because all inputs are prime), and we have @:latex a_1, \ldots, a_k @:@ integers such 
that @:latex 0 \leq a_i < n_i @:@  for every i (which I'll get to), then there is only one integer @:latex x @:@, such that
@:latex 0 \leq x < N @:@ and @:latex x \, \mathrm{rem} \, n_i @:@ is @:latex a_i @:@ for every @:latex i @:@.

That was basically copied from the wikipedia and that didn't really help me process it either. Let's just show for now that
we do indeed have @:latex a_i @:@. 

We can get @:latex a_i @:@ by getting the offset between its index in the sequence and its number,
and then getting the Euclidean remainder of that. This doesn't mean all too much on its own, but in the
context of the Chinese Remainder Theorem, it means that the returned result will have a multiple of @:latex n_i @:@
at the offset of the index from the input, which fulfills the requirements of the puzzle.

Here's my common implementation of Euclidean remainder:

```scala 3
extension (self: Int)
  infix def rem(that: Int): Int =
    val mod = self % that
    if mod < 0 then mod + that else mod
```

Then let's get these offsets in a list:

```scala 3
def part2(input: (Int, List[Option[Int]])): BigInt =
  val (_, ids) = input
  val offsets = ids.zipWithIndex.collect:
    // returns (a_i, n_i)
    case (Some(v), i) => ((v - i) rem v, v)
  // ...
```

Effectively, we've just gotten ourselves @:latex a_i @:@ for each @:latex n_i @:@ in our list. This means that we can use
CRT to solve our problem. Now to just implement it.

There are multiple ways to implement the Chinese Remainder Theorem, but I found using modular inverse to be easiest because
we can do each computation individually. [Here's a good video](https://www.youtube.com/watch?v=ru7mWZJlRQg) on how this method works,
but basically for each @:latex i @:@ we multiply that section by the product of all @:latex n @:@ _except_ for @:latex n_i @:@,
so that it doesn't affect the result of any other section. We then multiply each section by the modular inverse of @:latex n_i @:@ and
the product we just calculated so that we can multiply @:latex a_i @:@ as well and get @:latex a_i @:@ to be the result when
the result is mod @:latex n_i @:@.

That's still not really a helpful explanation. Let's just write the code, so I can point out what we're doing.

```scala 3
def crt(ls: List[(Int, Int)]): BigInt =
  val (as, ns) = ls.unzip
  val N = ns.map(i => BigInt(i)).product
  // foreach i yield the product of all ns except for self
  // which can be found by just removing ourselves from N
  val prodsExceptSelf = ns.map(N / _)
  // using BigInt because the number is big, but we also get modInverse for free
  val invN = (ns, prodsExceptSelf).parMapN((n, prod) => prod.modInverse(BigInt(n)))
  // the multiplication is reordered here so we don't have to wrap a in a BigInt call
  (as, prodsExceptSelf, invN).parMapN((a, prod, invNi) => prod * a * invNi).sum
```

Alright, there's the formula. Again, I highly recommend watching the above video - I didn't really fully understand why this solution
worked before fully watching it. Now let's go back and finish that part 2 function.
```scala 3
  // ...
  crt(offsets)
```

## Full Code

```scala 3
import cats.*
import cats.syntax.all.*

def parse(str: String): (Int, List[Option[Int]]) =
  str.linesIterator.toList match
    case List(s, xs) => (s.toInt, xs.split(",").map(_.toIntOption).toList)
    case _ => ???

def leastMultipleGreaterThan(threshold: Int, multiplier: Int): Int =
  Iterator.iterate(multiplier)(_ + multiplier).find(threshold < _).get

def part1(input: (Int, List[Option[Int]])): Int =
  val (start, ids) = input
  normalIds = ids.flatten
  val (busId, t) = normalIds.zip(normalIds.map(it => leastMultipleGreaterThan(start, it))).minBy(_._2)
  busId * (t - start)

extension (self: Int)
  infix def rem(that: Int): Int =
    val mod = self % that
    if mod < 0 then mod + that else mod

def crt(ls: List[(Int, Int)]): BigInt =
  val (as, ns) = ls.unzip
  val N = ns.map(i => BigInt(i)).product
  val prodsExceptSelf = ns.map(N / _)
  val invN = (ns, prodsExceptSelf).parMapN((n, prod) => prod.modInverse(BigInt(n)))
  (as, prodsExceptSelf, invN).parMapN((a, prod, invNi) => prod * a * invNi).sum

def part2(input: (Int, List[Option[Int]])): BigInt =
  val (_, ids) = input
  val offsets = ids.zipWithIndex.collect:
    case (Some(v), i) => ((v - i) rem v, v)

  crt(offsets)
```

@:benchmarkSection {
    overrideP1 = us
    overrideP2 = us
}

@:solution