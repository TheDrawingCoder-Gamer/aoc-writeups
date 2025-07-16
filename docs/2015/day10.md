{% aoc.day = 10 %}

# Day 10: Elves Look, Elves Say

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Iterate the sequence N times, and then get the end length

## Part 1

This is boilerplate, but we have to parse our input:

```scala 3 
def parse(s: String): String = s.trim
```

I trimmed here because when fetching the puzzle input via http, it had a newline.

Ok, now let's do some utility functions; The tool I normally reach for here is haskell's `grouped`,
but Scala doesn't have an analog, so I have to implement it myself:

```scala 3
def grouped(s: String): List[String] =
  @tailrec
  def go(v: String, acc: List[String]): List[String] =
    if v.isEmpty then
      acc
    else
      val x = v.head
      val xs = v.tail
      val (ys, zs) = xs.span(_ == x)
      go(zs, (ys :+ x) :: acc)

  go(s, List.empty).reverse
```

Now let's do the actual function. I've named it "RLE" to stand for Run Length Encoding (which is what I thought of
when first seeing this problem)

```scala 3
def rle(str: String): String =
  val chunks = grouped(str)
  chunks.map(it => it.length.toString + it.head.toString).mkString("")
```

Now let's do part 1:

```scala 3
def part1(input: String): Int =
  Iterator.iterate(input)(rle).drop(40).next().length
```

## Part 2

