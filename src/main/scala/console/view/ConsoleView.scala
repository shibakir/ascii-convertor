package console.view

import console.parser.Parser
import console.parser.Argument
import importer.{FileSystemImageImporter, Image2DImporter, ImageImporter}

class ConsoleView(args: Array[String]) {

  private val parser = new Parser(args)
  private val parsedArgs = parser.parse()

  def run(): Unit = {
    print("run ConsoleView.run()")
  }

  def getImporter: Unit = {

    var importer: Option[Image2DImporter] = Option.empty

    parsedArgs.foreach {

      case Argument("image", params) if params.nonEmpty =>
        params.head match {
          case "random" =>
            println("GENERATE RANDOM INPUT IMAGE")
          case p if p.endsWith(".jpg") || p.endsWith(".png") || p.endsWith(".webp") =>
            importer = Option(new FileSystemImageImporter(p))

            println("READ FROM FS INPUT IMAGE")
          case _ =>
            println("ERROR")
        }
      case _ =>
    }
  }

  def loadObject(): Unit = {

  }

  def showArgs(): Unit = {

      print(parsedArgs)
  }
}