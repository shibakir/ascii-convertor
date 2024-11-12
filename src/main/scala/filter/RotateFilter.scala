package filter

import model.pixel.Pixel
import model.image.Image

case class RotateFilter() extends ImageFilter[Pixel] {

  override def apply(image: Image[Pixel]): Image[Pixel] = {
    
    image
  }
}