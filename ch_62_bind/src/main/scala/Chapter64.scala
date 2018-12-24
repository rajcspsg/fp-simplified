object Chapter64 extends App {
  import Wrapper._
  case class Wrapper[Int](value: Int) {
    def map(f: Int => Int): Wrapper[Int] = Wrapper(f(value))
    def flatMap(f: Int => Wrapper[Int]): Wrapper[Int] = f(value)
    //def filter(f: Int => Boolean): Wrapper[Int] = Wrapper(getValue(f, value))
  }

  object Wrapper {
    def pure(x:Int): Wrapper[Int] = Wrapper(x)
    def getValue(f: Int => Boolean, value: Int): Int = if (f(value)) 0 else value
  }

  println(Wrapper.pure(10).map(_ + 2))



}
