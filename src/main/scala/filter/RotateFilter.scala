package filter

import model.pixel.Pixel
import model.image.Image

class RotateFilter() extends ImageFilter[Image[Pixel]] {

  override def apply(image: Image[Pixel]): Image[Pixel] = {

    image
  }
}