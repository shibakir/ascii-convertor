package model.image

import model.pixel.PixelASCII

case class ImageASCII(protected val pixels: Seq[Seq[PixelASCII]]) extends Image2D[PixelASCII] {


}