package exporter.file.ascii

import model.image.{Image, ImageASCII}
import model.pixel.PixelASCII
import org.scalatest.funsuite.AnyFunSuite

import java.io.ByteArrayOutputStream

class ASCIIToConsoleExportTest extends AnyFunSuite {

  test("Null image test") {
    val exporter = new ASCIIToConsoleExport()

    intercept[IllegalArgumentException] {
      exporter.exportData(null)
    }
  }

  test("Export basic image") {
    val exporter = new ASCIIToConsoleExport()

    val input: Seq[Seq[PixelASCII]] = Seq(
      Seq(PixelASCII('A'), PixelASCII('B')),
      Seq(PixelASCII('C'), PixelASCII('D'))
    )
    val inputImage: Image[PixelASCII] = ImageASCII(input)

    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new java.io.PrintStream(outputStream)) {
      exporter.exportData(inputImage)
    }

    val expectedOutput = "AB\nCD\n"
    assert(outputStream.toString == expectedOutput)
  }
}