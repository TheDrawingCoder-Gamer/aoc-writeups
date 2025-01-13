# Benchmarking

Some of these pages have benchmarks listed. Here's some info on what they mean:

For Scala, I use a custom benchmarker across JVM, JS, and Native that warms up, and measures. It warms up at least 3 times,
but it will always take at least 5 seconds to warmup, repeating if needed. It then takes as many samples as it can in 5 seconds,
with the minimum being 3. This is fine for really long benchmarks (>10s) and short benchmarks (<1s) but in between the error
can get really high, with some even exceeding the mean itself, making it useless.

Some notes from a naive interpretation of results so far: JVM is surprisingly good at handling high memory throughput
(meaning we allocate a lot of objects that die quickly.) JS and Native aren't very good at this, so in solutions where
we do a lot of immutable shenanigans JS and Native can fall behind quickly.

Haskell uses a similar custom benchmarker, and I've made sure to force the results.

Elixir uses Bungee, and then I convert its results with a special function in scala to make the statistics match.