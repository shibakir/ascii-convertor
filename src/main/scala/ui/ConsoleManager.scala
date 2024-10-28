package ui

class ConsoleManager(val controller: String, args: List[String]) {

  def run(): Unit = {
    println(f"ConsoleManager has been started with controller: $controller.")
  }

}