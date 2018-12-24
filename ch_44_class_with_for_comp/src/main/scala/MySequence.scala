import scala.collection.mutable.ArrayBuffer

case class MySequence[A](initialElements: A*) {

  private val elems:ArrayBuffer[A] = scala.collection.mutable.ArrayBuffer[A]()

  elems ++= initialElements

  def foreach(block: A => Unit): Unit = {
    elems.foreach(block)
  }

  def map[B] (block: A => B): MySequence[B] = MySequence(elems.map(block): _*)

  def withFilter (block: A => Boolean): MySequence[A] = MySequence(elems.filter(block): _*)

  def filter(block: A => Boolean): MySequence[A] = withFilter(block)

  def flatMap[B](block: A => MySequence[B]): MySequence[B] =  {
    val mapRes: MySequence[MySequence[B]] = map(block)
    flattenLike(mapRes)
  }

  //def flatten[B]: MySequence[B] = flattenLike(this)

  def flattenLike[B](seqseq: MySequence[MySequence[B]]): MySequence[B] = {
    var xs = ArrayBuffer[B]()
    for(listB: MySequence[B] <- seqseq) {
      for(e <- listB) {
        xs += e
      }
    }
    MySequence(xs: _*)
  }

}
