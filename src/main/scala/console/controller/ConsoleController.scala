package console.controller

import console.controller.parser.Parser

class ConsoleController(parser: Parser) extends Controller {

  def run(): Unit = {
    
    println("AppController run()")

    val params = parser.parse()
    println(params)


  }
}