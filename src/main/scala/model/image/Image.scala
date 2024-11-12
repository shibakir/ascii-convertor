package model.image

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

trait Image[T] {

  def getHeight: Int
  def getWidth: Int
  
  def getPixel(x: Int, y: Int): T
  def setPixel(x: Int, y: Int, pixel: T): Unit
}