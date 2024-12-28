{%
aoc.day = 2
%}

# Day 2: Password Philosophy

Here's another Haxe day, but today's Haxe code was rewritten from the ground up because the original was very confusing.

## Solution Summary

1. Parse input into a `List` of policy entries
2. Count entries where password is valid
    * For `part1`, this is counting the number of characters in the password that match the character in the entry.
    * For `part2`, this is an xor between 2 positions based on whether they match the entry's character.

## Part 1

Let's first define what a `PolicyEntry` is:

@:select(languageHaxe)
@:choice(scala)
```scala 3
case class PolicyEntry(left: Int, right: Int, of: Char, password: String)
```
@:choice(haxe)
```haxe
typedef PolicyEntry = {
    var min: Int;
    var max: Int;
    var char: String;
    var password: String;
};
```
@:@

Let's then parse our input:

@:select(languageHaxe)
@:choice(scala)
```scala 3
def parse(str: String): List[PolicyEntry] =
  str.linesIterator.map:
    case s"$lower-$upper $char: $password" =>
      assert(char.length == 1)
      PolicyEntry(lower.toInt, upper.toInt, char.head, password.trim())
  .toList
```
@:choice(haxe)
As always, Haxe really sucks at handling newlines properly. We need to bring in `StringTools` to trim the string.
```haxe
using StringTools;
// ...
static public function parse(str: String): Array<PolicyEntry> {
    var policies: Array<PolicyEntry> = [];
    for (line in str.trim().split("\n")) {
        final reg =  ~/(\d+)-(\d+) ([a-z]): ([a-z]+)/;
        final goodLine = line.trim();
        reg.match(goodLine);
        final entry: PolicyEntry = {
            min: Std.parseInt(reg.matched(0)), 
            max: Std.parseInt(reg.matched(1)), 
            char: reg.matched(3), 
            password: reg.matched(4)
        };
        policies.push(entry);
    }
    return policies;
}

```
@:@

Then we can do part 1, which is just a simple `count`:

@:select(languageHaxe)
@:choice(scala)
Range is helpful here and saves us having to write out the comparison manually.
```scala 3
def part1(input: List[PolicyEntry]): Int =
  input.count: entry =>
    (entry.left to entry.right).contains(entry.password.count(_ == entry.of))
```
@:choice(haxe)
Haxe doesn't really have a count function, but it has `filter`, so `filter` into `length` is acceptable here.
For the main loop though I just use a mutable variable.

Haxe `String` _also_ doesn't even have a `filter` function, so I have to convert it to an `Array<String>` with
`split("")`.

```haxe
static public function part1(policies: Array<PolicyEntry>): Int {
    var count = 0;
    for (entry in policies) {
        final size = entry.password.split("").filter((it) -> it == entry.char).length;
        if (size >= entry.min && size <= entry.max) {
            count += 1;
        }
    }
    return count;
}
```
@:@

That's part 1.

## Part 2

Part 2 is easy, we just replace our test with an xor test.

@:select(languageHaxe)
@:choice(scala)
Scala lets you use the `^` operator on Booleans directly:
```scala 3
def part2(input: List[PolicyEntry]): Int =
  input.count: entry =>
    val l = entry.password(entry.left - 1) == entry.of
    val r = entry.password(entry.right - 1) == entry.of
    l ^ r
```
@:choice(haxe)
Haxe doesn't actually have a dedicated `Char` class, so I'm just comparing strings here.
The closest is `charCodeAt` which returns an `Int`.

The xor op here is self explainatory.
```haxe
static public function part2(policies: Array<PolicyEntry>): Int {
    var count = 0;
    for (entry in policies) {
        final l = entry.password.charAt(entry.min - 1) == entry.char;
        final r = entry.password.charAt(entry.max - 1) == entry.char;
        // xor
        if ((l || r) && !(l && r)) {
            count += 1;
        }
    }
    return count;
}

```
@:@

## Final Code

@:select(languageHaxe)
@:choice(scala)
```scala 3
case class PolicyEntry(left: Int, right: Int, of: Char, password: String)

def parse(str: String): List[PolicyEntry] =
  str.linesIterator.map:
    case s"$lower-$upper $char: $password" =>
      assert(char.length == 1)
      PolicyEntry(lower.toInt, upper.toInt, char.head, password.trim())
  .toList

def part1(input: List[PolicyEntry]): Int =
  input.count: entry =>
    (entry.left to entry.right).contains(entry.password.count(_ == entry.of))

def part2(input: List[PolicyEntry]): Int =
  input.count: entry =>
    val l = entry.password(entry.left - 1) == entry.of
    val r = entry.password(entry.right - 1) == entry.of
    l ^ r
```
@:choice(haxe)
```haxe
using StringTools;


typedef PolicyEntry = {
    var min: Int;
    var max: Int;
    var char: String;
    var password: String;
};

class Day02 {

    static public function parse(str: String): Array<PolicyEntry> {
        var policies: Array<PolicyEntry> = [];
	for (line in str.trim().split("\n")) {
	    final reg =  ~/(\d+)-(\d+) ([a-z]): ([a-z]+)/;
	    final goodLine = line.trim();
	    reg.match(goodLine);
            final entry: PolicyEntry = {
		min: Std.parseInt(reg.matched(0)), 
		max: Std.parseInt(reg.matched(1)), 
		char: reg.matched(3), 
		password: reg.matched(4)
	    };
	    policies.push(entry);
	}
	return policies;
    }

    static public function part1(policies: Array<PolicyEntry>): Int {
	var count = 0;
	for (entry in policies) {
	    final size = entry.password.split("")
                .filter((it) -> it == entry.char).length;
	    if (size >= entry.min && size <= entry.max) {
		count += 1;
	    }
	}
	return count;
    }

    static public function part2(policies: Array<PolicyEntry>): Int {
	var count = 0;
	for (entry in policies) {
	    final l = entry.password.charAt(entry.min - 1) == entry.char;
	    final r = entry.password.charAt(entry.max - 1) == entry.char;
	    // xor
	    if ((l || r) && !(l && r)) {
		count += 1;
	    }
	}
	return count;
    }
}
```
@:@
