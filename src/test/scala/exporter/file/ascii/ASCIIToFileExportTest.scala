package exporter.file.ascii

import model.image.{Image, ImageASCII}
import model.pixel.PixelASCII
import org.scalatest.funsuite.AnyFunSuite

import java.io.File
import java.nio.file.Files

class ASCIIToFileExportTest extends AnyFunSuite {

  test("Export basic test") {

    val input: Seq[Seq[PixelASCII]] = Seq(
      Seq(PixelASCII('a'), PixelASCII('b')),
      Seq(PixelASCII('c'), PixelASCII('d')),
    )
    val image: Image[PixelASCII] = ImageASCII(input)

    val tempFile = Files.createTempFile("test", ".txt")
    val path = tempFile.toString

    val exporter = new ASCIIToFileExport(path)
    exporter.exportData(image)

    val file = new File(path)
    val lines = scala.io.Source.fromFile(file).getLines.toList

    assert(lines == List("ab", "cd"))
    file.delete()
  }

  test("Null image test") {
    val exporter = new ASCIIToFileExport("pic/test.txt")

    intercept[IllegalArgumentException] {
      exporter.exportData(null)
    }
  }
}