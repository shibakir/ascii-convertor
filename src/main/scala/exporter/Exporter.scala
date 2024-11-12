package exporter

trait Exporter[T] {
  
  def exportData(data: T): Unit
}