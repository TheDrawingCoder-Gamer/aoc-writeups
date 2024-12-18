---
title: "Day 17: Chronospatial Computer"
year: 2024
day: 17
---

## Puzzle Description
<https://adventofcode.com/2024/day/17>

## Scala Center Page

<https://scalacenter.github.io/scala-advent-of-code/2024/puzzles/day17>

## Solution Summary

1. Parse input into bytecode
2. Solve problem
    * for `part1`, this is just running the bytecode interpreter
    * for `part2`, this is semi bruteforcing the register to get the output to match the program

## Part 1

The input will be represented as a `ComputerState`. Here is that computer state:

```scala
case class ComputerState(ip: Int, program: Vector[Byte], regA: Long, regB: Long, regC: Long, outputs: List[Byte]):
  def advancePtr: ComputerState = copy(ip = ip + 2)
```

Before we get too carried away with the bytecode interpreter, let's first parse our input:

```scala
def parse(str: String): ComputerState =
  val Array(regs, program) = str.split("\n\n")
  val List(regA, regB, regC) = regs.linesIterator.map:
    case s"Register $_: $a" => a.toLong
  .toList
  val s"Program: $programStr" = program.trim

  ComputerState(0, programStr.split(',').map(_.toByte).toVector, regA, regB, regC, List())
```

Now let's actually write the bytecode interpreter:

```scala
case class ComputerState(ip: Int, program: Vector[Byte], regA: Long, regB: Long, regC: Long, outputs: List[Byte]):
  // ...

  final def complete: List[Byte] =
    if ip < program.size then
      step.complete
    else
      outputs.reverse

  def step: ComputerState =
    val Vector(opcode, operand) = program.slice(ip, ip + 2)
    def comboOperand =
      operand match
        case 0 => 0L
        case 1 => 1L
        case 2 => 2L
        case 3 => 3L
        case 4 => regA
        case 5 => regB
        case 6 => regC
        case 7 => assert(false)
        case _ => ???
    opcode match
      // adv
      case 0 => advancePtr.copy(regA = regA >> comboOperand)
      // bxl bitwise xor b
      case 1 => advancePtr.copy(regB = regB ^ operand)
      // bst modulo 8
      case 2 => advancePtr.copy(regB = comboOperand & 0b111)
      // jnz
      case 3 => if (regA == 0) advancePtr else copy(ip = operand)
      // bxc
      case 4 => advancePtr.copy(regB = regB ^ regC)
      // out
      case 5 => advancePtr.copy(outputs = outputs.prepended((comboOperand & 0b111).toByte))
      // bdv
      case 6 => advancePtr.copy(regB = regA >> comboOperand)
      // cdv
      case 7 => advancePtr.copy(regC = regA >> comboOperand)
```

Some notes: `x / 2^N` is equivalent to `x >> N` if x is an integral. `x % 8` is also equivalent to `x & 0b111`.

Part 1 is just simply getting the output, so we just call the interpreter:

```scala
def part1(str: String): List[Byte] = parse(str).complete
```

## Part 2

Part 2 is actually rather difficult, and I was unable to fully complete it without using 
[merlinorg's solution](https://github.com/merlinorg/aoc2024/blob/main/src/main/scala/Day17.scala). 

This is at first kind of a brick wall. However, it seems that everyone's input had something in common: the core of 
the program is `... a = a >> 3 ... jnz 0`. This means that every iteration a is divided by 8, so at the last iteration, before the call, it could be
anywhere from 1 to 7. Only some of those output the last digit of the program, so we can eliminate some possibilities while working backwards.

Here's the part 2 code:
```scala
def part2(str: String): Long = 
  val input = parse(str)
  Iterator.iterate(1L): a =>
    if input.program.endsWith(input.copy(regA = a).complete) then a << 3 else if a % 8 < 7 then a + 1 else (a >> 3) + 1
  .flatMap: a =>
    Option.when(input.copy(regA = a).complete.toVector == input.program)(a)
  .next()
```

The main iteration is happening in the initial iterate. It tests if the current A value's output matches the suffix of the program.
If it does, then those 3 bits are moved left and we start iterating on the next 3 bits. If not, we cycle those 3 bits, backing out if we've already
tested all the bits. If we've tested all the bits in an octet it means the path that got us here was wrong. The `.flatMap(...).next()` just gets
the first value of `a` where the output with the register A set to `a` is equal to the program.

Final code:
```scala
case class ComputerState(ip: Int, program: Vector[Byte], regA: Long, regB: Long, regC: Long, outputs: List[Byte]):
  def advancePtr: ComputerState = copy(ip = ip + 2)

  final def complete: List[Byte] =
    if ip < program.size then
      step.complete
    else
      outputs.reverse

  def step: ComputerState =
    val Vector(opcode, operand) = program.slice(ip, ip + 2)
    def comboOperand =
      operand match
        case 0 => 0L
        case 1 => 1L
        case 2 => 2L
        case 3 => 3L
        case 4 => regA
        case 5 => regB
        case 6 => regC
        case 7 => assert(false)
        case _ => ???
    opcode match
      // adv
      case 0 => advancePtr.copy(regA = regA >> comboOperand)
      // bxl bitwise xor b
      case 1 => advancePtr.copy(regB = regB ^ operand)
      // bst modulo 8
      case 2 => advancePtr.copy(regB = comboOperand & 0b111)
      // jnz
      case 3 => if (regA == 0) advancePtr else copy(ip = operand)
      // bxc
      case 4 => advancePtr.copy(regB = regB ^ regC)
      // out
      case 5 => advancePtr.copy(outputs = outputs.prepended((comboOperand & 0b111).toByte))
      // bdv
      case 6 => advancePtr.copy(regB = regA >> comboOperand)
      // cdv
      case 7 => advancePtr.copy(regC = regA >> comboOperand)

def parse(str: String): ComputerState =
  val Array(regs, program) = str.split("\n\n")
  val List(regA, regB, regC) = regs.linesIterator.map:
    case s"Register $_: $a" => a.toLong
  .toList
  val s"Program: $programStr" = program.trim

  ComputerState(0, programStr.split(',').map(_.toByte).toVector, regA, regB, regC, List())

def part1(str: String): List[Byte] = parse(str).complete

def part2(str: String): Long = 
  val input = parse(str)
  Iterator.iterate(1L): a =>
    if input.program.endsWith(input.copy(regA = a).complete) then a << 3 else if a % 8 < 7 then a + 1 else (a >> 3) + 1
  .flatMap: a =>
    Option.when(input.copy(regA = a).complete.toVector == input.program)(a)
  .next()
```

Here's my [actual day 17 solution](https://github.com/TheDrawingCoder-Gamer/adventofcode2024/blob/master/src/main/scala/Day17.scala). 
I have functions for testing here that helped find bugs.
