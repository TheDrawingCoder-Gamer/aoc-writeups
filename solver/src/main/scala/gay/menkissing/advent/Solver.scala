package gay.menkissing.advent

import org.scalajs.dom.{DocumentReadyState, document}
import com.raquo.laminar.api.L.{quotes => _, *}

import Macros.solutionMap
import scala.util.{Failure, Success, Try}
import scala.scalajs.js.annotation.JSExportTopLevel

object Solver:

  def runSolutionP1[A, B](x: HalfDay[A, B])(str: String): String = x.part1(x.parse(str)).toString
  def runSolutionP2[A, B](x: WithPart2[A, B] & WithParser[A])(str: String): String = x.part2(x.parse(str)).toString



  private val solutions2020: Map[String, HalfDay[?, ?]] =
    solutionMap(2020,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      18,
      19
    )
  private val solutions2021: Map[String, HalfDay[?, ?]] =
    solutionMap(2021,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      19,
      20,
      21
    )
  private val solutions2022: Map[String, HalfDay[?, ?]] =
    solutionMap(2022,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      18,
      20,
      21,
      22,
      23,
      24,
      25
    )
  private val solutions2023: Map[String, HalfDay[?, ?]] =
    solutionMap(2023,
      1,
      2,
      3,
      4
    )
  private val solutions2024: Map[String, HalfDay[?, ?]] =
    solutionMap(2024,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25
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