---
title: "Day 15: Warehouse Woes"
year: 2024
day: 15
---

## Puzzle Description
<https://adventofcode.com/2024/day/15>

## Solution Summary

1. Parse input into grid, robot position, and moves list
2. Execute moves list
  * The bulk of this is calculating how boxes move when pushed.
  * In `part1`, this can fairly simply be represented as a tail recursive function.
  * In `part2`, it's hard (if not impossible) to make this function tailrec. 
    `cats.Eval` can still let us do this recursively within the limits of the JVM stack.
3. Calculate GPS coordinates and sum them

## Part 1

First, let's define our basic types. Here's `Vec2i`:

```scala
case class Vec2i(x: Int, y: Int):
  def offset(dir: Direction): Vec2i = {
    dir match
      case Direction.Up => Vec2i(x, y - 1)
      case Direction.Down => Vec2i(x, y + 1)
      case Direction.Left => Vec2i(x - 1, y)
      case Direction.Right => Vec2i(x + 1, y)
  }

  def isContainedIn(w: Int, h: Int): Boolean =
    x >= 0 && x < w && y >= 0 && y < h
```

And here's `Grid`:

```scala
case class Grid[A](values: Vector[Vector[A]]):
  val height: Int = values.size
  val width: Int = values.head.size
  
  def apply(x: Int, y: Int): A = values(y)(x)
  def apply(p: Vec2i): A = apply(p.x, p.y)
  
  def isDefinedAt(p: Vec2i): Boolean = p.isContainedIn(width, height)
  def isDefinedAt(x: Int, y: Int): Boolean = isDefinedAt(Vec2i(x, y))
  
  def updated(x: Int, y: Int)(value: A): Grid[A] = Grid(values.updated(y, values(y).updated(x, value)))
  def updated(p: Vec2i)(value: A): Grid[A] = updated(p.x, p.y)(value)
  
  def zipWithIndices: Seq[(A, Vec2i)] = {
    for {
      y <- 0 until height
      x <- 0 until width
    } yield (this (x, y), Vec2i(x, y))
  }

object Grid:
  def apply[A](values: IterableOnce[IterableOnce[A]]): Grid[A] = Grid(values.iterator.map(_.iterator.toVector).iterator.toVector)
```

Then let's make an enumeration of the possible grid items:
```scala
enum GridItem:
  case Empty, Wall, Box
```

And now a holder for the current state:

```scala
case class ProblemState(grid: Grid[GridItem], robot: Vec2i, remainingMoves: List[Direction])
```

Now we can write our parser:
```scala
def parse(str: String): ProblemState =
  val Array(gridStr, moveStr) = str.split("\n\n")
  var robotPos = Vec2i(-1, -1)
  val grid = Grid(gridStr.linesIterator.zipWithIndex.map: (str, y) =>
    str.toVector.zipWithIndex.map: (it, x) =>
      it match
        case '#' => GridItem.Wall
        case 'O' => GridItem.Box
        case '.' => GridItem.Empty
        case '@' =>
          assert(robotPos == Vec2i(-1, -1))
          robotPos = Vec2i(x, y)
          GridItem.Empty
        case _ => ???
    )
  val dirs = moveStr.linesIterator.flatten.map:
    case '<' => Direction.Left
    case '^' => Direction.Up
    case '>' => Direction.Right
    case 'v' => Direction.Down
    case _ => ???

  ProblemState(grid, robotPos, dirs.toList)
```


Now for the actual move part:

```scala
extension (grid: Grid[GridItem]) {
  @targetName("updatedMoveP1")
  def updatedMove(start: Vec2i, dir: Direction): Option[Grid[GridItem]] =
    @tailrec
    def go(curGrid: Grid[GridItem], start: Vec2i): Option[Grid[GridItem]] =
      val newPos = start.offset(dir)
      val oldItem = curGrid(start)
      curGrid(newPos) match
        case GridItem.Wall => None
        case GridItem.Empty => Some(curGrid.updated(newPos)(oldItem))
        case GridItem.Box => go(curGrid, newPos)

    go(grid, start).map: it =>
      val newPos = start.offset(dir)
      if it.isDefinedAt(newPos) then
        it.updated(newPos)(GridItem.Empty)
      else it
}
```

