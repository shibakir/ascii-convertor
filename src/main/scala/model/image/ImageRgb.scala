package model.image

import model.grid.Grid
import model.dot.DotRgb

case class ImageRgb(grid: Grid[DotRgb]) extends Image {

  override def height: Int = grid.height
  override def width: Int = grid.width
  
  override def getElement(x: Int, y: Int): DotRgb = {
    grid.getDot(x, y)
  }
}
