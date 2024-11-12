package importer

import model.image.Image
import model.image.Image2D
import model.pixel.PixelRGB

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File


class FileSystemImageImporter(path: String) extends Image2DImporter {

  override def importImage(): Image2D[PixelRGB] = {

    val file = new File(path)
    val bufferedImage: BufferedImage = ImageIO.read(file)

    val width = bufferedImage.getWidth
    val height = bufferedImage.getHeight

    val image = Image2D[PixelRGB](Array.ofDim[PixelRGB](height, width))

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val color = bufferedImage.getRGB(x, y)
        val r = (color >> 16) & 255
        val g = (color >> 8) & 255
        val b = color & 255
        // image(y)(x) = PixelRGB(r, g, b)
        image.setPixel(y, x, PixelRGB(r, g, b))
      }
    }
    image
  }
}