{%
aoc.day = 20
%}
# Day 20: Race Condition

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into grid, start, end
2. Find all cheats
3. Calculate savings of all cheats and count those with savings above 100.

## Part 1

Part 1 is just a cheat of 2 picoseconds, which isn't very hard.


Let's get started with our data types. I'm honestly tired of rewriting stuff for my writeups so I'm not even going to bother today,
but I'm importing `Vec2i` and `Grid` from my common package.

Then lets make a holder for our Input:

```scala
case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean])
```

Then let's parse our input:

```scala
def parse(str: String): RaceTrack =
  val goodGrid = mut.ArrayBuffer.fill(str.linesIterator.length, str.linesIterator.next().length)(false)
  var start = Vec2i(0, 0)
  var end = Vec2i(0, 0)
  str.linesIterator.zipWithIndex.foreach: (line, y) =>
    line.zipWithIndex.foreach: (char, x) =>
      char match
        case 'S' => start = Vec2i(x, y)
        case 'E' => end = Vec2i(x, y)
        case _ => ()
      char match
        case '#' => goodGrid(y)(x) = true
        case _ => ()
  RaceTrack(start, end, Grid(goodGrid))
```

Before we find the cheats, let's write our pathfind function now.

Here's the pathfinding function, and a companion timing function:

```scala
extension (grid: Grid[Boolean])
  def pathfind(start: Vec2i, goal: Vec2i): Option[List[Vec2i]] =
    def reconstructPath(cameFrom: Map[Vec2i, Vec2i], p: Vec2i): List[Vec2i] = {
      val totalPath = mut.ListBuffer[Vec2i](p)
      var current = p
      while (cameFrom.contains(current)) {
        current = cameFrom(current)
        totalPath.prepend(current)
      }
      totalPath.toList
    }
    val cameFrom = mut.HashMap[Vec2i, Vec2i]()
    val dist = mut.HashMap[Vec2i, Double](start -> 0d)

    val q = mut.PriorityQueue(start -> 0d)(using Ordering.by[(Vec2i, Double), Double](_._2).reverse)

    while q.nonEmpty && q.head._1 != goal do
      val (current, score) = q.dequeue()
      
      current.cardinalNeighbors.filter(grid.get(_).contains(false)).foreach: neighbor =>
        val alt = score + 1d
        if alt < dist.getOrElse(neighbor, Double.PositiveInfinity) then
          cameFrom(neighbor) = current
          dist(neighbor) = alt
          q.addOne(neighbor -> alt)

    q.headOption.map: (p, _) =>
      reconstructPath(cameFrom.toMap, p)
```

Let's store this in the `RaceTrack` class:

```scala
case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean]):
  lazy val basePath: List[Vec2i] = grid.pathfind(start, end).get
```

Now we can actually find all the valid cheats. For part 1 it's fairly easy to find all points; it's just finding all walls with at least two neighbors.


Let's define our cheat class:

```scala
case class Cheat(skips: Vec2i)
```

Then let's find all of them:
```scala
case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean]):
  // ...
  def findCheats(): List[Cheat] =
    grid.zipWithIndices.withFilter(_._1).flatMap: (_, p) =>
      Option.when(p.cardinalNeighbors.count(grid.get(p).contains(false)) >= 2)(Cheat(p))
```


Part 1 is simple now:

```scala
def part1(input: RaceTrack): Int =
  val baseScore = input.basePath.size
  val cheats = input.findCheats()

  cheats.count(c => input.grid.updated(c.skips)(false).pathfind(input.start, input.end).get.size >= 100)
```

## Part 2


Part 2 sets all of our previous code on fire and we'll have to rewrite almost everything.

