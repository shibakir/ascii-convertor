package converter.ascii

import converter.ImageConverter
import model.image.Image
import model.pixel.PixelASCII

trait ASCIIConverter[T] extends ImageConverter[Image[PixelASCII], T] {}