package converter.basic

import converter.rgb.RGBToGreyscaleConverter
import model.image.{Image, Image2D}
import model.pixel.PixelRGB

class InternalRGBToGreyscaleConvertor extends RGBToGreyscaleConverter {

  override def convert(image: Image[PixelRGB]): Image[Int] = {
    
    val height = image.getHeight
    val width = image.getWidth
    
    var result: Image[Int] = Image2D[Int](Array.ofDim(height, width))
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val greyscale = convertRGBToGreyScale(image.getPixel(y, x))
        result.setPixel(y, x, greyscale.toInt)
      }
    }
    result
  }
  
  private def convertRGBToGreyScale(pixel: PixelRGB) : Int = {
    val red = pixel.getRed
    val green = pixel.getGreen
    val blue = pixel.getBlue
  
    val greyscale = 0.299 * red + 0.587 * green + 0.114 * blue
    greyscale.toInt
  }
}