First we need to understand some concepts. I solved this myself with a final time of ~20s, but I'm using
[Berg's optimization](https://gitlab.com/matthew.smedberg/advent-of-code-2024/-/blob/main/dec-20/src/main/scala/advent2024/dec20/Dec20.scala)
which gets it down to 4s. He realized that all that matters is skips between points already on the path, so we can use the base path and only have to
pathfind once. The difference in indices in the path of the two points is the non cheat time, and the taxicab distance between them is the
time with cheat, so the time saved is the difference between those.

Let's redefine our `Cheat` class so it works for longer skips and saves the time saved.
```scala
case class Cheat(start: Vec2i, end: Vec2i, saved: Int)
```

Let's redefine our `findCheats` function as well:

```scala
case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean]):
  // ...
  def findCheats(limit: Int): List[Cheat] =
    basePath.zipWithIndex.flatMap: (lp, li) =>
      basePath.zipWithIndex.drop(li).flatMap: (rp, ri) =>
        val dist = lp.taxiDistance(rp)
        Option.when(dist <= limit && (dist < ri - li))(Cheat(lp, rp, (ri - li) - dist))
```

We only take in ones where the cheat is valid (the taxicab distance is <= the limit) and where time is saved 
(the taxicab distance is less than path distance of `ri - li`). We then save the time saved in the cheat itself. All of the computation
for the time saved is right here, and we only need to pathfind once.

We'll have to update our part 1 code to keep it working:
```scala
def part1(input: RaceTrack): Int =
  val cheats = input.findCheats(2)

  cheats.count(_.saved >= 100)
```

As a side note, this gets part 1 from 4s down to 1.5s.

Part 2 is the same as our updated part 1 code, but with the limit set to 20:
```scala
def part2(input: RaceTrack): Int =
  val cheats = input.findCheats(20)
 
  cheats.count(_.saved >= 100)
```

## Final Code

```scala
extension (grid: Grid[Boolean])
  def pathfind(start: Vec2i, goal: Vec2i): Option[List[Vec2i]] =
    def reconstructPath(cameFrom: Map[Vec2i, Vec2i], p: Vec2i): List[Vec2i] = {
      val totalPath = mut.ListBuffer[Vec2i](p)
      var current = p
      while (cameFrom.contains(current)) {
        current = cameFrom(current)
        totalPath.prepend(current)
      }
      totalPath.toList
    }
    val cameFrom = mut.HashMap[Vec2i, Vec2i]()
    val dist = mut.HashMap[Vec2i, Double](start -> 0d)

    val q = mut.PriorityQueue(start -> 0d)(using Ordering.by[(Vec2i, Double), Double](_._2).reverse)

    while q.nonEmpty && q.head._1 != goal do
      val (current, score) = q.dequeue()

      current.cardinalNeighbors.filter(grid.get(_).contains(false)).foreach: neighbor =>
        val alt = score + 1d
        if alt < dist.getOrElse(neighbor, Double.PositiveInfinity) then
          cameFrom(neighbor) = current
          dist(neighbor) = alt
          q.addOne(neighbor -> alt)

    q.headOption.map: (p, _) =>
      reconstructPath(cameFrom.toMap, p)

case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean]):
  lazy val basePath: List[Vec2i] = grid.pathfind(start, end).get

  def findCheats(limit: Int): List[Cheat] =
    basePath.zipWithIndex.flatMap: (lp, li) =>
      basePath.zipWithIndex.drop(li).flatMap: (rp, ri) =>
        val dist = lp.taxiDistance(rp)
        Option.when(dist <= limit && (dist < ri - li))(Cheat(lp, rp, (ri - li) - dist))


case class Cheat(start: Vec2i, end: Vec2i, saved: Int)



def parse(str: String): RaceTrack =
  val goodGrid = mut.ArrayBuffer.fill(str.linesIterator.length, str.linesIterator.next().length)(false)
  var start = Vec2i(0, 0)
  var end = Vec2i(0, 0)
  str.linesIterator.zipWithIndex.foreach: (line, y) =>
    line.zipWithIndex.foreach: (char, x) =>
      char match
        case 'S' => start = Vec2i(x, y)
        case 'E' => end = Vec2i(x, y)
        case _ => ()
      char match
        case '#' => goodGrid(y)(x) = true
        case _ => ()
  RaceTrack(start, end, Grid(goodGrid))

def part1(input: RaceTrack): Int =
  val cheats = input.findCheats(2)

  cheats.count(_.saved >= 100)

def part2(input: RaceTrack): Int =
  val cheats = input.findCheats(20)

  cheats.count(_.saved >= 100)
```

[Solution on github](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/tree/e163baeaedcd90732b5e19f578a2faadeb1ef872/src/main/scala/Day20.scala)

@:benchmarkSection {
    p1 = {
        jvm = [1204.433, 15.171],
        js = [1625.689, 6.604],
        native = [3678.584, 7.629]
    },
    p2 = {
        jvm = [2351.833, 15.475],
        js = [2174.306, 82.285],
        native = [4004.255, 21.184]
    }
}

@:solution