package model.image

import model.pixel.PixelGS

case class ImageGS(protected val pixels: Seq[Seq[PixelGS]]) extends Image2D[PixelGS] {


}