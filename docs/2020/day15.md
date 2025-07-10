{% aoc.day = 15 %}

# Day 15: Rambunctious Recitation

@:include(/inc/solutionHeader.md)

Today had a surprising optimization that I honestly wasn't expecting.

## Solution Input
1. Parse input into a `List[Int]`
2. Calculate sequence, and get number at specific point

## Part 1

I'm going to actually represent my thought process. I like
representing things immutably if possible, and part 1 wasn't long
enough for me to have to optimize it.

Let's define what our structure is - we'll use a `Map` with `Int` keys
that stores either only 1 index (the first time we've seen the number) or
2 indices (the 1st and 2nd most recent times we've seen the number).

Let's encode those values with an enum:

```scala 3
enum Memory:
  case First(idx: Int)
  case Repeated(old: Int, recent: Int)

  def mostRecent: Int = this match
    case First(i) => i
    case Repeated(_, i) => i
```

Updating the map is kind of special, so we'll make a special function for
updating it:

```scala 3
def setMap(map: Map[Int, Memory], num: Int, idx: Int): Map[Int, Memory] =
  map.get(num) match
    case Some(v) => map.updated(num, Memory.Repeated(v.mostRecent, idx))
    case None => map.updated(num, Memory.First(idx))
```

Then calculating it isn't too bad:

```scala 3
def calc(input: List[Int], n: Int): Int =
  val m = input.zipWithIndex.map[(Int, Memory)]((x, i) => (x, Memory.First(i))).toMap
  Iterator.iterate((input.last, input.length, m)): (lastNum, idx, map) =>
    map(lastNum) match
      // First time we've seen it, so the number we say is zero
      case Memory.First(_) =>
        (0, idx + 1, setMap(map, 0, idx))
      // Seen before, say difference in indices
      case Memory.Repeated(i, r) =>
        val n = r - i
        (n, idx + 1, setMap(map, n, idx))
  .drop(n - input.length).next()._1
```

Ok. Maybe it is kind of bad. We start out by setting each numbers indices (this could break if the input
has duplicates, but my input didn't so it doesn't really matter). Then, starting from that last index,
we iterate by looking at the last number we said and seeing the info about it - if that was the first time
we said it we say 0, otherwise we say the difference between the two most recent indices.

Then we can hook this up to part 1:

```scala 3
def part1(input: List[Int]): Int = calc(input, 2020)
```

## Part 2

While the first part's implementation does technically work, it takes too long in garbage
collection, and when GC is the bottleneck JS and Native tend to suffer A LOT. Native had an
OOM error when attempting to solve this. It would be really nice if we didn't have to constantly allocate objects.

Let's first start with the obvious: `Memory` is kind of overkill. The most stored in it is two `Int`, which could
fit in a `Long`. So we can replace it with a Long, which isn't an object and thus isn't allocated.

`Map` is also expensive. This was the surprising part for me, and what I got from looking up other solutions after
already solving - an `Array` works just fine. We could do fancy math and figure out exactly how long it needs to be,
but it's ok to just make it the length of the input requested.

Replacing `Map` with `Array` comes with a hidden cost though - we still need to encode what
it means for something to not be present. Thankfully it's rather easy - let's just make 0 mean
"not seen yet", and to make sure we don't store 0, we'll add 1 to all indices.

Let's get started on the new `calc` function:

```scala 3
def calc(input: List[Int], n: Int): Int =
  val arr = Array.fill[Long](n)(0L)
  input.zipWithIndex.foreach: (x, i) =>
    arr(x) = i.toLong + 1L
```

Ok, we've initialized the array, but how will we set the longs? Well I came up
with a solution I'm pretty proud of - we can just bitshift 32 and add our index.
This also handles both cases for free because we selected 0 as the never seen value -
if its 0, then the upper bits will remain 0.

```scala 3
  // still inside calc, so arr is in scope
  def setArr(num: Int, idx: Int): Unit =
    arr(num) = (arr(num) << 32) + idx.toLong + 1L
```

Then we can recreate our earlier function, but mutably:

```scala 3
  var lastNum = input.last
  (input.length until n).foreach: idx =>
    val lastI = arr(lastNum)
    // If lastI is greater than int max value, that means two values are stored in the long
    if lastI > Int.MaxValue.toLong then
      // more recent number is in lower bits, 
      // so we are subtracting the higher int (old) from lower int (new)
      val x = (lastI & Int.MaxValue.toLong) - (lastI >> 32)
      lastNum = x.toInt
      setArr(x.toInt, idx)
    else
      lastNum = 0
      setArr(0, idx)
  // return
  lastNum
```

This replaces our previous calc function, so part 1 also gets faster, but let's hook it up to part 2 as well.
```scala 3
def part2(input: List[Int]): Int = calc(input, 30_000_000)
```


@:benchmarkSection {
    overrideP1 = us
    overrideP2 = ms
}

@:solution