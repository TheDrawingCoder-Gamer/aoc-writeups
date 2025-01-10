import java.util.concurrent.TimeUnit

object HaskellBenches {
  val benchmarks = Map(
    "day5y2021p1" -> BenchmarkTiming(
      mean = 62492945.0d,
      error = 26242935.045774784d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p2" -> BenchmarkTiming(
      mean = 246905304.6d,
      error = 42078822.97856483d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p1" -> BenchmarkTiming(
      mean = 227764453.2d,
      error = 33186838.16976277d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p2" -> BenchmarkTiming(
      mean = 657800.8d,
      error = 159337.78134215565d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p1" -> BenchmarkTiming(
      mean = 2574496.9d,
      error = 547109.0754784005d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p2" -> BenchmarkTiming(
      mean = 2414222.7d,
      error = 505933.4567912997d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    )

  ).map { case (k, v) => (k + "plathaskell", v) }
}