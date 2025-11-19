{% aoc.day = 25 %}

# Day 25: Combo Breaker

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into two Longs (order doesn't matter)
2. Calculate loop size for one value
3. Use loop size and key of other value to get encryption key

## Solution

Alright, first let's get our input parsed:
```scala 3
def parse(str: String): (Long, Long) =
  val Array(card, door) =
    str.linesIterator.map(_.toLong).toArray: @unchecked
  (card, door)
```

Ok, to actually solve this, we'll need to know some things about our situation -

`20201227` is a _prime number_. When doing modular arithmetic with a prime divisor,
we get some extra properties.

The key property we get is _multiplicative inverse_. This means in a @:latex \mathrm{mod} \, n @:@
system, foreach number @:latex a @:@ in 1 until n, there is a number @:latex u @:@ where @:latex au = 1 @:@
This effectively gives us divison, which is the exact operation we need to easily reverse this encryption procedure.
Divison by any @:latex a @:@ is equivilant to multiplying by its @:latex u @:@.

Of course it's expensive to calculate all of these for a rather high prime number, but thankfully we
only need one inverse: the inverse of 7. Let's calculate that now:

```scala 3
def part1(input: (Long, Long)): Long =
  val (card, door) = input

  val inverseSeven = (0 until 20201227).find(it => ((7 * it) % 20201227) == 1)
```

Then, to find the loop size, we just keep dividing by 7 until our initial value is 1, and count
the steps it took. I used `Monad[Id].tailRecM`, which is a shortcut for this recursive tailrec function:

```scala 3
@tailrec def tailRec[A, B](a: A)(f: A => Either[A, B]): B =
  f(a) match
    case Left(a1) => tailRec(a1)(f)
    case Right(b) => b
```

Basically, we keep going until we return a `Right`. This works for all monads, and the `Id` type is just
`type Id[A] = A`, but that's enough for Monad (and a lot of other weird instances but that's neither here nor there)

Let's add this to our `part1` function:

```scala 3
  val doorLoopSize =
    Monad[Id].tailRecM((door, 0)): (v, n) =>
      if v == 1 then Right(n)
      else
        val newV = (v * inverseSeven) % 20201227L
        Left((newV, n + 1))
```

We know the loop size of the door AND the card's public ID, which is enough to complete our puzzle. Let's first
add a transform function:

```scala 3
def transform(subject: Long, loopSize: Int): Long =
  def transformStep(n: Long): Long = (n * subject) % 20201227L
  transformStep.repeated(loopSize)(1L)
```

This is a BIT overkill but I really wanted to avoid using `while` here.

Then let's append the `transform` to our `part1` function:

```scala 3
  transform(card, doorLoopSize)
```

And we're done! That's all that's needed, and it's rather fast too!

## Final code

```scala 3
def parse(str: String): (Long, Long) =
  val Array(card, door) =
    str.linesIterator.map(_.toLong).toArray: @unchecked
  (card, door)

def transform(subject: Long, loopSize: Int): Long =
  def transformStep(n: Long): Long = (n * subject) % 20201227L
  transformStep.repeated(loopSize)(1L)

def part1(input: (Long, Long)): Long =
  val (card, door) = input

  val inverseSeven = (0 until 20201227).find(it => ((7 * it) % 20201227) == 1)

  val doorLoopSize =
    Monad[Id].tailRecM((door, 0)): (v, n) =>
      if v == 1 then Right(n)
      else
        val newV = (v * inverseSeven) % 20201227L
        Left((newV, n + 1))

  transform(card, doorLoopSize)
```
  




@:benchmarkSection {
    overrideP1 = ms
}

@:solution