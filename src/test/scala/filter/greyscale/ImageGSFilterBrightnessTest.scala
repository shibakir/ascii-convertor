package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS
import org.scalatest.funsuite.AnyFunSuite

class ImageGSFilterBrightnessTest extends AnyFunSuite {

  test("Image with multiple rows and columns") {
    val filter = new ImageGSFilterBrightness(100)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(1)),
      Seq(PixelGS(2), PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(100), PixelGS(101)),
      Seq(PixelGS(102), PixelGS(103))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Test that brightness value cant be bigger than 255") {
    val filter = new ImageGSFilterBrightness(100)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(250), PixelGS(200))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(255), PixelGS(255)),
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)
    
    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Test that brightness value cant be smaller than 0") {
    val filter = new ImageGSFilterBrightness(-50)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(10), PixelGS(49))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(0)),
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Null image") {
    val filter = new ImageGSFilterBrightness(5)

    intercept[IllegalArgumentException] {
      filter.apply(null)
    }
  }
}
