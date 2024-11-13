package console.controller

import console.view.ConsoleView
import converter.rgb.RGBToGreyscaleConverter
import converter.basic.InternalRGBToGreyscaleConvertor

class ConsoleController(var args: Array[String]) extends Controller {


  override def run(): Unit = {

    println("AppController run()")
    val consoleView = ConsoleView(args)

    consoleView.run()
    consoleView.showArgs()

    val importer = consoleView.getImporter
    val exporter = consoleView.getExporter
    val converter = consoleView.getConverter

    val basicConverter: RGBToGreyscaleConverter = new InternalRGBToGreyscaleConvertor
    val image = basicConverter.convert(importer.importImage())
    
    // val output = converter.conve

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