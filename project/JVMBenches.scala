import java.util.concurrent.TimeUnit

object JVMBenches {
  val benchmarks = Map(    
    "day1y2015p1" -> BenchmarkTiming(
      mean = 21370.735294117647d,
      error = 559.9369340958654d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2015p2" -> BenchmarkTiming(
      mean = 240806.6908462867d,
      error = 2526.500973111996d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2015p1" -> BenchmarkTiming(
      mean = 890494.4060150376d,
      error = 12512.614300219873d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2015p2" -> BenchmarkTiming(
      mean = 890835.3352165725d,
      error = 12776.208261229582d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2015p1" -> BenchmarkTiming(
      mean = 1113899.0412757974d,
      error = 21103.113695619835d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2015p2" -> BenchmarkTiming(
      mean = 1791089.5341614906d,
      error = 30980.24741718099d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2015p1" -> BenchmarkTiming(
      mean = 6.514348328169014E7d,
      error = 241274.90802186533d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2015p2" -> BenchmarkTiming(
      mean = 1.8786006603333333E9d,
      error = 1.805547751333109E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2015p1" -> BenchmarkTiming(
      mean = 1627125.7003968253d,
      error = 27359.49873584505d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2015p2" -> BenchmarkTiming(
      mean = 6558062.149847095d,
      error = 173108.6168000815d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2015p1" -> BenchmarkTiming(
      mean = 3.330318982926829E7d,
      error = 1445768.6820059656d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2015p2" -> BenchmarkTiming(
      mean = 1.5202901064220183E7d,
      error = 237962.0976622007d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2015p1" -> BenchmarkTiming(
      mean = 945423.7459165155d,
      error = 23166.307815492033d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2015p2" -> BenchmarkTiming(
      mean = 991452.4637964775d,
      error = 21564.25391944661d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2015p1" -> BenchmarkTiming(
      mean = 204543.6637781629d,
      error = 4977.347535983365d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2015p2" -> BenchmarkTiming(
      mean = 223485.77403035414d,
      error = 3660.5150563213538d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2015p1" -> BenchmarkTiming(
      mean = 1.2824602226315789E8d,
      error = 544028.3504915795d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2015p2" -> BenchmarkTiming(
      mean = 1.2316236812820514E8d,
      error = 551766.8445777865d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2015p1" -> BenchmarkTiming(
      mean = 739928.5816993464d,
      error = 13884.64375550912d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2015p2" -> BenchmarkTiming(
      mean = 983664.1221020092d,
      error = 11187.382556134733d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2015p1" -> BenchmarkTiming(
      mean = 481333.7408695652d,
      error = 5513.693255635508d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2015p2" -> BenchmarkTiming(
      mean = 1137432.1114167813d,
      error = 17677.36341313776d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2015p1" -> BenchmarkTiming(
      mean = 4.453733963636363E7d,
      error = 329812.5215615786d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2015p2" -> BenchmarkTiming(
      mean = 4.349565301666667E8d,
      error = 8642052.41477297d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2015p1" -> BenchmarkTiming(
      mean = 277410.744d,
      error = 3805.3642953161093d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2015p2" -> BenchmarkTiming(
      mean = 899409.0662739322d,
      error = 8123.650208840347d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2015p1" -> BenchmarkTiming(
      mean = 1.8630902284974094E7d,
      error = 1059285.105976359d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2015p2" -> BenchmarkTiming(
      mean = 2.1343576441860463E7d,
      error = 1345159.5900097776d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2015p1" -> BenchmarkTiming(
      mean = 2122353.6153846155d,
      error = 7763.600973076325d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2015p2" -> BenchmarkTiming(
      mean = 2165139.6598639456d,
      error = 6688.983422128869d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2015p1" -> BenchmarkTiming(
      mean = 6.54368430875E8d,
      error = 4.643591325266686E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2015p2" -> BenchmarkTiming(
      mean = 6.474027195E8d,
      error = 6.654679438251574E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2015p1" -> BenchmarkTiming(
      mean = 1.4329133994117647E8d,
      error = 1851510.2269969902d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2015p2" -> BenchmarkTiming(
      mean = 1.4353345188235295E8d,
      error = 538976.0154603362d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2015p1" -> BenchmarkTiming(
      mean = 2892950.940839695d,
      error = 69944.45357457224d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2015p2" -> BenchmarkTiming(
      mean = 264259.7189781022d,
      error = 3444.1230151752848d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2015p1" -> BenchmarkTiming(
      mean = 1.7077133692307692E7d,
      error = 201638.39604455724d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2015p2" -> BenchmarkTiming(
      mean = 1.2701864176E7d,
      error = 486879.49087617436d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2015p1" -> BenchmarkTiming(
      mean = 310216.2202166065d,
      error = 3797.6514994255645d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2015p2" -> BenchmarkTiming(
      mean = 284019.75451263535d,
      error = 2606.3215091119155d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2015p1" -> BenchmarkTiming(
      mean = 1.0271968291304348E8d,
      error = 2445015.553912872d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2015p2" -> BenchmarkTiming(
      mean = 8.56461980925926E7d,
      error = 1530829.4672367403d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2015p1" -> BenchmarkTiming(
      mean = 140134.779286927d,
      error = 1796.6534016459777d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2015p2" -> BenchmarkTiming(
      mean = 158468.10154241647d,
      error = 2049.533735026414d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2015p1" -> BenchmarkTiming(
      mean = 3.539866018644068E7d,
      error = 716445.4063003354d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2015p2" -> BenchmarkTiming(
      mean = 6581016.157434402d,
      error = 184715.00763653152d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2015p1" -> BenchmarkTiming(
      mean = 9.59288466122449E7d,
      error = 2385741.0254507684d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p1" -> BenchmarkTiming(
      mean = 1.585715387826087E7d,
      error = 121685.02137650177d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 2.799194797222222E8d,
      error = 4464896.712260686d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 1088917.8922495274d,
      error = 22913.272237156893d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 1112512.4054054054d,
      error = 11697.76842675456d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 123849.0076142132d,
      error = 1532.3094331786735d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 189969.20969855832d,
      error = 3335.6321060575674d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 3531417.9776674937d,
      error = 15329.514021107294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 3731691.8541666665d,
      error = 17121.026726364817d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 199742.49593495936d,
      error = 2409.3723154068516d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 553715.4349775785d,
      error = 6585.588001352689d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 3652910.0610687025d,
      error = 62177.61029351555d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 3235013.8312655087d,
      error = 39969.33325082922d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 9264773.24632353d,
      error = 50358.01592072663d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 2683184.459276018d,
      error = 4324.00665168243d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 528014.9582753825d,
      error = 11561.809512538524d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 1915456.47601476d,
      error = 38008.16790381668d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 4108308.004115226d,
      error = 156734.94159431075d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 4714440.0d,
      error = 127913.43863887222d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 109159.99351851852d,
      error = 1595.7311545214645d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p2" -> BenchmarkTiming(
      mean = 114216.38271604938d,
      error = 1751.5119332194927d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p1" -> BenchmarkTiming(
      mean = 4.468405221818182E8d,
      error = 5365604.583746929d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2020p2" -> BenchmarkTiming(
      mean = 2.4645071295E8d,
      error = 4456942.915165902d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p1" -> BenchmarkTiming(
      mean = 123418.42170022371d,
      error = 1739.578837479484d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2020p2" -> BenchmarkTiming(
      mean = 182673.39672131147d,
      error = 2672.5866026609474d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p1" -> BenchmarkTiming(
      mean = 1399143.1032357472d,
      error = 27672.890022411062d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2020p2" -> BenchmarkTiming(
      mean = 126315.41870824054d,
      error = 4311.571077623318d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p1" -> BenchmarkTiming(
      mean = 1741679.688016529d,
      error = 40890.81624891832d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2020p2" -> BenchmarkTiming(
      mean = 5.896291383116883E7d,
      error = 1284403.4993211948d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p1" -> BenchmarkTiming(
      mean = 87466.2570951586d,
      error = 1626.8817098314455d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2020p2" -> BenchmarkTiming(
      mean = 5.521158302222222E8d,
      error = 5.597390899148532E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p1" -> BenchmarkTiming(
      mean = 1035499.4716312056d,
      error = 15301.335658350752d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2020p2" -> BenchmarkTiming(
      mean = 1819431.6345381527d,
      error = 59508.336352744474d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2020p1" -> BenchmarkTiming(
      mean = 1.3857115185840707E7d,
      error = 207896.9325630549d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2020p2" -> BenchmarkTiming(
      mean = 4.8127657745454544E8d,
      error = 1.4298317077848414E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2020p1" -> BenchmarkTiming(
      mean = 5173673.854938271d,
      error = 103583.27382778117d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2020p2" -> BenchmarkTiming(
      mean = 4920705.299435028d,
      error = 115891.33466653294d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2020p1" -> BenchmarkTiming(
      mean = 1.914348257E9d,
      error = 1.268094088757217E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2020p2" -> BenchmarkTiming(
      mean = 1.0409573314814815E7d,
      error = 355266.66457038873d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2020p1" -> BenchmarkTiming(
      mean = 2.2147705964071855E7d,
      error = 308340.30342196324d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2020p2" -> BenchmarkTiming(
      mean = 3.239790267768595E7d,
      error = 1517323.6743878531d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2020p1" -> BenchmarkTiming(
      mean = 2311006.007125891d,
      error = 37335.19321378499d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2020p2" -> BenchmarkTiming(
      mean = 2501167.739961759d,
      error = 33597.508145530184d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2020p1" -> BenchmarkTiming(
      mean = 157886.22523961661d,
      error = 2511.7060827738537d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2020p2" -> BenchmarkTiming(
      mean = 5.47249112E8d,
      error = 1.1957727252507104E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2020p1" -> BenchmarkTiming(
      mean = 155549.14611260055d,
      error = 2755.6687361179083d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2020p2" -> BenchmarkTiming(
      mean = 5.246611234666667E9d,
      error = 2.3528631179480777E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2020p1" -> BenchmarkTiming(
      mean = 3834246.986807388d,
      error = 110909.30743934917d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2020p2" -> BenchmarkTiming(
      mean = 4.7011785154545456E8d,
      error = 3.860652601978375E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2020p1" -> BenchmarkTiming(
      mean = 1.0531246668888889E8d,
      error = 1937462.4850071953d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p1" -> BenchmarkTiming(
      mean = 476846.79333333333d,
      error = 7427.929073473106d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 900873.7530674847d,
      error = 35364.75962579562d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 754065.7674858223d,
      error = 16958.182197423477d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 786553.622605364d,
      error = 9878.46854899703d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 209672.305982906d,
      error = 5613.2031700822545d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 252091.4351732991d,
      error = 6731.721186453498d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 2177954.4316666666d,
      error = 55401.85357781833d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 1.0366319921146953E7d,
      error = 180460.32401579042d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 3.746640133928572E7d,
      error = 631351.7292284688d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 8.169934268421052E7d,
      error = 3195068.27859105d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 2.5845406987096775E7d,
      error = 752755.1791790443d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 471005.92194403533d,
      error = 13520.858885805234d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 352721.82729805016d,
      error = 5310.812830848337d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 235232.8538587849d,
      error = 3511.7022361663253d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p1" -> BenchmarkTiming(
      mean = 1140367.0105263158d,
      error = 19939.924198848912d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2021p2" -> BenchmarkTiming(
      mean = 1914022.3956043955d,
      error = 12637.910575524838d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p1" -> BenchmarkTiming(
      mean = 1388265.443778111d,
      error = 29768.895207415288d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2021p2" -> BenchmarkTiming(
      mean = 1.1246780135658914E7d,
      error = 410767.71414905717d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p1" -> BenchmarkTiming(
      mean = 583168.4353741497d,
      error = 10172.682295675915d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2021p2" -> BenchmarkTiming(
      mean = 633776.0140646977d,
      error = 6915.078560970997d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p1" -> BenchmarkTiming(
      mean = 9261734.746835442d,
      error = 84122.42035626643d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2021p2" -> BenchmarkTiming(
      mean = 3.160231358778626E7d,
      error = 325254.1821902877d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p1" -> BenchmarkTiming(
      mean = 4.802211186021505E7d,
      error = 943006.5435981092d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2021p2" -> BenchmarkTiming(
      mean = 1.7580546786666667E9d,
      error = 4.6058195921141636E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2021p1" -> BenchmarkTiming(
      mean = 1004023.1837769328d,
      error = 26125.544399656334d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2021p2" -> BenchmarkTiming(
      mean = 1877601.5225375625d,
      error = 49690.93179596259d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2021p1" -> BenchmarkTiming(
      mean = 456394.0663580247d,
      error = 8104.688338772657d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2021p2" -> BenchmarkTiming(
      mean = 8517621.067114094d,
      error = 174886.11927614152d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2021p1" -> BenchmarkTiming(
      mean = 1.4454072440366972E7d,
      error = 289952.3292595172d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2021p2" -> BenchmarkTiming(
      mean = 4.919549648181818E8d,
      error = 8457914.404144734d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2021p1" -> BenchmarkTiming(
      mean = 159187.22832722834d,
      error = 975.7234012790475d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2021p2" -> BenchmarkTiming(
      mean = 133281.5422116528d,
      error = 1455.9377562572708d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2021p1" -> BenchmarkTiming(
      mean = 131616.4035759898d,
      error = 2848.677148657017d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2021p2" -> BenchmarkTiming(
      mean = 6895354.161559888d,
      error = 211519.00218240145d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2021p1" -> BenchmarkTiming(
      mean = 1.2268123788E7d,
      error = 518081.2030618622d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2021p2" -> BenchmarkTiming(
      mean = 8.81682360754717E7d,
      error = 948870.9790649837d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 1.6854501597156398E7d,
      error = 217954.562575631d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 8.082359228571428E8d,
      error = 5149321.627510635d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 672174.8862973761d,
      error = 7758.44544450283d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p2" -> BenchmarkTiming(
      mean = 4.356475180333333E9d,
      error = 3.718439684786811E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2021p1" -> BenchmarkTiming(
      mean = 1321988.5758389262d,
      error = 42551.50387043979d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2021p2" -> BenchmarkTiming(
      mean = 9.68070057755102E7d,
      error = 1460914.3163350124d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2021p1" -> BenchmarkTiming(
      mean = 6.578575865E8d,
      error = 1.7765701185990874E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2021p2" -> BenchmarkTiming(
      mean = 2.1250574293333333E9d,
      error = 4.29893786690595E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2021p1" -> BenchmarkTiming(
      mean = 537261.5391566266d,
      error = 5353.209010277759d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2021p2" -> BenchmarkTiming(
      mean = 535919.4304347826d,
      error = 3213.873865479361d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2021p1" -> BenchmarkTiming(
      mean = 1.0919232564E9d,
      error = 7.535128314623582E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 335527.9708029197d,
      error = 2835.6553904366438d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 403607.82836879435d,
      error = 2958.011830862591d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 552524.7177700348d,
      error = 12158.991260799929d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 520335.34330985916d,
      error = 1761.6032294645427d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 791146.7260083449d,
      error = 3616.5112364841257d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 1903837.8841463414d,
      error = 22124.69592294951d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 1.1983753996168582E7d,
      error = 172474.68230076297d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 1.2198534984189723E7d,
      error = 115983.84794603186d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 842650.6919575114d,
      error = 7969.480570467648d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 815820.2563718141d,
      error = 7445.63651733825d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 1548570.4021406728d,
      error = 19564.300765839263d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 5029407.479532164d,
      error = 235167.1991251799d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 3419080.8320610686d,
      error = 54410.55587864777d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 3493552.3274111673d,
      error = 38398.296059124026d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 6.53283859125E8d,
      error = 2.9387591911793556E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 6.93946893E8d,
      error = 8.61597046687109E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 2.057315555952381E7d,
      error = 758906.7709203665d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 2.7182457507246375E7d,
      error = 1217307.2533747677d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 377505.46776406036d,
      error = 3754.2699005708155d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 1065139.2140672782d,
      error = 17198.314051482987d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 338785.4875912409d,
      error = 5581.13445310747d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 1.8021112331606217E7d,
      error = 192017.3105734346d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 1.1077341492248062E7d,
      error = 292651.84343339724d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 1.2305865218E9d,
      error = 4.8649363999832116E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 2074620.1376404495d,
      error = 84357.80017584312d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 3784858.7166276346d,
      error = 56689.10867384016d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 1.5737203478048781E7d,
      error = 244476.42825109742d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 4.755486944333333E9d,
      error = 8.011593110939021E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 187802.56938325992d,
      error = 2792.0866311565755d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 1.610969491E9d,
      error = 8.192611192129785E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 1.915734835E8d,
      error = 905551.1234688843d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 5.279593222666667E9d,
      error = 6.092213825605776E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2022p1" -> BenchmarkTiming(
      mean = 7716815.87654321d,
      error = 145763.50839310075d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2022p2" -> BenchmarkTiming(
      mean = 3.779828977E9d,
      error = 9.440524262188746E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 7226929.29375d,
      error = 102261.63429397468d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p2" -> BenchmarkTiming(
      mean = 1.642227387817259E7d,
      error = 267171.94106467604d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2022p1" -> BenchmarkTiming(
      mean = 4.620290656E9d,
      error = 2.2558922410612932E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 2.846540776223776E7d,
      error = 451340.3493448299d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 3.018988155882353E8d,
      error = 4919113.26524636d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 3638841.1274509802d,
      error = 22942.0634586237d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 3729368.0272952854d,
      error = 8714.773397888084d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 3.0115629566929135E7d,
      error = 295312.6922878113d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 1.1788014719626168E7d,
      error = 176939.48284991138d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 1.4555016729357798E7d,
      error = 194060.4298610436d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 9.308514346666666E8d,
      error = 3.268213125928392E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 2.7967119123333335E9d,
      error = 1.504189545288005E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 92147.15592783505d,
      error = 946.0606102789255d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 232014.43307086613d,
      error = 6517.536694577065d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 3004463.5695488723d,
      error = 35764.11884673068d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 1109420.3538913364d,
      error = 45349.46966715063d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 1465246.7680140599d,
      error = 5258.047430691264d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 1494578.5110821382d,
      error = 43190.233097082804d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 1464019.1148036253d,
      error = 12042.041728077973d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 1811578.7982261642d,
      error = 15718.246136933503d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 2019857.6597938144d,
      error = 12700.816040619397d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2023p1" -> BenchmarkTiming(
      mean = 442975.3230016313d,
      error = 6622.877098558239d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2023p2" -> BenchmarkTiming(
      mean = 1557547.0227703985d,
      error = 6889.718212968021d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2023p1" -> BenchmarkTiming(
      mean = 228408.48484848486d,
      error = 2299.5547534443863d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2023p2" -> BenchmarkTiming(
      mean = 6.036703151948052E7d,
      error = 451226.64975298085d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2023p1" -> BenchmarkTiming(
      mean = 1.046375327443609E7d,
      error = 120879.05040879831d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2023p2" -> BenchmarkTiming(
      mean = 1.0830196973180076E7d,
      error = 65620.8867871577d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2023p1" -> BenchmarkTiming(
      mean = 2566980.478448276d,
      error = 23281.663951886556d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2023p2" -> BenchmarkTiming(
      mean = 7990998.563862928d,
      error = 153784.22019075116d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2023p1" -> BenchmarkTiming(
      mean = 5668437.274787535d,
      error = 93402.55680063559d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2023p2" -> BenchmarkTiming(
      mean = 5383343.906593407d,
      error = 127576.43982557456d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2023p1" -> BenchmarkTiming(
      mean = 1.0454521530075189E7d,
      error = 293520.3323249393d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2023p2" -> BenchmarkTiming(
      mean = 1.9313373112E8d,
      error = 3408253.752978222d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2023p1" -> BenchmarkTiming(
      mean = 3.1401814633093525E7d,
      error = 149595.57893655612d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2023p2" -> BenchmarkTiming(
      mean = 4.11426083119266E7d,
      error = 319940.33670956193d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2023p1" -> BenchmarkTiming(
      mean = 2623003.1019607843d,
      error = 22217.526349303527d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2023p2" -> BenchmarkTiming(
      mean = 6699868.052083333d,
      error = 347128.84397980734d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 1324501.736418511d,
      error = 16705.63931973963d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 1179792.512244898d,
      error = 14517.146381196471d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 1535005.6011235956d,
      error = 11366.445189154701d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 4076351.224880383d,
      error = 20489.93563535966d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 430648.99468085106d,
      error = 2837.45379696692d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 812138.1771653544d,
      error = 11381.37838352838d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 9598762.418367347d,
      error = 447873.6406292188d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1156861.4252077562d,
      error = 16385.685874282764d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 1.05370078697318E7d,
      error = 144980.34018026013d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 3.567763645714286E8d,
      error = 4675012.332633311d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 1316962.0590778098d,
      error = 17435.167531390307d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 1.9266934083333333E9d,
      error = 8.205117433661646E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 5102696.524725275d,
      error = 43343.93759496529d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 1.6790589227586207E8d,
      error = 1358860.6883380164d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 4379597.216666667d,
      error = 89491.00946828381d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 6217245.360881543d,
      error = 44535.81943358398d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 1.7736471546666667E9d,
      error = 2.561480178157459E10d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 4.8463136027272725E8d,
      error = 4.00407036549756E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 9.137812931666666E8d,
      error = 1.3924503471960368E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 6.70372941375E8d,
      error = 1.0554090967804063E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 2578255.065913371d,
      error = 22379.28272630245d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 7.218555565625E7d,
      error = 400604.58782406995d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 2.0385103654166666E8d,
      error = 4250215.138308588d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 4.7352422627272725E8d,
      error = 1.095151906921552E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 1130929.573556797d,
      error = 21302.032526951083d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 1081476.9318181819d,
      error = 17264.286954536292d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 1148399.877852349d,
      error = 18835.226252638327d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 2.0881665283333334E8d,
      error = 1246905.626402842d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 9870088.152173912d,
      error = 276120.9436166398d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 1.0982468786821706E7d,
      error = 286509.8071283139d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 3.050462E7d,
      error = 1465752.87151469d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 3.5602570596491225E7d,
      error = 893027.2076905485d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 198442.7895716946d,
      error = 3393.480211199365d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 355428.6469465649d,
      error = 4645.137022418985d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 6244753.041899442d,
      error = 323101.2026474437d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 1.8414295856666667E9d,
      error = 9.451530606813552E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 8013365.885294118d,
      error = 15825.95689344856d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 6.2350888216216214E7d,
      error = 812608.9647904387d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p1" -> BenchmarkTiming(
      mean = 7.189720878333333E9d,
      error = 4.8836520359330195E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p2" -> BenchmarkTiming(
      mean = 9.721992656E9d,
      error = 1.9880940483727577E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 384479.4129554656d,
      error = 6247.232035695992d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 5393694.617737003d,
      error = 71131.23126035543d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 1.4164549163865546E7d,
      error = 153221.13492315463d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 2.587123454E9d,
      error = 8.050009966241887E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 5783966.392638037d,
      error = 43757.39571176356d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 1.1452132477732794E7d,
      error = 561890.9730027831d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 1165224.6176470588d,
      error = 8823.608237957194d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 1.0460636778E9d,
      error = 5.133142304340982E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 9348921.278350515d,
      error = 170342.11669137195d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platjvm", v) }
}