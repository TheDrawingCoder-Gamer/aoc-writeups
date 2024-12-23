{% 
aoc.day = 14
%}
# Day 14: Restroom Redoubt

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into list of robots
2. Perform steps
  * For part 1, we just have to do it 100 times
  * For part 2, it's technically unbounded
3. For part 2, detect easter egg


## Part 1


First, I'll define `Vec2i`:
```scala
case class Vec2i(x: Int, y: Int)
```


To accommodate testing, let's define a case class `GridSize` and a `given` so we can change the size depending on the input we are using.
```scala
case class GridSize(x: Int, y: Int)

given gridSize: GridSize = GridSize(101, 103)
```

Now we can make a `Robot`:

```scala
case class Robot(pos: Vec2i, velocity: Vec2i)
```

Let's parse the input now:

```scala
def parse(str: String): List[Robot] = {
  str.linesIterator.map { case s"p=$px,$py v=$vx,$vy" => Robot(Vec2i(px.toInt, py.toInt), Vec2i(vx.toInt, vy.toInt)) }.toList
}
```

An observation of the movement rules is that when we move forward `n` steps, we don't need to calculate in between moves. A modulo will suffice.

Of course the modulo in scala doesn't work how we want, so we can define `rem`:

```scala
extension (self: Int) {
  infix def rem(that: Int): Int = {
    // these don't cancel out due to floor div
    self - that.abs * (self.toDouble / that.toDouble.abs).floor.toInt
  }
}
```

With this we can add `stepN` to `Robot`:

```scala
case class Robot(pos: Vec2i, velocity: Vec2i) {
  def stepN(n: Int = 1)(using size: GridSize): Robot = {
    copy(pos = pos.copy(x = (pos.x + n * velocity.x) rem size.x, y = (pos.y + n * velocity.y) rem size.y))
  }
}
```

To ease function calling on the `List[Robot]`, let's add extensions:

```scala
extension (robots: List[Robot])(using size: GridSize) {
  def stepN(n: Int = 1): List[Robot] = robots.map(_.stepN(n))
}
```

Let's also add the safety score as an extension as well:

```scala
extension (robots: List[Robot])(using size: GridSize) {
  // ...
  def safety: Int = {
    val middleX = size.x / 2
    val middleY = size.y / 2

    robots.groupBy { robot =>
      if (robot.pos.x == middleX || robot.pos.y == middleY) {
        -1
      } else if (robot.pos.x < middleX) {
        if (robot.pos.y < middleY) {
          0
        } else {
          2
        }
      } else {
        if (robot.pos.y < middleY) {
          1
        } else {
          3
        }
      }
    }.removed(-1).values.map(_.length).product
  }
}
```

Now we can finish part 1:

```scala
def part1(str: String): Int = {
  val input = parse(str)
  input.stepN(100).safety
}
```

## Part 2

... What? Find an image????

