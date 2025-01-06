{% aoc.day = 8 %}

# Day 8: Handheld Halting

@:include(/inc/solutionHeader.md)

Wow! Another bytecode interpreter! Now with solving the halting problem!

@:benchmarkSection {
p1 = {
jvm = [3.023, 0.604],
js = [7.748, 0.145],
native = [0.748, 0.111]
},
p2 = {
jvm = [4.973, 0.235],
js = [12.337, 1.734],
native = [2.1663, 0.011]
}
}

@:solution