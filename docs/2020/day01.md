{%
aoc.day = 1
%}

# Day 1: Report Repair

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into `List[Int]`
2. Get `n` entries that sum to 2020, and get their product
    * In part 1 `n` is 2
    * In part 2 `n` is 3
 

## Part 1

Let's parse first. 

@:select(languageHaxe)
@:choice(scala)
```scala 3
def parse(str: String): List[Int] =
  str.linesIterator.map(_.toInt).toList
```
@:choice(haxe)
Haxe has issues with newlines, so we'll need to pull in `StringTools` to `trim` it.
```haxe
using StringTools;

class Day01 {
    static public function parse(str: String): Array<Int> {
        return str.trim().split("\n").map((a) -> Std.parseInt(a.trim()));
    }
}
```
@:@

Then, let's iterate both. I never ran into this with my input, but just for safety let's check to make sure our indexes
don't overlap:

@:select(languageHaxe)
@:choice(scala)
Scala's `combinations` function is a perfect fit here, and does exactly what we need.
`flatMap` on an `Iterator` into an `Option` and then `next` is like doing `find`, but we can map the value
immediately.
```scala 3
def part1(input: List[Int]): Int =
  input.combinations(2).flatMap { case List(x, y) =>
    Option.when(x + y == 2020)(x * y)
  }.next()
```
@:choice(haxe)
```haxe
// inside Day01...
static public function part1(ls: Array<Int>): Int {
  for (xi => x in ls) {
      for (yi => y in ls) {
          if (xi != yi && x + y == 2020) {
              return x * y;
          }
      } 
   }
   return -1;
}
```
@:@

## Part 2

Part 2 is just iterating over a 3rd time, which is easy.

@:select(languageHaxe)
@:choice(scala)
For Scala only minor changes are needed:
```scala 3
def part2(input: List[Int]): Int =
  input.combinations(3).flatMap { case List(x, y, z) =>
    Option.when(x + y + z == 2020)(x * y * z)
  }.next()
```
@:choice(haxe)
```haxe
static public function part2(ls: Array<Int>): Int {
    for (xi => x in ls) {
        for (yi => y in ls) {
            if (xi != yi) {
                for (zi => z in ls) {
                    if (xi != zi && yi != zi && x + y + z == 2020) {
                        return x * y * z;
                    }
                }
            }
        }
    }
    return -1;
}
```
@:@

And that's part 2 done.

## Final Code

@:select(languageHaxe)
@:choice(scala)
```scala
def parse(str: String): List[Int] =
  str.linesIterator.map(_.toInt).toList

def part1(input: List[Int]): Int =
  input.combinations(2).flatMap { case List(x, y) =>
    Option.when(x + y == 2020)(x * y)
  }.next()

def part2(input: List[Int]): Int =
  input.combinations(3).flatMap { case List(x, y, z) =>
    Option.when(x + y + z == 2020)(x * y * z)
  }.next()
```
@:choice(haxe)
```haxe
using StringTools;

class Day01 {
    static public function parse(str: String): Array<Int> {
		return str.trim().split("\n").map((a) -> Std.parseInt(a.trim()));
	}
	
    static public function part1(ls: Array<Int>): Int {
        for (xi => x in ls) {
           for (yi => y in ls) {
               if (xi != yi && x + y == 2020) {
                   return x * y;
               }
           } 
        }
        return -1;
    }
    static public function part2(ls: Array<Int>): Int {
       for (xi => x in ls) {
           for (yi => y in ls) {
               if (xi != yi) {
                   for (zi => z in ls) {
                       if (xi != zi && yi != zi && x + y + z == 2020) {
                           return x * y * z;
                       }
                   }
               }
           }
       }
       return -1;
    } 
}
```
@:@
