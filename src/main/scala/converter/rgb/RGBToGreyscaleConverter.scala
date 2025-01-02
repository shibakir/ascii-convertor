package converter.rgb

import model.image.Image
import model.pixel.PixelGS

trait RGBToGreyscaleConverter extends RGBConverter[Image[PixelGS]] {}