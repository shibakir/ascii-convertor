package model.pixel

case class PixelRGB(
                    private var r: Int,
                    private var  g: Int,
                    private var b: Int
                                        ) extends Pixel {

  def getRed: Int = r
  def getGreen: Int = g
  def getBlue: Int = b
  
  def setRed(red: Int): Unit = { r = validateColorValue(red) }

  def setGreen(green: Int): Unit = { g = validateColorValue(green) }

  def setBlue(blue: Int): Unit = { b = validateColorValue(blue) }
  
  override def toInt: Int = { (r << 16) | (g << 8) | b }

  private def validateColorValue(value: Int): Int = {
    if (value < 0) 0
    else if (value > 255) 255
    else value
  }
}
