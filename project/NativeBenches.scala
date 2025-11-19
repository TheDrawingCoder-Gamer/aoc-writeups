import java.util.concurrent.TimeUnit

object NativeBenches {
  val benchmarks = Map(    
    "day1y2015p1" -> BenchmarkTiming(
      mean = 38063.624200190054d,
      error = 47.922110931737535d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2015p2" -> BenchmarkTiming(
      mean = 339281.75132665096d,
      error = 175.30125923442358d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2015p1" -> BenchmarkTiming(
      mean = 1077495.2414976598d,
      error = 523.1746630614025d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2015p2" -> BenchmarkTiming(
      mean = 1086278.6006472493d,
      error = 538.7986670336414d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2015p1" -> BenchmarkTiming(
      mean = 1527380.3442136499d,
      error = 1011.2145179718112d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2015p2" -> BenchmarkTiming(
      mean = 2374099.710653753d,
      error = 945.028749145744d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2015p1" -> BenchmarkTiming(
      mean = 3.462386098666667E8d,
      error = 982088.889543484d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2015p2" -> BenchmarkTiming(
      mean = 9.990742846333334E9d,
      error = 2.3793857646016288E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2015p1" -> BenchmarkTiming(
      mean = 2104046.4577030814d,
      error = 932.3133384587447d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2015p2" -> BenchmarkTiming(
      mean = 1.0872504413793104E7d,
      error = 12564.080904121412d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2015p1" -> BenchmarkTiming(
      mean = 8.371693331666666E7d,
      error = 72192.66728031178d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2015p2" -> BenchmarkTiming(
      mean = 9.340990652830188E7d,
      error = 130383.21781295163d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2015p1" -> BenchmarkTiming(
      mean = 1116513.207102953d,
      error = 517.1216207468293d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2015p2" -> BenchmarkTiming(
      mean = 1165739.7852965747d,
      error = 394.3470340185008d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2015p1" -> BenchmarkTiming(
      mean = 351257.08350357506d,
      error = 227.91793384265824d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2015p2" -> BenchmarkTiming(
      mean = 171004.4532390511d,
      error = 194.92282764689776d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2015p1" -> BenchmarkTiming(
      mean = 2.988613690588235E8d,
      error = 1328863.4194050971d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2015p2" -> BenchmarkTiming(
      mean = 2.9924775435294116E8d,
      error = 1829677.8082597842d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2015p1" -> BenchmarkTiming(
      mean = 456469.34477427334d,
      error = 263.60106131006876d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2015p2" -> BenchmarkTiming(
      mean = 661782.5634629494d,
      error = 348.2686695696233d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2015p1" -> BenchmarkTiming(
      mean = 4791679.8169582775d,
      error = 3912.982629175073d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2015p2" -> BenchmarkTiming(
      mean = 1081374.6149301827d,
      error = 669.2348657054621d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2015p1" -> BenchmarkTiming(
      mean = 1.4968349296969697E8d,
      error = 424167.7771994544d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2015p2" -> BenchmarkTiming(
      mean = 1.501691714E9d,
      error = 4.893181446835872E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2015p1" -> BenchmarkTiming(
      mean = 159355.0313993174d,
      error = 153.7851445539334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2015p2" -> BenchmarkTiming(
      mean = 1016120.181184669d,
      error = 480.92181961997295d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2015p1" -> BenchmarkTiming(
      mean = 2.187752557711443E7d,
      error = 43888.96896887793d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2015p2" -> BenchmarkTiming(
      mean = 1.9835204785388127E7d,
      error = 18342.93033881786d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2015p1" -> BenchmarkTiming(
      mean = 4337180.702364395d,
      error = 2633.2329185073568d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2015p2" -> BenchmarkTiming(
      mean = 4340317.566063978d,
      error = 2511.6729597663157d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2015p1" -> BenchmarkTiming(
      mean = 1.33501969625E9d,
      error = 1.0524635826259597E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2015p2" -> BenchmarkTiming(
      mean = 1.30797876475E9d,
      error = 2.0805614221324444E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2015p1" -> BenchmarkTiming(
      mean = 7.673794681428572E8d,
      error = 2.2005492888044577E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2015p2" -> BenchmarkTiming(
      mean = 7.877762532857143E8d,
      error = 3.533515971917531E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2015p1" -> BenchmarkTiming(
      mean = 4668999.442901234d,
      error = 4401.763815605137d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2015p2" -> BenchmarkTiming(
      mean = 118786.87913172175d,
      error = 193.9450775425141d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2015p1" -> BenchmarkTiming(
      mean = 2.8964073634615384E7d,
      error = 31699.55557030424d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2015p2" -> BenchmarkTiming(
      mean = 2.597710847368421E7d,
      error = 68254.42568953987d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2015p1" -> BenchmarkTiming(
      mean = 213043.27975528364d,
      error = 220.95639120282655d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2015p2" -> BenchmarkTiming(
      mean = 201607.1090289608d,
      error = 187.32613614266438d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2015p1" -> BenchmarkTiming(
      mean = 2.1944984908695653E8d,
      error = 1662277.754878405d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2015p2" -> BenchmarkTiming(
      mean = 1.8326844644444445E8d,
      error = 278293.06351372215d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2015p1" -> BenchmarkTiming(
      mean = 118576.40858318636d,
      error = 377.9494352513514d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2015p2" -> BenchmarkTiming(
      mean = 124792.55248618785d,
      error = 188.9336492744018d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2015p1" -> BenchmarkTiming(
      mean = 1.0157394175E8d,
      error = 142678.8267839349d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2015p2" -> BenchmarkTiming(
      mean = 9324821.912371134d,
      error = 3896.2347820579917d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2015p1" -> BenchmarkTiming(
      mean = 1.4747797120588234E8d,
      error = 403802.2478811733d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p1" -> BenchmarkTiming(
      mean = 1.5134248104477612E7d,
      error = 9438.42652337002d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 2.974245737058824E8d,
      error = 237019.9694286145d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 1334264.199090909d,
      error = 818.3534181161752d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1301497.1438914028d,
      error = 846.5149271900352d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 128276.54475703325d,
      error = 153.9037872037311d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 190503.17777777778d,
      error = 220.13349972412757d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 1.0039749435261708E7d,
      error = 7932.143630175718d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 1.0136148008333333E7d,
      error = 5868.619059070521d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 205788.65258855585d,
      error = 283.0189424440467d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 517266.31598793366d,
      error = 361.47036888267996d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 2171164.9499431173d,
      error = 1004.8434501522717d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 2130141.4715261958d,
      error = 944.7423442680632d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 1.0920477425595239E7d,
      error = 8072.671643382847d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 5710685.620689655d,
      error = 2416.4476896626275d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 757904.0126475549d,
      error = 584.4044439348241d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 2279036.3658536584d,
      error = 11089.097741841157d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 9094658.852242744d,
      error = 11907.744514451655d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 9122059.007894738d,
      error = 4826.372410856991d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 50676.62926829268d,
      error = 146.37765318270704d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p2" -> BenchmarkTiming(
      mean = 57572.922969187675d,
      error = 177.6544097091773d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p1" -> BenchmarkTiming(
      mean = 1.2172200942E9d,
      error = 1.3916313411755892E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p2" -> BenchmarkTiming(
      mean = 1.1037898066E9d,
      error = 1.2707413248819701E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p1" -> BenchmarkTiming(
      mean = 136977.6303630363d,
      error = 1218.2996094650953d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p2" -> BenchmarkTiming(
      mean = 146432.53122398d,
      error = 439.2623433916711d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p1" -> BenchmarkTiming(
      mean = 2677869.1267605633d,
      error = 2791.7861081218334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p2" -> BenchmarkTiming(
      mean = 28505.761865793782d,
      error = 132.21377219333266d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p1" -> BenchmarkTiming(
      mean = 2616869.4030470913d,
      error = 4850.152350960675d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p2" -> BenchmarkTiming(
      mean = 2.6072406436842105E8d,
      error = 726685.33945706d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p1" -> BenchmarkTiming(
      mean = 26433.988175675677d,
      error = 484.8234431309169d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p2" -> BenchmarkTiming(
      mean = 6.89536766625E8d,
      error = 1.169128067571015E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p1" -> BenchmarkTiming(
      mean = 911972.4524053225d,
      error = 3140.8976229290324d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p2" -> BenchmarkTiming(
      mean = 1440233.597949886d,
      error = 2450.2103832659795d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2020p1" -> BenchmarkTiming(
      mean = 2.6093829703703705E7d,
      error = 30630.627070999784d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2020p2" -> BenchmarkTiming(
      mean = 9.878459018333334E8d,
      error = 2.6938322900271088E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2020p1" -> BenchmarkTiming(
      mean = 5358134.435845214d,
      error = 3771.1960813115284d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2020p2" -> BenchmarkTiming(
      mean = 5376354.028571429d,
      error = 3579.679297779263d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2020p1" -> BenchmarkTiming(
      mean = 9.11630095E8d,
      error = 1.679015492673212E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2020p2" -> BenchmarkTiming(
      mean = 9660054.329341317d,
      error = 11496.714281657922d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2020p1" -> BenchmarkTiming(
      mean = 6.0549944733333334E7d,
      error = 75283.64556764734d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2020p2" -> BenchmarkTiming(
      mean = 8.152491089473684E7d,
      error = 117856.47944451048d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2020p1" -> BenchmarkTiming(
      mean = 2146953.0923520923d,
      error = 2557.8869785640313d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2020p2" -> BenchmarkTiming(
      mean = 1961864.7088607594d,
      error = 3157.377964348766d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2020p1" -> BenchmarkTiming(
      mean = 138962.89876033057d,
      error = 331.1529469665825d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2020p2" -> BenchmarkTiming(
      mean = 1.25002019975E9d,
      error = 8.158654743129231E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2020p1" -> BenchmarkTiming(
      mean = 83455.15240083507d,
      error = 187.5273273160641d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2020p2" -> BenchmarkTiming(
      mean = 1.0100325272E10d,
      error = 1.3394103136494626E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2020p1" -> BenchmarkTiming(
      mean = 2516594.5054773083d,
      error = 1930.0931648462515d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2020p2" -> BenchmarkTiming(
      mean = 6.68536394375E8d,
      error = 1601083.7867844708d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2020p1" -> BenchmarkTiming(
      mean = 2.793908399444444E8d,
      error = 2606315.0620357d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p1" -> BenchmarkTiming(
      mean = 578350.6289017341d,
      error = 608.4920334107787d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 1206248.6848249028d,
      error = 1251.6386999291892d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 979099.3208955224d,
      error = 656.3286009338593d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 942968.0739827374d,
      error = 833.1631682237752d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 328137.4719471947d,
      error = 1730.6511460348959d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 287596.70175438595d,
      error = 472.733002362086d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 6521888.941463415d,
      error = 3575.829700861028d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 2.9708020425531916E7d,
      error = 34296.548011060535d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 4.163314189622641E7d,
      error = 41141.95608057512d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 8.214920971929824E7d,
      error = 67323.01612435559d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 6.761763727941176E7d,
      error = 138926.77706323238d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 264568.85471055616d,
      error = 426.2754199147232d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 253997.66666666666d,
      error = 1180.023375267199d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 405620.8224852071d,
      error = 1438.3174408737657d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p1" -> BenchmarkTiming(
      mean = 3783264.973333333d,
      error = 3031.8603222677534d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p2" -> BenchmarkTiming(
      mean = 4977757.490280777d,
      error = 6770.285934830109d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p1" -> BenchmarkTiming(
      mean = 2980510.5008726004d,
      error = 3147.260240924217d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p2" -> BenchmarkTiming(
      mean = 2.430980489090909E7d,
      error = 41518.591563921065d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p1" -> BenchmarkTiming(
      mean = 319368.19760479045d,
      error = 577.2542613538138d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p2" -> BenchmarkTiming(
      mean = 343329.30108827085d,
      error = 737.7526388419285d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p1" -> BenchmarkTiming(
      mean = 4.242202403883495E7d,
      error = 74424.0956938783d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p2" -> BenchmarkTiming(
      mean = 1.516775600625E8d,
      error = 489214.8116625334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p1" -> BenchmarkTiming(
      mean = 9.347846224E7d,
      error = 235678.1862307476d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p2" -> BenchmarkTiming(
      mean = 3.7253700676666665E9d,
      error = 1.421363383419026E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2021p1" -> BenchmarkTiming(
      mean = 1132839.5572065378d,
      error = 4301.178000276369d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2021p2" -> BenchmarkTiming(
      mean = 1676157.0398724084d,
      error = 5101.490811354533d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2021p1" -> BenchmarkTiming(
      mean = 316495.63095238095d,
      error = 1844.3353657557204d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2021p2" -> BenchmarkTiming(
      mean = 5937581.927680798d,
      error = 5016.637294058648d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2021p1" -> BenchmarkTiming(
      mean = 2.255837136627907E7d,
      error = 26409.326846743905d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2021p2" -> BenchmarkTiming(
      mean = 7.762816442857143E8d,
      error = 3957730.9851157074d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2021p1" -> BenchmarkTiming(
      mean = 112222.94415584416d,
      error = 1058.3925117376618d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2021p2" -> BenchmarkTiming(
      mean = 95098.81119791667d,
      error = 927.7713149146604d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2021p1" -> BenchmarkTiming(
      mean = 14178.855855855856d,
      error = 723.3322571680795d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2021p2" -> BenchmarkTiming(
      mean = 1.00417548989899E7d,
      error = 6689.2525020330795d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2021p1" -> BenchmarkTiming(
      mean = 2.7449207479452055E7d,
      error = 34363.66630299098d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2021p2" -> BenchmarkTiming(
      mean = 3.322112978666667E8d,
      error = 2913775.685138558d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 3.6051874097345136E7d,
      error = 42824.09206501925d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 2.074544179E9d,
      error = 1.0989121368690707E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 638564.1082390953d,
      error = 559.2468434860793d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2021p1" -> BenchmarkTiming(
      mean = 1511522.6606822263d,
      error = 1119.046362950678d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2021p2" -> BenchmarkTiming(
      mean = 1.5493304448387095E8d,
      error = 364953.43955317204d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2021p1" -> BenchmarkTiming(
      mean = 1.59747372125E9d,
      error = 1.5379986122561598E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2021p2" -> BenchmarkTiming(
      mean = 5.655983606E9d,
      error = 9.304135484433264E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2021p1" -> BenchmarkTiming(
      mean = 637354.2915309446d,
      error = 637.2904720314328d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2021p2" -> BenchmarkTiming(
      mean = 644013.0065359477d,
      error = 736.8368170271401d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2021p1" -> BenchmarkTiming(
      mean = 2.977795959E9d,
      error = 1.4353225541492197E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 529037.2443365696d,
      error = 694.2548752149322d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 556418.9787928222d,
      error = 597.8266293823484d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 7797502.9750778815d,
      error = 4560.722785519374d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 7816594.834375d,
      error = 4539.982993052886d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 686173.7157190635d,
      error = 649.4629603165497d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 1272895.5612788633d,
      error = 1184.5906805791935d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 2.215691563253012E7d,
      error = 12670.368735843807d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 2.210209189221557E7d,
      error = 12319.952202745697d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 1329886.8558394162d,
      error = 1948.4936232145346d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 1214160.714028777d,
      error = 67698.54765485955d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 2391103.208588957d,
      error = 2149.7204035917516d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 1.225129595951417E7d,
      error = 21244.600535495367d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 4328467.8799019605d,
      error = 3815.070886704528d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 4317703.632352941d,
      error = 3000.923647404825d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 1.13151754E9d,
      error = 6006520.063040011d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 1.26210201025E9d,
      error = 1.2028426377816658E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 1.6291564570731707E7d,
      error = 14745.107206718978d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 2.0636582028735634E7d,
      error = 16732.565281261213d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 288853.9768595041d,
      error = 467.2423249868916d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 816185.9150442478d,
      error = 813.7773784895107d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 271735.13628899836d,
      error = 620.0161276435274d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 5.530402793670886E7d,
      error = 237889.53605498731d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 1.2766594481481481E7d,
      error = 7078.251459651017d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 2.388592644E9d,
      error = 1.2522591257465318E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 3998624.455188679d,
      error = 1999.0553908115621d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 5678754.601078168d,
      error = 2935.9993952834097d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 5.364091985185185E7d,
      error = 50055.32841586831d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 1.8355551062E10d,
      error = 1.582518987960274E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 114046.77586206897d,
      error = 322.44123238146295d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 4.574314015E9d,
      error = 1.0516690836503519E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 4.66495782E8d,
      error = 1831772.2827691245d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 1.3247958928333334E10d,
      error = 2.0164945773480913E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2022p1" -> BenchmarkTiming(
      mean = 1.1279616860465117E7d,
      error = 11351.788713257172d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2022p2" -> BenchmarkTiming(
      mean = 9.813868848E9d,
      error = 1.065617566957157E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 9348987.33217993d,
      error = 4232.459847807777d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p2" -> BenchmarkTiming(
      mean = 3.0891247125E7d,
      error = 40126.29437867847d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 6.469714486764706E7d,
      error = 126306.27548974373d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 8.269846945E8d,
      error = 2224415.5825165375d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 3955517.5547445253d,
      error = 2484.5495267378697d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 4026246.1501210653d,
      error = 2251.021740434024d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 4.2755622448979594E7d,
      error = 30494.094449361426d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 1.145444133992095E7d,
      error = 32859.03193073906d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 3.021669545736434E7d,
      error = 32989.5905666537d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 1.43614946325E9d,
      error = 1279723.4349663637d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 4.807570402666667E9d,
      error = 3.543376362408417E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 53893.50578512397d,
      error = 198.993800374935d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 369141.65d,
      error = 467.219746136649d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 1.2351363533333333E7d,
      error = 14192.139026867038d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 3647046.451923077d,
      error = 2132.998666678426d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 3641355.8843373493d,
      error = 1937.938538324386d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 2618513.154525386d,
      error = 2546.719946794394d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 1820436.2510204082d,
      error = 1605.5867310865663d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 8460898.017064847d,
      error = 6219.994182170686d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 8505883.270547945d,
      error = 5718.965920445026d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2023p1" -> BenchmarkTiming(
      mean = 413893.66725352115d,
      error = 824.471307759335d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2023p2" -> BenchmarkTiming(
      mean = 2012971.3340292275d,
      error = 2620.3402150321126d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2023p1" -> BenchmarkTiming(
      mean = 55229.010256410256d,
      error = 242.78644423437518d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2023p2" -> BenchmarkTiming(
      mean = 3.059778753125E8d,
      error = 651420.2160370582d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2023p1" -> BenchmarkTiming(
      mean = 2.0078450782857142E7d,
      error = 25156.137317536894d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2023p2" -> BenchmarkTiming(
      mean = 1.8683598923497267E7d,
      error = 22819.962140229716d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2023p1" -> BenchmarkTiming(
      mean = 2545511.6756152124d,
      error = 3598.805326467652d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2023p2" -> BenchmarkTiming(
      mean = 8902673.735915493d,
      error = 19914.150063674908d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2023p1" -> BenchmarkTiming(
      mean = 1.1974476643153528E7d,
      error = 11756.586454682863d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2023p2" -> BenchmarkTiming(
      mean = 1.1954877319502074E7d,
      error = 9819.896624266688d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2023p1" -> BenchmarkTiming(
      mean = 1.3146812030701755E7d,
      error = 15887.094233622778d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2023p2" -> BenchmarkTiming(
      mean = 2.859311259411765E8d,
      error = 8449813.583427574d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2023p1" -> BenchmarkTiming(
      mean = 8.618214132692307E7d,
      error = 172638.36963473883d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2023p2" -> BenchmarkTiming(
      mean = 8.839250029411764E7d,
      error = 263780.2916453601d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2023p1" -> BenchmarkTiming(
      mean = 2826751.0124223605d,
      error = 1887.8285669272584d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2023p2" -> BenchmarkTiming(
      mean = 7538967.4d,
      error = 22068.349885702555d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 1427013.6129032257d,
      error = 4490.74158920179d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 1402063.9032258065d,
      error = 3830.0180364460366d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 8233328.4d,
      error = 14832.400218029834d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 1.1874844E7d,
      error = 26752.117746006475d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 2612869.4516129033d,
      error = 4966.3089885681675d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 3140248.8387096776d,
      error = 4514.733486765916d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 1.878851660714286E7d,
      error = 50444.39719821961d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1151954.0322580645d,
      error = 5198.374133264206d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 2.8943300962962963E7d,
      error = 71114.96895331833d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 1.2056225325E9d,
      error = 1.2325060214345102E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 1686405.8709677418d,
      error = 4676.711047485704d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 5.165376466666667E9d,
      error = 5.2118358629289114E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 1.4992100379310345E7d,
      error = 64469.978399743464d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 3.3192724045454544E8d,
      error = 1744646.0807208477d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 5240959.333333333d,
      error = 5449.082764933187d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 5719407.7d,
      error = 9442.53141811043d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 7.639035915E8d,
      error = 1287857.9896715784d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 3.870191755E9d,
      error = 3.003147304631222E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 3.347948306E9d,
      error = 1.651081456104463E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 2.8126073873333335E9d,
      error = 1.2183547993407537E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 2157253.290322581d,
      error = 4318.129554180782d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 9.76156812E7d,
      error = 276233.30908490566d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 5.0858424775E8d,
      error = 6512099.155689263d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 1.0631935888E9d,
      error = 1.7210698233689763E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 1678296.1612903227d,
      error = 4909.064599517301d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 1676226.5806451612d,
      error = 4530.47194605072d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 1612024.5806451612d,
      error = 7545.051350535179d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 5.811592561428572E8d,
      error = 1.0187154251205832E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 1.5253994413793104E7d,
      error = 39102.58121615081d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 1.7329984035714287E7d,
      error = 50238.93043039094d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 4.081191952E7d,
      error = 65121.197237272725d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 8.68644113E7d,
      error = 340362.00307929673d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 69549.67741935483d,
      error = 2484.7582135859748d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 344397.4516129032d,
      error = 1754.8624791648135d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 9689150.8d,
      error = 19205.915614648853d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 3.8565519536666665E9d,
      error = 2.55682940714059E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 1.241058751724138E7d,
      error = 16265.579124477012d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 1.91526177E8d,
      error = 1928969.3833809064d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 586626.1304347826d,
      error = 4207.467699266948d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 7544791.304347826d,
      error = 27223.684861266d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 4.8842825473684214E7d,
      error = 4.945656223980017E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 8.345234428E9d,
      error = 4.734378257773393E10d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 7337335.105263158d,
      error = 51501.51187086642d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 1.045108305263158E7d,
      error = 59859.14647762684d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 1132387.55d,
      error = 7828.48965658138d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 1.3413924703333333E9d,
      error = 7.70036031790619E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 1.41332226E7d,
      error = 70898.93020718663d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platnative", v) }
}