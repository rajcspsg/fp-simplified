object IOFunctions {

  def showPrompt: Unit = println(s"\n (h)eads, (t)ails, or (q)uit: ")

  def getUserInput: String = scala.io.StdIn.readLine().trim.toUpperCase


  def printableFlipResult(flip: String): String = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = {
    print(s"Flip was $printableResult")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit =
    println(s"#Flips: ${gameState.numFlips}, #correct: ${gameState.numCorrectGuesses}")

  def printGameOver: Unit = println("====Game Over====")
}
