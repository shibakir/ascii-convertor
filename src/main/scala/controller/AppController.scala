
package controller

import controller.parser.Parser

class AppController(parser: Parser) {

  def run(): Unit = {
    
    println("AppController run()")
    
    parser.parse()
  }
}