package model.image

import model.pixel.PixelRGB

case class ImageRGB(protected val pixels: Seq[Seq[PixelRGB]]) extends Image2D[PixelRGB] {


}