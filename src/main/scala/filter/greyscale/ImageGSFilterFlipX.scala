package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS

class ImageGSFilterFlipX() extends ImageGSFilter {

  override def apply(image: Image[PixelGS]): Image[PixelGS] = {
    validateInputImage(image)
    
    val height = image.getHeight
    val width = image.getWidth

    val convertedPixels: Seq[Seq[PixelGS]] =
      (0 until height).map { row =>
        (0 until width).reverse.map { col =>
          image.getPixel(row, col)
        }
      }

    ImageGS(convertedPixels)
  }
}