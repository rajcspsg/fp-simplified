object Step3Bind extends App {

  def f(a: Int): (Int, String) = (a * 2, s"\n f result: ${a * 2}")

  def g(a: Int): (Int, String) = (a * 3, s"\n g result: ${a * 3}")

  def h(a: Int): (Int, String)= (a * 4, s"\n g result: ${a * 4}")

  def bind(fun: Int => (Int, String),
           tup: Tuple2[Int, String]): (Int, String) = {
    val (intResult, stringResult) = fun(tup._1)
    (intResult, tup._2 + stringResult)

  }

  val fResult = bind(f, (100, ""))
  val gResult = bind(g, fResult)
  val hResult = bind(h, gResult)

  /*val finalResult = for {
    fRes <- f(100)
    gRes <- g(fRes)
    hRes <- h(gRes)
  } yield hRes

  println(finalResult)*/

}
