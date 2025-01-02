package model.image

import model.pixel.PixelASCII
import org.scalatest.funsuite.AnyFunSuite

class ImageTest() extends AnyFunSuite {

  test("Getting width") {
    val pixels = Seq(
      Seq(PixelASCII('A'), PixelASCII('B')),
      Seq(PixelASCII('C'), PixelASCII('D'))
    )
    val image = ImageASCII(pixels)

    assert(image.getWidth == 2)
  }

  test("Getting height") {
    val pixels = Seq(
      Seq(PixelASCII('A'), PixelASCII('B')),
      Seq(PixelASCII('C'), PixelASCII('D'))
    )
    val image = ImageASCII(pixels)

    assert(image.getHeight == 2)
  }

  test("Getting pixel") {
    val pixels = Seq(
      Seq(PixelASCII('A'), PixelASCII('B')),
      Seq(PixelASCII('C'), PixelASCII('D'))
    )
    val image = ImageASCII(pixels)

    assert(image.getPixel(1, 1).toChar == 'D')

  }
  test("Getting with incorrect pixel") {
    val pixels = Seq(
      Seq(PixelASCII('A'), PixelASCII('B')),
      Seq(PixelASCII('C'), PixelASCII('D'))
    )
    val image = ImageASCII(pixels)

    intercept[ArrayIndexOutOfBoundsException] {
      image.getPixel(100, 100)
    }
  }
}