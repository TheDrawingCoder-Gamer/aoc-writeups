import java.util.concurrent.TimeUnit

object NativeBenches {
  val benchmarks = Map(    
    "day1y2020p1" -> BenchmarkTiming(
      mean = 1.51103567E7d,
      error = 56410.51480473099d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 2.890840549E8d,
      error = 2987109.7168340283d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 1369222.2d,
      error = 28472.790131163343d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1279620.1d,
      error = 3813.5061083177193d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 157493.1d,
      error = 4852.419408832577d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 235570.2d,
      error = 3210.560754689192d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 1.0941327E7d,
      error = 204878.2137264108d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 1.13061082E7d,
      error = 1333391.2359013646d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 241792.2d,
      error = 8360.837512884138d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 537927.3d,
      error = 6565.714093565913d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 2095665.9d,
      error = 6092.890172257867d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 2063563.6d,
      error = 8563.589734737265d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 1.04779135E7d,
      error = 54831.39036988742d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 5406024.9d,
      error = 21396.77142078189d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 752511.6d,
      error = 6243.586708706002d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 2217843.0d,
      error = 16052.272581591531d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 8511724.6d,
      error = 1849494.281304545d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 7910661.3d,
      error = 32850.61471085683d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 14270.0d,
      error = 1139.3201153155564d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p1" -> BenchmarkTiming(
      mean = 604533.4d,
      error = 5363.8498531491605d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 1261988.1d,
      error = 16462.020477867674d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 986485.9d,
      error = 12822.481046586354d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 961223.0d,
      error = 4875.003622939316d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 324758.4d,
      error = 12674.942544265958d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 267218.3d,
      error = 5449.078408758798d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 7617792.9d,
      error = 51470.390523855d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 3.52654618E7d,
      error = 2906934.9224559753d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 3.53822269E7d,
      error = 2105146.6324154516d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 6.91589395E7d,
      error = 2258278.963131391d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 6.82065307E7d,
      error = 331480.4367822183d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 266967.3d,
      error = 1698.4460724512876d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 233054.2d,
      error = 1436.6079365854475d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 157859.2d,
      error = 1677.7828919491947d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p1" -> BenchmarkTiming(
      mean = 2.5500975000333332E10d,
      error = 9.890785911999955E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p2" -> BenchmarkTiming(
      mean = 2.5562537459666668E10d,
      error = 2.978791290211551E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 3.694461E7d,
      error = 6429395.108595528d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 2.1099505343333333E9d,
      error = 1.2452863051450023E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 590866.5d,
      error = 4748.431286199368d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 461695.4d,
      error = 6254.203069074912d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 498664.3d,
      error = 6962.726162996223d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 7396668.9d,
      error = 40655.381991994494d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 7427293.8d,
      error = 42073.44164382862d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 759773.7d,
      error = 16053.057933236203d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 1394560.0d,
      error = 27152.79583541936d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 2.19352848E7d,
      error = 108248.24457093311d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 2.2043238E7d,
      error = 125399.835654503d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 1299984.2d,
      error = 9774.527676491456d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 1174893.1d,
      error = 6122.202790565072d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 2383313.2d,
      error = 13086.018957613775d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 1.0622235E7d,
      error = 53913.21229461993d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 3604002.2d,
      error = 7548.661049397424d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 3641458.5d,
      error = 9797.204781596078d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 1.110103966E9d,
      error = 6922925.877510975d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 1.226156731E9d,
      error = 7037288.744954257d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 1.31437618E7d,
      error = 226878.90428174738d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 1.55343211E7d,
      error = 129619.33406656506d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 264882.3d,
      error = 3664.1892636821326d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 834086.0d,
      error = 13313.069453923441d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 225386.3d,
      error = 5452.75385040742d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 5.34354295E7d,
      error = 325199.4449141024d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 3.29926369E7d,
      error = 132459.36115053415d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 5.3385765E9d,
      error = 3.162335804074349E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 4076931.0d,
      error = 22453.97167090945d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 6009643.4d,
      error = 116419.80040564502d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 4.47246296E7d,
      error = 514523.18951331533d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 1.6462764795333334E10d,
      error = 7.143716828101292E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 67433.0d,
      error = 320.24184799346256d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 7.563358822E9d,
      error = 1.003607239509951E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 4.951986123333333E8d,
      error = 4.098508922203899E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 1.3951557526333334E10d,
      error = 1.420620909523558E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 5929879.0d,
      error = 22888.894055066852d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 5.97881432E7d,
      error = 213857.14204116282d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 9.208585706666666E8d,
      error = 9.944888323906283E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 4117713.8d,
      error = 18958.196991068613d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 4154429.8d,
      error = 16281.606544355729d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 4.05923927E7d,
      error = 960444.5040036408d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 9314645.4d,
      error = 43091.193587152666d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 3.08311269E7d,
      error = 326134.11809423217d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 2.4332466913333335E9d,
      error = 2.2415441002787952E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 7.721867512666667E9d,
      error = 1.1541428245655328E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 48519.0d,
      error = 3485.423722842342d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 388358.3d,
      error = 8551.694399322556d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 1.48977196E7d,
      error = 56519.00647031678d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 3598344.3d,
      error = 21557.167696402255d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 3606007.3d,
      error = 14422.686747413625d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 2861299.6d,
      error = 29013.330275453383d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 1947152.8d,
      error = 11743.480190833441d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 9527544.6d,
      error = 27011.559784509987d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 9561924.6d,
      error = 38910.12012913871d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 1393234.3d,
      error = 8062.282884002277d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 1365837.2d,
      error = 11913.958250817299d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 7650852.0d,
      error = 44848.363679521164d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 1.03235904E7d,
      error = 40020.77181295036d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 2824743.5d,
      error = 16852.371253497946d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 3364922.1d,
      error = 14525.525464595905d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 1.57966704E7d,
      error = 151671.03444577963d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1607675.5d,
      error = 20137.128408505934d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 4.26711658E7d,
      error = 238073.14057812467d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 1.443288834E9d,
      error = 4.4452549040955015E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 1009383.9d,
      error = 8803.810149689652d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 2.2771825463333335E9d,
      error = 1.7896493353652486E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 1.4144986E7d,
      error = 118697.05576037489d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 3.40842072E8d,
      error = 8524293.64712826d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 5495309.0d,
      error = 53144.81784666024d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 6054416.6d,
      error = 157641.12406478162d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 1.7333874394333332E10d,
      error = 9.991308475992506E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 3.8416258736666665E9d,
      error = 7.065179454204638E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 1.3883706343333333E9d,
      error = 1.736654140838465E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 1.3157220786666667E9d,
      error = 1.9611414942837393E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 2122345.8d,
      error = 9384.304208079655d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 9.67266895E7d,
      error = 706355.2680378315d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 5.516969363333334E8d,
      error = 6174579.035133297d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 1.260636032E9d,
      error = 8.358279084250425E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 1484548.0d,
      error = 51722.37591192166d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 1498248.0d,
      error = 427819.1230108771d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 716613.7d,
      error = 7546.155063303144d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 5.372964833333334E8d,
      error = 7133913.353437575d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 1.56625672E7d,
      error = 520450.3105974541d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 1.40052007E7d,
      error = 41528.49792452118d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 6.82724726E7d,
      error = 727291.0109204652d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 6.47330907E7d,
      error = 914986.2869716889d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 33513.64d,
      error = 152.78210166370823d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 716592.28d,
      error = 5898.016706415238d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 1.60052224E7d,
      error = 46106.63768076498d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 6.752840894333333E9d,
      error = 4.697701648811461E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 1.06893998E7d,
      error = 23399.902926293347d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 2.628359991E8d,
      error = 1397697.9206788016d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p1" -> BenchmarkTiming(
      mean = 4.0846077806666665E9d,
      error = 8.283866936325793E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p2" -> BenchmarkTiming(
      mean = 4.2874995776666665E9d,
      error = 2.386683231215439E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 351183.3d,
      error = 3512.4101607081943d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 5508105.0d,
      error = 74790.61369118685d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 3.13280684E7d,
      error = 903033.5347430585d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 5.323367983E9d,
      error = 7.273823001544002E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 7368644.7d,
      error = 63796.79732852009d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 1.1058993E7d,
      error = 235644.65304127304d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 993369.0d,
      error = 17959.33732571525d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 1.3291904376666667E9d,
      error = 1.7077858545157346E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 1.35674312E7d,
      error = 118351.58918031288d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platnative", v) }
}