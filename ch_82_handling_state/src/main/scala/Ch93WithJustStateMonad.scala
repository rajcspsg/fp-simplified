import scalaz.{State, _}

object Ch93WithJustStateMonad extends App {

  case class IntState(i: Int)

  def add(i: Int): State[IntState, Unit] = State { oldState =>
    (IntState(oldState.i + i), Unit)
  }

  def multiply(i: Int): State[IntState, Unit] = State { oldState =>
    (IntState(oldState.i * i), Unit)
  }

  val calc = for {
    _ <- add(2)
    _ <- add(3)
    x <- multiply(10)
  } yield x

  val result = calc.run(IntState(0))._1

  println(s"result is $result")


}
