package exporter.file.ascii

import exporter.ASCIIToImageExporter
import model.image.Image
import model.pixel.PixelASCII

import java.io.FileWriter

class ASCIIToFileExport(path: String) extends ASCIIToImageExporter {

  override def exportData(data: Image[PixelASCII]): Unit = {

    val saver = new FileWriter(path)

    for (y <- 0 until data.getHeight) {
      for (x <- 0 until data.getWidth) {
        saver.write(data.getPixel(y, x).toChar)
      }
      saver.write('\n')
    }
  }
}