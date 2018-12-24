object Chapter68 extends App {

  case class Debuggable[A](value: A, message: String) {

    def map[B](f: A => B): Debuggable[B] = Debuggable(f(value), message)
    def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {  val output = f(value); output.copy(message = message + output.message) }
  }


  def f(a: Int): Debuggable[Int] = Debuggable(a * 2, s"f: a ($a) = ${a * 2}")
  def g(a: Int): Debuggable[Int] = Debuggable(a * 3, s"g: a ($a) = ${a * 3}")
  def h(a: Int): Debuggable[Int] = Debuggable(a * 4, s"h: a ($a) = ${a * 4}")

  val result = for {
    fRes <- f(10)
    gRes <- g(fRes)
    hRes <- h(gRes)
  } yield hRes

  println("result is \n" + result)
}
