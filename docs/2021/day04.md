{% aoc.day = 4 %}

# Day 4: Giant Squid

@:include(/inc/solutionHeader.md)

I _did_ solve this in 2022, but for some reason my code folder for it is empty, so I had to do a full rewrite
today.

## Solution Summary

1. Parse input into a `List[BingoCard]`
2. Make function to advance bingo card with each callout
3. Find the card
   * For part 1, find the card that completes first
   * For part 2, find the card that completes last
4. Score the card

## Part 1

Our types are a bit weird, so let's get it out of the way now:

```scala 3
type BingoCard = Grid[Int]
type RealBingoCard = Grid[(Int, Boolean)]
```

(the grid impl wraps a `Vector[Vector[A]]` with some convenience functions)

Now let's parse our input:

```scala 3
def parse(str: String): (List[Int], List[BingoCard]) =
  val blocks = str.split("\n\n")
  val callouts = blocks.head.trim.split(',').map(_.toInt)
  val cards = blocks.tail.map: block =>
    Grid:
      block.linesIterator.map: it =>
        it.trim.split(raw"\s+").map(_.toInt)

  (callouts.toList, cards.toList)
```

We'll need to convert the `BingoCard` into a `RealBingoCard`, so let's make a function for that:

```scala 3
def makeCard(base: BingoCard): RealBingoCard =
  base.map(it => (it, false))
```

We'll also add some extension methods to the `RealBingoCard` to advance the state, score the card, and test if we've won.

```scala 3
extension (card: RealBingoCard)
  def acceptCallout(callout: Int): RealBingoCard =
    card.map((n, x) => (n, (n == callout) || x))

  def score(lastCall: Int): Int =
    card.flatten.filterNot(_._2).map(_._1).sum * lastCall

  def won: Boolean =
    card.rows.exists(_.forall(_._2)) || card.columns.exists(_.forall(_._2))
```

Part 1 is a simple `foldLeft`:

```scala 3
def part1(input: (List[Int], List[BingoCard])): Int =
  val (callouts, cards) = input
  val realCards = cards.map(makeCard)

  callouts.foldLeft((Option.empty[Int], realCards)):
    case ((r @ Some(_), c), _) => (r, c)
    case ((_, cards), callout) =>
      val newCards = cards.map(_.acceptCallout(callout))
      (newCards.find(_.won).map(_.score(callout)), newCards)
  ._1.get
```

## Part 2

Surprisingly, our tools we made are enough for us to do part 2 in less than a second. Instead of checking if we already found
a card and doing nothing if we have, we'll override the current score if we got a new result and subtract the cards that won from
our running list.

```scala 3
def part2(input: (List[Int], List[BingoCard])): Int =
  val (callouts, cards) = input
  val realCards = cards.map(makeCard)

  callouts.foldLeft((Option.empty[Int], realCards.toSet)):
    case ((f, cards), callout) =>
      val newCards = cards.map(_.acceptCallout(callout))
      val winningCards = newCards.filter(_.won)
      (newCards.find(_.won).map(_.score(callout)).orElse(f), newCards -- winningCards)
  ._1.get
```

## Final Code

```scala 3
type BingoCard = Grid[Int]
type RealBingoCard = Grid[(Int, Boolean)]

def parse(str: String): (List[Int], List[BingoCard]) =
  val blocks = str.split("\n\n")
  val callouts = blocks.head.trim.split(',').map(_.toInt)
  val cards = blocks.tail.map: block =>
    Grid:
      block.linesIterator.map: it =>
        it.trim.split(raw"\s+").map(_.toInt)

  (callouts.toList, cards.toList)


def makeCard(base: BingoCard): RealBingoCard =
  base.map(it => (it, false))

extension (card: RealBingoCard)
  def acceptCallout(callout: Int): RealBingoCard =
    card.map((n, x) => (n, (n == callout) || x))

  def score(lastCall: Int): Int =
    card.flatten.filterNot(_._2).map(_._1).sum * lastCall

  def won: Boolean =
    card.rows.exists(_.forall(_._2)) || card.columns.exists(_.forall(_._2))

def part1(input: (List[Int], List[BingoCard])): Int =
  val (callouts, cards) = input
  val realCards = cards.map(makeCard)

  callouts.foldLeft((Option.empty[Int], realCards)):
    case ((r @ Some(_), c), _) => (r, c)
    case ((_, cards), callout) =>
      val newCards = cards.map(_.acceptCallout(callout))
      (newCards.find(_.won).map(_.score(callout)), newCards)
  ._1.get

def part2(input: (List[Int], List[BingoCard])): Int =
  val (callouts, cards) = input
  val realCards = cards.map(makeCard)

  callouts.foldLeft((Option.empty[Int], realCards.toSet)):
    case ((f, cards), callout) =>
      val newCards = cards.map(_.acceptCallout(callout))
      val winningCards = newCards.filter(_.won)
      (newCards.find(_.won).map(_.score(callout)).orElse(f), newCards -- winningCards)
  ._1.get
```

@:benchmarkSection {
    p1 = {
        jvm = [8.291, 0.311]
        js = [7.567, 0.075]
        native = [7.156, 0.188]
    },
    p2 = {
        jvm = [18.019, 0.274],
        js = [60.343, 1.260]
        native = [30.359, 0.160]
    }
}

@:solution