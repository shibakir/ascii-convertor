package converter.impl

import converter.rgb.RGBToGreyscaleConverter
import model.image.{Image, Image2D, ImageGS}
import model.pixel.{PixelGS, PixelRGB}

class ImplRGBToGreyscaleConvertor extends RGBToGreyscaleConverter {

  override def convert(image: Image[PixelRGB]): Image[PixelGS] = {
    if (image == null) {
      throw new IllegalArgumentException("Converter: Input image cannot be null")
    }

    val height = image.getHeight
    val width = image.getWidth

    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException(s"Invalid image dimensions: height = $height, width = $width")
    }

    val pixels: Array[Array[PixelGS]] = Array.ofDim[PixelGS](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        try {
          val pixelRGB = image.getPixel(y, x)
          val greyscale = convertRGBToGreyScale(pixelRGB)
          pixels(y)(x) = greyscale
        } catch {
          case e: Exception =>
            throw new RuntimeException(s"Converter: Error processing pixel at ($x, $y): ${e.getMessage}", e)
        }
      }
    }

    val imageGS: Image[PixelGS] = ImageGS(pixels.map(_.toSeq).toSeq)
    imageGS
  }

  private def convertRGBToGreyScale(pixel: PixelRGB) : PixelGS = {
    val red = pixel.getRed
    val green = pixel.getGreen
    val blue = pixel.getBlue

    val greyscale = 0.299 * red + 0.587 * green + 0.114 * blue
    PixelGS(greyscale.toInt)
  }
}