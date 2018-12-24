import scalaz.StateT
import scalaz.effect.IO

package object demo {


  def toInt(s: String): Int = try ( s.toInt ) catch { case e: Throwable => 0 }

  case class SumState(sum: Int)

  def updateAppState(newValue: Int): StateT[IO, SumState, Int] = StateT { oldState =>
    val newSum = newValue + oldState.sum
    IO(SumState(newSum), newSum)
  }

  def liftIOintoStateT[A](io: IO[A]): StateT[IO, SumState, A] = StateT { s => io.map(a => (s, a)) }

  def getLineAsStateT: StateT[IO, SumState, String] = liftIOintoStateT(IO(scala.io.StdIn.readLine()))

  def putLineAsStateT(s: String): StateT[IO, SumState, Unit] = liftIOintoStateT(IO(println(s)))


}
