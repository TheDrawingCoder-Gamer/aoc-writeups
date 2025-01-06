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

@:benchmarkSection {
p1 = {
jvm = [6.629, 0.501],
js = [18.094, 1.207],
native = [2.128, 0.099]
},
p2 = {
jvm = [10.288, 2.129],
js = [32.922, 0.428],
native = [9.184, 0.116]
}
}

@:solution