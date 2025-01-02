package  filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS

class ImageGSFilterRotate(rotateValue: Int) extends ImageGSFilter {

  override def apply(image: Image[PixelGS]): Image[PixelGS] = {
    validateInputImage(image)
    
    val height = image.getHeight
    val width = image.getWidth
    val normalizedRotation = ((rotateValue % 360) + 360) % 360

    val convertedPixels: Seq[Seq[PixelGS]] = normalizedRotation match {
      case 0 =>
        (0 until height).map(row => (0 until width).map(col => image.getPixel(row, col)))
      case 90 =>
        (0 until width).map(col => (0 until height).reverse.map(row => image.getPixel(row, col)))
      case 180 =>
        (0 until height).reverse.map(row => (0 until width).reverse.map(col => image.getPixel(row, col)))
      case 270 =>
        (0 until width).reverse.map(col => (0 until height).map(row => image.getPixel(row, col)))
    }
    ImageGS(convertedPixels)
  }
}