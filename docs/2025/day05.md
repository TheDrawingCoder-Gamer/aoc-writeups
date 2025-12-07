{% aoc.day = 5 %}
# Day 5: Cafeteria

@:include(/inc/solutionHeader.md)

Today I wrote the Scala Center writeup, but I have an alternate approach I'd like to share using cats collections.

## Solution Summary

1. Parse our input into a `Diet`
2. For part 1, count how many ingredients are in our `Diet`
3. For part 2, count the size of the diet.

## Parsing

Parsing is in fact the majority of our problem, so let's start there.

We're parsing the ingredients and the diet, so here's our Input type:

```scala
type Input = (diet: Diet[Long], ingredients: List[Long])
```

Alright, now let's parse our diet. We'll be importing `cats.collections.Range` as well as `Diet`, so when you
see `Range` we're actually using `cats.collections.Range`.

```scala
def parse(str: String): Input =
  val Array(ranges, ings) = str.split("\n\n").runtimeChecked
  val diet =
    ranges.linesIterator.map:
      case s"$s-$e" => Range(s.toLong, e.toLong)
    .foldLeft(Diet.empty[Long])((acc, range) => acc.addRange(range))
  (
    diet = diet,
    ingredients = ings.linesIterator.map(_.toLong).toList
  )
```

For some reason there is no convenience method on `Diet` to convert a list of ranges to a Diet, so we have
to add them all manually with a fold.

Our ingredients list is easy, we just parse each line as a `Long`.

## Part 1

We did all the work in parsing already, we just need to count the number of ingredients that are in our diet.

So our part 1 will look like this:

```scala
def part1(input: Input): Long = input.ingredients.count(input.diet.contains)
```

## Part 2

For some reason, cats `Range` doesn't give a `size` method. Let's make a quick and dirty `size` extension method:

```scala
extension (self: Range[Long])
  def size: Long =
    self.end - self.start + 1L
```

Now part 2 we just combine all the ranges sizes:

```scala
def part2(input: Input): Long =
  input.diet.foldLeftRange(0L): (acc, range) =>
    acc + range.size
```

## Final Code

```scala
type Input = (diet: Diet[Long], ingredients: List[Long])


def parse(str: String): Input =
  val Array(ranges, ings) = str.split("\n\n").runtimeChecked
  val diet =
    ranges.linesIterator.map:
      case s"$s-$e" => Range(s.toLong, e.toLong)
    .foldLeft(Diet.empty[Long])((acc, range) => acc.addRange(range))
  (
    diet = diet,
    ingredients = ings.linesIterator.map(_.toLong).toList
  )

def part1(input: Input): Long = input.ingredients.count(input.diet.contains)

extension (self: Range[Long])
  def size: Long =
    self.end - self.start + 1L

def part2(input: Input): Long =
  input.diet.foldLeftRange(0L): (acc, range) =>
    acc + range.size
```

If you're interested in a solution using only the Scala 3 standard library, see the [Scala Center Writeup](https://scalacenter.github.io/scala-advent-of-code/2025/puzzles/day05)
I did