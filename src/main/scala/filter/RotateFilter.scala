package filter

import model.pixel.Pixel
import model.image.{Image, Image2D}

case class RotateFilter() extends ImageFilter[Image2D[Pixel]] {

  override def apply(image: Image): Image = {
    
    image
  }
}