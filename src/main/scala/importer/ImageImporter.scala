package importer

import model.image.Image

trait ImageImporter[T] extends Importer[Image[T]] {}
