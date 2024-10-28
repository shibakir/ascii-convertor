package ui

import controller.Controller

class ConsoleManager(val controller: Controller, args: List[String]) {

  def run(): Unit = {
    println(f"ConsoleManager has been started with controller: $controller.")
  }

}