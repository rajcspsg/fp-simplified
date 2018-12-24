import scala.util.Random

object CoinFlipApp extends App {

  import  IOFunctions._

  val r = Random
  val s = GameState(0, 0)
  runLoop(s, r)

  def runLoop(state: GameState, random: Random): Unit = {
    showPrompt

    val userInput = getUserInput

    userInput match {
      case "H" | "T" => {
        val coinTossResult = tossCoin(random)
        if(userInput == coinTossResult) {
          val newState = GameState(state.numFlips + 1, state.numCorrectGuesses + 1)
          printGameState(coinTossResult,newState )
          runLoop(newState, random)
        } else {
          val newState = GameState(state.numFlips + 1, state.numCorrectGuesses )
          printGameState(coinTossResult,newState )
          runLoop(newState, random)
        }
      }
      case "q" | "Q" => printGameState("", state )
    }
  }

  def tossCoin(random: Random): String = {
    val i = r.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }
}
