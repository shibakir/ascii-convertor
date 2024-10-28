package model.filter

import model.image.Image

// type image or its inheritors
trait Filter[T <: Image] {

  def apply(image: T): T
}
