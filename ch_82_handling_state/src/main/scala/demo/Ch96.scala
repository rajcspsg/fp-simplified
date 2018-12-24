package demo

import scalaz.StateT
import scalaz.effect._


object Ch96 extends App {

  def doSumWithStateT(newValue: Int): StateT[IO, SumState, Int] = StateT { oldState =>
    val newSum = newValue + oldState.sum
    println(s"updateIntState, oldState  $oldState")
    println(s"updateIntState, new inout $newValue")
    println(s"updateIntState new sum $newSum")
    val newState = oldState.copy(sum = newSum)
    IO(newState, newSum)
  }

  def sumLoop: StateT[IO, SumState, Unit] = for {
    _ <- putLineAsStateT("\n Enter an Int")
    input <- getLineAsStateT
    i <- liftIOintoStateT(IO(toInt(input)))
    _ <- doSumWithStateT(i)
    _ <- sumLoop
  } yield Unit

  val result = sumLoop.run(SumState(2)).unsafePerformIO()
  println(result)

}
