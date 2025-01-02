package model.image

import model.pixel.Pixel

trait Image2D[T <: Pixel] extends Image[T] {

  protected val pixels: Seq[Seq[T]] // 2D image
  
  def getHeight: Int = pixels.length
  def getWidth: Int = if (pixels.isEmpty) 0 else pixels.head.length

  override def getPixel(x: Int, y: Int): T = {
    validateCoordinates(x, y)
    pixels(x)(y)
  }

  private def validateCoordinates(x: Int, y: Int): Unit = {
    if (x < 0 || x >= getHeight || y < 0 || y >= getWidth) {
      throw new ArrayIndexOutOfBoundsException("Invalid coordinates!")
    }
  }
}
