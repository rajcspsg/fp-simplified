object Golfing2 extends App {

  case class GolfState(strokes: List[Int])

  def nextStroke(gs: GolfState, distanceOfNextHit: Int): GolfState = GolfState(distanceOfNextHit :: gs.strokes)

  val state0 = GolfState(Nil)

  val state1 = nextStroke(state0, 20)

  val state2 = nextStroke(state1, 15)

  val state3 = nextStroke(state2, 0)

  println(state3)
}
