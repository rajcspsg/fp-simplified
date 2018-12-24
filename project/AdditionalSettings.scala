import sbt.{Def, State, Test}
import sbt.Keys._

object AdditionalSettings {

  val loadInitialCmds = true

  val initialLoadCommands = "import scalaz._\n import Scalaz._ \n import simulacrum._ \n"
  val initialCmdsConsole: Seq[Def.Setting[String]] = if(loadInitialCmds) Seq(initialCommands in console := initialLoadCommands) else Seq()

  val initialCmdsTestConsole: Seq[Def.Setting[String]] =
    if(loadInitialCmds)  Seq(initialCommands in(Test, console) := (initialCommands in console).value + ", TestData._") else Seq()

  val cmdAliasesIn: Seq[Def.Setting[(State) => State]] = Seq(
    //    addCommandAlias("xxx", "help"),
    //    addCommandAlias("yxy", "help")
  ).flatten

  val cmdAliases: Seq[Def.Setting[State => State]] =
    cmdAliasesIn

}
