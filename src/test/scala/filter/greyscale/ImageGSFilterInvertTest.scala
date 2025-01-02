package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS
import org.scalatest.funsuite.AnyFunSuite

class ImageGSFilterInvertTest() extends AnyFunSuite {

  test("Image with multiple rows and columns") {
    val filter = new ImageGSFilterInvert()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(128), PixelGS(255)),
      Seq(PixelGS(255), PixelGS(128), PixelGS(0))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(255), PixelGS(127), PixelGS(0)),
      Seq(PixelGS(0), PixelGS(127), PixelGS(255))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Invert an empty image") {
    val filter = new ImageGSFilterInvert()

    val input: Seq[Seq[PixelGS]] = Seq()
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq()
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Single pixel image") {
    val filter = new ImageGSFilterInvert()

    val input: Seq[Seq[PixelGS]] = Seq(Seq(PixelGS(128)))
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(Seq(PixelGS(127)))
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Image with a row of pixels") {
    val filter = new ImageGSFilterInvert()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(255), PixelGS(128), PixelGS(0), PixelGS(64))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(127), PixelGS(255), PixelGS(191))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Image with multiple rows and one column") {
    val filter = new ImageGSFilterInvert()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(255)),
      Seq(PixelGS(128)),
      Seq(PixelGS(0))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0)),
      Seq(PixelGS(127)),
      Seq(PixelGS(255))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Null image") {
    val filter = new ImageGSFilterInvert()

    intercept[IllegalArgumentException] {
      filter.apply(null)
    }
  }
}