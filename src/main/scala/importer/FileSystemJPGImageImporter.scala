package importer

import model.image.Image
import model.pixel.PixelRGB

class FileSystemJPGImageImporter(path: String) extends FileSystemImage2DImporter(path) {

  override def importItem(): Image[PixelRGB] = {
    validatePath()
    super.importItem()
  }

  override def validatePath() : Unit = {
    super.validatePath()
    if (!path.toLowerCase.endsWith(".jpg") && !path.toLowerCase.endsWith(".jpeg")) {
      throw new IllegalArgumentException(s"File at '$path' is not a valid JPG image.")
    }
  }
}