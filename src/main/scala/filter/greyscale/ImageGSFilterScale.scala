package  filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS

class ImageGSFilterScale(scaleValue: Double) extends ImageGSFilter {

  override def apply(image: Image[PixelGS]): Image[PixelGS] = {
    validateInputImage(image)

    scaleValue match {
      case 0.25 => scale025(image)
      case 1.0 => scale1(image)
      case 4.0 => scale4(image)
      case _ => throw new IllegalArgumentException("Filter: Invalid scale value. Supported values are 0.25, 1, and 4.")
    }
  }

  private def scale025(image: Image[PixelGS]): Image[PixelGS] = {
    val height = image.getHeight
    val width = image.getWidth

    val convertedPixels: Seq[Seq[PixelGS]] =
      (0 until height by 2).map { row =>
        (0 until width by 2).map { col =>
          image.getPixel(row, col)
        }
      }
    ImageGS(convertedPixels)
  }

  private def scale1(image: Image[PixelGS]): Image[PixelGS] = {
    image
  }

  private def scale4(image: Image[PixelGS]): Image[PixelGS] = {
    val height = image.getHeight
    val width = image.getWidth

    val convertedPixels: Seq[Seq[PixelGS]] =
      (0 until height).flatMap { row =>
        val rowPixels = (0 until width).flatMap { col =>
          val pixel = image.getPixel(row, col)
          Seq.fill(2)(pixel)
        }
        Seq.fill(2)(rowPixels)
      }
    ImageGS(convertedPixels)
  }

}