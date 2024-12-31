package gay.menkissing.advent

import org.scalajs.dom.{document, DocumentReadyState}
import com.raquo.laminar.api.L.*
import scala.util.{Try, Failure, Success}
import scala.scalajs.js.annotation.JSExportTopLevel

object Solver:
  extension[A, B, C] (self: ProblemAdv[A, B, C])
    def generic: ProblemAdv[Any, Any, Any] = self.asInstanceOf[ProblemAdv[Any, Any, Any]]

  private val solutions2020: Map[String, ProblemAdv[Any, Any, Any]] =
    Map(
      "day1" -> y2020.Day01y2020.generic,
      "day2" -> y2020.Day02y2020.generic,
      "day3" -> y2020.Day03y2020.generic,
      "day4" -> y2020.Day04y2020.generic,
      "day5" -> y2020.Day05y2020.generic,
      "day6" -> y2020.Day06y2020.generic,
      "day7" -> y2020.Day07y2020.generic
    )
  private val solutions2021: Map[String, ProblemAdv[Any, Any, Any]] =
    Map(
      "day1"  -> y2021.Day01y2021.generic,
      "day6"  -> y2021.Day6y2021.generic,
      "day19" -> y2021.Day19y2021.generic,
      "day20" -> y2021.Day20y2021.generic,
      "day21" -> y2021.Day21y2021.generic
    )
  private val solutions2022: Map[String, ProblemAdv[Any, Any, Any]] =
    Map(
      "day1" -> y2022.Day01y2022.generic,
      "day2" -> y2022.Day02y2022.generic,
      "day3" -> y2022.Day03y2022.generic,
      "day4" -> y2022.Day04y2022.generic,
      "day5" -> y2022.Day05y2022.generic,
      "day6" -> y2022.Day06y2022.generic
    )
  private val solutions2024: Map[String, ProblemAdv[Any, Any, Any]] =
    Map[String, ProblemAdv[Any, Any, Any]](
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
      "day14" -> Day14.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day15" -> Day15.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day16" -> Day16.generic,
      "day17" -> Day17.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day18" -> Day18.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day19" -> Day19.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day20" -> Day20.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day21" -> Day21.generic,
      "day22" -> Day22.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day23" -> Day23.asInstanceOf[ProblemAdv[Any, Any, Any]],
      "day24" -> Day24.generic,
      "day25" -> Day25.asInstanceOf[ProblemAdv[Any, Any, Any]]
    )

  private val solutions: Map[String, Map[String, ProblemAdv[Any, Any, Any]]] =
    Map(
      "2020" -> solutions2020,
      "2021" -> solutions2021,
      "2022" -> solutions2022,
      "2024" -> solutions2024
    )
  def paddedDay(day: Int): String =
    if (day < 10) s"0$day" else day.toString
  private def doSolve(puzzleId: String, year: String, part2: Boolean): Unit =
    for 
      solutionOfYear <- solutions.get(year)
      solution <- solutionOfYear.get(puzzleId)
      div <- Option(document.getElementById(puzzleId + (if part2 then "p2" else "p1")))
    do
      render(div,
        solverElementSide(it =>
          if !part2 then
            solution.part1(solution.parse(it))
          else
            solution.part2(solution.parse(it))
      ))
  
  @JSExportTopLevel("default")
  def solver(day: Int, year: String, part2: Boolean): Unit =
    doSolve(s"day$day", year, part2)
  
  private def solverElement(solution: ProblemAdv[Any, Any, Any]): Element = {
    div(
      solverElementSide(it => solution.part1(solution.parse(it))),
      solverElementSide(it => solution.part2(solution.parse(it)))
    )
  }
  private def solverElementSide(solution: String => Any): Element =
    val input = Var("")
    val answer = EventBus[Try[Any]]()
    div(
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
          className := "codeBlockLines_node_modules-@docusaurus-theme-classic-lib-next-theme-CodeBlock-styles-module",
          answer.toString.linesIterator.toSeq.map(l => span(l, br()))
        )
      )
    )