I was completely and entirely lost on this one because it gives you 0 information other than that the pattern is a christmas tree. My original solution was based off scarf's
where you just generate images to a file and eyeball it. However, there are better solutions from others I've read. My favorite I've seen is from a 
[solution](https://github.com/Philippus/adventofcode/blob/main/src/main/scala/adventofcode2024/Day14.scala) from [Philippus](https://github.com/philippus), where you test 
each map to see if there are 15 or more robots inline vertically or horizontally.

An important part of this problem is that the tree is actually framed by a rectangle. Testing for this rectangle is way easier than testing for the christmas tree. 

First, we need to be able to actually see our output:
```scala
extension (robots: List[Robot])(using size: GridSize) {
  // ...
  def robotMap: Vector[Vector[Int]] = {
    val goodGrid = mut.ArrayBuffer.fill(size.y, size.x)(0)

    robots.foreach { robot =>
      goodGrid(robot.pos.y)(robot.pos.x) = goodGrid(robot.pos.y)(robot.pos.x) + 1
    }

    goodGrid.map(_.toVector).toVector
  }

  def pretty: String = {
    val grid = robots.robotMap

    grid.map(_.map {
      case 0 => '.'
      case _ => '#'
    }.mkString("", "", "")).mkString("", "\n", "")
  }
}
```

Now, let's implement Philippus's solution.
```scala
extension (robots: List[Robot])(using size: GridSize) {
  // ...
  def findEasterEgg(): Unit =
    for (i <- 0 to 10000) {
      val newRobots = robots.stepN(i)
      if (newRobots.groupBy(_._1.x).map(_._2.length).max > 15 && newRobots.groupBy(_._1.y).map(_._2.length).max > 15) {
        val str = newRobots.pretty
        println(s"$i seconds:\n" + str)
      }
    }
}
```

Unfortunately, this still requires some human double checking, but this is much better than manually checking every image. On my input it only outputs 5 images.

We can make this entirely programatic by making our test a little stricter: this tests if bots are inline with gaps, but the border on a tree is completely solid.

So we modify our `findEasterEgg` function like so:

```scala

def longestSubseq[A](seq: List[A], item: A): Int =
  seq.foldLeft((0, 0)):
    case ((max, count), a) =>
      if item == a then
        (math.max(max, count + 1), count + 1)
      else
        (max, 0)
 ._1
extension (robots: List[Robot])(using size: GridSize) {
  def findEasterEgg: Int =
    (0 to 10000).find { i =>
      val newRobots = robots.stepN(i)
      if (newRobots.groupBy(_.pos.x).map(_._2.length).max > 15 && newRobots.groupBy(_.pos.y).map(_._2.length).max > 15) {

        val xLineMembers = newRobots.groupBy(_.pos.x).maxBy(_._2.length)._2.map(_.pos.y).toSet
        val yLineMembers = newRobots.groupBy(_.pos.y).maxBy(_._2.length)._2.map(_.pos.x).toSet
        val xLine = (0 until size.y).map(it => xLineMembers.contains(it)).toList
        val yLine = (0 until size.x).map(it => yLineMembers.contains(it)).toList
        longestSubseq(xLine, true) > 15 && longestSubseq(yLine, true) > 15
      } else false
    }.getOrElse(-1)
}
```

This checks the line with the most members and finds the length of the longest subsequence. If these are both higher than 15 then we found the christmas tree.

This works - no need to double check with human eyes.

We can now solve part 2 fully programatically:

```scala
def part2(str: String): Int =
  val input = parse(str)
  input.findEasterEgg
```

Final code:

```scala
case class Vec2i(x: Int, y: Int)

case class GridSize(x: Int, y: Int)

given gridSize: GridSize = GridSize(101, 103)

extension (self: Int) {
  infix def rem(that: Int): Int = {
    // these don't cancel out due to floor div
    self - that.abs * (self.toDouble / that.toDouble.abs).floor.toInt
  }
}

case class Robot(pos: Vec2i, velocity: Vec2i) {
  def stepN(n: Int = 1)(using size: GridSize): Robot = {
    copy(pos = pos.copy(x = (pos.x + n * velocity.x) rem size.x, y = (pos.y + n * velocity.y) rem size.y))
  }
}

def longestSubseq[A](seq: List[A], item: A): Int =
  seq.foldLeft((0, 0)):
    case ((max, count), a) =>
      if item == a then
        (math.max(max, count + 1), count + 1)
      else
        (max, 0)
 ._1

extension (robots: List[Robot])(using size: GridSize) {

  def stepN(n: Int = 1): List[Robot] = robots.map(_.stepN(n))
  def safety: Int = {
    val middleX = (size.x / 2)
    val middleY = (size.y / 2)

    robots.groupBy { robot =>
      if (robot.pos.x == middleX || robot.pos.y == middleY) {
        -1
      } else if (robot.pos.x < middleX) {
        if (robot.pos.y < middleY) {
          0
        } else {
          2
        }
      } else {
        if (robot.pos.y < middleY) {
          1
        } else {
          3
        }
      }
    }.removed(-1).values.map(_.length).product
  }
  def pretty: String = {
    val grid = robots.robotMap

    grid.map(_.map {
      case 0 => '.'
      case _ => '#'
    }.mkString("", "", "")).mkString("", "\n", "")
  }

  def findEasterEgg: Int =
    (0 to 10000).find { i =>
      val newRobots = robots.stepN(i)
      if (newRobots.groupBy(_.pos.x).map(_._2.length).max > 15 && newRobots.groupBy(_.pos.y).map(_._2.length).max > 15) {

        val xLineMembers = newRobots.groupBy(_.pos.x).maxBy(_._2.length)._2.map(_.pos.y).toSet
        val yLineMembers = newRobots.groupBy(_.pos.y).maxBy(_._2.length)._2.map(_.pos.x).toSet
        val xLine = (0 until size.y).map(it => xLineMembers.contains(it)).toList
        val yLine = (0 until size.x).map(it => yLineMembers.contains(it)).toList
        longestSubseq(xLine, true) > 15 && longestSubseq(yLine, true) > 15
      } else false
    }.getOrElse(-1)

  def robotMap: Vector[Vector[Int]] = {
    val goodGrid = mut.ArrayBuffer.fill(size.y, size.x)(0)

    robots.foreach { robot =>
      goodGrid(robot.pos.y)(robot.pos.x) = goodGrid(robot.pos.y)(robot.pos.x) + 1
    }

    goodGrid.map(_.toVector).toVector
  }

}

def part1(str: String): Int =
  val input = parse(str)
  input.stepN(100).safety

def part2(str: String): Int =
  val input = parse(str)
  input.findEasterEgg
```

[My Solution](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/src/main/scala/Day14.scala) on GitHub
