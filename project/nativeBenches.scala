import java.util.concurrent.TimeUnit

object NativeBenches {
  val benchmarks = Map(
    "day1y2020p1" -> BenchmarkTiming(
      mean = 1.4612487E7d,
      error = 910443.3361815794d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2020p2" -> BenchmarkTiming(
      mean = 2.8706938E8d,
      error = 3.366939526697782E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2020p1" -> BenchmarkTiming(
      mean = 1425007.0d,
      error = 38336.32874150535d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1321717.3333333333d,
      error = 184242.9390071567d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2020p1" -> BenchmarkTiming(
      mean = 162773.33333333334d,
      error = 50081.00329711618d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2020p2" -> BenchmarkTiming(
      mean = 238773.33333333334d,
      error = 6758.1166807430745d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2020p1" -> BenchmarkTiming(
      mean = 1.1224178666666666E7d,
      error = 7962620.837592178d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2020p2" -> BenchmarkTiming(
      mean = 1.0909905E7d,
      error = 1451699.1618107099d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2020p1" -> BenchmarkTiming(
      mean = 260613.33333333334d,
      error = 107736.90161957477d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2020p2" -> BenchmarkTiming(
      mean = 560850.3333333334d,
      error = 41483.83538663328d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2020p1" -> BenchmarkTiming(
      mean = 2091124.3333333333d,
      error = 219813.78520621953d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2020p2" -> BenchmarkTiming(
      mean = 2072537.6666666667d,
      error = 136751.05854876642d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2020p1" -> BenchmarkTiming(
      mean = 1.0684545E7d,
      error = 271749.58311129874d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2020p2" -> BenchmarkTiming(
      mean = 5565579.333333333d,
      error = 276362.84170891886d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2020p1" -> BenchmarkTiming(
      mean = 783720.6666666666d,
      error = 14302.50714949627d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2020p2" -> BenchmarkTiming(
      mean = 2285447.6666666665d,
      error = 7609.088112971139d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2020p1" -> BenchmarkTiming(
      mean = 7790687.0d,
      error = 555594.164925292d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2020p2" -> BenchmarkTiming(
      mean = 7833967.0d,
      error = 206404.90032881542d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2020p1" -> BenchmarkTiming(
      mean = 14926.666666666666d,
      error = 2337.9188035871534d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2021p1" -> BenchmarkTiming(
      mean = 609487.0d,
      error = 69177.7442439084d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2021p2" -> BenchmarkTiming(
      mean = 1288673.6666666667d,
      error = 258377.62009084993d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2021p1" -> BenchmarkTiming(
      mean = 1010437.0d,
      error = 131836.34621681098d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2021p2" -> BenchmarkTiming(
      mean = 986450.6666666666d,
      error = 70841.40378331921d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2021p1" -> BenchmarkTiming(
      mean = 386046.6666666667d,
      error = 68544.676395263d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2021p2" -> BenchmarkTiming(
      mean = 286513.3333333333d,
      error = 7776.383070993658d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2021p1" -> BenchmarkTiming(
      mean = 7661037.333333333d,
      error = 118589.6547263075d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2021p2" -> BenchmarkTiming(
      mean = 3.4455973333333336E7d,
      error = 2376687.1624326566d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p1" -> BenchmarkTiming(
      mean = 3.3816313E7d,
      error = 6473691.654728307d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p2" -> BenchmarkTiming(
      mean = 6.7591282E7d,
      error = 1467757.3054195046d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p1" -> BenchmarkTiming(
      mean = 6.977880666666667E7d,
      error = 5251195.745122155d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p2" -> BenchmarkTiming(
      mean = 268560.0d,
      error = 12810.505974850286d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p1" -> BenchmarkTiming(
      mean = 236683.66666666666d,
      error = 71373.05617542374d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p2" -> BenchmarkTiming(
      mean = 161576.66666666666d,
      error = 28600.32869043021d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2021p1" -> BenchmarkTiming(
      mean = 2.6036737811333332E10d,
      error = 4.1756375911044745E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2021p2" -> BenchmarkTiming(
      mean = 2.5899841643666668E10d,
      error = 4.159304506521011E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2021p1" -> BenchmarkTiming(
      mean = 3.6446730666666664E7d,
      error = 2173670.614775094d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2021p2" -> BenchmarkTiming(
      mean = 2.0805544523333333E9d,
      error = 1.739499349784183E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2021p1" -> BenchmarkTiming(
      mean = 599243.6666666666d,
      error = 9155.978160417468d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2022p1" -> BenchmarkTiming(
      mean = 463510.3333333333d,
      error = 153382.01223861446d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2022p2" -> BenchmarkTiming(
      mean = 479917.0d,
      error = 10730.421492127218d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2022p1" -> BenchmarkTiming(
      mean = 7434353.666666667d,
      error = 184522.0594334365d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2022p2" -> BenchmarkTiming(
      mean = 7459700.0d,
      error = 438228.87873865274d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2022p1" -> BenchmarkTiming(
      mean = 744227.0d,
      error = 79984.49307504918d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2022p2" -> BenchmarkTiming(
      mean = 1372274.3333333333d,
      error = 49967.89524362294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2022p1" -> BenchmarkTiming(
      mean = 2.2190054333333332E7d,
      error = 1136469.3423446652d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2022p2" -> BenchmarkTiming(
      mean = 2.2139681E7d,
      error = 234350.87315065903d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2022p1" -> BenchmarkTiming(
      mean = 1290577.3333333333d,
      error = 23831.359652723975d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2022p2" -> BenchmarkTiming(
      mean = 1143587.3333333333d,
      error = 130899.29734375772d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2022p1" -> BenchmarkTiming(
      mean = 2345184.3333333335d,
      error = 212873.38344915982d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2022p2" -> BenchmarkTiming(
      mean = 1.0994078333333334E7d,
      error = 356138.536233728d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2022p1" -> BenchmarkTiming(
      mean = 3677801.3333333335d,
      error = 237511.3860653515d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2022p2" -> BenchmarkTiming(
      mean = 3708668.6666666665d,
      error = 66357.90314992986d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2022p1" -> BenchmarkTiming(
      mean = 1.100315205E9d,
      error = 3.5618164305299565E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2022p2" -> BenchmarkTiming(
      mean = 1.225217818E9d,
      error = 4.3650009494584575E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2022p1" -> BenchmarkTiming(
      mean = 1.2977413E7d,
      error = 388917.5919435838d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2022p2" -> BenchmarkTiming(
      mean = 1.5578130666666666E7d,
      error = 2302843.036672559d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2022p1" -> BenchmarkTiming(
      mean = 269207.0d,
      error = 73325.97816206074d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2022p2" -> BenchmarkTiming(
      mean = 773374.0d,
      error = 16019.865402361189d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2022p1" -> BenchmarkTiming(
      mean = 217160.33333333334d,
      error = 4632.620497335968d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2022p2" -> BenchmarkTiming(
      mean = 5.3867956E7d,
      error = 3638029.367186222d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2022p1" -> BenchmarkTiming(
      mean = 3.2338972E7d,
      error = 821355.2854713051d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2022p2" -> BenchmarkTiming(
      mean = 5.226796072E9d,
      error = 2.726053738577476E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2022p1" -> BenchmarkTiming(
      mean = 4030475.0d,
      error = 130554.66534325146d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2022p2" -> BenchmarkTiming(
      mean = 5816663.0d,
      error = 186095.6889993263d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2022p1" -> BenchmarkTiming(
      mean = 4.3954034333333336E7d,
      error = 4080601.3108467683d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2022p2" -> BenchmarkTiming(
      mean = 1.6119912580333334E10d,
      error = 2.631835030958248E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2022p1" -> BenchmarkTiming(
      mean = 68070.0d,
      error = 6199.287473782242d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day15y2022p2" -> BenchmarkTiming(
      mean = 7.719989175E9d,
      error = 4.420599437349706E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2022p1" -> BenchmarkTiming(
      mean = 4.944026493333333E8d,
      error = 1.3080880310766624E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2022p2" -> BenchmarkTiming(
      mean = 1.3838987162333334E10d,
      error = 8.426483570967335E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day18y2022p1" -> BenchmarkTiming(
      mean = 5952299.333333333d,
      error = 173576.61079360597d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2022p1" -> BenchmarkTiming(
      mean = 6.36869E7d,
      error = 806913.1645302251d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2022p2" -> BenchmarkTiming(
      mean = 9.418717993333334E8d,
      error = 2.6020304393336108E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2022p1" -> BenchmarkTiming(
      mean = 4148572.0d,
      error = 57135.386057767784d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2022p2" -> BenchmarkTiming(
      mean = 4190705.3333333335d,
      error = 135431.62391989472d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2022p1" -> BenchmarkTiming(
      mean = 3.9581222333333336E7d,
      error = 805988.7590569108d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2022p2" -> BenchmarkTiming(
      mean = 9337584.0d,
      error = 194977.06363896944d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2022p1" -> BenchmarkTiming(
      mean = 3.0524178E7d,
      error = 706262.9196870355d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2022p1" -> BenchmarkTiming(
      mean = 2.4058542603333335E9d,
      error = 1.0033568199709319E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2022p2" -> BenchmarkTiming(
      mean = 7.702581936E9d,
      error = 7.72932454889105E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day25y2022p1" -> BenchmarkTiming(
      mean = 49753.333333333336d,
      error = 55566.90394656943d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2023p1" -> BenchmarkTiming(
      mean = 379400.0d,
      error = 11656.011354676937d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2023p2" -> BenchmarkTiming(
      mean = 1.4892767333333334E7d,
      error = 276125.76705825d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2023p1" -> BenchmarkTiming(
      mean = 3606561.6666666665d,
      error = 134827.32353685974d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2023p2" -> BenchmarkTiming(
      mean = 3609108.3333333335d,
      error = 145240.93352630644d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2023p1" -> BenchmarkTiming(
      mean = 2856987.6666666665d,
      error = 472751.6224116621d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2023p2" -> BenchmarkTiming(
      mean = 1988137.6666666667d,
      error = 158582.78898632957d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2023p1" -> BenchmarkTiming(
      mean = 9412135.0d,
      error = 320830.16673085454d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2023p2" -> BenchmarkTiming(
      mean = 9532617.666666666d,
      error = 504345.7229324744d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2024p1" -> BenchmarkTiming(
      mean = 1436607.6666666667d,
      error = 60105.491070522105d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2024p2" -> BenchmarkTiming(
      mean = 1402437.6666666667d,
      error = 85745.79843452969d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2024p1" -> BenchmarkTiming(
      mean = 7622816.666666667d,
      error = 906472.4954151247d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2024p2" -> BenchmarkTiming(
      mean = 1.0303148333333334E7d,
      error = 656621.0436858762d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2024p1" -> BenchmarkTiming(
      mean = 2886691.3333333335d,
      error = 118708.44247122336d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2024p2" -> BenchmarkTiming(
      mean = 3418728.3333333335d,
      error = 149637.73014159297d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2024p1" -> BenchmarkTiming(
      mean = 1.5404613666666666E7d,
      error = 537626.2426128294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1546664.3333333333d,
      error = 32526.510472871658d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2024p1" -> BenchmarkTiming(
      mean = 4.1523523333333336E7d,
      error = 1.0968060433549108E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2024p2" -> BenchmarkTiming(
      mean = 1.595693944E9d,
      error = 6.537640660298274E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2024p1" -> BenchmarkTiming(
      mean = 1037467.6666666666d,
      error = 124029.97534141674d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2024p2" -> BenchmarkTiming(
      mean = 2.3199146926666665E9d,
      error = 7.159037281259954E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2024p1" -> BenchmarkTiming(
      mean = 1.3914603333333334E7d,
      error = 2472866.0980673595d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2024p2" -> BenchmarkTiming(
      mean = 3.346284726666667E8d,
      error = 2114897.6155590843d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2024p1" -> BenchmarkTiming(
      mean = 7102779.666666667d,
      error = 408607.3771264174d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2024p2" -> BenchmarkTiming(
      mean = 6393753.333333333d,
      error = 64673.315530573265d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2024p1" -> BenchmarkTiming(
      mean = 1.9891939025E10d,
      error = 1.5089195577881477E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2024p2" -> BenchmarkTiming(
      mean = 3.7506359553333335E9d,
      error = 1.6530403251413077E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2024p1" -> BenchmarkTiming(
      mean = 1.3716277273333333E9d,
      error = 4.737686839729344E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2024p2" -> BenchmarkTiming(
      mean = 1.280254314E9d,
      error = 2.30453543188755E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2024p1" -> BenchmarkTiming(
      mean = 2093177.6666666667d,
      error = 57412.260593303574d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2024p2" -> BenchmarkTiming(
      mean = 9.8362524E7d,
      error = 1.6176509005621437E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2024p1" -> BenchmarkTiming(
      mean = 5.82631218E8d,
      error = 3.618563132675322E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2024p2" -> BenchmarkTiming(
      mean = 1.281355354E9d,
      error = 2.166595288760264E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2024p1" -> BenchmarkTiming(
      mean = 1468424.3333333333d,
      error = 19493.38897439012d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2024p2" -> BenchmarkTiming(
      mean = 1479583.6666666667d,
      error = 36805.26650069482d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2024p1" -> BenchmarkTiming(
      mean = 748824.0d,
      error = 233804.60901519324d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2024p2" -> BenchmarkTiming(
      mean = 5.482965583333334E8d,
      error = 1.5260801416879507E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2024p1" -> BenchmarkTiming(
      mean = 1.5558140666666666E7d,
      error = 6415259.196470838d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2024p2" -> BenchmarkTiming(
      mean = 1.4372490333333334E7d,
      error = 7752726.0428132545d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2024p1" -> BenchmarkTiming(
      mean = 6.7978076E7d,
      error = 6490783.042039569d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2024p2" -> BenchmarkTiming(
      mean = 6.4280990666666664E7d,
      error = 1.0809809675127363E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day17y2024p1" -> BenchmarkTiming(
      mean = 32754.84d,
      error = 1040.3926767808598d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day17y2024p2" -> BenchmarkTiming(
      mean = 697640.72d,
      error = 4227.554725714231d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day18y2024p1" -> BenchmarkTiming(
      mean = 1.5865014E7d,
      error = 860477.3096326615d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day18y2024p2" -> BenchmarkTiming(
      mean = 6.549349289666667E9d,
      error = 2.2533231252252835E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2024p1" -> BenchmarkTiming(
      mean = 1.0594868333333334E7d,
      error = 660128.583552959d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2024p2" -> BenchmarkTiming(
      mean = 2.1388992866666666E8d,
      error = 1.3858533154973516E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2024p1" -> BenchmarkTiming(
      mean = 4.105649978E9d,
      error = 2.1919527472948322E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2024p2" -> BenchmarkTiming(
      mean = 4.340223596333333E9d,
      error = 7.108228116150938E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2024p1" -> BenchmarkTiming(
      mean = 349237.0d,
      error = 35583.32606338166d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2024p2" -> BenchmarkTiming(
      mean = 5390002.0d,
      error = 441571.15787395334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2024p1" -> BenchmarkTiming(
      mean = 3.2168008666666668E7d,
      error = 6959799.787623533d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2024p2" -> BenchmarkTiming(
      mean = 5.303535432333333E9d,
      error = 2.0940176458045515E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2024p1" -> BenchmarkTiming(
      mean = 7399777.0d,
      error = 207085.94543291992d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2024p2" -> BenchmarkTiming(
      mean = 1.1139868666666666E7d,
      error = 1543612.352744124d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2024p1" -> BenchmarkTiming(
      mean = 975394.0d,
      error = 115881.62855727081d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2024p2" -> BenchmarkTiming(
      mean = 1.3011754403333333E9d,
      error = 9.8479706352337E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day25y2024p1" -> BenchmarkTiming(
      mean = 1.3125303E7d,
      error = 285688.2999737326d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platnative", v)}
}