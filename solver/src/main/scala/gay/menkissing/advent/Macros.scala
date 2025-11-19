package gay.menkissing.advent

import scala.quoted.*
import cats.Eval

object Macros:
  // Lazily evaluate the solutions so we arent loading the entire
  // goddamn solution infrastructure on each page
  type SolutionMap = Map[String, Eval[WithPart1 & ParseP1]]

  def paddedDay(day: Int): String =
    if (day < 10) s"0$day" else day.toString

  def solutionMapCode(ls: Expr[Seq[Int]], year: Expr[Int])(using Quotes): Expr[SolutionMap] =
    import quotes.reflect
    import quotes.reflect.given
    val yearName = year.valueOrAbort.toString
    val daDays = ls match
      case Varargs(dayExprs) =>
        dayExprs.map: it =>
          val v = it.valueOrAbort
          ("Day" + paddedDay(v), "day" + v.toString)
    val daDayExprs: Seq[Expr[Eval[WithPart1 & ParseP1]]] = 
      daDays.map: it =>
        val term = reflect.Ident(reflect.Symbol.requiredModule("gay.menkissing.advent.y" + yearName + "." + it._1).termRef).asExprOf[WithPart1 & ParseP1]
        '{ Eval.later($term) }
    val daList =
      Expr.ofSeq[(String, Eval[WithPart1 & ParseP1])] {
        daDays.zip(daDayExprs).map: (k, v) =>
          val y = Expr(k._2)
          '{ $y -> $v }
      }
    '{ ${daList}.toMap }




  inline def solutionMap(inline year: Int, inline days: Int*): SolutionMap =
    ${ solutionMapCode('days, 'year) }
