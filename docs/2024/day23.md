{%
aoc.day = 23
%}

# Day 23: LAN Party

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into a `List[(String, String)]`, a `List[String]` and a `Map[String, Set[String]]`.

For part 1...

1. Find all sets of length 3 that contain at least one computer starting with "t" and where all computers are interconnected.
2. Return the count of this total set.

For part 2...

1. Find the largest group of interconnected computers
2. Sort this group alphabetically and join by ','

## Part 1

Let's start the parsing. It's convienient to define a case class to automatically make the `List[String]` and
`Map[String, Set[String]]` for us:

```scala
case class LANConnections(values: List[(String, String)]):
  val allComputers: List[String] = values.flatMap((x, y) => List(x, y)).distinct
  val computerMap: Map[String, Set[String]] = 
    values.flatMap(it => List((it._1, it._2), (it._2, it._1))).groupMap(_._1)(_._2).view.mapValues(_.toSet).toMap
```

Then let's parse it:

```scala
def parse(str: String): LANConnections =
  LANConnections:
    str.linesIterator.map:
      _.split('-') match
        case Array(x, y) => (x, y)
    .toList
```

Part 1 is very easy to bruteforce, so let's just do that.

```scala
def part1(conns: LANConnections): Long =
  conns.allComputers.toSet.subsets(3).filter: l =>
    l.exists(_.head == 't')
      && l.forall: it =>
          l.filter(_ != it).forall: r =>
            conns.computerMap(it).contains(r)
  .distinct.size
```

## Part 2

Part 2, on the other hand, is near impossible to brute force naively. But a key insight is realizing that "Hey, this input is just an undirected graph."
Then doing research on subgraphs where all points are interconnected, they actually have a name: cliques. There's even a group problems called the 
Clique problem. The one we're interested in is finding the maximum (the largest) cliques in arbitrary graphs, which depends on the Bron-Kerbosch algorithim.

Let's implement this and walk through it:

```scala
def maximumClique(graph: Map[String, Set[String]]): Set[String] =
  def maximalCliques(r: Set[String], p: Set[String], x: Set[String]): Set[Set[String]] =
    if p.isEmpty && x.isEmpty then
      Set(r)
    else
      val u = p.union(x).head
      p.diff(graph(u)).foldLeft((Set[Set[String]](), p, x)):
        case ((res, p, x), v) =>
          (res ++ maximalCliques(r.incl(v), p.intersect(graph(v)), p.intersect(graph(v))), p - v, x.incl(v))
      ._1
  maximalCliques(Set(), graph.keySet, Set()).maxBy(_.size)
```

First we find all the _maximal_ cliques, which are just cliques where there is no way to make it bigger by adding a point. This is the
Bron-Kerbosch algorithim, and I can't begin to fully understand it, but it works. We then take the result of all the maximal cliques and find
the largest. This is guaranteed to be the maximum clique.

Our `part2` is now just getting the maximum clique, sorting it, and making a string out of it:

```scala
def part2(conns: LANConnections): String =
  maximumClique(conns.computerMap).toList.sorted.mkString(",")
```

## Final Code

```scala
def parse(str: String): Day23.LANConnections =
  LANConnections:
    str.linesIterator.map:
      _.split('-') match
        case Array(x, y) => (x, y)
    .toList

case class LANConnections(values: List[(String, String)]):
  val allComputers: List[String] = values.flatMap((x, y) => List(x, y)).distinct
  val computerMap: Map[String, Set[String]] =
    values.flatMap(it => List((it._1, it._2), (it._2, it._1))).groupMap(_._1)(_._2).view.mapValues(_.toSet).toMap


def maximumClique(graph: Map[String, Set[String]]): Set[String] =
  def maximalCliques(r: Set[String], p: Set[String], x: Set[String]): Set[Set[String]] =
    if p.isEmpty && x.isEmpty then
      Set(r)
    else
      val u = p.union(x).head
      p.diff(graph(u)).foldLeft((Set[Set[String]](), p, x)):
        case ((res, p, x), v) =>
          (res ++ maximalCliques(r.incl(v), p.intersect(graph(v)), p.intersect(graph(v))), p - v, x.incl(v))
      ._1
  maximalCliques(Set(), graph.keySet, Set()).maxBy(_.size)


def part1(conns: LANConnections): Long =
  conns.allComputers.toSet.subsets(3).filter: l =>
    l.exists(_.head == 't')
      && l.forall: it =>
          l.filter(_ != it).forall: r =>
            conns.computerMap(it).contains(r)
  .distinct.size

def part2(conns: LANConnections): String =
  maximumClique(conns.computerMap).toList.sorted.mkString(",")
```

[Code on GitHub](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/4cafb9bd040cff15cc9cb687506e85b63c02c299/src/main/scala/gay/menkissing/advent/Day23.scala)

@:solution