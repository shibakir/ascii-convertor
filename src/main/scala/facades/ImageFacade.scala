package facades

import converter.impl.{ImplGreyscaleToASCIIConverter, ImplRGBToGreyscaleConvertor}
import ui.config.Config
import ui.handling.{CommandHandler, DataHandler}

object ImageFacade {

  def setupConfig(args: String, commands: Seq[CommandHandler]): Config = {
    
      var dataHandler: DataHandler = DataHandler(args, new Config())

      commands.foreach { command =>
          dataHandler = command.handle(dataHandler)
      }
      dataHandler.config
  }

  def convert(config: Config): Unit = {
    try {
      config.validateBeforeConversion()

      val rgbToGreyscaleConvertor: ImplRGBToGreyscaleConvertor = new ImplRGBToGreyscaleConvertor()
      val greyscaleToASCIIConverter: ImplGreyscaleToASCIIConverter =
        new ImplGreyscaleToASCIIConverter(config.getTransformation.getOrElse {
          throw new NoSuchElementException("Transformation configuration is missing.")
        })

      val importer = config.getImporter.getOrElse {
        throw new NoSuchElementException("Image importer is not configured.")
      }
      
      val image = importer.importItem()
      var gsImage = rgbToGreyscaleConvertor.convert(image)

      val filters = config.getFilters
      filters.foreach { filter =>
        try {
          gsImage = filter.apply(gsImage)
        } catch {
          case e: Exception =>
            println(s"Error applying filter: ${e.getMessage}")
            throw e
        }
      }

      val asciiImage = greyscaleToASCIIConverter.convert(gsImage)

      val exporters = config.getExporters
      exporters.foreach { exporter =>
        try {
          exporter.exportData(asciiImage)
        } catch {
          case e: Exception =>
            throw e
        }
      }
    } catch {
      case e: Exception =>
        throw e
    }
  }
}