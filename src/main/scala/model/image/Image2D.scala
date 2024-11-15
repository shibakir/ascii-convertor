package model.image

import model.pixel.PixelRGB

class Image2D[T](private val pixels: Array[Array[T]]) extends Image[T] {

  def getHeight: Int = pixels.length
  def getWidth: Int = if (pixels.isEmpty) 0 else pixels(0).length

  override def getPixel(x: Int, y: Int): T = {
    validateCoordinates(x, y)
    pixels(x)(y)
  }

  override def setPixel(x: Int, y: Int, pixel: T): Unit = {
    validateCoordinates(x, y)
    pixels(x)(y) = pixel

  }

  private def validateCoordinates(x: Int, y: Int): Unit = {
    if (x < 0 || x >= getHeight || y < 0 || y >= getWidth) {
      throw new ArrayIndexOutOfBoundsException("Invalid coordinates!")
    }
  }
}
