{% aoc.day = 4 %}

# Day 4: The Ideal Stocking Stuffer

@:include(/inc/solutionHeader.md)

For most languages (and plain Scala, if you aren't cross compiling) today isn't really that interesting.
However, it's _very_ interesting if you are doing this for Scala.JS or Scala Native.

My Scala Native version links to openssl libcrypto. JVM uses `java.security.MessageDigest`,
and JS rolls its own MD5 hash function.

@:benchmarkSection {
    overrideP1 = ms
    overrideP2 = s
}

@:solution