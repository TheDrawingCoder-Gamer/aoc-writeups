{%
aoc.day = 23
%}

# Day 23: LAN Party

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `List[(Int, Int)]` and a `Map[Int, BitSet]`.

For part 1...

1. Find all sets of length 3 that contain at least one computer starting with "t" and where all computers are interconnected.
2. Return the count of this total set.

For part 2...

1. Find the largest group of interconnected computers
2. Sort this group alphabetically and join by ','

## Part 1

For parsing, we'll be parsing into an `Int` so we can take advantage of `BitSet` and the speed of primitive equality.

Let's define an object to convert between the input and `Int`:

```scala 3
object Computer:
  // We want this number to be as small as possible so the bitset
  // chooses the least amount of bits needed
  def apply(str: String): Int =
    val c1 = str(0) - 'a'
    val c2 = str(1) - 'a'
    // highest bit set is 5
    (c1 << 5) + c2

  def startsWithT(n: Int): Boolean =
    ((n >> 5) + 'a').toChar == 't'

  def unapply(n: Int): String =
    val c1 = ((n >> 5) + 'a').toChar
    val c2 = ((n & 0b11111) + 'a').toChar
    String.valueOf(Array(c1, c2))
```

For bitsets we want our number to be as small as possible, so we only take 5 bits, which is the amount of bits the number 25 takes to store.

Let's start the parsing. It's convenient to define a case class to automatically make the `Map[Int, BitSet]` for us:

```scala 3
case class LANConnections(values: List[(Int, Int)]):
  val computerMap: Map[Int, BitSet] =
    values.flatMap(it => List((it._1, it._2), (it._2, it._1))).groupMap(_._1)(_._2).view.mapValues(_.to(BitSet)).toMap

```

Then let's parse it:

```scala 3
def parse(str: String): LANConnections =
  LANConnections:
    str.linesIterator.map:
      case s"$x-$y" =>
        (Computer(x), Computer(y))
    .toList
```

Part 1 can't be fully bruteforced in a reasonable amount of time, but we don't need to fully brute force it, we can step along
the "triangle" while searching:

```scala 3
def part1(conns: LANConnections): Long =
  val goodMap = conns.computerMap
  val res = for {
    (n1, n2s) <- goodMap.iterator
    if Computer.startsWithT(n1)
    n2 <- n2s.iterator
    n3 <- goodMap(n2).iterator
    if n3 != n2
    n4 <- goodMap(n3).iterator
    if n4 == n1
  } yield Set(n1, n2, n3)

  res.distinct.size
```

## Part 2

Part 2, on the other hand, is near impossible to brute force naively. But a key insight is realizing that "Hey, this input is just an undirected graph."
Then doing research on subgraphs where all points are interconnected, they actually have a name: cliques. There's even a group problems called the 
Clique problem. The one we're interested in is finding the maximum (the largest) cliques in arbitrary graphs, which depends on the Bron-Kerbosch algorithim.

Let's implement this and walk through it:

```scala 3
def maximumClique(graph: Map[Int, BitSet]): BitSet =
  def maximalCliques(r: BitSet, p: BitSet, x: BitSet): Set[BitSet] =
    if p.isEmpty && x.isEmpty then
      Set(r)
    else
      val u = p.union(x).head
      p.diff(graph(u)).foldLeft((Set[BitSet](), p, x)):
        case ((res, p, x), v) =>
          (res ++ maximalCliques(r.incl(v), p.intersect(graph(v)), p.intersect(graph(v))), p - v, x.incl(v))
       ._1
  maximalCliques(BitSet(), graph.keySet.to(BitSet), BitSet()).maxBy(_.size)


```

First we find all the _maximal_ cliques, which are just cliques where there is no way to make it bigger by adding a point. This is the
Bron-Kerbosch algorithim, and I can't begin to fully understand it, but it works. We then take the result of all the maximal cliques and find
the largest. This is guaranteed to be the maximum clique.

Our `part2` is now just getting the maximum clique, sorting it, and making a string out of it. This is why we made the 
`Computer.unapply` function earlier:

```scala 3
def part2(conns: LANConnections): String =
  maximumClique(conns.computerMap).map(Computer.unapply).toList.sorted.mkString(",")

```

## Final Code

```scala 3
def parse(str: String): Day23.LANConnections =
  LANConnections:
    str.linesIterator.map:
      case s"$x-$y" =>
        (Computer(x), Computer(y))
    .toList

object Computer:
  // We want this number to be as small as possible so the bitset
  // chooses the least amount of bits needed
  def apply(str: String): Int =
    val c1 = str(0) - 'a'
    val c2 = str(1) - 'a'
    // highest bit set is 5
    (c1 << 5) + c2

  def startsWithT(n: Int): Boolean =
    ((n >> 5) + 'a').toChar == 't'

  def unapply(n: Int): String =
    val c1 = ((n >> 5) + 'a').toChar
    val c2 = ((n & 0b11111) + 'a').toChar
    String.valueOf(Array(c1, c2))

case class LANConnections(values: List[(Int, Int)]):
  val computerMap: Map[Int, BitSet] =
    values.flatMap(it => List((it._1, it._2), (it._2, it._1))).groupMap(_._1)(_._2).view.mapValues(_.to(BitSet)).toMap


def maximumClique(graph: Map[Int, BitSet]): BitSet =
  def maximalCliques(r: BitSet, p: BitSet, x: BitSet): Set[BitSet] =
    if p.isEmpty && x.isEmpty then
      Set(r)
    else
      val u = p.union(x).head
      p.diff(graph(u)).foldLeft((Set[BitSet](), p, x)):
        case ((res, p, x), v) =>
          (res ++ maximalCliques(r.incl(v), p.intersect(graph(v)), p.intersect(graph(v))), p - v, x.incl(v))
      ._1
  maximalCliques(BitSet(), graph.keySet.to(BitSet), BitSet()).maxBy(_.size)


def part1(conns: LANConnections): Long =
  val goodMap = conns.computerMap
  val res = for {
    (n1, n2s) <- goodMap.iterator
    if Computer.startsWithT(n1)
    n2 <- n2s.iterator
    n3 <- goodMap(n2).iterator
    if n3 != n2
    n4 <- goodMap(n3).iterator
    if n4 == n1
  } yield Set(n1, n2, n3)

  res.distinct.size

def part2(conns: LANConnections): String =
  maximumClique(conns.computerMap).map(Computer.unapply).toList.sorted.mkString(",")
```

[Code on GitHub](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/4cafb9bd040cff15cc9cb687506e85b63c02c299/src/main/scala/gay/menkissing/advent/Day23.scala)

@:benchmarkSection {
    p1 = {
        jvm = [10.388, 1.019],
        js = [13.862, 1.151],
        native = [6.611, 0.185]
    },
    p2 = {
        jvm = [17.497, 3.799],
        js = [25.193, 0.936],
        native = [9.713, 0.032]
    }
}

@:solution