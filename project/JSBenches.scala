import java.util.concurrent.TimeUnit

object JSBenches {
  val benchmarks = Map(
    "day1y2015p1" -> BenchmarkTiming(
      mean = 48228.54038588511d,
      error = 31.32800341992152d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2015p2" -> BenchmarkTiming(
      mean = 300977.3738732492d,
      error = 113.55961617465947d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2015p1" -> BenchmarkTiming(
      mean = 1695370.7410901468d,
      error = 678.3501681809167d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day2y2015p2" -> BenchmarkTiming(
      mean = 1725630.1403508773d,
      error = 16478.96143009686d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2015p1" -> BenchmarkTiming(
      mean = 1080634.0588633288d,
      error = 2619.340011142906d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day3y2015p2" -> BenchmarkTiming(
      mean = 2025632.544472153d,
      error = 4573.791341195578d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2015p1" -> BenchmarkTiming(
      mean = 1094641884.6d,
      error = 7855206.218669945d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day4y2015p2" -> BenchmarkTiming(
      mean = 31959273270d,
      error = 7689911962.183137d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2015p1" -> BenchmarkTiming(
      mean = 2775836.2813559324d,
      error = 3093.1419181185915d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day5y2015p2" -> BenchmarkTiming(
      mean = 12494822.518796992d,
      error = 20132.03970356672d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2015p1" -> BenchmarkTiming(
      mean = 139919300.7222222d,
      error = 283519.85889435164d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day6y2015p2" -> BenchmarkTiming(
      mean = 134544394.5d,
      error = 777059.0136040207d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2015p1" -> BenchmarkTiming(
      mean = 2140856.616232907d,
      error = 756.2692454173437d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day7y2015p2" -> BenchmarkTiming(
      mean = 2264141.6422915696d,
      error = 2093.285098279899d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2015p1" -> BenchmarkTiming(
      mean = 91524.93505069883d,
      error = 52.9542194119185d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day8y2015p2" -> BenchmarkTiming(
      mean = 85796.51120994591d,
      error = 35.95035965671294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2015p1" -> BenchmarkTiming(
      mean = 939768233.5d,
      error = 83905566.95393817d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day9y2015p2" -> BenchmarkTiming(
      mean = 1051420559.2d,
      error = 20288207.688859683d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2015p1" -> BenchmarkTiming(
      mean = 2307360.2041686405d,
      error = 2109.9634305183927d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day10y2015p2" -> BenchmarkTiming(
      mean = 3232168.939353988d,
      error = 28776.21506441432d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2020p1" -> BenchmarkTiming(
      mean = 9789034.427165354d,
      error = 46953.11848836213d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 173258444.24137932d,
      error = 1548990.9250995282d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 2068284.467025572d,
      error = 1767.8119293562272d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1984891.8117501035d,
      error = 5264.801282214259d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 141242.08078441047d,
      error = 78.53053231890135d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 166672.25990622415d,
      error = 129.16343981118706d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 10382619.348008385d,
      error = 5760.377417016896d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 10456117.483122364d,
      error = 77516.94482392537d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 128850.66155983483d,
      error = 53.5315226589935d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 514028.0093196645d,
      error = 311.6289310739901d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 12681260.979539642d,
      error = 21226.204069199637d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 10796480.899563318d,
      error = 321130.4699623156d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 17318895.21830986d,
      error = 27686.536711946104d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 6662289.631436314d,
      error = 2379.105666179883d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 1208017.100202429d,
      error = 2806.985112111001d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 3640609.088455772d,
      error = 8132.956879179708d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 9247606.393194707d,
      error = 23874.91816063338d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 9372559.362068966d,
      error = 19138.739303247476d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 62540.96738642917d,
      error = 34.77797454987039d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p2" -> BenchmarkTiming(
      mean = 44323.34203826161d,
      error = 27.37328514525396d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p1" -> BenchmarkTiming(
      mean = 2034870105.6666667d,
      error = 157394539.5275834d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p2" -> BenchmarkTiming(
      mean = 447028783.0833333d,
      error = 5967019.29536133d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p1" -> BenchmarkTiming(
      mean = 82064.88144238334d,
      error = 62.70806773715372d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p2" -> BenchmarkTiming(
      mean = 102690.8894143218d,
      error = 97.83678875827745d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p1" -> BenchmarkTiming(
      mean = 1771868.7538181818d,
      error = 8037.141229597113d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p2" -> BenchmarkTiming(
      mean = 41044.29085597541d,
      error = 55.55179827984482d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p1" -> BenchmarkTiming(
      mean = 3026853.6477132263d,
      error = 5789.488536044908d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p2" -> BenchmarkTiming(
      mean = 76925188.1904762d,
      error = 764609.7491186846d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p1" -> BenchmarkTiming(
      mean = 18568.943156059286d,
      error = 11.879249897241543d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p2" -> BenchmarkTiming(
      mean = 3136053369.6666665d,
      error = 780314330.8312483d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p1" -> BenchmarkTiming(
      mean = 1715304.4323268207d,
      error = 2650.0269610867094d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p2" -> BenchmarkTiming(
      mean = 2268514.875526439d,
      error = 7320.865560114144d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
    "day1y2021p1" -> BenchmarkTiming(
      mean = 882609.058155209d,
      error = 1218.4402822595753d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 1923612.675071167d,
      error = 2470.145738281344d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 1453710.315690573d,
      error = 955.1985948838825d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 1465351.8207343412d,
      error = 2056.4957601725478d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 192756.75009021084d,
      error = 178.29403004253834d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 220477.61946547372d,
      error = 68.33212176650176d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 6172345.217610063d,
      error = 12830.485584365228d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 53851033.010752685d,
      error = 257443.68264621112d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 149858366.57575756d,
      error = 7019592.598205062d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 264697798.7368421d,
      error = 14039643.352567175d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 75043114.22727273d,
      error = 816150.6830320946d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 2029140.61022632d,
      error = 2223.7554890367164d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 278360.6322361724d,
      error = 298.6235505484652d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 183936.31665367374d,
      error = 139.81257262772044d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p1" -> BenchmarkTiming(
      mean = 1290455.8710895362d,
      error = 1535.0531840512986d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p2" -> BenchmarkTiming(
      mean = 2050278.903935675d,
      error = 4972.94514685099d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p1" -> BenchmarkTiming(
      mean = 1290762.305898491d,
      error = 2681.6506377390106d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p2" -> BenchmarkTiming(
      mean = 13959269.317142857d,
      error = 203474.99231651734d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p1" -> BenchmarkTiming(
      mean = 241328.53341493267d,
      error = 299.18142538784605d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p2" -> BenchmarkTiming(
      mean = 262361.0022393466d,
      error = 299.6260320405252d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p1" -> BenchmarkTiming(
      mean = 74246134.6764706d,
      error = 60447.73260231744d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p2" -> BenchmarkTiming(
      mean = 265393158.15789473d,
      error = 904592.3454716131d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p1" -> BenchmarkTiming(
      mean = 206869589.28d,
      error = 2786951.451615607d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p2" -> BenchmarkTiming(
      mean = 8539998647d,
      error = 2201139086.2365265d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 66239472.5131579d,
      error = 81145.42631064153d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 3740681725.3333335d,
      error = 85684595.03688067d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 785846.3360938579d,
      error = 769.7032551722197d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p2" -> BenchmarkTiming(
      mean = 16133783173.666666d,
      error = 4351524083.635073d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 247043.0920625d,
      error = 462.0432329736113d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 300355.71483861544d,
      error = 229.91964936376328d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 1916863.8101815311d,
      error = 823.2114021071004d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 2120807.743690165d,
      error = 3527.630526687251d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 1546765.793350717d,
      error = 2128.719709744711d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 6119129.460396039d,
      error = 10965.66737459776d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 87476859.61403508d,
      error = 1880884.6619283976d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 89593495.08928572d,
      error = 915681.0577937077d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 1593422.00265428d,
      error = 654.4285393062341d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 1409652.4068742655d,
      error = 4303.994534245265d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 3707159.4564723694d,
      error = 1865.2554326362133d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 15881331.856687898d,
      error = 35783.75788047797d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 2473722.023255814d,
      error = 1588.192329473422d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 2591875.6214928534d,
      error = 13728.121779456525d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 1751340787.6666667d,
      error = 317630421.2634221d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 2082769924.3333333d,
      error = 458675854.38523126d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 38968239.9140625d,
      error = 846749.4141070236d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 42758774.854700856d,
      error = 1280675.2399650426d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 366117.92849015316d,
      error = 252.82127341842389d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 900859.480290253d,
      error = 1489.390101216827d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 222004.88331160365d,
      error = 364.5985171779381d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 61634452.55555555d,
      error = 362160.90933908866d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 85423581.72881356d,
      error = 82320.30894548891d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 14005031981d,
      error = 5173864605.722997d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 5677260.0705202315d,
      error = 42487.20203387182d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 7022907.115549215d,
      error = 18086.486045104157d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 57293704.42045455d,
      error = 160892.29798474492d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 13467295273d,
      error = 853638923.6026255d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 180966.18128826842d,
      error = 260.8428843242357d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 10061938672.333334d,
      error = 410927577.8795345d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 878094019.1666666d,
      error = 19704824.000804093d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 33934853959d,
      error = 2781578476.753536d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 13755465.952380951d,
      error = 64248.812271286435d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 82510769.44262294d,
      error = 176798.99431606743d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 1044892856d,
      error = 84466249.56809571d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 8021026.089576547d,
      error = 30534.771856743067d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 8237854.747491639d,
      error = 29557.875117935026d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 63129206.65d,
      error = 580775.088492925d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 17053212.523972604d,
      error = 67681.16295539847d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 55097748.12087912d,
      error = 428236.2233635817d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 5852223081.666667d,
      error = 4202491450.071203d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 17590703133.666668d,
      error = 2516799355.590147d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 70408.97076791168d,
      error = 40.29430832035848d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 219794.32878511076d,
      error = 254.9554381403806d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 762592.269363026d,
      error = 434.23038650117667d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 3607609.0654411763d,
      error = 17716.352713541015d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 3441728.955789474d,
      error = 3747.0495092048136d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 3566333.1013119533d,
      error = 1329.07553915379d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 2859816.80493537d,
      error = 1546.0482891724369d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 3735550.719754977d,
      error = 2858.601521741511d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 3784500.457496136d,
      error = 2435.830875825216d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 2034533.8198389148d,
      error = 1082.546866850461d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 2325500.631704981d,
      error = 959.4455010211335d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 2819130.839285714d,
      error = 1409.634531775199d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 5534945.714927048d,
      error = 1947.4631556751012d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 462261.89199573104d,
      error = 258.6205180378327d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 773783.9028675618d,
      error = 665.5469767549088d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 41554286.06666667d,
      error = 411786.64939048287d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 2266600.668374476d,
      error = 5467.858179675217d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 43756602.33913043d,
      error = 407910.81465331354d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 2578828689.6666665d,
      error = 92111219.12023966d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 1935683.8617492947d,
      error = 2436.5773831696933d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 7934375236d,
      error = 535894850.3771935d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 14668498.557522124d,
      error = 85665.95232029443d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 515698557.4d,
      error = 4692222.010952382d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 5922690.369879518d,
      error = 17096.225893757688d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 7572098.292307693d,
      error = 12183.353768344596d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 6446019055d,
      error = 57617310659.29194d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 3299005392.6666665d,
      error = 118028057.60532503d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 2428298856.3333335d,
      error = 193110429.05817622d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 1165469510.6d,
      error = 15274839.83195495d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 7460794.960606061d,
      error = 115592.39842417685d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 353806957.3333333d,
      error = 21420722.19521938d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 927257173.6666666d,
      error = 7238939.559624233d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 2187008473d,
      error = 201009464.0885005d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 2080283.4764150945d,
      error = 5780.132320893624d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 2232101.9222988505d,
      error = 963.9959590111858d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 1120391.116273585d,
      error = 500.95074172157933d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 1275285740.75d,
      error = 125343802.19062272d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 24233425.90291262d,
      error = 202738.07428054596d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 29679000.01785714d,
      error = 367571.95081526693d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 217400088.7826087d,
      error = 2310904.2704972555d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 98742333.88235295d,
      error = 944746.3158796713d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 22957.531138142094d,
      error = 17.770955943350017d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 1104889.5439126394d,
      error = 398.59768371773254d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 41260630.40495868d,
      error = 108440.09253040342d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 16892247273d,
      error = 1078243721.238561d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 11166611.594170403d,
      error = 15442.475354670754d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 100684552.16d,
      error = 603498.9107843564d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p1" -> BenchmarkTiming(
      mean = 1454331619.25d,
      error = 37685562.97403909d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p2" -> BenchmarkTiming(
      mean = 2026238810d,
      error = 4088739236.206162d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 599253.5227486243d,
      error = 406.4412530568739d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 10450907.016842104d,
      error = 27805.415933952023d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 28549985.28d,
      error = 35791.362748307176d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 18242245178.666668d,
      error = 2977521594.0671706d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 11819283.493975904d,
      error = 66329.38207253432d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 20728406.020833332d,
      error = 112508.13448559714d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 2208948.389977221d,
      error = 4244.471003421567d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 6757712333.333333d,
      error = 1701677307.846728d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 19285468.740310077d,
      error = 125038.43683016312d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platjs", v) }
}
