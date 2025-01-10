{%
aoc.day = 6
%}

# Day 6: Custom Customs

@:include(/inc/solutionHeader.md)

Today is another Ruby day. Again, my original solution is hilariously incompetent, so I just rewrote it.

## Solution Summary

1. Parse input into a `List[List[Set[Char]]]`
2. Solve
    * For part 1, sum results of each block, where each block's result is the union of all people in it.
    * For part 2, sum results of each block, where each block's result is the intersection of all people in it.


## Part 1

We'll be making use of `Set`, because this sounds a lot like bitwise operations, but we aren't using a bitmap (because that would
require an ugly conversion). Sets let us do these kind of operations on arbitrary "Sets" of objects.

Let's parse our input:

@:select(languageRuby)
@:choice(scala)
```scala 3
def parse(str: String): List[List[Set[Char]]] =
  str.split("\n\n").map: block =>
    block.linesIterator.map(_.toSet).toList
  .toList
```
@:choice(ruby)
We must pull in `set` specifically here:
```ruby
require 'set'

def parse(input)
  input.strip.split("\n\n").map { |block|
    block.strip.split("\n").map { |person| 
      person.strip.chars.to_set
    }
  }
end
```
@:@

Then we can solve `part1` just by unioning each block and summing:

@:select(languageRuby)
@:choice(scala)
```scala 3
def part1(input: List[List[Set[Char]]]): Int =
  input.map: block =>
    block.reduce(_ | _).size
  .sum
```
@:choice(ruby)
```ruby
def part1(input)
  input.map { |block| 
    block.reduce { |l, r| l | r }.size
  }.sum
end
```
@:@


## Part 2

Part 2 is just a matter of swapping `|` for `&`:

@:select(languageRuby)
@:choice(scala)
```scala 3
def part2(input: List[List[Set[Char]]]): Int =
  input.map: block =>
    block.reduce(_ & _).size
  .sum
```
@:choice(ruby)
```ruby
def part2(input)
  input.map { |block|
    block.reduce { |l, r| l & r }.size
  }.sum
end
```
@:@

And that's part 2 done.

## Final Code

@:select(languageRuby)
@:choice(scala)
```scala 3
def parse(str: String): List[List[Set[Char]]] =
  str.split("\n\n").map: block =>
    block.linesIterator.map(_.toSet).toList
  .toList

def part1(input: List[List[Set[Char]]]): Int =
  input.map: block =>
    block.reduce(_ | _).size
  .sum

def part2(input: List[List[Set[Char]]]): Int =
  input.map: block =>
    block.reduce(_ & _).size
  .sum
```
@:choice(ruby)
```ruby
def parse(input)
  input.strip.split("\n\n").map { |block|
    block.strip.split("\n").map { |person| 
      person.strip.chars.to_set
    }
  }
end

def part1(input)
  input.map { |block| 
    block.reduce { |l, r| l | r }.size
  }.sum
end

def part2(input)
  input.map { |block|
    block.reduce { |l, r| l & r }.size
  }.sum
end
```
@:@

@:benchmarkSection

@:solution