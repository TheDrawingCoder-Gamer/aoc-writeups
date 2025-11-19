{% aoc.day = 24 %}

# Day 24: It Hangs in the Balance

@:include(/inc/solutionHeader.md)

Due to my implementation depending on our "input" N (derived from a portion of the sum of input numbers),
part 2 is actually faster than part 1 because it has a smaller N.

@:benchmarkSection {
    overrideP1 = ms
    overrideP2 = ms
}

@:solution