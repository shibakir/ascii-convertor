package converter

trait Converter[A, B] {

  def convert(image: A): B
}