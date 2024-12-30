{%
aoc.day = 3
%}

# Day 3: Toboggan Trajectory

@:include(/inc/solutionHeader.md)

Today's another Haxe day. Today uses Haxe's `for` comprehension which lets you save for results into arrays.

## Solution Summary

1. Parse input into a `Vector[Vector[Boolean]]`
2. Test slope(s), and multiply them together if more than 1

## Part 1

Let's parse our input:

@:select(languageHaxe)
@:choice(scala)
```scala 3
def parse(str: String): Vector[Vector[Boolean]] =
  str.linesIterator.map(_.map(_ == '#').toVector).toVector
```
@:choice(haxe)
As always Haxe struggles with newlines, so we need to bring in `StringTools` to trim.

```haxe
using StringTools;
// ...
static function parse(str: String): Array<Array<Bool>> {
    
   return [for (line in str.trim().split("\n")) {
        line = line.trim();
        [for (char in line.split("")) char == "#"];
    }];
}
```
@:@

Then let's define a function to test a slope. The solution between languages differs a lot because I really
wanted to show off the functional programming aspect of scala.

@:select(languageHaxe)
@:choice(scala)
```scala 3
extension (self: Vector[Vector[Boolean]])
  def testSlope(slopeX: Int, slopeY: Int): Int =
    Iterator.iterate((0, 0))((x, y) => ((x + slopeX) % self.head.length, y + slopeY))
            .takeWhile((_, y) => y < self.length)
            .count((x, y) => self(y)(x))
```
@:choice(haxe)
Haxe's auto casting into abstracts is kind of jank but it just works here. We have to explicitly specify
`Int64` because part2 will need it later, but part 1 works fine if it's just a normal `Int`.

```haxe
static function testSlope(input: Array<Array<Bool>>, slopeX: Int, slopeY: Int): Int64 {
    var xPos = 0;
    var yPos = 0;
    var treeBonk = 0;
    while (yPos + slopeY < input.length) {
        xPos += slopeX;
        xPos %= input[0].length;
        yPos += slopeY;

        if (input[yPos][xPos]) {
            treeBonk++;
        }
    }

    return treeBonk;
}
```
@:@

Then for part 1 we just hook up this function directly with the defined slope of `3, 1`:

@:select(languageHaxe)
@:choice(scala)
```scala 3
def part1(input: Vector[Vector[Boolean]]): Long =
  input.testSlope(3, 1)
```
@:choice(haxe)
```haxe
static function part1(input: Array<Array<Bool>>): Int64 {
    return testSlope(input, 3, 1);
}
```
@:@

## Part 2

Part 2 is just testing multiple slopes and multiplying them together. Since we've already extracted the `testSlope`
function, it's easy to do this:

@:select(languageHaxe)
@:choice(scala)
```scala 3
def part2(input: Vector[Vector[Boolean]]): Long =
  List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2)).foldLeft(1L):
    case (acc, (x, y)) => acc * input.testSlope(x, y)
```
@:choice(haxe)
```haxe
static function part2(input: Array<Array<Bool>>): Int64 {
    final slopes = [[1, 1], [3, 1], [5, 1], [7, 1], [1, 2]];
    var res: Int64 = 1;
    for (slope in slopes) {
        res *= testSlope(input, slope[0], slope[1]);
    }
    return res;
}
```
@:@

## Final Code

@:select(languageHaxe)
@:choice(scala)
```scala 3
def parse(str: String): Vector[Vector[Boolean]] =
  str.linesIterator.map(_.map(_ == '#').toVector).toVector

extension (self: Vector[Vector[Boolean]])
  def testSlope(slopeX: Int, slopeY: Int): Int =
    Iterator.iterate((0, 0))((x, y) => ((x + slopeX) % self.head.length, y + slopeY))
            .takeWhile((_, y) => y < self.length)
            .count((x, y) => self(y)(x))

def part1(input: Vector[Vector[Boolean]]): Long =
  input.testSlope(3, 1)

def part2(input: Vector[Vector[Boolean]]): Long =
  List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2)).foldLeft(1L):
    case (acc, (x, y)) => acc * input.testSlope(x, y)
```
@:choice(haxe)
```haxe
import haxe.Int64;
using StringTools;

class Day03 {
    static function parse(str: String): Array<Array<Bool>> {
	
       return [for (line in str.trim().split("\n")) {
	    line = line.trim();
	    [for (char in line.split("")) char == "#"];
	}];
    }

    static function testSlope(input: Array<Array<Bool>>, slopeX: Int, slopeY: Int): Int64 {
	var xPos = 0;
	var yPos = 0;
	var treeBonk = 0;
	while (yPos + slopeY < input.length) {
	    xPos += slopeX;
	    xPos %= input[0].length;
	    yPos += slopeY;

	    if (input[yPos][xPos]) {
		treeBonk++;
	    }
	}

	return treeBonk;
    }

    static function part1(input: Array<Array<Bool>>): Int64 {
	return testSlope(input, 3, 1);
    }

    static function part2(input: Array<Array<Bool>>): Int64 {
	final slopes = [[1, 1], [3, 1], [5, 1], [7, 1], [1, 2]];
	var res: Int64 = 1;
	for (slope in slopes) {
	    res *= testSlope(input, slope[0], slope[1]);
	}
	return res;
    }
}
```
@:@

@:solution