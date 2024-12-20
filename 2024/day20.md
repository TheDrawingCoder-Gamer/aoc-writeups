---
title: "Day 20: Race Condition"
year: 2024
day: 20
layout: solution
---

## Solution Summary

1. Parse input into grid, start, end
2. Find all cheats
3. Calculate savings of all cheats and count those with savings above 100.

## Part 1

Part 1 is just a cheat of 2 picoseconds, which isn't very hard. However, to plan ahead for part 2 I'll just make it optimized now.


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

Before we find the cheats, let's write our pathfind function now. I could just pull in my `astar` function,
but initially I had some special code for limiting the amount searched and returning `None` if that limit was
exceeded. 

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

Now we can actually find all the valid cheats.

I'm not going to take credit for this optimization; I was able to solve today fully in about 20 seconds but with 
[Berg's optimization](https://gitlab.com/matthew.smedberg/advent-of-code-2024/-/blob/main/dec-20/src/main/scala/advent2024/dec20/Dec20.scala)
it's down to 1.5s for part 1 and 3 seconds for part 2. The optimization here is realizing that skips are only ever between points already on the best path,
and that the time saved is, in their words, the difference between an "geodesic metric" and an "induced metric". A geodesic path is number of steps along the path,
and the induced metric is the taxicab distance. For part 1, a cheat is a two points whose taxicab distance is 2 and their geodesic distance is greater than 2, and
the savings is the geodesic distance minus taxicab distance.

Let's define our cheat class:

```scala
case class Cheat(start: Vec2i, end: Vec2i, saved: Int)
```

Then let's find all of them:

```scala
case class RaceTrack(start: Vec2i, end: Vec2i, grid: Grid[Boolean]):
  // ...
  def findCheats(limit: Int): List[Cheat] =
    basePath.zipWithIndex.flatMap: (lp, li) =>
      basePath.zipWithIndex.drop(li).flatMap: (rp, ri) =>
        val dist = lp.taxiDistance(rp)
        Option.when(dist <= limit && (dist < ri - li))(Cheat(lp, rp, (ri - li) - dist))
```

The geodesic distance here is calculated as the difference between paths. We only take in ones where
the cheat is valid (the taxicab distance is <= the limit) and where time is saved 
(the distance is less than geodesic distance of `ri - li`). We then save the time saved in the cheat itself. All of the computation
for the time saved is right here, and we only need to pathfind once.

Part 1 is simple now:

```scala
def part1(input: RaceTrack): Int =
  val cheats = input.findCheats(2)

  cheats.count(_.saved > 100)
```

## Part 2

Because we've already optimized part 1 and planned ahead, part 2 is the same as part 1, just with the limit changed:

```scala
def part2(input: RaceTrack): Int =
  val cheats = input.findCheats(20)
 
  cheats.count(_.saved > 100)
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



override def parse(str: String): RaceTrack =
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

override def part1(input: RaceTrack): Int =
  val cheats = input.findCheats(2)

  cheats.count(_.saved >= 100)

override def part2(input: RaceTrack): Int =
  val cheats = input.findCheats(20)

  cheats.count(_.saved >= 100)
```

[Solution on github](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/src/main/scala/Day20.scala)
