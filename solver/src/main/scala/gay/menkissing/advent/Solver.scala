package gay.menkissing.advent

import org.scalajs.dom.{document, DocumentReadyState}
import com.raquo.laminar.api.L.*
import scala.util.{Try, Failure, Success}
import scala.scalajs.js.annotation.JSExportTopLevel

object Solver:
  extension[A, B, C] (self: HalfDay[A, B])
    def generic: HalfDay[Any, Any] = self.asInstanceOf[HalfDay[Any, Any]]

  private val solutions2020: Map[String, HalfDay[Any, Any]] =
    Map(
      "day1" -> y2020.Day01y2020.generic,
      "day2" -> y2020.Day02y2020.generic,
      "day3" -> y2020.Day03y2020.generic,
      "day4" -> y2020.Day04y2020.generic,
      "day5" -> y2020.Day05y2020.generic,
      "day6" -> y2020.Day06y2020.generic,
      "day7" -> y2020.Day07y2020.generic,
      "day8" -> y2020.Day08y2020.generic,
      "day9" -> y2020.Day09y2020.generic,
      "day10" -> y2020.Day10y2020.generic
    )
  private val solutions2021: Map[String, HalfDay[Any, Any]] =
    Map(
      "day1"  -> y2021.Day01y2021.generic,
      "day2"  -> y2021.Day02y2021.generic,
      "day3"  -> y2021.Day03y2021.generic,
      "day5"  -> y2021.Day05y2021.generic,
      "day6"  -> y2021.Day6y2021.generic,
      "day7"  -> y2021.Day07y2021.generic,
      "day19" -> y2021.Day19y2021.generic,
      "day20" -> y2021.Day20y2021.generic,
      "day21" -> y2021.Day21y2021.generic
    )
  private val solutions2022: Map[String, HalfDay[Any, Any]] =
    Map(
      "day1" -> y2022.Day01y2022.generic,
      "day2" -> y2022.Day02y2022.generic,
      "day3" -> y2022.Day03y2022.generic,
      "day4" -> y2022.Day04y2022.generic,
      "day5" -> y2022.Day05y2022.generic,
      "day6" -> y2022.Day06y2022.generic,
      "day7" -> y2022.Day07y2022.generic,
      "day8" -> y2022.Day08y2022.generic,
      "day9" -> y2022.Day09y2022.generic,
      "day10" -> y2022.Day10y2022.generic,
      "day11" -> y2022.Day11y2022.generic,
      "day12" -> y2022.Day12y2022.generic,
      "day13" -> y2022.Day13y2022.generic,
      "day14" -> y2022.Day14y2022.generic,
      "day15" -> y2022.Day15y2022.generic,
      "day16" -> y2022.Day16y2022.generic,
      "day18" -> y2022.Day18y2022.generic,
      "day20" -> y2022.Day20y2022.generic,
      "day21" -> y2022.Day21y2022.generic,
      "day22" -> y2022.Day22y2022.generic,
      "day23" -> y2022.Day23y2022.generic,
      "day24" -> y2022.Day24y2022.generic,
      "day25" -> y2022.Day25y2022.generic
    )
  private val solutions2023: Map[String, HalfDay[Any, Any]] =
    Map(
      "day1" -> y2023.Day01y2023.generic,
      "day2" -> y2023.Day02y2023.generic,
      "day3" -> y2023.Day03y2023.generic,
      "day4" -> y2023.Day04y2023.generic
    )
  private val solutions2024: Map[String, HalfDay[Any, Any]] =
    Map(
      "day1" -> Day1.generic,
      "day2" -> Day2.generic,
      "day3" -> Day3.generic,
      "day4" -> Day4.generic,
      "day5" -> Day5.generic,
      "day6" -> Day6.generic,
      "day7" -> Day7.generic,
      "day8" -> Day8.generic,
      "day9" -> Day9.generic,
      "day10" -> Day10.generic,
      "day11" -> Day11.generic,
      "day12" -> Day12.generic,
      "day13" -> Day13.generic,
      "day14" -> Day14.generic,
      "day15" -> Day15.generic,
      "day16" -> Day16.generic,
      "day17" -> Day17.generic,
      "day18" -> Day18.generic,
      "day19" -> Day19.generic,
      "day20" -> Day20.generic,
      "day21" -> Day21.generic,
      "day22" -> Day22.generic,
      "day23" -> Day23.generic,
      "day24" -> Day24.generic,
      "day25" -> Day25.generic
    )

  private val solutions: Map[String, Map[String, HalfDay[Any, Any]]] =
    Map(
      "2020" -> solutions2020,
      "2021" -> solutions2021,
      "2022" -> solutions2022,
      "2023" -> solutions2023,
      "2024" -> solutions2024
    )
  def paddedDay(day: Int): String =
    if (day < 10) s"0$day" else day.toString

  def getSolutionFunc(year: String, puzzleId: String, part2: Boolean): Option[String => Any] =
    for
      solutionOfYear <- solutions.get(year)
      solution <- solutionOfYear.get(puzzleId)
      solutionFunc <-
        if !part2 then
          Some((it: String) => solution.part1(solution.parse(it)))
        else
          solution match
            case s: ProblemAdv[Any, Any, Any] => Some((it: String) => s.part2(s.parse(it)))
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
  

  private def solverElementSide(part: Int, solution: String => Any): Element =
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