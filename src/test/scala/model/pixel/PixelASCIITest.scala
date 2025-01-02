package model.pixel

import org.scalatest.funsuite.AnyFunSuite

class PixelASCIITest extends AnyFunSuite {

  test("Test ascii pixel initialization") {

    val pixel = PixelASCII('A')
    assert(pixel.symbol == 'A')
  }

  test("Test conversion to int method") {

    val pixel = PixelASCII('B')
    assert(pixel.toInt == 8)
  }

  test("Test conversion to char method") {

    val pixel = PixelASCII('C')
    assert(pixel.toChar == 'C')
  }

  test("Test conversion to char with # character") {

    val pixel1 = PixelASCII('#')
    assert(pixel1.toChar == '#')
  }

  test("Test conversion to char with \n character") {

    val pixel4 = PixelASCII('\n')
    assert(pixel4.toChar == '\n')
  }
}
