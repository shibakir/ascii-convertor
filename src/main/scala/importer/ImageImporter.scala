package importer

import model.image.Image
import model.pixel.Pixel

trait ImageImporter[T <: Pixel] extends FileSystemImporter[Image[T]] {

  
}