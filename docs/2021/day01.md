{%
aoc.day = 1
%}

# Day 1: Sonar Sweep

@:include(/inc/solutionHeader.md)

The first two days I actually wrote my solution in Elixir but I quickly got tired of it. As a treat though, I've updated my Elixir code
to a more sensible solution so it can stand alongside my scala.

## Solution Summary

1. Parse input into `List[Int]`
2. For part 2, calculate the sliding sums of this list.
3. Count instances where a number is greater than its previous number

## Part 1

Parsing is easy (in scala, at least). Elixir forces you to always handle errors but frankly I could care less here.

@:select(languageElixir)
@:choice(scala)
```scala 3
def parse(str: String): List[Int] =
    str.linesIterator.map(_.toInt).toList
```
@:choice(elixir)
All Elixir functions will be inside `defmodule Day1`. 
```elixir
defmodule Day1 do
  def parse_int!(str) do
    case Integer.parse(str) do
      { v, "" } -> v
      :error -> nil
    end
  end

  def parse(str) do
    for line <- String.split(String.trim(str), "\n"), 
    line != "", 
    do: Day1.parse_int!(String.trim(line))
  end
end
```
@:@

Let's then do an easy measurement. It's just a sliding window:

@:select(languageElixir)
@:choice(scala)
```scala 3
def measureScans(scans: List[Int]): Int =
 scans.sliding(2).count: ls =>
   ls.head < ls.tail.head
```
@:choice(elixir)
```elixir
# inside Day1...
def measurement_basic(list) do
  Enum.chunk_every(list, 2, 1, :discard) 
    |> Enum.count(fn a -> Enum.at(a, 0) < Enum.at(a, 1) end)
end

```
@:@

And hook it up:

@:select(languageElixir)
@:choice(scala)
```scala 3
def part1(input: List[Int]): Int =
  measureScans(input)
```
@:choice(elixir)
```elixir
def part1(list) do
  measurement_basic(list)
end
```
@:@

And that's part 1. 

## Part 2

Part 2 is easy - we convert the input list into a new list then rerun part 1 on this new list.

Let's convert the list with sliding sums:

@:select(languageElixir)
@:choice(scala)
```scala 3
def slidingSums(scans: List[Int]): List[Int] =
  scans.sliding(3).map(_.sum).toList
```
@:choice(elixir)
```elixir
def sliding_sum(list) do
  Enum.chunk_every(list, 3, 1, :discard)
    |> Enum.map(fn a -> Enum.sum(a) end)
end
```
@:@

Then hook it up:

@:select(languageElixir)
@:choice(scala)
```scala 3
def part2(input: List[Int]): Int =
  measureScans(slidingSums(input))
```
@:choice(elixir)
```elixir
def part2(list) do
  list |> sliding_sum |> measurement_basic 
end
```
@:@

And that's part 2. 

## Final Code

@:select(languageElixir)
@:choice(scala)
```scala 3
def parse(str: String): List[Int] =
  str.linesIterator.map(_.toInt).toList

def measureScans(scans: List[Int]): Int =
  scans.sliding(2).count: ls =>
    ls.head < ls.tail.head
def part1(input: List[Int]): Int =
  measureScans(input)

def slidingSums(scans: List[Int]): List[Int] =
  scans.sliding(3).map(_.sum).toList

def part2(input: List[Int]): Int =
  measureScans(slidingSums(input))
```
@:choice(elixir)
```elixir
defmodule Day1 do
  def parse_int!(str) do
    case Integer.parse(str) do
      { v, "" } -> v
      :error -> nil
    end
  end
  def measurement_basic(list) do
    Enum.chunk_every(list, 2, 1, :discard) 
      |> Enum.count(fn a -> Enum.at(a, 0) < Enum.at(a, 1) end)
  end
  def part1(list) do
    measurement_basic(list)
  end
  def sliding_sum(list) do
    Enum.chunk_every(list, 3, 1, :discard)
      |> Enum.map(fn a -> Enum.sum(a) end)
  end
  def part2(list) do
    list |> sliding_sum |> measurement_basic 
  end
  def parse(str) do
    for line <- String.split(String.trim(str), "\n"), 
      line != "", 
      do: Day1.parse_int!(String.trim(line))
  end
end
```
@:@

@:solution