import console.controller.ConsoleController

object Main {

  def main(args: Array[String]): Unit = {

    val app = new ConsoleController(args)
    app.run()
  }
}