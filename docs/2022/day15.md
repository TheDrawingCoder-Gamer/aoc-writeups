{% aoc.day = 15 %}

# Day 15: Beacon Exclusion Zone

@:include(/inc/solutionHeader.md)

This one took a bit to optimize; ended up having to plagiarize the optimization from the Scala Center writeup.

@:benchmarkSection {
    p1 = {
        jvm = [1731.283, 191.029],
        js = [849.076, 170.324],
        native = [51.427, 0.055],
    },
    p2 = {
        jvm = [2395997.047, 57324.073],
        js = [9896581.787, 33106.563],
        native = [6545453.547, 5342.771],
        asUnit = ms
    },
    unit = us
}

@:solution
