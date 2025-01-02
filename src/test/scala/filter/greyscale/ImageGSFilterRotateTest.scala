package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS
import org.scalatest.funsuite.AnyFunSuite

class ImageGSFilterRotateTest extends AnyFunSuite {

  test("Rotate 0 degrees") {
    val filter = new ImageGSFilterRotate(0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 90 degrees") {
    val filter = new ImageGSFilterRotate(90)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1)),
      Seq(PixelGS(2)),
      Seq(PixelGS(3))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 180 degrees") {
    val filter = new ImageGSFilterRotate(180)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(3), PixelGS(2), PixelGS(1))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 270 degrees") {
    val filter = new ImageGSFilterRotate(270)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
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

  test("Rotate 360 degrees") {
    val filter = new ImageGSFilterRotate(360)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 0 degrees for square image") {
    val filter = new ImageGSFilterRotate(0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 90 degrees for square image") {
    val filter = new ImageGSFilterRotate(90)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(3), PixelGS(1)),
      Seq(PixelGS(4), PixelGS(2))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 180 degrees for square image") {
    val filter = new ImageGSFilterRotate(180)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(4), PixelGS(3)),
      Seq(PixelGS(2), PixelGS(1))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 270 degrees for square image") {
    val filter = new ImageGSFilterRotate(270)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(2), PixelGS(4)),
      Seq(PixelGS(1), PixelGS(3))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 360 degrees for square image") {
    val filter = new ImageGSFilterRotate(360)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 0 degrees for 2x3 rectangle image") {
    val filter = new ImageGSFilterRotate(0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 90 degrees for 2x3 rectangle image") {
    val filter = new ImageGSFilterRotate(90)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(4), PixelGS(1)),
      Seq(PixelGS(5), PixelGS(2)),
      Seq(PixelGS(6), PixelGS(3))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 180 degrees for 2x3 rectangle image") {
    val filter = new ImageGSFilterRotate(180)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(6), PixelGS(5), PixelGS(4)),
      Seq(PixelGS(3), PixelGS(2), PixelGS(1))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 270 degrees for 2x3 rectangle image") {
    val filter = new ImageGSFilterRotate(270)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(3), PixelGS(6)),
      Seq(PixelGS(2), PixelGS(5)),
      Seq(PixelGS(1), PixelGS(4))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 360 degrees for 2x3 rectangle image") {
    val filter = new ImageGSFilterRotate(360)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2), PixelGS(3)),
      Seq(PixelGS(4), PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 0 degrees for 3x2 rectangle image") {
    val filter = new ImageGSFilterRotate(0)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Rotate 90 degrees for 3x2 rectangle image") {
    val filter = new ImageGSFilterRotate(90)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(5), PixelGS(3), PixelGS(1)),
      Seq(PixelGS(6), PixelGS(4), PixelGS(2))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 180 degrees for 3x2 rectangle image") {
    val filter = new ImageGSFilterRotate(180)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(6), PixelGS(5)),
      Seq(PixelGS(4), PixelGS(3)),
      Seq(PixelGS(2), PixelGS(1))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 270 degrees for 3x2 rectangle image") {
    val filter = new ImageGSFilterRotate(270)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val expected: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(2), PixelGS(4), PixelGS(6)),
      Seq(PixelGS(1), PixelGS(3), PixelGS(5))
    )
    val expectedImage: Image[PixelGS] = ImageGS(expected)

    val result = filter.apply(inputImage)

    assert(result.equals(expectedImage))
  }

  test("Rotate 360 degrees for 3x2 rectangle image") {
    val filter = new ImageGSFilterRotate(360)

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(1), PixelGS(2)),
      Seq(PixelGS(3), PixelGS(4)),
      Seq(PixelGS(5), PixelGS(6))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
    val expected = inputImage

    val result = filter.apply(inputImage)

    assert(result.equals(expected))
  }

  test("Null image") {
    val filter = new ImageGSFilterRotate(5)

    intercept[IllegalArgumentException] {
      filter.apply(null)
    }
  }
}