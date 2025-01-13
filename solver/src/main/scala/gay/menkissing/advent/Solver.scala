package gay.menkissing.advent

import org.scalajs.dom.{document, DocumentReadyState}
import com.raquo.laminar.api.L.*
import scala.util.{Try, Failure, Success}
import scala.scalajs.js.annotation.JSExportTopLevel

object Solver:

  def runSolutionP1[A, B](x: HalfDay[A, B])(str: String): String = x.part1(x.parse(str)).toString
  def runSolutionP2[A, B](x: WithPart2[A, B] & WithParser[A])(str: String): String = x.part2(x.parse(str)).toString

  private val solutions2020: Map[String, HalfDay[?, ?]] =
    Map(
      "day1" -> y2020.Day01y2020,
      "day2" -> y2020.Day02y2020,
      "day3" -> y2020.Day03y2020,
      "day4" -> y2020.Day04y2020,
      "day5" -> y2020.Day05y2020,
      "day6" -> y2020.Day06y2020,
      "day7" -> y2020.Day07y2020,
      "day8" -> y2020.Day08y2020,
      "day9" -> y2020.Day09y2020,
      "day10" -> y2020.Day10y2020
    )
  private val solutions2021: Map[String, HalfDay[?, ?]] =
    Map(
      "day1"  -> y2021.Day01y2021,
      "day2"  -> y2021.Day02y2021,
      "day3"  -> y2021.Day03y2021,
      "day4"  -> y2021.Day04y2021,
      "day5"  -> y2021.Day05y2021,
      "day6"  -> y2021.Day6y2021,
      "day7"  -> y2021.Day07y2021,
      "day8"  -> y2021.Day08y2021,
      "day9"  -> y2021.Day09y2021,
      "day10" -> y2021.Day10y2021,
      "day11" -> y2021.Day11y2021,
      "day12" -> y2021.Day12y2021,
      "day19" -> y2021.Day19y2021,
      "day20" -> y2021.Day20y2021,
      "day21" -> y2021.Day21y2021
    )
  private val solutions2022: Map[String, HalfDay[?, ?]] =
    Map(
      "day1" -> y2022.Day01y2022,
      "day2" -> y2022.Day02y2022,
      "day3" -> y2022.Day03y2022,
      "day4" -> y2022.Day04y2022,
      "day5" -> y2022.Day05y2022,
      "day6" -> y2022.Day06y2022,
      "day7" -> y2022.Day07y2022,
      "day8" -> y2022.Day08y2022,
      "day9" -> y2022.Day09y2022,
      "day10" -> y2022.Day10y2022,
      "day11" -> y2022.Day11y2022,
      "day12" -> y2022.Day12y2022,
      "day13" -> y2022.Day13y2022,
      "day14" -> y2022.Day14y2022,
      "day15" -> y2022.Day15y2022,
      "day16" -> y2022.Day16y2022,
      "day18" -> y2022.Day18y2022,
      "day20" -> y2022.Day20y2022,
      "day21" -> y2022.Day21y2022,
      "day22" -> y2022.Day22y2022,
      "day23" -> y2022.Day23y2022,
      "day24" -> y2022.Day24y2022,
      "day25" -> y2022.Day25y2022
    )
  private val solutions2023: Map[String, HalfDay[?, ?]] =
    Map(
      "day1" -> y2023.Day01y2023,
      "day2" -> y2023.Day02y2023,
      "day3" -> y2023.Day03y2023,
      "day4" -> y2023.Day04y2023
    )
  private val solutions2024: Map[String, HalfDay[?, ?]] =
    Map(
      "day1" -> Day1,
      "day2" -> Day2,
      "day3" -> Day3,
      "day4" -> Day4,
      "day5" -> Day5,
      "day6" -> Day6,
      "day7" -> Day7,
      "day8" -> Day8,
      "day9" -> Day9,
      "day10" -> Day10,
      "day11" -> Day11,
      "day12" -> Day12,
      "day13" -> Day13,
      "day14" -> Day14,
      "day15" -> Day15,
      "day16" -> Day16,
      "day17" -> Day17,
      "day18" -> Day18,
      "day19" -> Day19,
      "day20" -> Day20,
      "day21" -> Day21,
      "day22" -> Day22,
      "day23" -> Day23,
      "day24" -> Day24,
      "day25" -> Day25
    )

  private val solutions: Map[String, Map[String, HalfDay[?, ?]]] =
    Map(
      "2020" -> solutions2020,
      "2021" -> solutions2021,
      "2022" -> solutions2022,
      "2023" -> solutions2023,
      "2024" -> solutions2024
    )
  def paddedDay(day: Int): String =
    if (day < 10) s"0$day" else day.toString

  def getSolutionFunc(year: String, puzzleId: String, part2: Boolean): Option[String => String] =
    for
      solutionOfYear <- solutions.get(year)
      solution <- solutionOfYear.get(puzzleId)
      solutionFunc <-
        if !part2 then
          Some(runSolutionP1(solution))
        else
          solution match
            case s: ProblemAdv[?, ?, ?] => Some(runSolutionP2(s))
            case _ => None
    yield solutionFunc

  private def doSolve(puzzleId: String, year: String, part2: Boolean): Unit =
    for 
      solutionFunc <- getSolutionFunc(year, puzzleId, part2)
      div <- Option(document.getElementById(puzzleId + (if part2 then "p2" else "p1")))
    do
      render(div,
        solverElementSide(if part2 then 2 else 1, solutionFunc))
  
  @JSExportTopLevel("default")
  def solver(day: Int, year: String, part2: Boolean): Unit =
    doSolve(s"day$day", year, part2)
  

  private def solverElementSide(part: Int, solution: String => String): Element =
    val input = Var("")
    val answer = EventBus[Try[Any]]()
    div(
      h3(s"Part $part"),
      textArea(
        onChange.mapToValue --> input,
        width := "100%",
        placeholder := "Paste your input here",
        rows := 6
      ),
      p(
        button(
          "Run Solution",
          onClick.mapTo(Try(solution(input.now()))) --> answer.writer
        )
      ),
      child <-- answer.events.map {
        case Failure(e) => failureResponse(e)
        case Success(answer) => answerResponse(answer)
      }
    )

  private def failureResponse(e: Throwable): Element =
    p(
      "Execution failed: ",
      p(
        color := "red",
        s"\t${e.getClass.getName}: ${e.getMessage}"
      )
    )

  private def answerResponse(answer: Any): Element =
    p(
      s"Answer is: ",
      pre(
        code(
          answer.toString.linesIterator.toSeq.map(l => span(l, br()))
        )
      )
    )