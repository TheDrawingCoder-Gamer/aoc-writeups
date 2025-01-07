# Benchmarking

Some of these pages have benchmarks listed. Here's some info on what they mean:

I use a custom benchmarker across JVM, JS, and Native that warms up 3 times then takes 3 measurements.
It forks for every single benchmark (except on native, afaik native doesn't require forking to get good results).

Some notes from a naive interpretation of results so far: JVM is surprisingly good at handling high memory throughput
(meaning we allocate a lot of objects that die quickly.) JS and Native aren't very good at this, so in solutions where
we do a lot of immutable shenanigans JS and Native can fall behind quickly. 