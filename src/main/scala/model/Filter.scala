package model

// type image or its inheritors
trait Filter[T <: Image] {

  def apply(image: T): T
}
