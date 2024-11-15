package console.view

import console.parser.Parser
import console.parser.Argument
import converter.ImageConverter
import converter.basic.InternalGreyscaleToASCIIConverter
import converter.greyscale.{GreyscaleConverter, GreyscaleToASCIIConvertor}
import exporter.file.ascii.ASCIIToFileExport
import exporter.{ASCIIToImageExporter, ImageExporter}
import importer.{FileSystemImageImporter, Image2DImporter, ImageImporter}
import transformation.{LinearTransformation, Transformation, TransformationTable}

class ConsoleView(args: Array[String]) {

  private val parser = new Parser(args)
  private val parsedArgs = parser.parse()

  def run(): Unit = {
    print("run ConsoleView.run()")
  }

  def getImporter: Image2DImporter = {

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
    importer match
      case Some(imageImporter) => imageImporter
      case None => throw new Exception("Error getting importer!")
  }
  /*
  def getExporter: Seq[ASCIIToImageExporter] = {
    //var exporter: Option[ASCIIToImageExporter] = Option.empty
    var exporters = Seq[ASCIIToImageExporter]()

    parsedArgs.foreach {
      case Argument("output-console", params) => println("OUTPUT TO CONSOLE")
      case Argument("output-file", params) if params.nonEmpty =>
        exporters = params.map(param => new ASCIIToFileExport(param)) ++ exporters
        println("OUTPUT TO FILES")
        // concat two Seq
      case _ =>
    }
    exporters
  }
   */

  def getExporter: ASCIIToImageExporter = {
    
    println("OUTPUT TO FILES")
    
    var exporter = new ASCIIToFileExport("pic/file.txt")
    exporter
  }
  
  def getConverter: GreyscaleToASCIIConvertor = {

    var table: Option[LinearTransformation] = Option.empty

    parsedArgs.foreach {
      case Argument("table-basic", params) =>
        table = Option(TransformationTable.tables("basic"))
        println("TABLE BASIC")
      case Argument("table-advance", params) =>
        table = Option(TransformationTable.tables("advance"))
        println("TABLE ADVANCE")
      case Argument("table-pro", params) =>
        table = Option(TransformationTable.tables("pro"))
        println("TABLE PRO")
      /*
      case Argument("table", params) if params.nonEmpty =>
        params.head match {
          case "basic" =>
            table = Option(TransformationTable.tables("basic"))
            println("BASIC CONVERTER")
          case "advance" =>
            table = Option(TransformationTable.tables("advance"))
            println("ADVANCE CONVERTER")
          case "pro" =>
            table = Option(TransformationTable.tables("pro"))
            println("PRO CONVERTER")
          case _ =>
            println("ERROR")
        }
      */
      case _ =>
    }
    InternalGreyscaleToASCIIConverter(table.get)
  }

  def loadObject(): Unit = {

  }

  def showArgs(): Unit = {

      print(parsedArgs)
  }
}