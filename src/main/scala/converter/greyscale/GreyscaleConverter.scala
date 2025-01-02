package converter.greyscale

import converter.ImageConverter
import model.pixel.PixelGS

trait GreyscaleConverter[T] extends ImageConverter[PixelGS, T] {}