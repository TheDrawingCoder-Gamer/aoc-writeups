import java.util.concurrent.TimeUnit

object JVMBenches {
  val benchmarks = Map(    
    "day1y2020p1" -> BenchmarkTiming(
      mean = 5921147.5d,
      error = 286548.30657006014d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2020p2" -> BenchmarkTiming(
      mean = 1.348312251E8d,
      error = 976538.5790333701d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p1" -> BenchmarkTiming(
      mean = 3186147.0d,
      error = 1101704.802012999d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2020p2" -> BenchmarkTiming(
      mean = 2321350.8d,
      error = 886458.2977464832d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p1" -> BenchmarkTiming(
      mean = 429052.7d,
      error = 146484.77712132316d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2020p2" -> BenchmarkTiming(
      mean = 658021.6d,
      error = 277633.2876282771d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p1" -> BenchmarkTiming(
      mean = 4140296.0d,
      error = 2057670.3797123826d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2020p2" -> BenchmarkTiming(
      mean = 4921389.4d,
      error = 2063114.7427952886d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p1" -> BenchmarkTiming(
      mean = 422054.9d,
      error = 27124.352758444486d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2020p2" -> BenchmarkTiming(
      mean = 2487121.2d,
      error = 467552.32085383293d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p1" -> BenchmarkTiming(
      mean = 4348468.9d,
      error = 902613.1436048829d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2020p2" -> BenchmarkTiming(
      mean = 3982806.6d,
      error = 747663.65260071d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p1" -> BenchmarkTiming(
      mean = 6901885.5d,
      error = 3447433.4232461317d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2020p2" -> BenchmarkTiming(
      mean = 7377895.8d,
      error = 1648574.412551494d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p1" -> BenchmarkTiming(
      mean = 1992720.3d,
      error = 860961.714399833d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2020p2" -> BenchmarkTiming(
      mean = 2760097.3d,
      error = 1375138.0160234994d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p1" -> BenchmarkTiming(
      mean = 4173710.6d,
      error = 1232696.3908951362d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2020p2" -> BenchmarkTiming(
      mean = 4795944.0d,
      error = 1454607.7829552055d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2020p1" -> BenchmarkTiming(
      mean = 384405.0d,
      error = 2406280.8549301033d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p1" -> BenchmarkTiming(
      mean = 1418283.7d,
      error = 850170.7435401668d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2021p2" -> BenchmarkTiming(
      mean = 1656456.0d,
      error = 570348.2262415327d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p1" -> BenchmarkTiming(
      mean = 2874907.9d,
      error = 1189406.1063123946d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2021p2" -> BenchmarkTiming(
      mean = 3524556.5d,
      error = 1360159.368345219d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p1" -> BenchmarkTiming(
      mean = 604617.5d,
      error = 337345.71097959887d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2021p2" -> BenchmarkTiming(
      mean = 890572.8d,
      error = 430779.58843504085d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p1" -> BenchmarkTiming(
      mean = 4730049.3d,
      error = 1617472.9967612885d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2021p2" -> BenchmarkTiming(
      mean = 1.73342614E7d,
      error = 3678650.190805758d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p1" -> BenchmarkTiming(
      mean = 3.09963121E7d,
      error = 7059884.705144209d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2021p2" -> BenchmarkTiming(
      mean = 5.88590132E7d,
      error = 1.3949219476617724E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p1" -> BenchmarkTiming(
      mean = 3.0931516E7d,
      error = 6733994.357639759d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2021p2" -> BenchmarkTiming(
      mean = 1162685.8d,
      error = 420713.42613221856d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p1" -> BenchmarkTiming(
      mean = 1108492.7d,
      error = 287591.84922783927d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2021p2" -> BenchmarkTiming(
      mean = 1148383.8d,
      error = 77182.05953392058d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p1" -> BenchmarkTiming(
      mean = 2.0241996965333332E10d,
      error = 9.212804645851059E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2021p2" -> BenchmarkTiming(
      mean = 1.9777908326333332E10d,
      error = 4.6164037619847625E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p1" -> BenchmarkTiming(
      mean = 2.1895558666666668E7d,
      error = 4.579755073655011E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2021p2" -> BenchmarkTiming(
      mean = 9.14488204E8d,
      error = 4.6523178954157636E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p1" -> BenchmarkTiming(
      mean = 2480455.0d,
      error = 1561152.9894696467d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2021p2" -> BenchmarkTiming(
      mean = 5.255275014666667E9d,
      error = 4.466475434741233E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p1" -> BenchmarkTiming(
      mean = 893682.5d,
      error = 544224.0624661421d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2022p2" -> BenchmarkTiming(
      mean = 989707.6d,
      error = 319164.10715794633d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p1" -> BenchmarkTiming(
      mean = 1637132.8d,
      error = 1164322.725544303d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2022p2" -> BenchmarkTiming(
      mean = 1405913.0d,
      error = 755564.0881407518d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p1" -> BenchmarkTiming(
      mean = 1179447.8d,
      error = 364907.0597820566d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2022p2" -> BenchmarkTiming(
      mean = 4067008.8d,
      error = 1971020.368472699d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p1" -> BenchmarkTiming(
      mean = 1.36609817E7d,
      error = 3571862.342070498d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2022p2" -> BenchmarkTiming(
      mean = 1.39161351E7d,
      error = 3668998.2402139907d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p1" -> BenchmarkTiming(
      mean = 3149293.4d,
      error = 1087822.439476782d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2022p2" -> BenchmarkTiming(
      mean = 3363584.5d,
      error = 820787.7331042746d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p1" -> BenchmarkTiming(
      mean = 3731034.0d,
      error = 1927547.554301963d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2022p2" -> BenchmarkTiming(
      mean = 5285436.9d,
      error = 746937.79048484d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p1" -> BenchmarkTiming(
      mean = 3990139.9d,
      error = 1921655.902390335d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2022p2" -> BenchmarkTiming(
      mean = 3974081.5d,
      error = 1703601.9621422773d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p1" -> BenchmarkTiming(
      mean = 7.343290976666666E8d,
      error = 1.0972521139903696E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2022p2" -> BenchmarkTiming(
      mean = 8.032756123333334E8d,
      error = 3.776566039684766E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p1" -> BenchmarkTiming(
      mean = 1.37092042E7d,
      error = 3505921.7440075143d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2022p2" -> BenchmarkTiming(
      mean = 2.07972543E7d,
      error = 6837199.316437494d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p1" -> BenchmarkTiming(
      mean = 2066329.2d,
      error = 432601.7592755202d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2022p2" -> BenchmarkTiming(
      mean = 3053550.8d,
      error = 593508.8193935073d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p1" -> BenchmarkTiming(
      mean = 1575135.8d,
      error = 766111.6135333532d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2022p2" -> BenchmarkTiming(
      mean = 2.00553657E7d,
      error = 1684450.5414399137d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p1" -> BenchmarkTiming(
      mean = 1.53256333E7d,
      error = 2034671.9352414594d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2022p2" -> BenchmarkTiming(
      mean = 2.1376187906666667E9d,
      error = 6.395642412087973E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p1" -> BenchmarkTiming(
      mean = 2909346.6d,
      error = 1192410.7530218665d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2022p2" -> BenchmarkTiming(
      mean = 3736665.3d,
      error = 905411.2492578992d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p1" -> BenchmarkTiming(
      mean = 1.57774891E7d,
      error = 1212026.5792590869d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2022p2" -> BenchmarkTiming(
      mean = 4.593364211E9d,
      error = 8.04122798592159E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2022p1" -> BenchmarkTiming(
      mean = 1493405.6d,
      error = 421194.6299282223d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day15y2022p2" -> BenchmarkTiming(
      mean = 2.5890080586666665E9d,
      error = 1.222569457244056E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p1" -> BenchmarkTiming(
      mean = 1.50678916E8d,
      error = 9.303546307879743E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2022p2" -> BenchmarkTiming(
      mean = 4.894791467666667E9d,
      error = 2.144550015066199E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2022p1" -> BenchmarkTiming(
      mean = 6187422.2d,
      error = 3146496.6313424823d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p1" -> BenchmarkTiming(
      mean = 3.51587418E7d,
      error = 2866607.6900608684d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2022p2" -> BenchmarkTiming(
      mean = 4.678632603333333E8d,
      error = 1.4758873833582547E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p1" -> BenchmarkTiming(
      mean = 3148554.6d,
      error = 1196035.6140067633d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2022p2" -> BenchmarkTiming(
      mean = 2906702.8d,
      error = 719335.3654891576d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p1" -> BenchmarkTiming(
      mean = 3.05518728E7d,
      error = 1568243.3602119514d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2022p2" -> BenchmarkTiming(
      mean = 1.08732571E7d,
      error = 5548686.3123154165d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p1" -> BenchmarkTiming(
      mean = 2.02327966E7d,
      error = 4779060.0026498325d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2022p2" -> BenchmarkTiming(
      mean = 2.9626749505666668E10d,
      error = 1.6124225002153022E9d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p1" -> BenchmarkTiming(
      mean = 1.2561649153333333E9d,
      error = 5.8885548821823224E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2022p2" -> BenchmarkTiming(
      mean = 3.924945593E9d,
      error = 1.5807983348607937E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2022p1" -> BenchmarkTiming(
      mean = 278374.4d,
      error = 149456.70622157806d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p1" -> BenchmarkTiming(
      mean = 712807.7d,
      error = 112165.20043317915d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2023p2" -> BenchmarkTiming(
      mean = 2743553.6d,
      error = 742692.9705882664d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p1" -> BenchmarkTiming(
      mean = 4016450.4d,
      error = 1072495.3123395056d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2023p2" -> BenchmarkTiming(
      mean = 3516560.6d,
      error = 1260031.1471045038d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p1" -> BenchmarkTiming(
      mean = 4191285.2d,
      error = 986688.3148140707d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2023p2" -> BenchmarkTiming(
      mean = 3722376.5d,
      error = 869793.3054994968d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p1" -> BenchmarkTiming(
      mean = 4909671.9d,
      error = 2045820.8986390973d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2023p2" -> BenchmarkTiming(
      mean = 6420797.2d,
      error = 4300186.566868476d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p1" -> BenchmarkTiming(
      mean = 3287812.4d,
      error = 1224466.4374206697d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day1y2024p2" -> BenchmarkTiming(
      mean = 3313565.6d,
      error = 758400.0118319916d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p1" -> BenchmarkTiming(
      mean = 2317086.6d,
      error = 1002595.2621314748d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day2y2024p2" -> BenchmarkTiming(
      mean = 3210189.0d,
      error = 1147169.5650657583d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p1" -> BenchmarkTiming(
      mean = 1184553.0d,
      error = 486315.01869277307d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day3y2024p2" -> BenchmarkTiming(
      mean = 1738468.1d,
      error = 498087.1614431619d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p1" -> BenchmarkTiming(
      mean = 6701034.6d,
      error = 1809616.622874068d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day4y2024p2" -> BenchmarkTiming(
      mean = 1715734.5d,
      error = 961224.8103251364d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p1" -> BenchmarkTiming(
      mean = 1.18547469E7d,
      error = 2507201.988667348d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day5y2024p2" -> BenchmarkTiming(
      mean = 4.0435508E8d,
      error = 1.2956673443993062E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p1" -> BenchmarkTiming(
      mean = 2531176.3d,
      error = 999296.2031533084d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day6y2024p2" -> BenchmarkTiming(
      mean = 1.278262529E9d,
      error = 1.3653040038487884E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p1" -> BenchmarkTiming(
      mean = 5532624.6d,
      error = 2677780.6611325024d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day7y2024p2" -> BenchmarkTiming(
      mean = 1.71613551E8d,
      error = 616724.1059194645d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p1" -> BenchmarkTiming(
      mean = 6063094.4d,
      error = 1475415.3258606207d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day8y2024p2" -> BenchmarkTiming(
      mean = 6243860.3d,
      error = 1544498.0973808088d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p1" -> BenchmarkTiming(
      mean = 1.6142512576666667E9d,
      error = 2.2623206176808575E10d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day9y2024p2" -> BenchmarkTiming(
      mean = 7.824324653333334E8d,
      error = 1.0273579715511388E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p1" -> BenchmarkTiming(
      mean = 5.942068673333334E8d,
      error = 6120076.353214295d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day10y2024p2" -> BenchmarkTiming(
      mean = 5.434063636666666E8d,
      error = 4.895043079722742E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p1" -> BenchmarkTiming(
      mean = 4817191.7d,
      error = 1811015.9291649754d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day11y2024p2" -> BenchmarkTiming(
      mean = 7.7946086E7d,
      error = 3853552.958605921d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p1" -> BenchmarkTiming(
      mean = 2.2689041066666666E8d,
      error = 1.5604804909931543E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day12y2024p2" -> BenchmarkTiming(
      mean = 4.785744286666667E8d,
      error = 1.8715905022785595E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p1" -> BenchmarkTiming(
      mean = 3530279.0d,
      error = 7560502.049468628d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day13y2024p2" -> BenchmarkTiming(
      mean = 4168966.0d,
      error = 1.2299018022775123E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p1" -> BenchmarkTiming(
      mean = 2533225.4d,
      error = 494238.23123786185d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day14y2024p2" -> BenchmarkTiming(
      mean = 2.0230582333333334E8d,
      error = 1.8072266871507356E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p1" -> BenchmarkTiming(
      mean = 1.31569538E7d,
      error = 2274826.6031079213d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day15y2024p2" -> BenchmarkTiming(
      mean = 9129674.6d,
      error = 1874694.5918515138d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p1" -> BenchmarkTiming(
      mean = 3.44788282E7d,
      error = 2007383.1788907126d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day16y2024p2" -> BenchmarkTiming(
      mean = 2.81865485E7d,
      error = 3338886.9865901144d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day17y2024p1" -> BenchmarkTiming(
      mean = 517226.84d,
      error = 63820.02368340849d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day17y2024p2" -> BenchmarkTiming(
      mean = 938317.52d,
      error = 330801.9903008584d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MICROSECONDS)
    ),    
    "day18y2024p1" -> BenchmarkTiming(
      mean = 9654159.8d,
      error = 2874214.6281562736d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day18y2024p2" -> BenchmarkTiming(
      mean = 2.8208969793333335E9d,
      error = 1.036341650296269E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p1" -> BenchmarkTiming(
      mean = 7611983.1d,
      error = 108264.21985765864d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day19y2024p2" -> BenchmarkTiming(
      mean = 5.73529842E7d,
      error = 5740706.54580943d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p1" -> BenchmarkTiming(
      mean = 1.403597566E9d,
      error = 1.6902760566201773E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day20y2024p2" -> BenchmarkTiming(
      mean = 2.5468058316666665E9d,
      error = 4.232194767212303E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p1" -> BenchmarkTiming(
      mean = 2695834.7d,
      error = 951498.4847456948d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day21y2024p2" -> BenchmarkTiming(
      mean = 8599949.5d,
      error = 4826228.066657949d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p1" -> BenchmarkTiming(
      mean = 1.41484767E7d,
      error = 2153571.0253938474d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day22y2024p2" -> BenchmarkTiming(
      mean = 2.8813541813333335E9d,
      error = 8.075915000370537E8d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p1" -> BenchmarkTiming(
      mean = 5767103.3d,
      error = 1664164.9718871722d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day23y2024p2" -> BenchmarkTiming(
      mean = 1.07531503E7d,
      error = 3537843.4635044187d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p1" -> BenchmarkTiming(
      mean = 3155966.3d,
      error = 1351457.6541592476d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day24y2024p2" -> BenchmarkTiming(
      mean = 9.4714128E8d,
      error = 7.521066497942841E7d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),    
    "day25y2024p1" -> BenchmarkTiming(
      mean = 8567486.6d,
      error = 2377071.1022817823d,
      unit = Some(TimeUnit.NANOSECONDS),
      convertTo = Some(TimeUnit.MILLISECONDS)
    ),
  ).map { case (k, v) => (k + "platjvm", v) }
}