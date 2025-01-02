package model.pixel

import org.scalatest.funsuite.AnyFunSuite

case class PixelRGBTest() extends AnyFunSuite {

  test("Test RGB get red value") {
    val pixel = PixelRGB(1, 2, 3)

    assert(pixel.getRed == 1)
  }

  test("Test RGB get green value") {
    val pixel = PixelRGB(1, 2, 3)

    assert(pixel.getGreen == 2)
  }

  test("Test RGB get blue value") {
    val pixel = PixelRGB(1, 2, 3)

    assert(pixel.getBlue == 3)
  }

  test("Test setting RGB values within valid range") {
    val pixel = PixelRGB(100, 150, 200)

    pixel.setRed(50)
    pixel.setGreen(100)
    pixel.setBlue(150)

    assert(pixel.getRed == 50)
    assert(pixel.getGreen == 100)
    assert(pixel.getBlue == 150)
  }

  test("Test setting RGB values below 0") {
    val pixel = PixelRGB(100, 150, 200)

    pixel.setRed(-10)
    pixel.setGreen(-20)
    pixel.setBlue(-30)

    assert(pixel.getRed == 0)
    assert(pixel.getGreen == 0)
    assert(pixel.getBlue == 0)
  }

  test("Test setting RGB values above 255") {
    val pixel = PixelRGB(100, 150, 200)

    pixel.setRed(999)
    pixel.setGreen(999)
    pixel.setBlue(999)

    assert(pixel.getRed == 255)
    assert(pixel.getGreen == 255)
    assert(pixel.getBlue == 255)
  }

  test("Test toInt conversion") {
    val pixel = PixelRGB(100, 150, 200)

    val expectedInt = (100 << 16) | (150 << 8) | 200
    assert(pixel.toInt == expectedInt)
  }
}
