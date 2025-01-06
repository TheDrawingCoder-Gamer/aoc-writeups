{% aoc.day = 20 %}

# Day 20: Grove Positioning System

@:include(/inc/solutionHeader.md)

This is another one where the porting went really poorly for some reason (probably
the botched attempt at making it immutable), so it kind of melted my brain. It works now though.

@:benchmarkSection {
p1 = {
jvm = [39.838, 2.115],
js = [125.391, 2.900],
native = [58.614, 0.314]
},
p2 = {
jvm = [470.262, 3.820],
js = [1133.645, 9.724],
native = [851.561, 5.992]
}
}

@:solution