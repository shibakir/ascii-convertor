package converter.impl

import transformation.Transformation
import converter.greyscale.GreyscaleToASCIIConvertor
import model.image.{Image, ImageASCII}
import model.pixel.{PixelASCII, PixelGS}

class ImplGreyscaleToASCIIConverter(table: Transformation) extends GreyscaleToASCIIConvertor {

  override def convert(image: Image[PixelGS]): Image[PixelASCII] = {
    if (image == null) {
      throw new IllegalArgumentException("Converter: Input image cannot be null")
    }

    val height = image.getHeight
    val width = image.getWidth

    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException(s"Converter: Invalid image dimensions: height = $height, width = $width")
    }

    val pixels: Array[Array[PixelASCII]] = Array.ofDim[PixelASCII](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        try {
          val greyscale = image.getPixel(y, x).toInt
          val pixel = PixelASCII(table.convert(greyscale))
          pixels(y)(x) = pixel
        } catch {
          case e: ClassCastException =>
            throw new ClassCastException(s"Converter: Failed to cast pixel at ($x, $y) to PixelGS: ${e.getMessage}")
          case e: Exception =>
            throw new RuntimeException(s"Converter: Error processing pixel at ($x, $y): ${e.getMessage}", e)
        }
      }
    }
    
    val imageASCII: Image[PixelASCII] = ImageASCII(pixels.map(_.toSeq).toSeq)
    imageASCII
  }
} 
