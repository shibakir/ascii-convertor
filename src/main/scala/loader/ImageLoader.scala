package loader

import model.image.Image
import model.pixel.Pixel

trait ImageLoader[T] extends Loader[Image[Pixel]] {

}