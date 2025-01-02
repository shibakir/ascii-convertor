package importer

import model.image.Image

trait Importer [T] {

  def importItem(): T
}
