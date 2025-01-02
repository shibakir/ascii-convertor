package ui.filter

trait Filter[T] {
  
  def filter(input: T): T
}