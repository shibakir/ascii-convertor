package model.grid

import scala.reflect.ClassTag
import model.dot.Dot


case class Grid[T <: Dot: ClassTag](height: Int, width: Int) {

  private val dots: Array[Array[T]] = Array.ofDim[T](height, width)

  def getDot(x: Int, y: Int): T = {
    if(x < 0 || x >= height || y < 0 || y >= width) {
      throw new ArrayIndexOutOfBoundsException(f"Invalid coordinates!")
    }
    dots(x)(y)
  }

  def setDot(x: Int, y: Int, dot: T): Unit = {
    if (x < 0 || x >= height || y < 0 || y >= width) {
      throw new ArrayIndexOutOfBoundsException(f"Invalid coordinates123!")
    }
    dots(x)(y) = dot
  }
}
