import java.util.concurrent.TimeUnit

object JSBenches {

  val benchmarks = Map(
    "day1y2020p1" -> BenchmarkTiming(
      mean = 10155122.666666666,
      error = 664281.8199061835,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2020p2" -> BenchmarkTiming(
      mean = 189651783,
      error = 126457026.02798049,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2020p1" -> BenchmarkTiming(
      mean = 3369748.3333333335,
      error = 812069.9684905843,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2020p2" -> BenchmarkTiming(
      mean = 3355715.6666666665,
      error = 484814.7678589484,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2020p1" -> BenchmarkTiming(
      mean = 346662.6666666667,
      error = 1624722.548718127,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2020p2" -> BenchmarkTiming(
      mean = 318869,
      error = 502822.7479482079,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2020p1" -> BenchmarkTiming(
      mean = 11575986.666666666,
      error = 4679728.04083645,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2020p2" -> BenchmarkTiming(
      mean = 12108224,
      error = 448086.9780663051,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2020p1" -> BenchmarkTiming(
      mean = 516454,
      error = 1323240.6779331276,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2020p2" -> BenchmarkTiming(
      mean = 816276,
      error = 612502.0885928342,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2020p1" -> BenchmarkTiming(
      mean = 12681661.333333334,
      error = 22926996.614943016,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2020p2" -> BenchmarkTiming(
      mean = 11621033.333333334,
      error = 28930755.280287046,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2020p1" -> BenchmarkTiming(
      mean = 18352717.666666668,
      error = 5695748.143529529,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2020p2" -> BenchmarkTiming(
      mean = 8835163,
      error = 8203213.289841014,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2020p1" -> BenchmarkTiming(
      mean = 1999951.6666666667,
      error = 2396566.8010688685,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2020p2" -> BenchmarkTiming(
      mean = 5227259.333333333,
      error = 4676406.966054252,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2020p1" -> BenchmarkTiming(
      mean = 10553658.666666666,
      error = 982104.3324865754,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2020p2" -> BenchmarkTiming(
      mean = 10913468.333333334,
      error = 5099758.636272451,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2020p1" -> BenchmarkTiming(
      mean = 224012,
      error = 567694.0156922073,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2021p1" -> BenchmarkTiming(
      mean = 1741786.3333333333,
      error = 6267291.587750021,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2021p2" -> BenchmarkTiming(
      mean = 2591309.3333333335,
      error = 1896201.565941522,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2021p1" -> BenchmarkTiming(
      mean = 2456591.6666666665,
      error = 458794.9885531427,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2021p2" -> BenchmarkTiming(
      mean = 2494615,
      error = 1389369.1161409388,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2021p1" -> BenchmarkTiming(
      mean = 433656.6666666667,
      error = 279280.1639774403,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2021p2" -> BenchmarkTiming(
      mean = 917843.3333333334,
      error = 571994.0958600827,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2021p1" -> BenchmarkTiming(
      mean = 7620273.333333333,
      error = 4813891.40384011,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2021p2" -> BenchmarkTiming(
      mean = 57050219.666666664,
      error = 3284346.9491232475,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p1" -> BenchmarkTiming(
      mean = 142599952.33333334,
      error = 32016271.08223399,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2021p2" -> BenchmarkTiming(
      mean = 261260711.33333334,
      error = 126294386.2714942,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p1" -> BenchmarkTiming(
      mean = 71293315.33333333,
      error = 3670630.12409675,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2021p2" -> BenchmarkTiming(
      mean = 1989634.6666666667,
      error = 3450744.478407018,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p1" -> BenchmarkTiming(
      mean = 638771.3333333334,
      error = 2756327.0867587253,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2021p2" -> BenchmarkTiming(
      mean = 478773.6666666667,
      error = 1096845.7161944427,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2021p1" -> BenchmarkTiming(
      mean = 64464885,
      error = 3260732.039391462,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2021p2" -> BenchmarkTiming(
      mean = 3578935420.3333335,
      error = 349692352.3619079,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2021p1" -> BenchmarkTiming(
      mean = 1655114.6666666667,
      error = 3967266.541657266,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2021p2" -> BenchmarkTiming(
      mean = 15980032717.0,
      error = 5815175380.528051,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2022p1" -> BenchmarkTiming(
      mean = 571137.3333333334,
      error = 1178108.6548854706,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2022p2" -> BenchmarkTiming(
      mean = 661321,
      error = 1535999.728327778,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2022p1" -> BenchmarkTiming(
      mean = 2661591.3333333335,
      error = 1869417.1770639753,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2022p2" -> BenchmarkTiming(
      mean = 3224962,
      error = 5297554.71648754,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2022p1" -> BenchmarkTiming(
      mean = 2197101.3333333335,
      error = 691076.3982857221,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2022p2" -> BenchmarkTiming(
      mean = 5472363.666666667,
      error = 2208223.1917653945,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2022p1" -> BenchmarkTiming(
      mean = 84719637.33333333,
      error = 13043627.817972952,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2022p2" -> BenchmarkTiming(
      mean = 71410087.33333333,
      error = 40767118.91536812,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2022p1" -> BenchmarkTiming(
      mean = 2838152.6666666665,
      error = 4915721.12475533,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2022p2" -> BenchmarkTiming(
      mean = 2235325.3333333335,
      error = 2285522.3713406664,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2022p1" -> BenchmarkTiming(
      mean = 6080987.666666667,
      error = 3385106.88800184,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2022p2" -> BenchmarkTiming(
      mean = 17432704.333333332,
      error = 15285420.998425355,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2022p1" -> BenchmarkTiming(
      mean = 3227682.3333333335,
      error = 3774992.2023574268,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2022p2" -> BenchmarkTiming(
      mean = 3445543.3333333335,
      error = 5542792.03305486,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2022p1" -> BenchmarkTiming(
      mean = 1969906332.3333333,
      error = 485534964.3270535,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2022p2" -> BenchmarkTiming(
      mean = 2190534814.0,
      error = 737445411.1849226,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2022p1" -> BenchmarkTiming(
      mean = 45204124,
      error = 123301235.69224639,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2022p2" -> BenchmarkTiming(
      mean = 51804152,
      error = 99302938.31744172,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2022p1" -> BenchmarkTiming(
      mean = 1681571.6666666667,
      error = 4362995.318543989,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2022p2" -> BenchmarkTiming(
      mean = 2569694,
      error = 3722185.2299274565,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2022p1" -> BenchmarkTiming(
      mean = 1314002.3333333333,
      error = 632407.2074165649,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2022p2" -> BenchmarkTiming(
      mean = 50900185.666666664,
      error = 8268821.466831624,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2022p1" -> BenchmarkTiming(
      mean = 96656013.33333333,
      error = 25206766.73547791,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2022p2" -> BenchmarkTiming(
      mean = 12277649748.666666,
      error = 1163742090.1031032,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2022p1" -> BenchmarkTiming(
      mean = 6833656,
      error = 15629348.849072224,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2022p2" -> BenchmarkTiming(
      mean = 10155781.666666666,
      error = 7547851.100641609,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2022p1" -> BenchmarkTiming(
      mean = 62101586.666666664,
      error = 46419749.55428485,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2022p2" -> BenchmarkTiming(
      mean = 13389251675.0,
      error = 2722041819.26654,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2022p1" -> BenchmarkTiming(
      mean = 758521.6666666666,
      error = 2204556.5026753955,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day15y2022p2" -> BenchmarkTiming(
      mean = 10087511327.333334,
      error = 337544676.66982514,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2022p1" -> BenchmarkTiming(
      mean = 867889699.6666666,
      error = 126066406.0603062,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2022p2" -> BenchmarkTiming(
      mean = 32278233258d,
      error = 16190197947.97456,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day18y2022p1" -> BenchmarkTiming(
      mean = 18060162.333333332,
      error = 5891298.22135843,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2022p1" -> BenchmarkTiming(
      mean = 86736019,
      error = 77912160.69198634,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2022p2" -> BenchmarkTiming(
      mean = 1066332842.3333334,
      error = 458127592.4833884,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2022p1" -> BenchmarkTiming(
      mean = 10176114.333333334,
      error = 8976842.1333551,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2022p2" -> BenchmarkTiming(
      mean = 9648564.333333334,
      error = 5168169.113264529,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2022p1" -> BenchmarkTiming(
      mean = 68875061,
      error = 46478316.91045748,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2022p2" -> BenchmarkTiming(
      mean = 17912795,
      error = 12315804.361037843,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2022p1" -> BenchmarkTiming(
      mean = 55943899,
      error = 17241621.036507953,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2022p1" -> BenchmarkTiming(
      mean = 4989526434.666667,
      error = 485075574.04060787,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2022p2" -> BenchmarkTiming(
      mean = 17197725877.333332,
      error = 433747258.86164737,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day25y2022p1" -> BenchmarkTiming(
      mean = 246848.66666666666,
      error = 1613004.7437364033,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2023p1" -> BenchmarkTiming(
      mean = 388945.6666666667,
      error = 781578.5120322685,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2023p2" -> BenchmarkTiming(
      mean = 2116504,
      error = 9031669.404173125,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2023p1" -> BenchmarkTiming(
      mean = 7659830,
      error = 39775116.97442327,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2023p2" -> BenchmarkTiming(
      mean = 6086163,
      error = 15909987.712494345,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2023p1" -> BenchmarkTiming(
      mean = 5888405,
      error = 7931123.86381389,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2023p2" -> BenchmarkTiming(
      mean = 5746317.333333333,
      error = 7479637.718791479,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2023p1" -> BenchmarkTiming(
      mean = 5457205.333333333,
      error = 17770023.375732686,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2023p2" -> BenchmarkTiming(
      mean = 5545505.666666667,
      error = 18689171.651527233,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2024p1" -> BenchmarkTiming(
      mean = 3329958.3333333335,
      error = 1018930.4854884029,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2024p2" -> BenchmarkTiming(
      mean = 4086709.6666666665,
      error = 6164758.215751505,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2024p1" -> BenchmarkTiming(
      mean = 4021519.6666666665,
      error = 1615743.5208452437,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2024p2" -> BenchmarkTiming(
      mean = 7015052,
      error = 7064963.560653882,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2024p1" -> BenchmarkTiming(
      mean = 838418.6666666666,
      error = 1374118.4588160003,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2024p2" -> BenchmarkTiming(
      mean = 1103767.6666666667,
      error = 1818170.97643127,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2024p1" -> BenchmarkTiming(
      mean = 48998633.666666664,
      error = 49227154.45034866,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2024p2" -> BenchmarkTiming(
      mean = 2896898.6666666665,
      error = 5506685.319457735,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2024p1" -> BenchmarkTiming(
      mean = 44902937.333333336,
      error = 3632103.3819744,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2024p2" -> BenchmarkTiming(
      mean = 3222411395.3333335,
      error = 362090326.4054457,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2024p1" -> BenchmarkTiming(
      mean = 3275278,
      error = 23832469.66886948,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2024p2" -> BenchmarkTiming(
      mean = 7220095434.333333,
      error = 602616831.7385192,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2024p1" -> BenchmarkTiming(
      mean = 16307053,
      error = 4272504.555937287,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2024p2" -> BenchmarkTiming(
      mean = 494283458,
      error = 13026676.45633699,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2024p1" -> BenchmarkTiming(
      mean = 7836071,
      error = 6234018.851837643,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2024p2" -> BenchmarkTiming(
      mean = 10103742.666666666,
      error = 10259149.999241032,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2024p1" -> BenchmarkTiming(
      mean = 6472017588.333333,
      error = 49077976608.68951,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2024p2" -> BenchmarkTiming(
      mean = 3029701628.0,
      error = 322466425.7062765,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2024p1" -> BenchmarkTiming(
      mean = 2197044971.3333335,
      error = 106791662.70618889,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2024p2" -> BenchmarkTiming(
      mean = 1127438012,
      error = 5707380.151466838,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2024p1" -> BenchmarkTiming(
      mean = 8061985.333333333,
      error = 5637246.4883461865,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day11y2024p2" -> BenchmarkTiming(
      mean = 354230317.6666667,
      error = 3690329.393539382,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2024p1" -> BenchmarkTiming(
      mean = 999087136.6666666,
      error = 222730140.14805958,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day12y2024p2" -> BenchmarkTiming(
      mean = 2100459450,
      error = 439069857.7726575,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2024p1" -> BenchmarkTiming(
      mean = 3085967,
      error = 1941984.4800086613,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day13y2024p2" -> BenchmarkTiming(
      mean = 3396885,
      error = 4232022.460660883,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2024p1" -> BenchmarkTiming(
      mean = 2091003.6666666667,
      error = 1452595.894874319,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day14y2024p2" -> BenchmarkTiming(
      mean = 1317467934.6666667,
      error = 23093888.929259084,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2024p1" -> BenchmarkTiming(
      mean = 29225250.666666668,
      error = 53158381.97240036,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day15y2024p2" -> BenchmarkTiming(
      mean = 31922848.666666668,
      error = 68003861.82661256,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2024p1" -> BenchmarkTiming(
      mean = 208496108.33333334,
      error = 41406491.92314602,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day16y2024p2" -> BenchmarkTiming(
      mean = 88950207.66666667,
      error = 2177420.9686624417,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day17y2024p1" -> BenchmarkTiming(
      mean = 150891.72,
      error = 15488.88807060016,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day17y2024p2" -> BenchmarkTiming(
      mean = 1273010.88,
      error = 24797.320538942156,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),
    "day18y2024p1" -> BenchmarkTiming(
      mean = 37821964,
      error = 4107057.9243900348,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day18y2024p2" -> BenchmarkTiming(
      mean = 19562287067.333332,
      error = 588010815.7887789,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2024p1" -> BenchmarkTiming(
      mean = 11505263.333333334,
      error = 979918.9580422986,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day19y2024p2" -> BenchmarkTiming(
      mean = 98757690.33333333,
      error = 4909684.008787853,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2024p1" -> BenchmarkTiming(
      mean = 1449994144.3333333,
      error = 70183686.83434445,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day20y2024p2" -> BenchmarkTiming(
      mean = 2001480658,
      error = 3003803690.5776124,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2024p1" -> BenchmarkTiming(
      mean = 1969271.3333333333,
      error = 456159.55416900705,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day21y2024p2" -> BenchmarkTiming(
      mean = 11632727,
      error = 10346660.258352138,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2024p1" -> BenchmarkTiming(
      mean = 27479351.333333332,
      error = 32413450.994830064,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day22y2024p2" -> BenchmarkTiming(
      mean = 17992555966d,
      error = 5207870451.662742,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2024p1" -> BenchmarkTiming(
      mean = 12960062,
      error = 7255362.9832825605,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day23y2024p2" -> BenchmarkTiming(
      mean = 25196971.666666668,
      error = 50597415.31252418,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2024p1" -> BenchmarkTiming(
      mean = 3392264,
      error = 5301351.166411486,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day24y2024p2" -> BenchmarkTiming(
      mean = 7159307275d,
      error = 109834646.88986236,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day25y2024p1" -> BenchmarkTiming(
      mean = 18997057,
      error = 6342278.110357151,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platjs", v)}
}