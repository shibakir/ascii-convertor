package model.image

import model.dot.Dot

trait Image[T] {
  
  def height: Int
  def width: Int

  def getElement(x: Int, y: Int): T
}
