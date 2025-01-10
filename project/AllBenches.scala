import java.util.concurrent.TimeUnit
import scala.collection.immutable.ListMap
import scala.collection.mutable

object AllBenches {
  val elixirBenches = Map(
    "day2y2021p2"-> BenchmarkTiming(
      mean = 670.30,
      error = 2.684,
      unit = Some(TimeUnit.MICROSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day2y2021p1"-> BenchmarkTiming(
      mean = 673.12,
      error = 2.704,
      unit = Some(TimeUnit.MICROSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day1y2021p1"-> BenchmarkTiming(
      mean = 764.94,
      error = 4.372,
      unit = Some(TimeUnit.MICROSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day1y2021p2"-> BenchmarkTiming(
      mean = 953.73,
      error = 4.702,
      unit = Some(TimeUnit.MICROSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    )
  ).map { case (k, v) => (k + "platelixir", v) }

  val benches = JSBenches.benchmarks ++ NativeBenches.benchmarks ++
    JVMBenches.benchmarks ++ HaskellBenches.benchmarks ++ elixirBenches



  def constructBenchmarkFor(names: ListMap[String, String], day: Int, year: Int, part: Int): Option[Benchmark] = {
    val builder = Map.newBuilder[String, BenchmarkTiming]
    val prefix = s"day${day}y${year}p${part}"
    names.keysIterator.foreach { key =>
      benches.get(prefix + "plat" + key).foreach { timing =>
        // ???
        builder.+=((key, timing))
      }
    }
    val daMap = builder.result()
    if (daMap.nonEmpty)
      Some(Benchmark(daMap))
    else
      None
  }
}
