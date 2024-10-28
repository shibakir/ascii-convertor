import controller.ControllerConsole
import ui.ConsoleManager

object Main extends App {

  val controller = new ControllerConsole()

  private val manager = new ConsoleManager(controller, null)

  manager.run()
}