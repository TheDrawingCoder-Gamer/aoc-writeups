{%
aoc.day = 19
%}

# Day 19: Linen Layout

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into two `List[String]`
2. Calculate each pattern
  * For `part1`, we just have to find 1 valid configuration then we can end early.
  * For `part2`, we have to find all valid configurations and count them.
3. Sum results of calculations

## Part 1

Part 1 is just finding one valid pattern, which isn't too bad.

Let's start with the parsing:

```scala
def parse(str: String): (List[String], List[String]) =
  val Array(towelsStr, designStr) = str.split("\n\n")

  val towels = towelsStr.split(',').map(_.trim).toList
  val designs = designStr.split('\n').toList

  (towels.sortBy(_.length)(using Ordering[Int].reverse), designs)
```

We sort the towels by length here so we don't have to do it in either solution - this doesn't matter too much for part 2, but
for part 1 choosing the biggest chunks first is preferable.

Now we just have to find a single valid configuration. My immediate thought was parser combinators, but I didn't really
want to pull those out so I just did a recursive function:

```scala
def parseDesign(towels: List[String], design: String): Boolean =
  def go(curTowels: List[String], restDesign: String): Boolean =
    if restDesign.isEmpty then
      true
    else
      curTowels match
        case head :: next =>
          if restDesign.startsWith(head) then
            val nextDesign = restDesign.drop(head.length)
            go(towels, nextDesign) || go(next, restDesign)
          else
            go(next, restDesign)
        case Nil => false
  go(towels, design)
```

Part 1 is now just as simple as counting the designs with at least 1 valid configuration:

```scala
def part1(str: String): Long =
  val (towels, designs) = parse(str)
  designs.count(parseDesign(towels, _)).toLong
```

And that's part 1 solved.

## Part 2

It's not too hard to write something that will work in the small example case, but I struggled with making it optimized enough.
I was unable to rub my braincells together today so I used [merlinorg's (older) solution](https://github.com/merlinorg/aoc2024/blob/082c1fb45953d698f2072e9bc0db90ddb2b37323/src/main/scala/Day19.scala) for part 2.

The key is using a cache to memoize the amount of combinations of a suffix of a pattern. Honestly I don't really fully understand the code myself, so here it is
and my best explanation:

```scala
def countDesigns(towels: List[String], design: String): Long =
  def go(pattern: String, total: Long, cache: Map[String, Long]): (Long, Map[String, Long]) =
    cache.get(pattern) match
      case Some(count) => (total + count, cache)
      case _ =>
        val (count, cache2) = towels.foldLeft(0L -> cache):
          case ((count, cache), towel) =>
            if pattern.startsWith(towel) then
              go(pattern.drop(towel.length), count, cache)
            else
              (count, cache)
        (total + count, cache2 + (pattern -> count))


  go(design, 0L, Map("" -> 1L))._1
```

If the pattern is already in the cache, then it returns the cache score + the total arg. If not, then it calculate combinations by
going through all the towels, and recursing on ones the pattern starts with. Then, it returns the count calculated from all combinations for that pattern
and adds that pattern to the cache.

The cache is useful because when a pattern's start can be matched by multiple towels then the suffixes tend to be equal, and if they aren't they likely will have children
later that are equal. So caching means that the bulk of the computation is done at the start but then most of the work is cache fetching.

Now to just hook that up to `part2`:

```scala
def part2(str: String): Long =
  val (towels, designs) = parse(str)
  designs.map(countDesigns(towels, _)).sum
```

Final code:


```scala
def parse(str: String): (List[String], List[String]) =
  val Array(towelsStr, designStr) = str.split("\n\n")

  val towels = towelsStr.split(',').map(_.trim).toList
  val designs = designStr.split('\n').toList

  (towels.sortBy(_.length)(using Ordering[Int].reverse), designs)

def parseDesign(towels: List[String], design: String): Boolean =
  def go(curTowels: List[String], restDesign: String): Boolean =
    if restDesign.isEmpty then
      true
    else
      curTowels match
        case head :: next =>
          if restDesign.startsWith(head) then
            val nextDesign = restDesign.drop(head.length)
            go(towels, nextDesign) || go(next, restDesign)
          else
            go(next, restDesign)
        case Nil => false
  go(towels, design)
def countDesigns(towels: List[String], design: String): Long =
  def go(pattern: String, total: Long, cache: Map[String, Long]): (Long, Map[String, Long]) =
    cache.get(pattern) match
      case Some(count) => (total + count, cache)
      case _ =>
        val (count, cache2) = towels.foldLeft(0L -> cache):
          case ((count, cache), towel) =>
            if pattern.startsWith(towel) then
              go(pattern.drop(towel.length), count, cache)
            else
              (count, cache)
        (total + count, cache2 + (pattern -> count))


  go(design, 0L, Map("" -> 1L))._1


def part1(input: (List[String], List[String])): Long =
  val (towels, designs) = input
  designs.count(parseDesign(towels, _)).toLong

def part2(input: (List[String], List[String])): Long =
  val (towels, designs) = input
  designs.map(countDesigns(towels, _)).sum
```

[Solution on github](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/tree/e163baeaedcd90732b5e19f578a2faadeb1ef872/src/main/scala/Day19.scala)

@:benchmarkSection {
    p1 = {
        jvm = [8.023, 0.072],
        js = [13.052, 0.041],
        native = [9.968, 0.115]
    },
    p2 = {
        jvm = [58.248, 2.887],
        js = [105.289, 0.554],
        native = [183.361, 0.843]
    }
}

@:solution