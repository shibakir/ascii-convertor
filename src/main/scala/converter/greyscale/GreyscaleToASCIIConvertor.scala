package converter.greyscale

import model.image.Image
import model.pixel.PixelASCII

trait GreyscaleToASCIIConvertor extends GreyscaleConverter[Image[PixelASCII]] {}