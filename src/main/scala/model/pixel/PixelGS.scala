package model.pixel

case class PixelGS(symbol: Int) extends Pixel {

  override def toInt: Int = symbol
}
