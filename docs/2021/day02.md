{% aoc.day = 2 %}

# Day 2: Dive!

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `List[(Dir, Int)]`
2. Calculate depth and x, and multiply them
   * For part 1, this is fairly simple as it's just a simple fold
   * This requires a bit more effort for part 2, but it's not too hard

## Part 1

Today is an Elixir day and I bothered to port it today, so we get to do both!

Let's define the `Dir` and how to parse it first:

@:select(languageElixir)
@:choice(scala)
```scala 3
enum Dir:
  case Forward
  case Down
  case Up

object Dir:
  def parse(str: String): Dir =
    str match
      case "forward" => Dir.Forward
      case "down" => Dir.Down
      case "up" => Dir.Up
```
@:choice(elixir)
Elixir is a dynamic language, so I didn't bother making an enum - I'm just using atoms here, which is something
that I _think_ is from Lisp. It's symbols that are prefixed with `:`, so we're using `:forward`,
`:down`, and `:up` here.
@:@

Now let's parse our input:

@:select(languageElixir)
@:choice(scala)
```scala 3
def parse(input: String): List[(Dir, Int)] =
  input.linesIterator.map:
    case s"$dir $n" =>
      val d = Dir.parse(dir)
      (d, n.toInt)
  .toList
```
@:choice(elixir)
```elixir
def parse_int!(str) do
  case Integer.parse(str) do
    {int, ""} -> int
    _ -> nil
  end
end

def parse(input) do
  for line <- String.split(String.trim(input), "\n"),
    line != "" do
    parts = String.split(String.trim(line), " ")
    dir = Enum.at(parts, 0)
    num = Enum.at(parts, 1) |> parse_int!
    case dir do
      "forward" -> {:forward, num}
      "up" -> {:up, num}
      "down" -> {:down, num}
    end
  end
end
```
@:@

Part 1 is just a `foldLeft` (or a `reduce` in Elixir, same thing).

@:select(languageElixir)
@:choice(scala)
```scala 3
def part1(input: List[(Dir, Int)]): Int =
   val (horz, depth) = input.foldLeft((0, 0, 0)):
      case ((horz, depth), (dir, n)) =>
         dir match
            case Dir.Forward => (horz + n, depth)
            case Dir.Down => (horz, depth + n)
            case Dir.Up => (horz, depth - n)

   depth * horz
```
@:choice(elixir)
```elixir
def part1(input) do
  {horz, depth} = input |> Enum.reduce({0, 0}, fn x, {h, d} -> 
    case x do
      {:forward, num} -> {h + num, d}
      {:down   , num} -> {h, d + num}
      {:up     , num} -> {h, d - num}
    end
  end)
  depth * horz
end

```
@:@

## Part 2

Part 2 isn't too bad, and I can actually show off a feature of Elixir that is similar to something haskell can do:
it's pattern binding with overloads.


@:select(languageElixir)
@:choice(scala)
```scala 3
def part2(input: List[(Dir, Int)]): Int =
  @tailrec
  def go(rest: List[(Dir, Int)], aim: Int, depth: Int, x: Int): (Int, Int) =
    rest match
      case Nil => (x, depth)
      case head :: next =>
        head match
          case (Dir.Forward, i) => go(next, aim, depth + aim * i, x + i)
          case (Dir.Down,    i) => go(next, aim + i, depth, x)
          case (Dir.Up,      i) => go(next, aim - i, depth, x)
  val (x, depth) = go(input, 0, 0, 0)
  x * depth
```
@:choice(elixir)
```elixir
def calc_depth([], _, depth, x), do: {x, depth}

def calc_depth([head | tail], aim, depth, x) do
  case head do
    {:forward, num} -> calc_depth(tail, aim, depth + aim * num, x + num)
    {:down   , num} -> calc_depth(tail, aim + num, depth, x)
    {:up     , num} -> calc_depth(tail, aim - num, depth, x)
  end
end

def part2(input) do
  {x, depth} = calc_depth(input, 0, 0, 0)
  x * depth
end
```
@:@

I want to touch on the Elixir solution more, because I really like how it looks. The first binding tests for empty list,
and returns the x and depth if so. The next overload splits the list into head and tail, so we can match on the head and
update the depth and aim accordingly. The Scala implementation is basically the same as this but without cool overloading.

## Final Code

@:select(languageElixir)
@:choice(scala)
```scala 3
enum Dir:
  case Forward
  case Down
  case Up

object Dir:
  def parse(str: String): Dir =
    str match
      case "forward" => Dir.Forward
      case "down" => Dir.Down
      case "up" => Dir.Up

def parse(input: String): List[(Dir, Int)] =
  input.linesIterator.map:
    case s"$dir $n" =>
      val d = Dir.parse(dir)
      (d, n.toInt)
  .toList


def part1(input: List[(Dir, Int)]): Int =
   val (horz, depth) = input.foldLeft((0, 0)):
      case ((horz, depth), (dir, n)) =>
         dir match
            case Dir.Forward => (horz + n, depth)
            case Dir.Down => (horz, depth + n)
            case Dir.Up => (horz, depth - n)

   depth * horz

  val depth = down - up

  depth * horz

def part2(input: List[(Dir, Int)]): Int =
  @tailrec
  def go(rest: List[(Dir, Int)], aim: Int, depth: Int, x: Int): (Int, Int) =
    rest match
      case Nil => (x, depth)
      case head :: next =>
        head match
          case (Dir.Forward, i) => go(next, aim, depth + aim * i, x + i)
          case (Dir.Down,    i) => go(next, aim + i, depth, x)
          case (Dir.Up,      i) => go(next, aim - i, depth, x)
  val (x, depth) = go(input, 0, 0, 0)
  x * depth
```
@:choice(elixir)
```elixir
defmodule Day02 do
  def parse_int!(str) do
    case Integer.parse(str) do
      {int, ""} -> int
      _ -> nil
    end
  end

  def parse(input) do
    for line <- String.split(String.trim(input), "\n"),
      line != "" do
      parts = String.split(String.trim(line), " ")
      dir = Enum.at(parts, 0)
      num = Enum.at(parts, 1) |> parse_int!
      case dir do
        "forward" -> {:forward, num}
        "up" -> {:up, num}
        "down" -> {:down, num}
      end
    end
  end

  def part1(input) do
    {horz, depth} = input |> Enum.reduce({0, 0}, fn x, {h, d} -> 
      case x do
        {:forward, num} -> {h + num, d}
        {:down   , num} -> {h, d + num}
        {:up     , num} -> {h, d - num}
      end
    end)
    depth * horz
  end

  def calc_depth([], _, depth, x), do: {x, depth}

  def calc_depth([head | tail], aim, depth, x) do
    case head do
      {:forward, num} -> calc_depth(tail, aim, depth + aim * num, x + num)
      {:down   , num} -> calc_depth(tail, aim + num, depth, x)
      {:up     , num} -> calc_depth(tail, aim - num, depth, x)
    end
  end

  def part2(input) do
    {x, depth} = calc_depth(input, 0, 0, 0)
    x * depth
  end
end
```
@:@

@:solution