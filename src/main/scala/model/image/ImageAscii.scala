package model.image

import model.grid.Grid
import model.dot.DotAscii

case class ImageAscii(grid: Grid[DotAscii]) extends Image {

  override def height: Int = grid.height
  override def width: Int = grid.width

  override def getElement(x: Int, y: Int): DotAscii = {
    grid.getDot(x, y)
  }
}
