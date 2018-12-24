package io

import scalaz._
import effect._

object IORecursiveLoop extends App {

  def loop: IO[Unit] = for {

    _  <- putStrLn("Type Something!!!")

    input <- getLine

    _ <- putStrLn(s"you said $input")

    _ <- if(input.equals( "quit")) IO(()) else loop
  } yield ()

  loop.unsafePerformIO()

}
