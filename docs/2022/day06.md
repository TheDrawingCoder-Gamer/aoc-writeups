{%
aoc.day = 6
%}

# Day 6: Turing Trouble

@:include(/inc/solutionHeader.md)

This one seems like it was easy to make short, even dumb stupid 2022 me got a short answer:
```scala 3
def process(input: String, size: Int): Int =
  input.sliding(size).indexWhere: it =>
    it.combinations(2).forall(i => i.charAt(0) != i.charAt(1))
  + size
```

@:benchmarkSection

@:solution