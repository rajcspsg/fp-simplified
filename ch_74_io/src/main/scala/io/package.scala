import scalaz._
import effect._

package object io {

  def getLine: IO[String] = IO(scala.io.StdIn.readLine())

  def putStrLn(s: String): IO[Unit] = IO(println(s))
}
