package model.pixel

case class PixelRGB(r: Int, g: Int, b: Int) extends Pixel {

  override def toInt: Int = {
    
    (r << 16) | (g << 8) | b
  }
}
