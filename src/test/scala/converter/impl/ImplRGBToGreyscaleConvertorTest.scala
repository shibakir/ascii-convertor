package converter.impl

import model.image.{Image, ImageASCII, ImageGS, ImageRGB}
import model.pixel.{PixelASCII, PixelGS, PixelRGB}
import org.scalatest.funsuite.AnyFunSuite

class ImplRGBToGreyscaleConvertorTest extends AnyFunSuite {

  test("Test valid black-white image conversion") {

    val input: Seq[Seq[PixelRGB]] = Seq(
      Seq(
        PixelRGB(
          0 , 0 , 0
      ),
        PixelRGB(
          255 , 255 , 255
        )
      ),
      Seq(
        PixelRGB(
          0 , 0 , 0
        ),
        PixelRGB(
          255 , 255 , 255
        )
      )
    )
    val inputImage: Image[PixelRGB] = ImageRGB(input)

    val convertor = new ImplRGBToGreyscaleConvertor()

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(255)),
      Seq(PixelGS(0), PixelGS(255))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = convertor.convert(inputImage)
    assert(result.equals(expectedImage))
  }

  test("Test some valid image conversion") {

    val input: Seq[Seq[PixelRGB]] = Seq(
      Seq(
        PixelRGB(
          10, 20, 30
        ),
        PixelRGB(
          228, 123, 1
        )
      ),
      Seq(
        PixelRGB(
          255, 0, 255
        ),
        PixelRGB(
          0, 255, 150
        )
      )
    )
    val inputImage: Image[PixelRGB] = ImageRGB(input)

    val convertor = new ImplRGBToGreyscaleConvertor()

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(18), PixelGS(140)),
      Seq(PixelGS(105), PixelGS(166))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = convertor.convert(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Null image conversion") {

    val convertor = new ImplRGBToGreyscaleConvertor()

    intercept[IllegalArgumentException] {
      convertor.convert(null)
    }
  }
} 