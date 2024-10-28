package model.image

import model.dot.Dot

trait Image {
  
  def height: Int
  def width: Int

  def getElement(x: Int, y: Int): Dot
}