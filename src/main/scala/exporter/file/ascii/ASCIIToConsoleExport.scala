package exporter.file.ascii

import exporter.ASCIIToImageExporter
import model.image.Image
import model.pixel.PixelASCII

class ASCIIToConsoleExport extends ASCIIToImageExporter {

  override def exportData(data: Image[PixelASCII]): Unit = {
    if (data == null) {
      throw new IllegalArgumentException("Exporter: Image data cannot be null")
    }
    
    for (y <- 0 until data.getHeight) {
      for (x <- 0 until data.getWidth) {
        try {
          print(data.getPixel(y, x).toChar)
        } catch {
          case e: IndexOutOfBoundsException =>
            throw new IndexOutOfBoundsException(s"Exporter: Invalid pixel access at ($x, $y): ${e.getMessage}")
          case e: Exception =>
            throw new RuntimeException(s"Exporter: Unexpected error accessing pixel at ($x, $y): ${e.getMessage}", e)
        }
      }
      println()
    }
  }
}