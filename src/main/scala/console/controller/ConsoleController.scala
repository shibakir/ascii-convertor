package console.controller

import console.view.ConsoleView

class ConsoleController(var args: Array[String]) extends Controller {

  private val consoleView = ConsoleView(args)

  override def run(): Unit = {

    println("AppController run()")
    consoleView.showArgs()
    consoleView.getImporter

    /*
    * step by step:
    *
    * import image
    *
    * coversions, ...
    *
    * convert to greyscale
    * convert to ascii
    * convert to string
    * */
    }
}