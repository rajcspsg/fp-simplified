object Chapter66 extends App {

  case class Wrapper[A](value: A) {
    def map[B](f: A => B): Wrapper[B] = Wrapper(f(value))
    def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = f(value)
  }

  val intResult = for {
    a <- Wrapper(1)
    b <- Wrapper(2)
    c <- Wrapper(3)
  } yield a + b + c

  println(intResult)
}
