import java.util.concurrent.TimeUnit
import scala.collection.immutable.ListMap
import scala.collection.mutable

object AllBenches {


  val benches = JSBenches.benchmarks ++ NativeBenches.benchmarks ++ JVMBenches.benchmarks ++ HaskellBenches.benchmarks

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
