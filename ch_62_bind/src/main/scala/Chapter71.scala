object Chapter71 extends App {

  case class Debuggable[A](value: A, log: List[String]) {
    def map[B](f: A => B): Debuggable[B] = Debuggable(f(value), log)
    def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {  val output = f(value); output.copy(log = log ++ output.log) }
  }

}
