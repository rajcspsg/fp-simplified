import scalaz.StateT
import scalaz.effect._

object StateTWithFor extends App {

  case class IntState(i: Int)

  def add(i: Int): StateT[IO, IntState, Int] = StateT[IO, IntState, Int] { oldState =>
    val newI = oldState.i + i
    val newState = oldState.copy(i = newI)
    IO.apply((newState, newI))
  }

  def multiply(i: Int): StateT[IO, IntState, Int] = StateT[IO, IntState, Int]{oldState =>
    val newI = oldState.i * i
    val newState = oldState.copy(i = newI)
    IO(newState, newI)
  }

  def printState: StateT[IO, IntState, Unit] = StateT[IO, IntState, Unit] { oldState =>
    IO(oldState, println(s"result so far is ${oldState.i}"))
  }

  val calc = for {
    _ <- add(2)
    _ <- add(3)
    x <- multiply(10)
    _ <- printState
    m <- add(3)
  } yield m



  //val result: IO[(IntState, Int)] = calc.run(IntState(1))


  val result: IO[(IntState, Int)] = calc.run(IntState(1))

  val (output) = result.unsafePerformIO()
  println(s"output is $output")

  //Thread.sleep(1000)

}
