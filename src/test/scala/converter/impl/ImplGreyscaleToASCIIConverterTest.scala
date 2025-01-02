package converter.impl

import exporter.file.ascii.ASCIIToConsoleExport
import model.image.{Image, ImageASCII, ImageGS}
import model.pixel.{PixelASCII, PixelGS}
import transformation.LinearTransformationTable
import org.scalatest.funsuite.AnyFunSuite
import transformation.tables.CustomTransformation

class ImplGreyscaleToASCIIConverterTest extends AnyFunSuite {
  
  val table = CustomTransformation("@#%*+=-:. ")
  
  test("Test valid image conversion") {

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(55)),
      Seq(PixelGS(155), PixelGS(255))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)
      
    val convertor = new ImplGreyscaleToASCIIConverter(table)
  
    val expected: Seq[Seq[PixelASCII]] = Seq(
      Seq(PixelASCII('@'), PixelASCII('%')),
      Seq(PixelASCII('-'), PixelASCII(' '))
    )
    val expectedImage: Image[PixelASCII] = ImageASCII(expected)
  
    val result = convertor.convert(inputImage)
    assert(result.equals(expectedImage))
  }

  test("Test valid image with same 'dark' pixels conversion") {

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(0), PixelGS(0)),
      Seq(PixelGS(0), PixelGS(0))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val convertor = new ImplGreyscaleToASCIIConverter(table)

    val expected: Seq[Seq[PixelASCII]] = Seq(
      Seq(PixelASCII('@'), PixelASCII('@')),
      Seq(PixelASCII('@'), PixelASCII('@'))
    )
    val expectedImage: Image[PixelASCII] = ImageASCII(expected)

    val result = convertor.convert(inputImage)
    assert(result.equals(expectedImage))
  }

  test("Test valid image with same 'white' pixels conversion") {

    val input: Seq[Seq[PixelGS]] = Seq(
      Seq(PixelGS(255), PixelGS(255)),
      Seq(PixelGS(255), PixelGS(255))
    )
    val inputImage: Image[PixelGS] = ImageGS(input)

    val convertor = new ImplGreyscaleToASCIIConverter(table)

    val expected: Seq[Seq[PixelASCII]] = Seq(
      Seq(PixelASCII(' '), PixelASCII(' ')),
      Seq(PixelASCII(' '), PixelASCII(' '))
    )
    val expectedImage: Image[PixelASCII] = ImageASCII(expected)

    val result = convertor.convert(inputImage)
    assert(result.equals(expectedImage))
  }

  test("Null image conversion") {

    val convertor = new ImplGreyscaleToASCIIConverter(table)
    
    intercept[IllegalArgumentException] {
      convertor.convert(null)
    }
  }
} 
