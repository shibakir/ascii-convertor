package importer

import model.image.{Image, ImageRGB}
import model.pixel.PixelRGB
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Image2DRandomImporter extends ImageRGBImporter {

  override def importItem(): Image[PixelRGB] = {

    val random = new Random
    val size = random.nextInt(400 + 1) + 100
    val pixels: ArrayBuffer[Seq[PixelRGB]] = ArrayBuffer.empty

    for (y <- 0 until size) {
      val row = ArrayBuffer[PixelRGB]()
      for (x <- 0 until size) {
        val r = (x * 255 / size)
        val g = (y * 255 / size)
        val b = ((x + y) * 255 / (size))
        row += PixelRGB(r, g, b)
      }
      pixels += row.toSeq
    }
    val image: Image[PixelRGB] = ImageRGB(pixels.toSeq)
    image
  }
}