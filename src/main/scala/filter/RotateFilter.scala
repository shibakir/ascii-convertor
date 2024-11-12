package filter

import model.dot.Dot
import model.image.Image

case class RotateFilter() extends ImageFilter[Dot] {

  override def apply(image: Image[Dot]): Image[Dot] = {
    image
  }
}