package model.pixel

case class PixelASCII(symbol: Char) extends Pixel {

  override def toInt: Int = 8
  def toChar: Char = symbol
}
