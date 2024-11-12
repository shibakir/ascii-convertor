package importer

import model.image.Image
import model.pixel.Pixel

trait ImageImporter[T] extends Importer[Image] {
  
  def importImage(): Image
}
