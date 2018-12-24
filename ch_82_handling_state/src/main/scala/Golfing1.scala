object Golfing1 extends App {

  case class GolfState(distance: Int)

  def nextStroke(prevState: GolfState, distanceOfNextHit: Int): GolfState = GolfState(distanceOfNextHit + prevState.distance)

  val state1 = GolfState(20)

  val state2 = nextStroke(state1, 15)

  val state3 = nextStroke(state2, 0)

  println(state3)

}
