package converter.ascii

import converter.ImageConverter
import model.pixel.PixelASCII

trait ASCIIConverter[T] extends ImageConverter[PixelASCII, T] {}