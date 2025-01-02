package importer

import model.image.Image
import model.pixel.PixelRGB

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

class FileSystemJPGImageImporterTest extends AnyFunSuite with MockitoSugar {

  test("importItem should throw an exception for invalid path") {
    val invalidPath = "dumb_image.123"
    val importer = new FileSystemJPGImageImporter(invalidPath)

    intercept[IllegalArgumentException] {
      importer.importItem()
    }
  }

  test("validatePath should throw IllegalArgumentException for non-JPG paths") {
    val invalidPath = "image.png"
    val importer = new FileSystemJPGImageImporter(invalidPath)

    intercept[IllegalArgumentException] {
      importer.validatePath()
    }
  }

  test("validatePath should throw exception for valid JPG path cause it doesnt exist") {
    val validPath = "image.jpg"
    val importer = new FileSystemJPGImageImporter(validPath)

    intercept[IllegalArgumentException] {
      importer.validatePath()
    }
  }

  test("validatePath should throw exception for valid JPEG cause it doesnt exist") {
    val validPath = "image.jpeg"
    val importer = new FileSystemJPGImageImporter(validPath)

    intercept[IllegalArgumentException] {
      importer.validatePath()
    }
  }
}
