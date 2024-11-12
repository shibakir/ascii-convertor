package filter

import filter.Filter
import model.image.Image
import model.pixel.Pixel

trait ImageFilter[T] extends Filter[Image[Pixel]] {

}