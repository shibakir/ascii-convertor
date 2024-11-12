package console.view

import console.parser.Parser

class ConsoleView(args: Array[String]) {

  private val parser = new Parser(args)
  private val parsedArgs = parser.parse()

  def showArgs(): Unit = {
    
      print(parsedArgs)
  }
}