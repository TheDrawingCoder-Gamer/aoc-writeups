import java.util.concurrent.TimeUnit

object JVMBenches {
  val benchmarks = Map(    
    "day1y2020p1" -> BenchmarkTiming(
      mean = 1.0854278274509804E7d,
      error = 118058.37224303873d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 1.3368457175E8d,
      error = 453169.13696679013d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 1154971.7643564357d,
      error = 10664.819758572217d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1143446.3424657534d,
      error = 1645.937193370098d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 85282.69535283993d,
      error = 914.3171918008031d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 142300.56597222222d,
      error = 799.7290777511753d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 3860540.0342105264d,
      error = 12904.733502659708d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 3610229.81377551d,
      error = 78028.4085617637d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 160593.0680272109d,
      error = 800.7640109173657d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 442832.0602189781d,
      error = 3860.502221399344d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 3570571.5865633073d,
      error = 35948.22494588421d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 3145233.4452554747d,
      error = 8866.433212511705d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 8377299.411971831d,
      error = 131008.79963921958d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 2816446.942857143d,
      error = 29511.71681820228d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 573749.0132325141d,
      error = 3543.0478190364097d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 2084779.7266666666d,
      error = 18804.305132579488d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 4130804.5536159603d,
      error = 107553.86845421947d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 4856759.605633803d,
      error = 67964.11841297054d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 53469.51877133106d,
      error = 1022.3385800807957d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p2" -> BenchmarkTiming(
      mean = 43139.11284722222d,
      error = 1174.2418258416394d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p1" -> BenchmarkTiming(
      mean = 5.045364203E8d,
      error = 2386563.515911352d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p2" -> BenchmarkTiming(
      mean = 1.2883132194594595E8d,
      error = 450617.21307703934d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p1" -> BenchmarkTiming(
      mean = 90096.98913043478d,
      error = 2039.7605381001426d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p2" -> BenchmarkTiming(
      mean = 85802.83663366336d,
      error = 537.3858231295437d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p1" -> BenchmarkTiming(
      mean = 1380303.4104627767d,
      error = 31364.475529329993d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p2" -> BenchmarkTiming(
      mean = 57017.81352833638d,
      error = 2742.3044909629302d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p1" -> BenchmarkTiming(
      mean = 1940065.0021367522d,
      error = 13768.342994715314d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p2" -> BenchmarkTiming(
      mean = 7.138304872307692E7d,
      error = 850230.3584345422d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p1" -> BenchmarkTiming(
      mean = 31387.455d,
      error = 490.5514388228909d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p2" -> BenchmarkTiming(
      mean = 5.518515036666666E8d,
      error = 2.701035282851297E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p1" -> BenchmarkTiming(
      mean = 907133.7473903967d,
      error = 3177.117572344126d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p2" -> BenchmarkTiming(
      mean = 1653441.574117647d,
      error = 4947.714315813334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ), 
    "day1y2021p1" -> BenchmarkTiming(
      mean = 404259.22222222225d,
      error = 1896.5220906157401d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 996083.0742857143d,
      error = 6190.6491549364455d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 768014.4345351043d,
      error = 2957.1985958501677d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 768415.072243346d,
      error = 1991.7996650259463d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 182308.06271186442d,
      error = 1359.2556736162733d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 213176.8031358885d,
      error = 1398.3482454645518d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 3366402.170157068d,
      error = 21700.86289682596d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 1.3544741448430493E7d,
      error = 158211.32135805796d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 3.1809749824E7d,
      error = 1318162.0839603033d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 5.5778533341772154E7d,
      error = 4217381.892001083d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 2.6313425413333334E7d,
      error = 1129816.0079991536d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 356638.6629001883d,
      error = 1404.8807972409154d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 279661.54642857146d,
      error = 2338.043339111523d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 117552.44887348353d,
      error = 1019.1077505302162d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p1" -> BenchmarkTiming(
      mean = 974169.7469387755d,
      error = 5231.759183425315d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p2" -> BenchmarkTiming(
      mean = 2261721.374701671d,
      error = 5789.790760055293d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p1" -> BenchmarkTiming(
      mean = 1323663.2020833334d,
      error = 7279.901887068927d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p2" -> BenchmarkTiming(
      mean = 1.1748203073469387E7d,
      error = 201592.8325907323d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p1" -> BenchmarkTiming(
      mean = 507553.16576576576d,
      error = 2865.4322676875386d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p2" -> BenchmarkTiming(
      mean = 539700.1697080293d,
      error = 2385.739158616348d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p1" -> BenchmarkTiming(
      mean = 2.7144773423611112E7d,
      error = 408332.80311250285d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p2" -> BenchmarkTiming(
      mean = 1.00632958125E8d,
      error = 2035861.677751983d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p1" -> BenchmarkTiming(
      mean = 4.664947933695652E7d,
      error = 835037.5419290604d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p2" -> BenchmarkTiming(
      mean = 1.7062051966666667E9d,
      error = 2.2817748426853207E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p1" -> BenchmarkTiming(
      mean = 1.9929070889E10d,
      error = 3.958571558755699E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p2" -> BenchmarkTiming(
      mean = 1.9697541808E10d,
      error = 4.5101052380209917E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 1.825971501025641E7d,
      error = 361350.74217852106d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 8.846507645E8d,
      error = 7276131.44772788d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 495179.25831702544d,
      error = 7369.960042087089d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p2" -> BenchmarkTiming(
      mean = 5.078097229666667E9d,
      error = 5.2299858550159484E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 196429.54481546572d,
      error = 1317.2682745112882d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 235692.99635036496d,
      error = 1626.1829933026354d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 540412.7566137566d,
      error = 7664.55130084763d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 439960.6900900901d,
      error = 5482.85516335617d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 784932.553030303d,
      error = 4378.309783222054d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 1874277.534934498d,
      error = 4617.677160297733d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 1.1087216352313166E7d,
      error = 54494.278962687546d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 1.1324629639676113E7d,
      error = 16286.786793138837d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 861067.6720647773d,
      error = 8682.057113121784d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 762993.772073922d,
      error = 6571.535598105737d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 1712918.796976242d,
      error = 10281.609346330571d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 7577970.453674122d,
      error = 280599.48985105957d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 2721066.097156398d,
      error = 6641.859397148333d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 2752457.9431279623d,
      error = 13324.711968882535d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 7.391239135714285E8d,
      error = 1.7986849203089725E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 8.093547877142857E8d,
      error = 3.781536309714716E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 1.88593727247191E7d,
      error = 286826.41134130495d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 2.1504496268292684E7d,
      error = 1231463.9782366406d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 251811.09072580645d,
      error = 3762.9206536113666d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 959167.8583877996d,
      error = 7211.539634143689d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 171841.49806949808d,
      error = 3433.2398298575777d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 1.7623015215384614E7d,
      error = 280683.8788992106d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 1.2812961360655738E7d,
      error = 87791.54009986886d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 2.1067493216666667E9d,
      error = 1.2900812116024084E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 2742876.950118765d,
      error = 55353.41457687466d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 3634538.0935064936d,
      error = 4856.918975941778d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 1.427162058064516E7d,
      error = 173808.65317546457d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 4.772232260333333E9d,
      error = 9.247823499845499E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 70115.73913043478d,
      error = 1729.6005783215228d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 2.5971151633333335E9d,
      error = 1.0274371483098788E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 1.8509897766666666E8d,
      error = 2834932.7880353145d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 5.026726538666667E9d,
      error = 2.0990630907231012E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 5324641.0720221605d,
      error = 191812.96257718213d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 3.53749341092437E7d,
      error = 463964.83766071714d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 4.7849249945454544E8d,
      error = 5897368.463231679d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 3630140.6975d,
      error = 12232.277025167226d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 3649867.067164179d,
      error = 11966.310972142172d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 2.8637516888888888E7d,
      error = 235277.5207768038d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 1.0981566730434783E7d,
      error = 158932.07495581268d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 1.7172842133333333E7d,
      error = 249924.98103725212d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p2" -> BenchmarkTiming(
      mean = 2.9437424077666668E10d,
      error = 1.1002865270368857E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 1.26091088875E9d,
      error = 1.0551834183322299E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 3.926984341E9d,
      error = 1.354071432634759E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 55394.31560891938d,
      error = 876.4976987499448d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 173878.4520069808d,
      error = 5469.695251671889d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 2633782.076233184d,
      error = 33933.564909293724d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 1423682.5680345572d,
      error = 12813.671450487987d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 1522559.4239828694d,
      error = 7499.9885627912045d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 2825306.6882494004d,
      error = 22162.593799821014d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 1830087.611738149d,
      error = 6445.68608299973d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 1912150.7706422019d,
      error = 2967.5317936740767d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 1949178.0184757505d,
      error = 11041.061846240782d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 1198271.5560081466d,
      error = 6607.309742538385d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 1145326.305785124d,
      error = 2689.186704941451d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 1207637.4748490946d,
      error = 4934.941895017086d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 2805857.0303738317d,
      error = 26564.372875118224d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 366209.1339285714d,
      error = 2993.677576845723d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 674603.8947368421d,
      error = 6237.963104263232d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 9660631.58302583d,
      error = 127911.69860109771d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1506251.0228215768d,
      error = 16090.695405963328d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 1.049231436259542E7d,
      error = 71042.6299880321d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 3.983096426923077E8d,
      error = 7492329.285955015d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 922270.6225680934d,
      error = 6283.333802430545d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 1.307101983E9d,
      error = 4.95343045306078E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 4986480.801675978d,
      error = 34097.76012621589d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 1.7024386667857143E8d,
      error = 93268.50123699255d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 4816881.9147727275d,
      error = 117679.1142154049d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 5789622.262345679d,
      error = 113305.59002671017d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 1.316924477E9d,
      error = 7.660774623956534E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 7.519037972857143E8d,
      error = 1.8873597470149717E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 5.92447614E8d,
      error = 3625059.108316539d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 5.547608448888888E8d,
      error = 1025465.9119009691d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 2336768.486111111d,
      error = 7140.61557177248d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 7.636238177419356E7d,
      error = 1112657.578815921d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 2.2529560463636363E8d,
      error = 2515587.4924254273d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 4.429816943333333E8d,
      error = 6327110.67323443d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 980963.7551020408d,
      error = 5426.736158384035d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 934089.074074074d,
      error = 5518.880518384099d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 590254.2729044835d,
      error = 5387.923536224349d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 1.9317909434615386E8d,
      error = 476505.7203463294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 1.2188474697478991E7d,
      error = 170066.08534385674d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 1.2499120421052631E7d,
      error = 404520.3116176981d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 3.396298706896552E7d,
      error = 468494.13075101795d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 2.762739426470588E7d,
      error = 323328.32562279055d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 44800.65209471767d,
      error = 1209.978605637056d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 308108.09980806144d,
      error = 1983.9198601919156d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 1.0166266390625E7d,
      error = 393331.42043540016d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 2.7975865073333335E9d,
      error = 9.516176203162867E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 1.14623033625498E7d,
      error = 132397.2002467838d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 6.435013201369863E7d,
      error = 1512325.111680246d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p1" -> BenchmarkTiming(
      mean = 1.41444904875E9d,
      error = 2.9046522217373893E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p2" -> BenchmarkTiming(
      mean = 2.6671049246666665E9d,
      error = 7.257508071007751E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 272390.9390962672d,
      error = 3651.5645817825393d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 4055942.279255319d,
      error = 67084.64335435888d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 1.3071673785714285E7d,
      error = 109038.82290391586d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 2.8586033176666665E9d,
      error = 3.0584361703146005E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 4532690.997382199d,
      error = 183225.14192825442d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 7587766.207612457d,
      error = 328390.22594332974d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 928820.4080338266d,
      error = 7579.569218563106d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 9.88410413E8d,
      error = 7029731.109042288d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 1.1130214395437263E7d,
      error = 465227.5079305368d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platjvm", v) }
}
