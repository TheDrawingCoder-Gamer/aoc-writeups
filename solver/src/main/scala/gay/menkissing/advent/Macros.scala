package gay.menkissing.advent

import scala.quoted.*

object Macros:

  def paddedDay(day: Int): String =
    if (day < 10) s"0$day" else day.toString

  def solutionMapCode(ls: Expr[Seq[Int]], year: Expr[Int])(using Quotes): Expr[Map[String, HalfDay[?, ?]]] =
    import quotes.reflect
    import quotes.reflect.given
    val yearName = year.valueOrAbort.toString
    val daDays = ls match
      case Varargs(dayExprs) =>
        dayExprs.map: it =>
          val v = it.valueOrAbort
          ("Day" + paddedDay(v), "day" + v.toString)
    val daDayExprs: Seq[Expr[HalfDay[?, ?]]] = daDays.map(it => quotes.reflect.Ident(quotes.reflect.Symbol.requiredModule("gay.menkissing.advent.y" + yearName + "." + it._1).termRef).asExprOf[HalfDay[?, ?]])
    val daList =
      Expr.ofSeq[(String, HalfDay[?, ?])] {
        daDays.zip(daDayExprs).map: (k, v) =>
          val y = Expr(k._2)
          '{ $y -> $v }
      }
    '{ ${daList}.toMap }




  inline def solutionMap(inline year: Int, inline days: Int*): Map[String, HalfDay[?, ?]] =
    ${ solutionMapCode('days, 'year) }
