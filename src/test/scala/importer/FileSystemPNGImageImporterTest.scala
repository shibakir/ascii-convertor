package importer

import model.image.Image
import model.pixel.PixelRGB

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar


class FileSystemPNGImageImporterTest extends AnyFunSuite with MockitoSugar {

  test("importItem should throw an exception for invalid path") {
    val invalidPath = "dumb_image"
    val importer = new FileSystemPNGImageImporter(invalidPath)

    intercept[IllegalArgumentException] {
      importer.importItem()
    }
  }

  test("validatePath should throw IllegalArgumentException for non png paths") {
    val invalidPath = "image.jpg"
    val importer = new FileSystemPNGImageImporter(invalidPath)

    intercept[IllegalArgumentException] {
      importer.validatePath()
    }
  }

  test("validatePath should throw exception for valid png path cause it doesnt exits") {
    val validPath = "image.png"
    val importer = new FileSystemPNGImageImporter(validPath)

    intercept[IllegalArgumentException] {
      importer.validatePath()
    }
  }
}
