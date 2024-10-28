import controller.AppController
import controller.parser.Parser

object Main {

  def main(args: Array[String]): Unit = {

    val app = new AppController(
      new Parser(args),
    )

    app.run()
  }
}