package model.image

import model.pixel.Pixel

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

trait Image[T <: Pixel] {

  def getHeight: Int
  def getWidth: Int
  
  def getPixel(x: Int, y: Int): T
  def setPixel(x: Int, y: Int, pixel: T): Unit
  
  def saveAsPng(outputPath: String = "template/output/output.png"): Unit = {
    val bufferedImage = new BufferedImage(getWidth, getHeight, BufferedImage.TYPE_INT_RGB)

    for (y <- 0 until getHeight) {
      for (x <- 0 until getWidth) {
        val pixel = getPixel(x, y)
        val rgb = pixel.toInt
        bufferedImage.setRGB(x, y, rgb)
      }
    }

    val outputFile = new File(outputPath)
    outputFile.getParentFile.mkdirs()
    ImageIO.write(bufferedImage, "png", outputFile)
  }
}