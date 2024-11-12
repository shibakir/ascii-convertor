package console.view

import console.parser.Parser

class ConsoleView(args: Array[String]) {

  private val parser = new Parser(args)
  private val parsedArgs = parser.parse()

  def run(): Unit = {

    print("run ConsoleView.run()")
  }
  
  def loadObject(): Unit = {
    
  }

  def showArgs(): Unit = {

      print(parsedArgs)
  }
}