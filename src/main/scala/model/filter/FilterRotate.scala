package model.filter

import model.image.Image

case class FilterRotate(angle: Int) extends Filter[Image] {

  override def apply(image: Image): Image = {
    image
  }
}