Ok. It takes way too long now. However, the text links a [funny little video](https://www.youtube.com/watch?v=ea7lJkEhytA)
about this sequence that kind of just tells you how to optimize it.

Basically, there are a few sequences that once formed, stop interacting with their neighbors. If you can split a sequence
into these "elements" then you can greatly optimize the iteration.

Writing these elements is kind of mind numbing though, so I'll just show you the code for it:

```scala 3
val elements = Map(
  "H" -> "22",
  "He" -> "13112221133211322112211213322112",
  "Li" -> "312211322212221121123222112",
  "Be" -> "111312211312113221133211322112211213322112",
  "B" -> "1321132122211322212221121123222112",
  "C" -> "3113112211322112211213322112",
  "N" -> "111312212221121123222112",
  "O" -> "132112211213322112",
  "F" -> "31121123222112",
  "Ne" -> "111213322112",
  "Na" -> "123222112",
  "Mg" -> "3113322112",
  "Al" -> "1113222112",
  "Si" -> "1322112",
  "P" -> "311311222112",
  "S" -> "1113122112",
  "Cl" -> "132112",
  "Ar" -> "3112",
  "K" -> "1112",
  "Ca" -> "12",
  "Sc" -> "3113112221133112",
  "Ti" -> "11131221131112",
  "V" -> "13211312",
  "Cr" -> "31132",
  "Mn" -> "111311222112",
  "Fe" -> "13122112",
  "Co" -> "32112",
  "Ni" -> "11133112",
  "Cu" -> "131112",
  "Zn" -> "312",
  "Ga" -> "13221133122211332",
  "Ge" -> "31131122211311122113222",
  "As" -> "11131221131211322113322112",
  "Se" -> "13211321222113222112",
  "Br" -> "3113112211322112",
  "Kr" -> "11131221222112",
  "Rb" -> "1321122112",
  "Sr" -> "3112112",
  "Y" -> "1112133",
  "Zr" -> "12322211331222113112211",
  "Nb" -> "1113122113322113111221131221",
  "Mo" -> "13211322211312113211",
  "Tc" -> "311322113212221",
  "Ru" -> "132211331222113112211",
  "Rh" -> "311311222113111221131221",
  "Pd" -> "111312211312113211",
  "Ag" -> "132113212221",
  "Cd" -> "3113112211",
  "In" -> "11131221",
  "Sn" -> "13211",
  "Sb" -> "3112221",
  "Te" -> "1322113312211",
  "I" -> "311311222113111221",
  "Xe" -> "11131221131211",
  "Cs" -> "13211321",
  "Ba" -> "311311",
  "La" -> "11131",
  "Ce" -> "1321133112",
  "Pr" -> "31131112",
  "Nd" -> "111312",
  "Pm" -> "132",
  "Sm" -> "311332",
  "Eu" -> "1113222",
  "Gd" -> "13221133112",
  "Tb" -> "3113112221131112",
  "Dy" -> "111312211312",
  "Ho" -> "1321132",
  "Er" -> "311311222",
  "Tm" -> "11131221133112",
  "Yb" -> "1321131112",
  "Lu" -> "311312",
  "Hf" -> "11132",
  "Ta" -> "13112221133211322112211213322113",
  "W" -> "312211322212221121123222113",
  "Re" -> "111312211312113221133211322112211213322113",
  "Os" -> "1321132122211322212221121123222113",
  "Ir" -> "3113112211322112211213322113",
  "Pt" -> "111312212221121123222113",
  "Au" -> "132112211213322113",
  "Hg" -> "31121123222113",
  "Tl" -> "111213322113",
  "Pb" -> "123222113",
  "Bi" -> "3113322113",
  "Po" -> "1113222113",
  "At" -> "1322113",
  "Rn" -> "311311222113",
  "Fr" -> "1113122113",
  "Ra" -> "132113",
  "Ac" -> "3113",
  "Th" -> "1113",
  "Pa" -> "13",
  "U" -> "3",
)
```

Each periodic table element (up to uranium) maps to a sequence. I copied this data (by hand) from the [Wikipedia](https://en.wikipedia.org/wiki/Look-and-say_sequence#Cosmological_decay).

We also need a way to chunk up a sequence into elements. What I did is keep around a sorted list and make a chunking function.

```scala 3
val sortedElements =
  elements.toList.map(_.swap).sortBy(_._1.length)(using Ordering[Int].reverse)

def tryAsElements(s: String): Option[List[String]] =
  val es = mutable.ListBuffer[String]()
  var curS = s

  while curS.nonEmpty do
    sortedElements.find(it => curS.startsWith(it._1)) match
      case Some((v, k)) =>
        curS = curS.drop(v.length)
        es.prepend(k)
      case None =>
        return None

  Some(es.reverse.toList)
```

My input was an element already so this isn't necessary for me and adds unneeded complexity, but it's always possible
that an input isn't an element (like in the sample case of `1`).

We also have to implement what each element becomes after each iteration.

```scala 3
val decaysTo = Map[String, List[String]](
  "H" -> List("H"),
  "He" -> List("Hf", "Pa", "H", "Ca", "Li"),
  "Li" -> List("He"),
  "Be" -> List("Ge", "Ca", "Li"),
  "B" -> List("Be"),
  "C" -> List("B"),
  "N" -> List("C"),
  "O" -> List("N"),
  "F" -> List("O"),
  "Ne" -> List("F"),
  "Na" -> List("Ne"),
  "Mg" -> List("Pm", "Na"),
  "Al" -> List("Mg"),
  "Si" -> List("Al"),
  "P" -> List("Ho", "Si"),
  "S" -> List("P"),
  "Cl" -> List("S"),
  "Ar" -> List("Cl"),
  "K" -> List("Ar"),
  "Ca" -> List("K"),
  "Sc" -> List("Ho", "Pa", "H", "Ca", "Co"),
  "Ti" -> List("Sc"),
  "V" -> List("Ti"),
  "Cr" -> List("V"),
  "Mn" -> List("Cr", "Si"),
  "Fe" -> List("Mn"),
  "Co" -> List("Fe"),
  "Ni" -> List("Zn", "Co"),
  "Cu" -> List("Ni"),
  "Zn" -> List("Cu"),
  "Ga" -> List("Eu", "Ca", "Ac", "H", "Ca", "Zn"),
  "Ge" -> List("Ho", "Ga"),
  "As" -> List("Ge", "Na"),
  "Se" -> List("As"),
  "Br" -> List("Se"),
  "Kr" -> List("Br"),
  "Rb" -> List("Kr"),
  "Sr" -> List("Rb"),
  "Y" -> List("Sr", "U"),
  "Zr" -> List("Y", "H", "Ca", "Tc"),
  "Nb" -> List("Er", "Zr"),
  "Mo" -> List("Nb"),
  "Tc" -> List("Mo"),
  "Ru" -> List("Eu", "Ca", "Tc"),
  "Rh" -> List("Ho", "Ru"),
  "Pd" -> List("Rh"),
  "Ag" -> List("Pd"),
  "Cd" -> List("Ag"),
  "In" -> List("Cd"),
  "Sn" -> List("In"),
  "Sb" -> List("Pm", "Sn"),
  "Te" -> List("Eu", "Ca", "Sb"),
  "I" -> List("Ho", "Te"),
  "Xe" -> List("I"),
  "Cs" -> List("Xe"),
  "Ba" -> List("Cs"),
  "La" -> List("Ba"),
  "Ce" -> List("La", "H", "Ca", "Co"),
  "Pr" -> List("Ce"),
  "Nd" -> List("Pr"),
  "Pm" -> List("Nd"),
  "Sm" -> List("Pm", "Ca", "Zn"),
  "Eu" -> List("Sm"),
  "Gd" -> List("Eu", "Ca", "Co"),
  "Tb" -> List("Ho", "Gd"),
  "Dy" -> List("Tb"),
  "Ho" -> List("Dy"),
  "Er" -> List("Ho", "Pm"),
  "Tm" -> List("Er", "Ca", "Co"),
  "Yb" -> List("Tm"),
  "Lu" -> List("Yb"),
  "Hf" -> List("Lu"),
  "Ta" -> List("Hf", "Pa", "H", "Ca", "W"),
  "W" -> List("Ta"),
  "Re" -> List("Ge", "Ca", "W"),
  "Os" -> List("Re"),
  "Ir" -> List("Os"),
  "Pt" -> List("Ir"),
  "Au" -> List("Pt"),
  "Hg" -> List("Au"),
  "Tl" -> List("Hg"),
  "Pb" -> List("Tl"),
  "Bi" -> List("Pm", "Pb"),
  "Po" -> List("Bi"),
  "At" -> List("Po"),
  "Rn" -> List("Ho", "At"),
  "Fr" -> List("Rn"),
  "Ra" -> List("Fr"),
  "Ac" -> List("Ra"),
  "Th" -> List("Ac"),
  "Pa" -> List("Th"),
  "U" -> List("Pa")
)
```

Again, copied BY HAND from Wikipedia. If you're smart you could probably copy the table from the Wikipedia source and
make a parser that generates these lists automatically, and I probably would recommend doing that. I underestimated how
long 92 elements would take.

Now let's actually implement this. We have to start with our original method to get a sequence of all elements,
but from that point we can optimize.

```scala 3
def lookandsay(str: String, limit: Int): Int =
  var i = 0
  var maybeElems = tryAsElements(str)

  var curS = str
  // iterate like before until we get a sequence decomposable into elements
  while maybeElems.isEmpty && i < limit do
    curS = rle(curS)
    maybeElems = tryAsElements(str)
    i += 1

  // if we ended up doing the full iteration, return the length
  if i >= limit then
    curS.length
  else
    val elems = maybeElems.get
    // elems.groupMapReduce(identity)(_ => 1)(_ + _) 
    // transforms our elems into an occurrence table
    //
    // If you've read my 2021 Day 6 writeup, the optimization used is very similar
    (i until limit).foldLeft(elems.groupMapReduce(identity)(_ => 1)(_ + _)): (elems, _) =>
      // I couldn't really find a nice way of doing this immutably, 
      // so I just decided to use a hashmap 
      val newElems = mutable.HashMap[String, Int]()
      // for each element in our current elems,
      elems.foreach: (k, v) =>
        // add the # of this element to all the elements it decays to
        decaysTo(k).foreach: kk =>
          newElems.updateWith(kk):
            case Some(vv) => Some(vv + v)
            case None => Some(v)
      newElems.toMap
    // then at the end, get the length of the actual element 
    // and multiply it by the number of times we see it.
    .map((k, v) => elements(k).length * v).sum
```

Then we can do part 2 with this:

```scala 3
def part2(input: String): Int =
  lookandsay(input, 50)
```

(I update part 1 as well in my source)

## Final Code

```scala 3
def parse(s: String): String = s.trim

def grouped(s: String): List[String] =
  @tailrec
  def go(v: String, acc: List[String]): List[String] =
    if v.isEmpty then
      acc
    else
      val x = v.head
      val xs = v.tail
      val (ys, zs) = xs.span(_ == x)
      go(zs, (ys :+ x) :: acc)

  go(s, List.empty).reverse

def rle(str: String): String =
  val chunks = grouped(str)
  chunks.map(it => it.length.toString + it.head.toString).mkString("")

val elements = Map(
  "H" -> "22",
  "He" -> "13112221133211322112211213322112",
  "Li" -> "312211322212221121123222112",
  "Be" -> "111312211312113221133211322112211213322112",
  "B" -> "1321132122211322212221121123222112",
  "C" -> "3113112211322112211213322112",
  "N" -> "111312212221121123222112",
  "O" -> "132112211213322112",
  "F" -> "31121123222112",
  "Ne" -> "111213322112",
  "Na" -> "123222112",
  "Mg" -> "3113322112",
  "Al" -> "1113222112",
  "Si" -> "1322112",
  "P" -> "311311222112",
  "S" -> "1113122112",
  "Cl" -> "132112",
  "Ar" -> "3112",
  "K" -> "1112",
  "Ca" -> "12",
  "Sc" -> "3113112221133112",
  "Ti" -> "11131221131112",
  "V" -> "13211312",
  "Cr" -> "31132",
  "Mn" -> "111311222112",
  "Fe" -> "13122112",
  "Co" -> "32112",
  "Ni" -> "11133112",
  "Cu" -> "131112",
  "Zn" -> "312",
  "Ga" -> "13221133122211332",
  "Ge" -> "31131122211311122113222",
  "As" -> "11131221131211322113322112",
  "Se" -> "13211321222113222112",
  "Br" -> "3113112211322112",
  "Kr" -> "11131221222112",
  "Rb" -> "1321122112",
  "Sr" -> "3112112",
  "Y" -> "1112133",
  "Zr" -> "12322211331222113112211",
  "Nb" -> "1113122113322113111221131221",
  "Mo" -> "13211322211312113211",
  "Tc" -> "311322113212221",
  "Ru" -> "132211331222113112211",
  "Rh" -> "311311222113111221131221",
  "Pd" -> "111312211312113211",
  "Ag" -> "132113212221",
  "Cd" -> "3113112211",
  "In" -> "11131221",
  "Sn" -> "13211",
  "Sb" -> "3112221",
  "Te" -> "1322113312211",
  "I" -> "311311222113111221",
  "Xe" -> "11131221131211",
  "Cs" -> "13211321",
  "Ba" -> "311311",
  "La" -> "11131",
  "Ce" -> "1321133112",
  "Pr" -> "31131112",
  "Nd" -> "111312",
  "Pm" -> "132",
  "Sm" -> "311332",
  "Eu" -> "1113222",
  "Gd" -> "13221133112",
  "Tb" -> "3113112221131112",
  "Dy" -> "111312211312",
  "Ho" -> "1321132",
  "Er" -> "311311222",
  "Tm" -> "11131221133112",
  "Yb" -> "1321131112",
  "Lu" -> "311312",
  "Hf" -> "11132",
  "Ta" -> "13112221133211322112211213322113",
  "W" -> "312211322212221121123222113",
  "Re" -> "111312211312113221133211322112211213322113",
  "Os" -> "1321132122211322212221121123222113",
  "Ir" -> "3113112211322112211213322113",
  "Pt" -> "111312212221121123222113",
  "Au" -> "132112211213322113",
  "Hg" -> "31121123222113",
  "Tl" -> "111213322113",
  "Pb" -> "123222113",
  "Bi" -> "3113322113",
  "Po" -> "1113222113",
  "At" -> "1322113",
  "Rn" -> "311311222113",
  "Fr" -> "1113122113",
  "Ra" -> "132113",
  "Ac" -> "3113",
  "Th" -> "1113",
  "Pa" -> "13",
  "U" -> "3",
)

val sortedElements = 
  elements.toList.map(_.swap).sortBy(_._1.length)(using Ordering[Int].reverse)

def tryAsElements(s: String): Option[List[String]] =
  val es = mutable.ListBuffer[String]()
  var curS = s

  while curS.nonEmpty do
    sortedElements.find(it => curS.startsWith(it._1)) match
      case Some((v, k)) =>
        curS = curS.drop(v.length)
        es.prepend(k)
      case None =>
        return None

  Some(es.reverse.toList)


def lookandsay(str: String, limit: Int): Int =
  var i = 0
  var maybeElems = tryAsElements(str)

  var curS = str
  while maybeElems.isEmpty && i < limit do
    curS = rle(curS)
    maybeElems = tryAsElements(str)
    i += 1

  if i >= limit then
    curS.length
  else
    val elems = maybeElems.get
    (i until limit).foldLeft(elems.groupMapReduce(identity)(_ => 1)(_ + _)): (elems, _) =>
      val newElems = mutable.HashMap[String, Int]()
      elems.foreach: (k, v) =>
        decaysTo(k).foreach: kk =>
          newElems.updateWith(kk):
            case Some(vv) => Some(vv + v)
            case None => Some(v)
      newElems.toMap
    .map((k, v) => elements(k).length * v).sum

def part1(input: String): Int =
  lookandsay(input, 40)

def part2(input: String): Int =
  lookandsay(input, 50)
```

@:benchmarkSection {
    overrideP1 = us
    overrideP2 = us
}

@:solution