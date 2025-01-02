package model.image

trait Image[T] {

  def getHeight: Int
  def getWidth: Int

  def getPixel(x: Int, y: Int): T
}