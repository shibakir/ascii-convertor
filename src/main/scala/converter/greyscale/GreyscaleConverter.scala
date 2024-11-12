package converter.greyscale

import converter.ImageConverter
import model.image.Image

trait GreyscaleConverter[T] extends ImageConverter[Image[Int], T] {}