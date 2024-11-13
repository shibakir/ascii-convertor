package console.controller

import console.view.ConsoleView

class ConsoleController(var args: Array[String]) extends Controller {


  override def run(): Unit = {

    println("AppController run()")
    val consoleView = ConsoleView(args)

    consoleView.run()
    consoleView.showArgs()

    consoleView.getImporter
    consoleView.getExporter



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