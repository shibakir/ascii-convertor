package converter

trait ImageConverter[A, B] {
  
  def convert(image: A): B
}