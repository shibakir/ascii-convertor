import ui.ConsoleManager

object Main extends App {

  val controller = "Controller"

  private val manager = new ConsoleManager(controller, null)

  manager.run()
}