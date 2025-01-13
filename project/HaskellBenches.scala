import java.util.concurrent.TimeUnit

object HaskellBenches {
  val benchmarks = Map(
    "day5y2021p1" -> BenchmarkTiming(
      mean = 73660672.94202898d,
      error = 8909130.433300178d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p2" -> BenchmarkTiming(
      mean = 239554935.23809522d,
      error = 21348409.451042887d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p1" -> BenchmarkTiming(
      mean = 266124356.89473686d,
      error = 12872746.349058293d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p2" -> BenchmarkTiming(
      mean = 447168.41597278183d,
      error = 3102.0087379977745d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p1" -> BenchmarkTiming(
      mean = 1700339.9826530612d,
      error = 15096.849816727d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p2" -> BenchmarkTiming(
      mean = 1854395.2292284865d,
      error = 16734.23491894167d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2021p1" -> BenchmarkTiming(
      mean = 1800281.285199856d,
      error = 14062.464144489619d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2021p2" -> BenchmarkTiming(
      mean = 4877980.583414634d,
      error = 20668.83232285702d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2021p1" -> BenchmarkTiming(
      mean = 4237068.439830508d,
      error = 126050.71248296415d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2021p2" -> BenchmarkTiming(
      mean = 16635612.388704319d,
      error = 345526.307750913d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2021p1" -> BenchmarkTiming(
      mean = 284356.45969027554d,
      error = 1537.3762699539018d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2021p2" -> BenchmarkTiming(
      mean = 310374.128440937d,
      error = 1859.9822278548518d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2021p1" -> BenchmarkTiming(
      mean = 18407137.970588237d,
      error = 150873.65999649683d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2021p2" -> BenchmarkTiming(
      mean = 67134966.0d,
      error = 2154771.7507038997d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2021p1" -> BenchmarkTiming(
      mean = 50386495.51d,
      error = 582495.9156365999d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2021p2" -> BenchmarkTiming(
      mean = 3291543897.0d,
      error = 1494887536.6044571d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    )

  ).map { case (k, v) => (k + "plathaskell", v) }
}