This took a while to figure out, but here's what it's doing: It checks the point that is being moved to. If it's empty, it ends there and
_copies the starting item to that position_. If it's a `Wall` then it returns early, saying that this move is impossible. If it's a `Box`,
it recurses, starting at the boxes position. Copying the starting item to the position at the end is important to make sure the boxes slide.
This implementation wouldn't work if each box had a unique ID, but boxes are identical apart from their coordinates so we can safely ignore their identity.

Now to go back to the problem state, now let's hook up our grid step function with the inputs we have:

```scala
case class ProblemState(grid: Grid[GridItem], robot: Vec2i, remainingMoves: List[Direction]):
  def step: Option[ProblemState] =
    remainingMoves match
      case head :: rest =>
        grid.updatedMove(robot, head) match
          case Some(newGrid) => Some(ProblemState(newGrid, robot.offset(head), rest))
          case _ => Some(ProblemState(grid, robot, rest))
      case _ => None
```

And let's also add a function to calculate the sum of the gps calculations:

```scala
  // ...
  def gpsCalc: Long =
    grid.zipWithIndices.filter(_._1 == GridItem.Box).map((_, p) => p.y.toLong * 100L + p.x.toLong).sum
```

Now we can write our part 1 solution:
```scala
def part1(str: String): Long =
  val input = parse(str)
  Iterator.iterate(input): i =>
    i.step.getOrElse(i)
  .find(_.remainingMoves.isEmpty).get.gpsCalc
```

## Part 2

For my code I ended up having to duplicate of lot of code to accomadate the new `BoxL` and `BoxR`.

Most of the duplication comes from making a new enumeration:

```scala
enum GridItemP2:
  case Empty, Wall, BoxL, BoxR
```

Let's make a new state holder as well:

```scala
case class ProblemStateP2(grid: Grid[GridItemP2], robot: Vec2i, remainingMoves: List[Direction]):
  // ...
```

And we may as well add the `gpsCalc` function here too:

```scala
  // ...
  def gpsCalc: Long =
    grid.zipWithIndices.filter(_._1 == GridItemP2.BoxL).map((_, p) => p.y.toLong * 100L + p.x.toLong).sum
```

We also need a way to convert the initial problem state to our new problem state, like here:

```scala
case class ProblemState(grid: Grid[GridItem], robot: Vec2i, remainingMoves: List[Direction]):
  // ...
  def doubled: ProblemStateP2 =
    val newGrid = Grid(grid.values.map(_.flatMap:
      case GridItem.Box => List(GridItemP2.BoxL, GridItemP2.BoxR)
      case GridItem.Wall => List(GridItemP2.Wall, GridItemP2.Wall)
      case GridItem.Empty => List(GridItemP2.Empty, GridItemP2.Empty)
    ))
    ProblemStateP2(newGrid, robot.copy(x = robot.x * 2), remainingMoves)
```


Now for the hard part: the movement for part 2. This was my implementation:

