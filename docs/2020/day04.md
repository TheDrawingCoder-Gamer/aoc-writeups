{%
aoc.day = 4
%}

# Day 4: Passport Processing

@:include(/inc/solutionHeader.md)

Today I originally used CoffeeScript but I decided to not rewrite CoffeeScript code as it's just a bleh language for me,
and Scala has a really elegant solution for today.

## Solution Summary

1. Parse passports
2. Count number of valid passports in list

## Part 1

Part 1 just is looking for the existance - the hard part of this is actually parsing.

First let's define our `Passport`:

```scala 3
case class Passport
  (byr: Option[Int],
   iyr: Option[Int],
   eyr: Option[Int],
   hgt: Option[String],
   hcl: Option[String],
   ecl: Option[String],
   pid: Option[String])
```

As you can see it's just a bunch of `Option`-al fields. 

Because the test is so simple for seeing if a passport is valid, let's do that now.
Using the monadic properties of `Option` with the monadic `for` makes this really easy:

```scala 3
case class Passport(...):
  def isValid: Boolean =
    (for
      _ <- byr
      _ <- iyr
      _ <- eyr
      _ <- hgt
      _ <- hcl
      _ <- ecl
      _ <- pid
    yield ()).isDefined
```

Now let's do the actual parsing:

```scala 3
def parse(str: String): List[Passport] =
  str.split("\n\n").map: block =>
    var byr = Option.empty[Int]
    var iyr = Option.empty[Int]
    var eyr = Option.empty[Int]
    var hgt = Option.empty[String]
    var hcl = Option.empty[String]
    var ecl = Option.empty[String]
    var pid = Option.empty[String]
    block.split(raw"\s+").foreach:
      // throw if not valid int
      case s"byr:$b" => byr = Some(b.toInt)
      case s"iyr:$i" => iyr = Some(i.toInt)
      case s"eyr:$e" => eyr = Some(e.toInt)
      case s"hgt:$h" => hgt = Some(h)
      case s"hcl:$h" => hcl = Some(h)
      case s"ecl:$e" => ecl = Some(e)
      case s"pid:$p" => pid = Some(p)
      case _ => ()
    Passport(byr, iyr, eyr, hgt, hcl, ecl, pid)
  .toList
```

We don't bother testing for country id as it never matters for us - each block's new lines don't matter either and
each component doesn't have spaces, so we can split on flat out whitespace. As a note, the `split` function takes
a regex string as a parameter, so the regex here is just "1 or more whitespace characters". We can then match on each
passport segment, and set the correct variable if it matches.

Our input will never have invalid years, so we can convert those here, but the others need to be tested later.

Now let's do part 1:

```scala 3
def part1(input: List[Passport]): Int = input.count(_.isValid)
```

## Part 2

Part 2 is harder but we can still use the monadic `for` to our advantage. Namely, the `if` in a `for` will return `None` if the expression is false.

So we can test with just a `for`:

```scala 3
case class Passport(...):
  def isValidP2: Boolean =
    (for
      byr <- this.byr
      if byr >= 1920 && byr <= 2002
      iyr <- this.iyr
      if iyr >= 2010 && iyr <= 2020
      eyr <- this.eyr
      if eyr >= 2020 && eyr <= 2030
      hgt <- this.hgt
      (heightNumStr, heightUnit) = hgt.span(_.isDigit)
      heightNum = heightNumStr.toInt
      if (heightUnit == "cm" && heightNum >= 150 && heightNum <= 193)
          || (heightUnit == "in" && heightNum >= 59 && heightNum <= 76)
      hcl <- this.hcl
      if hcl.head == '#' && hcl.tail.length == 6 
          && hcl.tail.forall(it => it.isDigit || (it >= 'a' && it <= 'f'))
      ecl <- this.ecl
      if ecl == "amb" || ecl == "blu" || ecl == "brn" 
         || ecl == "gry" || ecl == "grn" || ecl == "hzl" || ecl == "oth"
      pid <- this.pid
      if pid.length == 9
     yield ()).isDefined
```

After getting the value of each component, we test to see if it's valid. If it's not, the for loop will immediately short circuit for us.
(if you're curious what `if` in a `for` desugars to, it's the `filter` function.)

Then `part2` is just `part1` but using our new valid function:

```scala 3
def part2(input: List[Passport]) = input.count(_.isValidP2)
```

## Final Code

```scala 3
case class Passport
  (byr: Option[Int],
   iyr: Option[Int],
   eyr: Option[Int],
   hgt: Option[String],
   hcl: Option[String],
   ecl: Option[String],
   pid: Option[String]):
  def isValid: Boolean =
    (for
      _ <- byr
      _ <- iyr
      _ <- eyr
      _ <- hgt
      _ <- hcl
      _ <- ecl
      _ <- pid
    yield ()).isDefined

  def isValidP2: Boolean =
    (for
      byr <- this.byr
      if byr >= 1920 && byr <= 2002
      iyr <- this.iyr
      if iyr >= 2010 && iyr <= 2020
      eyr <- this.eyr
      if eyr >= 2020 && eyr <= 2030
      hgt <- this.hgt
      (heightNumStr, heightUnit) = hgt.span(_.isDigit)
      heightNum = heightNumStr.toInt
      if (heightUnit == "cm" && heightNum >= 150 && heightNum <= 193) 
          || (heightUnit == "in" && heightNum >= 59 && heightNum <= 76)
      hcl <- this.hcl
      if hcl.head == '#' && hcl.tail.length == 6 
         && hcl.tail.forall(it => it.isDigit || (it >= 'a' && it <= 'f'))
      ecl <- this.ecl
      if ecl == "amb" || ecl == "blu" || ecl == "brn" 
         || ecl == "gry" || ecl == "grn" || ecl == "hzl" || ecl == "oth"
      pid <- this.pid
      if pid.length == 9
     yield ()).isDefined

def parse(str: String): List[Passport] =
  str.split("\n\n").map: block =>
    var byr = Option.empty[Int]
    var iyr = Option.empty[Int]
    var eyr = Option.empty[Int]
    var hgt = Option.empty[String]
    var hcl = Option.empty[String]
    var ecl = Option.empty[String]
    var pid = Option.empty[String]
    block.split(raw"\s+").foreach:
      // throw if not valid int
      case s"byr:$b" => byr = Some(b.toInt)
      case s"iyr:$i" => iyr = Some(i.toInt)
      case s"eyr:$e" => eyr = Some(e.toInt)
      case s"hgt:$h" => hgt = Some(h)
      case s"hcl:$h" => hcl = Some(h)
      case s"ecl:$e" => ecl = Some(e)
      case s"pid:$p" => pid = Some(p)
      case _ => ()
    Passport(byr, iyr, eyr, hgt, hcl, ecl, pid)
  .toList

def part1(input: List[Passport]): Int = input.count(_.isValid)

def part2(input: List[Passport]): Int = input.count(_.isValidP2)
```

@:solution