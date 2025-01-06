{%
aoc.day = 5
%}

# Day 5: Binary Boarding

@:include(/inc/solutionHeader.md)

Today is a Ruby day, but my original solution was so embarassingly incompetent that I decided to completely rewrite it for 2024.

## Solution Summary

1. Parse input into a `List[...]`
2. Solve
    * For `part1`, get the highest seat id.
    * For `part2`, find a gap in seat ids and get that seat.

## Part 1

The wording in the problem description is intentionally poor. If you look at both of the solutions, neither actually require knowing
anything about the row id or column id outside of using them to assemble the seat id. And convieniently, the input is already assembled
such that when translated to binary _it's already the seat id_. 

To show this, let's consider Seat Id 7: 

```
0000000111
```

Let's split it into it's row and column ids:

```
0000000
111
```

The seat id is the row id * 8 + the column id. We know that * 8 is just another way of saying << 3, so
let's align our bits:

```
0000000
       111
```
We're back where we started, proving that our initial input is the seat id when converted to binary. 
(This isn't a rigorous proof but it's good enough for us!)


This is why I omitted the type parameter of the `List` earlier - it's just a `List[Int]`.

Let's parse our input into a `List[Int]`:

@:select(languageRuby)
@:choice(scala)
```scala 3
def parse(str: String): List[Int] =
  str.linesIterator.map: line =>
    line.foldLeft(0):
      case (acc, c) =>
        c match
          case 'F' | 'L' => acc << 1
          case 'B' | 'R' => (acc << 1) + 1
  .toList
```
@:choice(ruby)
```ruby
def parse(input)
  lines = input.strip().split("\n")
  values = []
  for line in lines do
    line = line.strip()

    line.gsub!(/F/, "0")
    line.gsub!(/B/, "1")
    line.gsub!(/L/, "0")
    line.gsub!(/R/, "1")

    values.push(line.to_i 2)
  end
  return values
end
```
@:@

Then `part1` is taking this input and getting the max:

@:select(languageRuby)
@:choice(scala)
```scala 3
def part1(input: List[Int]): Int = input.max
```
@:choice(ruby)
```ruby
def part1(input) 
  return input.max
end
```
@:@

## Part 2

Part 2 also seems hard, but look closer at the wording - it specifies specifically a seat that is missing from our input but with seats on either side of it.

This sounds like a perfect use for `sliding`:

@:select(languageRuby)
@:choice(scala)
```scala 3
def part2(input: List[Int]): Int =
  input.sorted.sliding(2).collectFirst:
    Function.unlift:
      case List(l, r) =>
        Option.when(r - l > 1)(r - 1)
  .get
```
@:choice(ruby)
Ruby uses `each_cons` for its sliding.
```ruby
def part2(input)
  resWindow = input.sort.each_cons(2).detect { |chunk| chunk[1] - chunk[0] > 1 }
  return resWindow[1] - 1
end
```
@:@

## Final Code

@:select(languageRuby)
@:choice(scala)
```scala 3
def parse(str: String): List[Int] =
  str.linesIterator.map: line =>
    line.foldLeft(0):
      case (acc, c) =>
        c match
          case 'F' | 'L' => acc << 1
          case 'B' | 'R' => (acc << 1) + 1
  .toList

def part1(input: List[Int]): Int = input.max

def part2(input: List[Int]): Int =
  input.sorted.sliding(2).collectFirst:
    Function.unlift:
      case List(l, r) =>
        Option.when(r - l > 1)(r - 1)
  .get
```
@:choice(ruby)
```ruby
def parse(input)
  lines = input.strip().split("\n")
  values = []
  for line in lines do
    line = line.strip()

    line.gsub!(/F/, "0")
    line.gsub!(/B/, "1")
    line.gsub!(/L/, "0")
    line.gsub!(/R/, "1")

    values.push(line.to_i 2)
  end
  return values
end

def part1(input) 
  return input.max
end

def part2(input)
  resWindow = input.sort.each_cons(2).detect { |chunk| chunk[1] - chunk[0] > 1 }
  return resWindow[1] - 1
end
```
@:@

@:benchmarkSection {
p1 = {
jvm = [0.593, 0.094],
js = [1.171, 0.355],
native = [0.247, 0.001]
},
p2 = {
jvm = [1.726, 0.140],
js = [3.456, 0.084],
native = [0.456, 0.002]
}
}

@:solution