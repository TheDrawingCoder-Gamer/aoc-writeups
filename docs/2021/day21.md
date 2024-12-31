{%
aoc.day = 21
%}

# Day 21: Dirac Dice

@:include(/inc/solutionHeader.md)

## Solution Summary

1. Parse input into our `ProblemState`
2. Create a way to advance for each turn
    * For `part1` this is fairly simple, but still requires effort
    * For `part2` this is actually rather difficult

## Part 1

For part 1 I'll be using Cats' `State`. `State` is a functional way
to represent functions that update state.

Let's first get our `ProblemState` and `Player`:

```scala 3
case class Player(score: Int, space: Int)

case class ProblemState(dice: Int, nrolls: Int, p1: Player, p2: Player)
```

Let's parse our input:

```scala 3
def parse(str: String): ProblemState =
  val List(player1, player2) = str.linesIterator.map { it =>
    Player(0, it.dropWhile(_ != ':').drop(1).trim.toInt)
  }.toList
  ProblemState(0, 0, player1, player2)
```

Then for `ProblemState` let's make a way to advance the dice state:

```scala 3
case class ProblemState(dice: Int, nrolls: Int, p1: Player, p2: Player):
  def nextDiceDeterministic: ProblemState =
    copy(dice = (dice + 1) % 100, nrolls = nrolls + 1)
```

Now let's use `State` to make this combinable:

```scala 3
val rollState: State[ProblemState, Int] = State: x =>
  (x.nextDiceDeterministic, x.dice + 1)
```

A single turn is the sum of 3 dice rolls, so let's represent that as well:

```scala 3
val takeTurn: State[ProblemState, Int] =
  for
    x <- rollState
    y <- rollState
    z <- rollState
  yield x + y + z
```

Now to get to the pawn part of this dice and pawn game. Let's add a function to player to 
move the pawn and change score:

```scala 3
case class Player(score: Int, space: Int):
  def move(n: Int): Player =
    val daSpace = (space + n) % 10
    val good = if daSpace == 0 then 10 else daSpace
    copy(score = score + good, space = good)
```

To avoid duplication let's make a general way to take a player's turn:

```scala 3
def playerTurn(accessor: ProblemState => Player, setter: (ProblemState, Player) => ProblemState): State[ProblemState, Boolean] =
  for
    score <- takeTurn
    _ <- State.modify[ProblemState](state => setter(state, accessor(state).move(score)))
    res <- State.inspect[ProblemState, Int](accessor.andThen(_.score))
  yield res >= 1000
```

This returns true if the player has won, so we can short circuit once we reach that point.

Now each player is just different accessors and setters to the `ProblemState`:

```scala 3
val player1Turn = playerTurn(_.p1, (s, p) => s.copy(p1 = p))
val player2Turn = playerTurn(_.p2, (s, p) => s.copy(p2 = p))
```

Now let's write a full turn:

```scala 3
val fullTurn =
  for
    r1 <- player1Turn
    r2 <-
      if r1 then
        State.pure(Some(1))
      else
        player2Turn.map(it => Option.when(it)(2))
  yield r2
```

We get the result of player 1. If they won, we short circuit and return `Some(1)` to show that Player 1 won.
Otherwise, we do player 2's turn. If they won we return `Some(2)`.

That's all the code we needed to set up part 1, so now let's actually do it:

```scala 3
override def part1(input: ProblemState): BigInt =
  val (state, winner) = fullTurn.untilDefinedM.run(input).value
  BigInt:
    winner match
      case 1 => state.p2.score * state.nrolls
      case 2 => state.p1.score * state.nrolls
      case _ => 0
```

The problem text specifies the result is the loser's score * the amount of rolls taken.

## Part 2

This is actually a lot harder, and a naive approach takes too long to be reasonable.

However, we can abstract a bit by instead of simulating each split individually, we can group the 3 rolls 
together and multiply the result by probability.

We'll need to make a new class to contain the amount of universes:

```scala 3
case class P2State(pState: ProblemState, universeCount: BigInt)
```

Let's calculate the probabilities of each result of the 3 dice:

```scala 3
val dieCombos: List[(Int, BigInt)] = {
  val possibleRolls =
    (for {
      x <- 1 to 3
      y <- 1 to 3
      z <- 1 to 3
    } yield x + y + z).toList
  possibleRolls.groupMapReduce(identity)(_ => BigInt(1))(_ + _).toList
}
```

