package exporter

import model.image.Image

trait ImageExporter[T] extends Exporter[Image[T]] {}