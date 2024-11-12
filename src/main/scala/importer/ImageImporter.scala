package importer

import model.image.Image
import model.pixel.Pixel

trait ImageImporter[T <: Image] extends Importer[T] {
  
  def importImage(): T
}
