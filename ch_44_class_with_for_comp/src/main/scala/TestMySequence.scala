object TestMySequence extends App {

  val myseq: MySequence[Int] = MySequence(1,2,3, 4, 5)

  for {
   a <- myseq
    //_ = println(a)
  } println(a)

  val b = for {
    a <- myseq
    //_ = println(a)
    if a > 3
  } yield a * 2


  println(b)

  println(b.map(_ * 4))

  println(b.filter(_ > 9))

  case class Person(name: String)

  val myFriends = MySequence(Person("Adam"), Person("David"), Person("Frank"))

  val admFriends = MySequence(Person("Nick"), Person("David"), Person("Frank"))

  val mutualFriends = for {
    a <- myFriends
    b <- admFriends
    if (a == b)
  } yield a

  println(mutualFriends)
}