Now we have a list of outcomes and the amount of universes that outcome happens.

For part 2, we're using `Reader` and `Kleisli` instead of `State` because there is no continuous `State` we can update.
`Reader` is basically a `Function1`, and `Kleisli` is a monadic function.

Let's calculate a player turn for part 2:

```scala 3
type P2Func[B] = Kleisli[List, P2State, B]
def playerTurnP2(accessor: ProblemState => Player, setter: (ProblemState, Player) => ProblemState): P2Func[(P2State, Option[BigInt])] =
  Kleisli: state =>
    dieCombos.map: (it, v) =>
      val newPlayer = accessor(state.pState).move(it)
      (state.copy(pState = setter(state.pState, newPlayer),
        universeCount = state.universeCount * v),
        Option.when(newPlayer.score >= 21)(state.universeCount * v))
```

We're doing the same thing as earlier with accessors. We're using `ProblemState` accessors and setters instead of `P2State`
because `ProblemState` is inside of `P2State`, and it reduces code duplication. 

The `Kleisli` here does `flatMap` for us, and it implies the return of its monad (`List` here)

For each die outcome and number of universes it is in, we get the new player moved by the outcome, make a new state,
and include a `Some(state.universeCount * comboUniverseCount)` if the player won.

Let's make the values for player 1 and 2:

```scala 3
val player1TurnP2 = playerTurnP2(_.p1, (s, p) => s.copy(p1 = p))
val player2TurnP2 = playerTurnP2(_.p2, (s, p) => s.copy(p2 = p))
```

Now let's do a full turn. For this we'll return a `Chain[P2State]` of states that don't have a winner yet,
and 2 `BigInt`s for each player's win count this turn. 

We're using `Chain` here because later we will be appending a lot, and `Chain` is really really good at appending things,
and it's well worth the cost of conversion. This halved my runtime of 10s to 5s.

```scala 3
val fullTurnP2: Reader[P2State, ((BigInt, BigInt), Chain[P2State])] = Reader: state =>
  // get all possible results of a player 1 turn...
  val p1 = player1TurnP2(state)
  val (p1Win, p1Cont) = p1.partition(_._2.isDefined)
  // For all turns where player one didn't win, then do a player 2 turn...
  val (p2Win, p2Cont) = p1Cont.map((s, _) => s).flatMap(player2TurnP2.apply).partition(_._2.isDefined)
  // return a list of problem states that have no winner
  // and count the ones where a player won.
  val p1WinCount = p1Win.map((_, p) => p.get).sum
  val p2WinCount = p2Win.map((_, p) => p.get).sum
  ((p1WinCount, p2WinCount), Chain.fromSeq(p2Cont.map((s, _) => s)))
```

I couldn't really figure out a way to make this nice and short, so it's a bit of a mess, but this takes a state and returns the count
of states where each player won, and a list of states that haven't got a winner yet.

Now let's do part 2. What we want is to keep calculating until the `Chain` of states remaining is empty. This sounds like `unfold`, so let's use that:

```scala 3
def part2(input: ProblemState): BigInt =
  val p2State = P2State(input, BigInt(1))
  val (l, r) = LazyList.unfold((BigInt(0), BigInt(0), Chain(p2State))):
    case (p1Sum, p2Sum, states) =>
      Option.when(states.nonEmpty):
        val r = states.foldLeft((p1Sum, p2Sum, Chain[P2State]())):
          case ((p1, p2, allStates), state) =>
            val (counts, chain) = fullTurnP2(state)

            (p1 + counts._1, p2 + counts._2, allStates ++ chain))
        ((r._1, r._2), r)
  .last
  l.max(r)
```

I feel like there is definitely a way to make this shorter (cats probably has a function that does this automatically if you define a `Semigroup`),
but this is good enough for me. What we do here is `unfold` until the list of states is empty, then we get the last sum.

For each iteration we are saving the sum of counts of universes where each player wins, and updating the list of states. We do this with a `foldLeft` on the 
current states, that sums all the counts with our current counts, and collects all the unfinished states.

This runs in only 5s on my machine with JVM, which I think is pretty good all things considered.

## Final Code

