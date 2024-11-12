package model.image

import model.pixel.Pixel

trait Image2D[T <: Pixel] extends Image[T] {

  protected val pixels: Array[Array[T]]
  
  private def getHeight: Int = pixels.length
  private def getWidth: Int = if (pixels.isEmpty) 0 else pixels(0).length
  
  def getPixel(x: Int, y: Int): T = {
    validateCoordinates(x, y)
    pixels(x)(y)
  }

  def setPixel(x: Int, y: Int, pixel: T): Unit = {
    validateCoordinates(x, y)
    pixels(x)(y) = pixel
  }

  def copy(): Image2D[T]

  private def validateCoordinates(x: Int, y: Int): Unit = {
    if (x < 0 || x >= getHeight || y < 0 || y >= getWidth) {
      throw new ArrayIndexOutOfBoundsException("Invalid coordinates!")
    }
  }
}
