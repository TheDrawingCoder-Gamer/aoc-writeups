{% aoc.day = 21 %}

# Day 21: Monkey Math

@:include(/inc/solutionHeader.md)

This was a fun one to port, and I was able to clean up the parsing function. A good day.

@:benchmarkSection {
p1 = {
jvm = [7.339, 1.694],
js = [20.429, 1.425],
native = [3.995, 0.190]
},
p2 = {
jvm = [7.802, 2.684],
js = [19.731, 3.287],
native = [3.699, 0.092]
}
}

@:solution