package filter

import filter.Filter
import model.image.Image

trait ImageFilter[T] extends Filter[Image[T]] {

}