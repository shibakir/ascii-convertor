package console.controller

import console.view.ConsoleView

class ConsoleController(var args: Array[String]) extends Controller {

  private val consoleView = ConsoleView(args)

  def run(): Unit = {

    println("AppController run()")
    consoleView.showArgs()
  }
}