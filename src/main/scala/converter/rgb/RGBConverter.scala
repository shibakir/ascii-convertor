package converter.rgb

import converter.ImageConverter
import model.pixel.PixelRGB

trait RGBConverter[T] extends ImageConverter[PixelRGB, T] {}