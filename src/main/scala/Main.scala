import ui.console.Console

object Main {

  def main(args: Array[String]): Unit = {
    println("\n---------")
    Console.processCommand(args.mkString(" "))
    println("\n---------")
  }
}
