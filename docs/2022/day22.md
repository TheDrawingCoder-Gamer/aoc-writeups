{% aoc.day = 22 %}

# Day 22: Monkey Map

@:include(/inc/solutionHeader.md)

I finally got around to part 2 (with some inspiration from other solutions) and it's FINE...
I don't know how generic my implementation is (I tried to implement every net, but I can't really test it)

@:benchmarkSection {
p1 = {
jvm =[33.310, 0.738],
js =  [67.564, 2.312],
native = [36.962, 0.770]
},
p2 = {
jvm = [12.966, 0.520],
js = [16.929, 0.180],
native = [8.226, 0.142]
}

}

@:solution