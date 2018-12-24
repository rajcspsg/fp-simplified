package io

import scalaz._
import effect._
import IO._

object IOTest2 extends App {

  val IOObj: IO[Unit] = for {
    _ <- putStrLn("First Name?")
    firstName <- getLine
    _ <- putStrLn("Last Name?")
    lastName <- getLine
    _ <- putStrLn(s"your name is ${firstName.toUpperCase} ${lastName.toUpperCase}")
  } yield ()
  IOObj.unsafePerformIO()

}