```scala
extension (grid: Grid[GridItemP2])
  @targetName("updatedMoveP2")
  def updatedMove(istart: Vec2i, dir: Direction): Option[Grid[GridItemP2]] =
    // ???
    def go(start: Vec2i, movedItems: List[(Vec2i, GridItemP2)]): Eval[Option[List[(Vec2i, GridItemP2)]]] =
      val newPos = start.offset(dir)
      grid(newPos) match
        case GridItemP2.Wall => Eval.always(None)
        case GridItemP2.Empty => Eval.now(Some(movedItems))
        case GridItemP2.BoxL =>
          val rPos = newPos.offset(Direction.Right)
          assert(grid(rPos) == GridItemP2.BoxR)
          val newItems = movedItems.prepended(newPos, GridItemP2.BoxL)
          dir match
            case Direction.Left | Direction.Right =>
              go(newPos, newItems)
            case Direction.Up | Direction.Down =>
              go(newPos, newItems).flatMap:
                case Some(it) => go(rPos, it.prepended(rPos, GridItemP2.BoxR))
                case None => Eval.now(None)
        case GridItemP2.BoxR =>
          val lPos = newPos.offset(Direction.Left)
          assert(grid(lPos) == GridItemP2.BoxL)
          val newItems = movedItems.prepended(newPos, GridItemP2.BoxR)
          dir match
            case Direction.Right | Direction.Left =>
              go(newPos, newItems)
            case Direction.Up | Direction.Down =>
              go(newPos, newItems).flatMap:
                case Some(it) => go(lPos, it.prepended(lPos, GridItemP2.BoxL))
                case None => Eval.now(None)


    go(istart, List()).value.map:
      val alreadyInspected = mut.Set[Vec2i]()
      _.foldLeft(grid.updated(istart)(GridItemP2.Empty)):
        case (g, (p, item)) =>
          if (!alreadyInspected.contains(p))
            alreadyInspected.add(p)
            g.updated(p)(GridItemP2.Empty).updated(p.offset(dir))(item)
          else g
```

Here we use Eval which trampolines computations meaning that the recursion can be of arbitrary depth. Unlike last time, this internal tailrec function
returns a `Option[List[(Vec2i, GridItemP2)]]`. This lists all the points that were found valid to move from, and at the end these are all
folded together to get back a grid.

Let's walk through the logic here. `go` is first called with the robots position, and it offsets that position by the direction.
If it finds an empty spot, it ends and returns an empty list, as no box was moved. If it finds a wall it returns `None`, meaning that this movement
isn't possible. Otherwise, it must have hit either a box's left piece or a box's right piece. The logic of these two are mirrored but otherwise the same.
If the direction is `Left` or `Right` then we don't have to do anything special - this is basically the same as the part 1 case. 
If the direction is `Up` or `Down` though, then we have to test both edges. 

This function has a throughline of movedItems which is just a list of all the box pieces that were moved. This is threaded through in the `BoxL` and `BoxR` cases,
prepending the position and type of each edge.

I start with the edge the robot runs into, `flatMap` the `Eval` 
(which lets me use the value of the last function call while staying stack safe), and test the value. 

If it's `None`, the first edge is immovable and I can
stop there. Otherwise, I have to test the other edge, so I return the test of the other edge.

At the end, I get the `.value` of the `Eval`, which just executes it, then `map` the option.
To prevent some oddities, I use a mutable `Set` to make sure I don't move a piece multiple times. Other than that, the `foldLeft` is fairly straight forward,
updating the old point to `Empty` and updating the new point to the piece type.

It's important here that the return of `go` is in an order where boxes that fill empty spaces go first. This makes 
the `foldLeft` work properly, as otherwise it would end up erasing boxes that it had already drawn.

Ok, now with the huge hard part out of the way we can hook up `step` in `ProblemStateP2`:

```scala
case class ProblemStateP2(grid: Grid[GridItemP2], robot: Vec2i, remainingMoves: List[Direction]):
  // ...
  def step: Option[ProblemStateP2] =
    remainingMoves match
      case head :: rest =>
        grid.updatedMove(robot, head) match
          case Some(newGrid) => Some(ProblemStateP2(newGrid, robot.offset(head), rest))
          case _ => Some(ProblemStateP2(grid, robot, rest))
      case _ => None
```

And now we can finish part 2:

```scala
def part2(str: String): Long =
  val input = parse(str)
  Iterator.iterate(input.doubled): i =>
    i.step.getOrElse(i)
  .find(_.remainingMoves.isEmpty).get.gpsCalc
```

Final code:

```scala
enum Direction:
  case Up, Down, Left, Right

case class Vec2i(x: Int, y: Int):
  def offset(dir: Direction): Vec2i = {
    dir match
      case Direction.Up => Vec2i(x, y - 1)
      case Direction.Down => Vec2i(x, y + 1)
      case Direction.Left => Vec2i(x - 1, y)
      case Direction.Right => Vec2i(x + 1, y)
  }

  def isContainedIn(w: Int, h: Int): Boolean =
    x >= 0 && x < w && y >= 0 && y < h

case class Grid[A](values: Vector[Vector[A]]):
  val height: Int = values.size
  val width: Int = values.head.size

  def apply(x: Int, y: Int): A = values(y)(x)
  def apply(p: Vec2i): A = apply(p.x, p.y)

  def isDefinedAt(p: Vec2i): Boolean = p.isContainedIn(width, height)
  def isDefinedAt(x: Int, y: Int): Boolean = isDefinedAt(Vec2i(x, y))

  def updated(x: Int, y: Int)(value: A): Grid[A] = Grid(values.updated(y, values(y).updated(x, value)))
  def updated(p: Vec2i)(value: A): Grid[A] = updated(p.x, p.y)(value)

  def zipWithIndices: Seq[(A, Vec2i)] = {
    for {
      y <- 0 until height
      x <- 0 until width
    } yield (this (x, y), Vec2i(x, y))
  }
object Grid:
  def apply[A](values: IterableOnce[IterableOnce[A]]): Grid[A] = Grid(values.iterator.map(_.iterator.toVector).iterator.toVector)
enum GridItem:
  case Empty, Wall, Box

enum GridItemP2:
  case Empty, Wall, BoxL, BoxR

extension (grid: Grid[GridItem]) {
  @targetName("updatedMoveP1")
  def updatedMove(start: Vec2i, dir: Direction): Option[Grid[GridItem]] =
    @tailrec
    def go(curGrid: Grid[GridItem], start: Vec2i): Option[Grid[GridItem]] =
      val newPos = start.offset(dir)
      val oldItem = curGrid(start)
      curGrid(newPos) match {
          case GridItem.Wall => None
          case GridItem.Empty => Some(curGrid.updated(newPos)(oldItem))
          case GridItem.Box => go(curGrid, newPos)
        }

      // prevent weird
      go(grid, start).map: it =>
        val newPos = start.offset(dir)
        if it.isDefinedAt(newPos) then
          it.updated(newPos)(GridItem.Empty)
        else it

  def pretty: String =
    grid.values.map: it =>
      it.map:
        case GridItem.Empty => '.'
        case GridItem.Wall => '#'
        case GridItem.Box => 'O'
      .mkString("", "", "")
    .mkString("", "\n", "")
}

extension (grid: Grid[GridItemP2])
  @targetName("updatedMoveP2")
  def updatedMove(istart: Vec2i, dir: Direction): Option[Grid[GridItemP2]] =
    // ???
    def go(start: Vec2i, movedItems: List[(Vec2i, GridItemP2)]): Eval[Option[List[(Vec2i, GridItemP2)]]] =
      val newPos = start.offset(dir)
      grid(newPos) match
        case GridItemP2.Wall => Eval.always(None)
        case GridItemP2.Empty => Eval.now(Some(movedItems))
        case GridItemP2.BoxL =>
          val rPos = newPos.offset(Direction.Right)
          assert(grid(rPos) == GridItemP2.BoxR)
          val newItems = movedItems.prepended(newPos, GridItemP2.BoxL)
          dir match
            case Direction.Left | Direction.Right =>
              go(newPos, newItems)
            case Direction.Up | Direction.Down =>
              go(newPos, newItems).flatMap:
                case Some(it) => go(rPos, it.prepended(rPos, GridItemP2.BoxR))
                case None => Eval.now(None)
        case GridItemP2.BoxR =>
          val lPos = newPos.offset(Direction.Left)
          assert(grid(lPos) == GridItemP2.BoxL)
          val newItems = movedItems.prepended(newPos, GridItemP2.BoxR)
          dir match
            case Direction.Right | Direction.Left =>
              go(newPos, newItems)
            case Direction.Up | Direction.Down =>
              go(newPos, newItems).flatMap:
                case Some(it) => go(lPos, it.prepended(lPos, GridItemP2.BoxL))
                case None => Eval.now(None)


    go(istart, List()).value.map:
      val alreadyInspected = mut.Set[Vec2i]()
      _.foldLeft(grid.updated(istart)(GridItemP2.Empty)):
        case (g, (p, item)) =>
          if (!alreadyInspected.contains(p))
            alreadyInspected.add(p)
            g.updated(p)(GridItemP2.Empty).updated(p.offset(dir))(item)
          else g

case class ProblemState(grid: Grid[GridItem], robot: Vec2i, remainingMoves: List[Direction]):
  def step: Option[ProblemState] =
    remainingMoves match
      case head :: rest =>
        grid.updatedMove(robot, head) match
          case Some(newGrid) => Some(ProblemState(newGrid, robot.offset(head), rest))
          case _ => Some(ProblemState(grid, robot, rest))
      case _ => None

  def gpsCalc: Long =
    grid.zipWithIndices.filter(_._1 == GridItem.Box).map((_, p) => p.y.toLong * 100L + p.x.toLong).sum

  def doubled: ProblemStateP2 =
    val newGrid = Grid(grid.values.map(_.flatMap:
      case GridItem.Box => List(GridItemP2.BoxL, GridItemP2.BoxR)
      case GridItem.Wall => List(GridItemP2.Wall, GridItemP2.Wall)
      case GridItem.Empty => List(GridItemP2.Empty, GridItemP2.Empty)
    ))
    ProblemStateP2(newGrid, robot.copy(x = robot.x * 2), remainingMoves)

case class ProblemStateP2(grid: Grid[GridItemP2], robot: Vec2i, remainingMoves: List[Direction]):
  def step: Option[ProblemStateP2] =
    remainingMoves match
      case head :: rest =>
        grid.updatedMove(robot, head) match
          case Some(newGrid) => Some(ProblemStateP2(newGrid, robot.offset(head), rest))
          case _ => Some(ProblemStateP2(grid, robot, rest))
      case _ => None

  def gpsCalc: Long =
    grid.zipWithIndices.filter(_._1 == GridItemP2.BoxL).map((_, p) => p.y.toLong * 100L + p.x.toLong).sum

def parse(str: String): ProblemState =
  val Array(gridStr, moveStr) = str.split("\n\n")
  var robotPos = Vec2i(-1, -1)
  val grid = Grid(gridStr.linesIterator.zipWithIndex.map: (str, y) =>
    str.toVector.zipWithIndex.map: (it, x) =>
      it match
        case '#' => GridItem.Wall
        case 'O' => GridItem.Box
        case '.' => GridItem.Empty
        case '@' =>
          assert(robotPos == Vec2i(-1, -1))
          robotPos = Vec2i(x, y)
          GridItem.Empty
        case _ => ???
    )
  val dirs = moveStr.linesIterator.flatten.map:
    case '<' => Direction.Left
    case '^' => Direction.Up
    case '>' => Direction.Right
    case 'v' => Direction.Down
    case _ => ???

  ProblemState(grid, robotPos, dirs.toList)

def part1(str: String): Long =
  val input = parse(str)
  Iterator.iterate(input): i =>
    i.step.getOrElse(i)
  .find: it =>
    it.remainingMoves.isEmpty
  .get.gpsCalc


def part2(str: String): Long =
  val input = parse(str)
  Iterator.iterate(input.doubled): i =>
    i.step.getOrElse(i)
  .find(_.remainingMoves.isEmpty).get.gpsCalc

```

Here's my [full solution](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/src/main/scala/Day15.scala). My solution uses my common package
but for this page I rewrote them into the script.
