# Benchmarking

Some of these pages have benchmarks listed. Here's some info on what they mean:

For Scala, I use a custom benchmarker across JVM, JS, and Native that warms up 3 times then takes 3 measurements.
It forks for every single benchmark (except on native, afaik native doesn't require forking to get good results).
I've set it up so results displayed are as automatic as I can manage, so when you see a missing Scala result for a
platform, you can be sure that it timed out or crashed. 

Some notes from a naive interpretation of results so far: JVM is surprisingly good at handling high memory throughput
(meaning we allocate a lot of objects that die quickly.) JS and Native aren't very good at this, so in solutions where
we do a lot of immutable shenanigans JS and Native can fall behind quickly.

Haskell uses a similar custom benchmarker, and I've made sure to force the results.

Elixir uses Bungee, and then I convert its results with a special function in scala to make the statistics match.