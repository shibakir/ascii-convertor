package exporter.file.ascii

import exporter.ASCIIToImageExporter
import model.image.Image
import model.pixel.PixelASCII

import java.io.{FileWriter, IOException}

class ASCIIToFileExport(path: String) extends ASCIIToImageExporter {

  override def exportData(data: Image[PixelASCII]): Unit = {
    if (data == null) {
      throw new IllegalArgumentException("Exporter: Image data cannot be null")
    }

    val saver = try {
      new FileWriter(path)
    } catch {
      case e: IOException =>
        throw new IOException(s"Exporter: Error opening file at path '$path': ${e.getMessage}", e)
    }

    try {
      for (y <- 0 until data.getHeight) {
        for (x <- 0 until data.getWidth) {
          try {
              saver.write(data.getPixel(y, x).toChar)
          } catch {
            case e: IndexOutOfBoundsException =>
              throw new IndexOutOfBoundsException(s"Exporter: Invalid pixel access at ($x, $y): ${e.getMessage}")
            case e: Exception =>
              throw new RuntimeException(s"Exporter: Unexpected error accessing pixel at ($x, $y): ${e.getMessage}", e)
          }
        }
        saver.write('\n')
      }
    } catch {
      case e: IOException =>
        throw new IOException(s"Exporter: Error writing to file '$path': ${e.getMessage}", e)
    } finally {
      try {
        saver.close()
      } catch {
        case e: IOException =>
          println(s"Exporter: Warning: Error closing file writer: ${e.getMessage}")
      }
    }
  }
}