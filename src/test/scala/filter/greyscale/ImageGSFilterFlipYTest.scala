package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS
import org.scalatest.funsuite.AnyFunSuite

class ImageGSFilterFlipYTest() extends AnyFunSuite {

  test("Image with multiple rows and columns") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6)),
      Seq(PixelGS(7), PixelGS(8), PixelGS(9))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(7), PixelGS(8), PixelGS(9)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6)),
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Flip an empty image") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq()
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq()
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Single pixel image") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq(Seq(PixelGS(0)))
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(Seq(PixelGS(0)))
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Image with a row of pixels") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3), PixelGS(4))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Image with multiple rows and one column") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1)),
      Seq(PixelGS(2)),
      Seq(PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(3)),
      Seq(PixelGS(2)),
      Seq(PixelGS(1))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Image with single column") {
    val filter = new ImageGSFilterFlipY()

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Null image") {
    val filter = new ImageGSFilterFlipY()

    intercept[IllegalArgumentException] {
      filter.apply(null)
    }
  }
}