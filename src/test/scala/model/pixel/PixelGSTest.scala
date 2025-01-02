package model.pixel

import org.scalatest.funsuite.AnyFunSuite

class PixelGSTest extends AnyFunSuite {

  test("Test valid grayscale pixel value") {

    val pixel = PixelGS(100)
    assert(pixel.symbol == 100)
  }

  test("Test toInt conversion") {

    val pixel = PixelGS(150)
    assert(pixel.toInt == 150)
  }

  test("Test boundary value 0") {

    val pixel = PixelGS(0)
    assert(pixel.toInt == 0)
  }

  test("Test boundary value 255") {

    val pixel = PixelGS(255)
    assert(pixel.toInt == 255)
  }

  test("Test invalid value > 255") {

    val pixel = PixelGS(300)
    assert(pixel.toInt == 300)
  }

  test("Test invalid value < 0") {

    val pixel = PixelGS(-50)
    assert(pixel.toInt == -50)
  }
}
