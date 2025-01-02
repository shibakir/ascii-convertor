package importer

import model.image.{Image, ImageRGB}
import model.pixel.PixelRGB

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.{File, FileNotFoundException, IOException}
import java.nio.file.{Files, Paths}
import scala.collection.mutable.ArrayBuffer

trait FileSystemImage2DImporter(path: String) extends ImageRGBImporter {

  override def importItem(): Image[PixelRGB] = {
    try {
      val file = new File(path)
      if (!file.exists()) {
        throw new FileNotFoundException(s"Importer: File not found: $path")
      }
      
      val bufferedImage: BufferedImage = ImageIO.read(file)
      if (bufferedImage == null) {
        throw new IOException(s"Importer: Could not read image from file: $path")
      }

      val width = bufferedImage.getWidth
      val height = bufferedImage.getHeight
      val pixels: ArrayBuffer[Seq[PixelRGB]] = ArrayBuffer.empty

      for (y <- 0 until height) {
        val row = ArrayBuffer[PixelRGB]()
        for (x <- 0 until width) {
          try {
            val color = bufferedImage.getRGB(x, y)
            val r = (color >> 16) & 255
            val g = (color >> 8) & 255
            val b = color & 255
            row += PixelRGB(r, g, b)
          } catch {
            case e: Exception =>
              throw new RuntimeException(s"Importer: Error processing pixel at ($x, $y): ${e.getMessage}") 
          }
        }
        pixels += row.toSeq
      }
      val image: Image[PixelRGB] = ImageRGB(pixels.toSeq)
      image
      
    } catch {
      case e: Exception =>
        throw e
    }
  }
  
  def validatePath(): Unit = {
    if (!Files.exists(Paths.get(path))) {
      throw new IllegalArgumentException(s"File at path '${path}' does not exist.")
    }

    if (!Files.isRegularFile(Paths.get(path))) {
      throw new IllegalArgumentException(s"Path '${path}' does not point to a file.")
    }

    if (!Files.isReadable(Paths.get(path))) {
      throw new IllegalArgumentException(s"File at path '${path}' is not readable.")
    }
  }
}