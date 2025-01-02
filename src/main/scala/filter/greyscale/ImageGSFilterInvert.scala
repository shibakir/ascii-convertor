package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS

class ImageGSFilterInvert() extends ImageGSFilter {

  override def apply(image: Image[PixelGS]): Image[PixelGS] = {
    validateInputImage(image)
    
    val height = image.getHeight
    val width = image.getWidth

    val convertedPixels: Seq[Seq[PixelGS]] =
      (0 until height).map { row =>
        (0 until width).map { col =>
          val originalPixel = image.getPixel(row, col)
          val invertedValue = 255 - originalPixel.toInt
          PixelGS(invertedValue)
        }
      }

    ImageGS(convertedPixels)
  }
}