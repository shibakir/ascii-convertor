import console.controller.ConsoleController
import console.controller.parser.Parser

object Main {

  def main(args: Array[String]): Unit = {

    val app = new ConsoleController(
      new Parser(args),
    )

    app.run()
  }
}