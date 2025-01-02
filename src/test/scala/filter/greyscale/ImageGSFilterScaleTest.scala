package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS
import org.scalatest.funsuite.AnyFunSuite

class ImageGSFilterScaleTest extends AnyFunSuite {

  test("Unsupported scale double value = 2.0") {
    val filter = new ImageGSFilterScale(2.0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Unsupported scale int value = 5") {
    val filter = new ImageGSFilterScale(5)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Unsupported scale double value = 1.5 with invalid image") {
    val filter = new ImageGSFilterScale(1.5)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq()
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Unsupported scale int value = 7 with invalid image") {
    val filter = new ImageGSFilterScale(7)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq()
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }

  test("Null image") {
    val filter = new ImageGSFilterScale(1.0)

    intercept[IllegalArgumentException] {
      filter.apply(null)
    }
  }

  test("Scale by 0.25") {
    val filter = new ImageGSFilterScale(0.25)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6), PixelGS(7), PixelGS(8)),
      Seq(PixelGS(9), PixelGS(10), PixelGS(11), PixelGS(12)),
      Seq(PixelGS(13), PixelGS(14), PixelGS(15), PixelGS(16))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(3)),
      Seq(PixelGS(9), PixelGS(11))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Scale by 1.0") {
    val filter = new ImageGSFilterScale(1.0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Scale by 4.0") {
    val filter = new ImageGSFilterScale(4.0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(1), PixelGS(2), PixelGS(2)),
      Seq(PixelGS(1), PixelGS(1), PixelGS(2), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(3), PixelGS(4), PixelGS(4)),
      Seq(PixelGS(3), PixelGS(3), PixelGS(4), PixelGS(4))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Single pixel scale") {
    val filter = new ImageGSFilterScale(4.0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(5))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(5), PixelGS(5)),
      Seq(PixelGS(5), PixelGS(5))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Scale with unsupported value throws exception") {
    val filter = new ImageGSFilterScale(2.0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    intercept[IllegalArgumentException] {
      filter.apply(inputImage)
    }
  }
}