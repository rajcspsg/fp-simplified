import scalaz.StateT
import scalaz.effect._

object BeginingStateTDemo extends App {

  def getLineAsStateT: StateT[IO, SumState, String] = StateT.liftM(IO(scala.io.StdIn.readLine()))

  def putStrAsStateT(s: String): StateT[IO, SumState, Unit] = StateT.liftM(IO(println(s)))

  def liftIntoStateT [A](x: A): StateT[IO, SumState, A] = StateT.liftM(IO(x))

  case class SumState(value: Int)

  def sumLoop: StateT[IO, SumState, Unit] = for {
    _ <- putStrAsStateT("\n give me an Int or 'q' to quit ")
    input <- getLineAsStateT
    _ <- if(input == "q") liftIntoStateT(IO(Unit))
    else for {
      _ <- liftIntoStateT(IO(input.toInt))
      _ <- sumLoop
    } yield Unit
  } yield Unit

  sumLoop.run(SumState(0)).unsafePerformIO()


}
