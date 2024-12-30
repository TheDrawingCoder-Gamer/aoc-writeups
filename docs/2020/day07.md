{%
aoc.day = 7
%}

# Day 7: Handy Haversacks

@:include(/inc/solutionHeader.md)

Today _was_ a Haxe day but my solution from 2021 was incompetent and honestly I'm tired of rewriting all my things, especially
when the Scala is so elegant. 


## Solution Summary

1. Parse input into a `Map[String, Set[BagDesc]]`
2. Solve
    * For `part1`, count the amount of bags that contain the **shiny gold** bag.
    * For `part2`, count the amount of bags inside the **shiny gold** bag.

## Part 1

Let's first define our types.

```scala 3
case class BagDesc(color: String, amount: Int)
type Rules = Map[String, Set[BagDesc]]
```

Let's then parse our input. For some reason the input is "complex" compared to other inputs - it follows
some rules of english syntax.

Let's parse it:

```scala 3
def parse(str: String): Rules =
  str.linesIterator.map:
    case s"$color bags contain $rest." =>
      color -> rest.split(',').foldLeft(Set.empty[BagDesc]):
        case (acc, r) =>
          r.trim match
            case s"no other bags" => acc
            case s"$n $color2 bag$_" => acc + BagDesc(color2, n.toInt)
  .toMap
```

We have to make sure to only parse the `s` sometimes, as it is omitted if `n` is `1`. Otherwise the parsing
isn't too bad.

Part 1 is counting the amount of bags that contain the **shiny gold** bag. A recursive function works fine here:

```scala 3
def part1(input: Rules): Int =
  def containsShinyGold(bag: String): Boolean =
    val rule = input(bag)
    rule.exists(_.color == "shiny gold") || rule.exists(it => containsShinyGold(it.color))

  input.removed("shiny gold").count(it => containsShinyGold(it._1))
```

## Part 2

Part 2 is finding the amount of bags inside the **shiny gold** bag. Another recursive function works here:

```scala 3
def part2(input: Rules): Int =
  def getBagAmount(bag: String): Int =
    val rule = input(bag)
    rule.foldLeft(1):
      case (acc, bag) =>
        acc + (bag.amount * getBagAmount(bag.color))
  getBagAmount("shiny gold") - 1
```

Each recursion gives at least 1 bag (the current bag). At the end we have to subtract 1 to remove the **shiny gold** bag
from the count.

## Final Code

```scala 3
case class BagDesc(color: String, amount: Int)
type Rules = Map[String, Set[BagDesc]]

def parse(str: String): Rules =
  str.linesIterator.map:
    case s"$color bags contain $rest." =>
      color -> rest.split(',').foldLeft(Set.empty[BagDesc]):
        case (acc, r) =>
          r.trim match
            case s"no other bags" => acc
            case s"$n $color2 bag$_" => acc + BagDesc(color2, n.toInt)
  .toMap


def part1(input: Rules): Int =
  def containsShinyGold(bag: String): Boolean =
    val rule = input(bag)
    rule.exists(_.color == "shiny gold") || rule.exists(it => containsShinyGold(it.color))

  input.removed("shiny gold").count(it => containsShinyGold(it._1))


def part2(input: Rules): Int =
  def getBagAmount(bag: String): Int =
    val rule = input(bag)
    rule.foldLeft(1):
      case (acc, bag) =>
        acc + (bag.amount * getBagAmount(bag.color))
  getBagAmount("shiny gold") - 1
```
