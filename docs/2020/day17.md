{% aoc.day = 17 %}

# Day 17: Conway Cubes

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `Set[Vec3]`
2. Perform 6 steps
    * For part 2, we'll need to convert into a `Set[Vec4]` first

## Part 1

With my existing common lib it was easiest to parse into a `Grid[Boolean]` first then
extract the `true` indexes:
```scala 3
def parse(str: String): Input =
  Grid.fromString(str)(_ == '#').zipWithIndices.flatMap:
    case (true, Vec2(x, y)) => Some(Vec3(x, 0, y))
    case _                  => None
  .toSet
```

Now we have to make our "step" function. Thankfully, scala 3.8.0 comes with a builtin "conwayStep" function:
Scala 3.8.0 isn't out yet, so we'll have to copy it into our code:
```scala 3
def conwayStep[A]
  (
    neighbors: A => Iterable[A],
    testKeepAlive: Int => Boolean,
    testBirth: Int => Boolean
  )
  (set: Set[A]): Set[A] =
  val extendedSet = set.flatMap(it => neighbors(it).toSet + it)
  val withKilled =
    set.filter: p =>
      val r = neighbors(p).count(set.apply)
      testKeepAlive(r)
  val deadSet = extendedSet -- set
  val withBorn =
    deadSet.filter: it =>
      testBirth(neighbors(it).count(set.apply))
  withKilled ++ withBorn
```

Then, we can define a step here. To make it easier, I'll bind `testKeepAlive` and `testBirth` so we can reuse this later.

```scala 3
def step[A](neighbors: A => Iterable[A])(state: Set[A]): Set[A] =
  conwayStep[A](neighbors, it => it == 2 || it == 3, _ == 3)(state)
```

Now part 1 is as easy as repeating this N times - I use a custom `repeated` impl, but cats has
`SemigroupK[Endo]` which lets you do `SemigroupK[Endo].combineNK(step[Vec3], 6)` which should be
the same result.

Note that in my real code Vec3 is parameterized with Int. In your code you can define your own,
non generic Vec3.
```scala 3
def part1(input: Set[Vec3[Int]]): Int =
  step[Vec3[Int]](_.allNeighbors).repeated(6)(input).size
```

## Part 2

Part 2 is a piece of cake - first we define a simple Vec4 (no need to do anything fancy, just define neighbors)

```scala 3
final case class Vec4(x: Int, y: Int, z: Int, w: Int):
  def allNeighbors: List[Vec4] =
    for
      x <- (this.x - 1) to (this.x + 1)
      y <- (this.y - 1) to (this.y + 1)
      z <- (this.z - 1) to (this.z + 1)
      w <- (this.w - 1) to (this.w + 1)
      if x != this.x || y != this.y || z != this.z || w != this.w
    yield Vec4(x, y, z, w)
```

@:callout(info)

In my real code, Vec4 is also parameterized so I can take advantage of my generic Vector macro.
This macro implements the neighbors function somewhat more efficiently by enumerating each case explicitly
rather than also including the empty case.

@:@

Now for our part 2 code:

```scala 3
def part2(input: Set[Vec3[Int]]): Int =
  val newInput = input.map(it => Vec4(it.x, it.y, it.z, 0))
  step[Vec4](_.allNeighbors).repeated(6)(newInput).size
```

## Final Code
```scala 3
def parse(str: String): Input =
  Grid.fromString(str)(_ == '#').zipWithIndices.flatMap:
    case (true, Vec2(x, y)) => Some(Vec3(x, 0, y))
    case _                  => None
  .toSet

def conwayStep[A]
  (
    neighbors: A => Iterable[A],
    testKeepAlive: Int => Boolean,
    testBirth: Int => Boolean
  )
  (set: Set[A]): Set[A] =
  val extendedSet = set.flatMap(it => neighbors(it).toSet + it)
  val withKilled =
    set.filter: p =>
      val r = neighbors(p).count(set.apply)
      testKeepAlive(r)
  val deadSet = extendedSet -- set
  val withBorn =
    deadSet.filter: it =>
      testBirth(neighbors(it).count(set.apply))
  withKilled ++ withBorn

def step[A](neighbors: A => Iterable[A])(state: Set[A]): Set[A] =
  conwayStep[A](neighbors, it => it == 2 || it == 3, _ == 3)(state)

def part1(input: Set[Vec3[Int]]): Int =
  step[Vec3[Int]](_.allNeighbors).repeated(6)(input).size

final case class Vec4(x: Int, y: Int, z: Int, w: Int):
  def allNeighbors: List[Vec4] =
    for
      x <- (this.x - 1) to (this.x + 1)
      y <- (this.y - 1) to (this.y + 1)
      z <- (this.z - 1) to (this.z + 1)
      w <- (this.w - 1) to (this.w + 1)
      if x != this.x || y != this.y || z != this.z || w != this.w
    yield Vec4(x, y, z, w)

def part2(input: Set[Vec3[Int]]): Int =
  val newInput = input.map(it => Vec4(it.x, it.y, it.z, 0))
  step[Vec4](_.allNeighbors).repeated(6)(newInput).size
```

(In case you were wondering, no, `conwayStep` is not actually in the stdlib. I extracted it out to my
common lib because a day later this year reuses it.)

@:benchmarkSection {
    overrideP1 = ms
    overrideP2 = ms
}

@:solution