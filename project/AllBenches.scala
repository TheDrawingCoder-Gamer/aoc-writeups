import java.util.concurrent.TimeUnit
import scala.collection.immutable.ListMap
import scala.collection.mutable

object AllBenches {
  val haskellBench = Map(
    "day5y2021p1" -> BenchmarkTiming(
      mean = 55.58,
      error = (64.76 - 55.58),
      unit = Some(TimeUnit.MILLISECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p2" -> BenchmarkTiming(
      mean = 208.9,
      error = (242.6 - 208.9),
      unit = Some(TimeUnit.MILLISECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    )
  ).map { case (k, v) => (k + "plathaskell", v) }


  val benches = JSBenches.benchmarks ++ NativeBenches.benchmarks ++ JVMBenchmarks.benchmarks ++ haskellBench

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
