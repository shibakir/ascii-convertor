package model.image

trait Image[T] {

  def getHeight: Int
  def getWidth: Int

  def getPixel(x: Int, y: Int): T
  def setPixel(x: Int, y: Int, pixel: T): Unit
}