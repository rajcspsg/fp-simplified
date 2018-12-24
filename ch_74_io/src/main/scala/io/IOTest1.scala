package io

object IOTest1 extends App {
  val IOObj = for {
    _ <- putStrLn("First Name?")
    firstName <- getLine
    _ <- putStrLn("Last Name?")
    lastName <- getLine
    _ <- putStrLn(s"your name is $firstName $lastName")
  } yield ()
  IOObj.unsafePerformIO()
}
