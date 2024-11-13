package converter.basic

import transformation.TransformationTable
import transformation.LinearTransformation
import converter.greyscale.GreyscaleToASCIIConvertor
import model.image.{Image, Image2D}
import model.pixel.PixelASCII

class InternalGreyscaleToASCIIConverter(table: LinearTransformation) extends GreyscaleToASCIIConvertor {

  override def convert(image: Image[Int]): Image[PixelASCII] = {
    val height = image.getHeight
    val width = image.getWidth
    val pixels: Image[PixelASCII] = new Image2D[PixelASCII](Array.ofDim(height, width))
    
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val greyscale = image.getPixel(y, x)
        val pixel = PixelASCII(table.convert(greyscale)) 
        pixels.setPixel(y, x, pixel)
      }
    }
    pixels
  }
} 
