import scalaz.State

object Golfing3 extends App {

  case class GolfState(distance: Int)

  def swing(distance: Int): State[GolfState, Int] = State { (s: GolfState) =>
    val newAmount = s.distance + distance
    (GolfState(newAmount), newAmount)
  }

  def stateWithNewDistance: State[GolfState, Int] = for {
    _ <- swing(20)
    _ <- swing(15)
    totalDistance <- swing(0)
  } yield totalDistance

  val result = stateWithNewDistance.run(GolfState(15))

  println(result)

}
