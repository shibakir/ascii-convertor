package converter.rgb

import converter.ImageConverter
import model.image.Image
import model.pixel.PixelRGB

trait RGBConverter[T] extends ImageConverter[Image[PixelRGB], T] {

}