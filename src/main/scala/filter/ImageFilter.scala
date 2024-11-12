package filter

import model.image.Image

trait ImageFilter[T] extends Filter[Image[T]] {

}