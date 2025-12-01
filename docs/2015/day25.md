{% aoc.day = 25 %}

# Day 25: Let It Snow

@:include(/inc/solutionHeader.md)

## Solution Summary
1. Get coordinates from input
2. Calculate index in sequence from coordinates
3. Get value in sequence

## Solution

Let's get started with parsing:

```scala 3
def parse(str: String): Vec2[Int] =
  str.trim match
    case s"$_ row $y, column $x." =>
      Vec2(x.toInt, y.toInt)
```

Initially I had solved this with trial and error math and some mental brainstorming, but I had failed to use OEIS the first time.

I had instantly recognized the triangular numbers in the first row of the table, so I had built my initial solution around that. However,
after a while I came back and looked at OEIS's [page for triangular numbers](https://oeis.org/A000217) and it turns out that there was
a reference to another type of triangle in there - [Floyd's triangle](https://en.wikipedia.org/wiki/Floyd%27s_triangle). The triangle numbers
are the right edge of that triangle, and the coordinates of our triangle seem to be a slightly modified version of that. If I could translate
row column to an index into floyd's triangle then I would have the index into the sequence, as our triangle is labeled the same way floyd's
triangle is.

Before we get too willy nilly with our triangles, let's implement the triangular numbers first. I have a binomial implementation
in my common lib, but it's kind of a mess so I'll reimplement a simpler version here for conveinience:
```scala 3
def triangularNumber(n: Int): Int =
  (1 to n).sum
```


In the below image, our puzzle space is rotated 45 degrees, with the first row of our puzzle space being the right edge of floyd's triangle,
and the first column of our puzzle space being the left edge of floyd's triangle. So we need to convert from puzzle space to floyd's triangle
space.

![floyd's triangle](https://upload.wikimedia.org/wikipedia/commons/9/93/Centered_square_numbers_vs_triangular_numbers.svg)

I'll call our input coordinates X and Y, and our floyd destination coordinates R and C, for row and column.
Based off the above image, you can see that C happens to align with X (if you tilt your head you can see that each right edge makes
a column in our original puzzle AND in the triangle). R is a bit more complicated, but I calculated it to be X - 1 + Y (reminder that
our puzzle coordinates start at 1, 1, not 0, 0). Proving this is an exercise for the reader 😉

Now, using the property that the right edge of floyd's triangle is the triangular numbers, I can translate R and C to an index by first getting the last
index of the previous row (which will be triangularNumber(R - 1)) and adding C.

Let's convert our coordinates into an index (starting from 1):

```scala 3
def xyToN(v: Vec2[Int]): Int =
  val r = v.x - 1 + v.y
  val c = v.x
  triangularNumber(r - 1) + c
```

We need to implement the actual sequence from the puzzle, but that's a very simple ask:
```scala 3
def advance(v: Long): Long = (v * 252533L) % 33554393L
```

Then our solution is simple:
```scala 3
def part1(input: Vec2[Int]): Long =
  val n = xyToN(input)
  // convert a 1 index to a zero index
  advance.repeated(n - 1)(20151125L)
```

## Final Code

```scala 3
def parse(str: String): Vec2[Int] =
  str.trim match
    case s"$_ row $y, column $x." =>
      Vec2(x.toInt, y.toInt)

def triangularNumber(n: Int): Int =
  (1 to n).sum

def xyToN(v: Vec2[Int]): Int =
  val r = v.x - 1 + v.y
  val c = v.x
  triangularNumber(r - 1) + c

def advance(v: Long): Long = (v * 252533L) % 33554393L

def part1(input: Vec2[Int]): Long =
  val n = xyToN(input)
  advance.repeated(n - 1)(20151125L)
```



@:benchmarkSection {
    overrideP1 = ms
}


@:solution