```scala 3
case class Player(score: Int, space: Int):
  def move(n: Int): Player =
    val daSpace = (space + n) % 10
    val good = if daSpace == 0 then 10 else daSpace
    copy(score = score + good, space = good)

case class ProblemState(dice: Int, nrolls: Int, p1: Player, p2: Player):
  def nextDiceDeterministic: ProblemState =
    copy(dice = (dice + 1) % 100, nrolls = nrolls + 1)

val rollState: State[ProblemState, Int] = State: x =>
  (x.nextDiceDeterministic, x.dice + 1)


val takeTurn: State[ProblemState, Int] =
  for
    x <- rollState
    y <- rollState
    z <- rollState
  yield x + y + z

def playerTurn(accessor: ProblemState => Player, setter: (ProblemState, Player) => ProblemState): State[ProblemState, Boolean] =
  for
    score <- takeTurn
    _ <- State.modify[ProblemState](state => setter(state, accessor(state).move(score)))
    res <- State.inspect[ProblemState, Int](accessor.andThen(_.score))
  yield res >= 1000

val player1Turn = playerTurn(_.p1, (s, p) => s.copy(p1 = p))
val player2Turn = playerTurn(_.p2, (s, p) => s.copy(p2 = p))

val fullTurn =
  for
    r1 <- player1Turn
    r2 <-
      if r1 then
        State.pure(Some(1))
      else
        player2Turn.map(it => Option.when(it)(2))
  yield r2

lazy val input = FileIO.getInput(2021, 21)

override def parse(str: String): ProblemState =
  val List(player1, player2) = str.linesIterator.map { it =>
    Player(0, it.dropWhile(_ != ':').drop(1).trim.toInt)
  }.toList
  ProblemState(0, 0, player1, player2)

override def part1(input: ProblemState): BigInt =
  val (state, winner) = fullTurn.untilDefinedM.run(input).value
  BigInt:
    winner match
      case 1 => state.p2.score * state.nrolls
      case 2 => state.p1.score * state.nrolls
      case _ => 0


case class P2State(pState: ProblemState, universeCount: BigInt)

val dieCombos: List[(Int, BigInt)] = {
  val possibleRolls =
    (for {
      x <- 1 to 3
      y <- 1 to 3
      z <- 1 to 3
    } yield x + y + z).toList
  possibleRolls.groupMapReduce(identity)(_ => BigInt(1))(_ + _).toList
}

type P2Func[B] = Kleisli[List, P2State, B]
def playerTurnP2(accessor: ProblemState => Player, setter: (ProblemState, Player) => ProblemState): P2Func[(P2State, Option[BigInt])] =
  Kleisli: state =>
    dieCombos.map: (it, v) =>
      val newPlayer = accessor(state.pState).move(it)
      (state.copy(pState = setter(state.pState, newPlayer),
        universeCount = state.universeCount * v),
        Option.when(newPlayer.score >= 21)(state.universeCount * v))

val player1TurnP2 = playerTurnP2(_.p1, (s, p) => s.copy(p1 = p))
val player2TurnP2 = playerTurnP2(_.p2, (s, p) => s.copy(p2 = p))

val fullTurnP2: Reader[P2State, ((BigInt, BigInt), Chain[P2State])] = Reader: state =>
  // get all possible results of a player 1 turn...
  val p1 = player1TurnP2(state)
  val (p1Win, p1Cont) = p1.partition(_._2.isDefined)
  // For all turns where player one didn't win, then do a player 2 turn...
  val (p2Win, p2Cont) = p1Cont.map((s, _) => s).flatMap(player2TurnP2.apply).partition(_._2.isDefined)
  // return a list of problem states that have no winner
  // and count the ones where a player won.
  val p1WinCount = p1Win.map((_, p) => p.get).sum
  val p2WinCount = p2Win.map((_, p) => p.get).sum
  ((p1WinCount, p2WinCount), Chain.fromSeq(p2Cont.map((s, _) => s)))




override def part2(input: ProblemState): BigInt =
  val p2State = P2State(input, BigInt(1))
  val (l, r) = LazyList.unfold((BigInt(0), BigInt(0), Chain(p2State))):
    case (p1Sum, p2Sum, states) =>
      Option.when(states.nonEmpty):
        val r = states.foldLeft((p1Sum, p2Sum, Chain[P2State]())):
          case ((p1, p2, allStates), state) =>
            val (counts, list) = fullTurnP2(state)

            (p1 + counts._1, p2 + counts._2, allStates ++ list)
        ((r._1, r._2), r)
  .last
  l.max(r)
```

@:solution
