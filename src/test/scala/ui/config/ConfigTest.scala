package ui.config

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*
import importer.ImageRGBImporter
import filter.greyscale.ImageGSFilter
import exporter.ASCIIToImageExporter
import transformation.Transformation

class ConfigTest extends AnyFunSuite with MockitoSugar {
  
  val mockImporter: ImageRGBImporter = mock[ImageRGBImporter]
  val mockTransformation: Transformation = mock[Transformation]
  val mockFilter1: ImageGSFilter = mock[ImageGSFilter]
  val mockFilter2: ImageGSFilter = mock[ImageGSFilter]
  val mockExporter1: ASCIIToImageExporter = mock[ASCIIToImageExporter]
  val mockExporter2: ASCIIToImageExporter = mock[ASCIIToImageExporter]

  test("setImporter should return new Config with importer set") {
    val config = Config()
    val newConfig = config.setImporter(mockImporter)

    assert(newConfig.getImporter.contains(mockImporter), "Importer should be set")
    assert(newConfig.getFilters == config.getFilters, "Filters should remain unchanged")
    assert(newConfig.getTransformation == config.getTransformation, "Transformation should remain unchanged")
    assert(newConfig.getExporters == config.getExporters, "Exporters should remain unchanged")
    assert(config.getImporter.isEmpty, "Original Config importer should remain unchanged")
  }

  test("addFilter should return new Config with filter added") {
    val config = Config()
    val newConfig = config.addFilter(mockFilter1)

    assert(newConfig.getFilters.contains(mockFilter1), "Filter should be added")
    assert(newConfig.getImporter == config.getImporter, "Importer should remain unchanged")
    assert(newConfig.getTransformation == config.getTransformation, "Transformation should remain unchanged")
    assert(newConfig.getExporters == config.getExporters, "Exporters should remain unchanged")
    assert(config.getFilters.isEmpty, "Original Config filters should remain unchanged")
  }

  test("setTransformation should return new Config with transformation set") {
    val config = Config()
    val newConfig = config.setTransformation(mockTransformation)

    assert(newConfig.getTransformation.contains(mockTransformation), "Transformation should be set")
    assert(newConfig.getImporter == config.getImporter, "Importer should remain unchanged")
    assert(newConfig.getFilters == config.getFilters, "Filters should remain unchanged")
    assert(newConfig.getExporters == config.getExporters, "Exporters should remain unchanged")
    assert(config.getTransformation.isEmpty, "Original Config transformation should remain unchanged")
  }

  test("addExporter should return new Config with exporter added") {
    val config = Config()
    val newConfig = config.addExporter(mockExporter1)

    assert(newConfig.getExporters.contains(mockExporter1), "Exporter should be added")
    assert(newConfig.getImporter == config.getImporter, "Importer should remain unchanged")
    assert(newConfig.getFilters == config.getFilters, "Filters should remain unchanged")
    assert(newConfig.getTransformation == config.getTransformation, "Transformation should remain unchanged")
    assert(config.getExporters.isEmpty, "Original Config exporters should remain unchanged")
  }

  test("validateBeforeConversion should throw IllegalStateException if importer is missing") {
    val config = Config(
      importer = None,
      filters = Seq(mockFilter1),
      transformation = Some(mockTransformation),
      exporters = Seq(mockExporter1)
    )

    val thrown = intercept[IllegalStateException] {
      config.validateBeforeConversion()
    }

    assert(thrown.getMessage == "Invalid configuration: importer in not defined!")
  }

  test("validateBeforeConversion should throw IllegalStateException if exporters are missing") {
    val config = Config(
      importer = Some(mockImporter),
      filters = Seq(mockFilter1),
      transformation = Some(mockTransformation),
      exporters = Seq()
    )

    val thrown = intercept[IllegalStateException] {
      config.validateBeforeConversion()
    }

    assert(thrown.getMessage == "Invalid configuration: no exporters are defined!")
  }

  test("validateBeforeConversion should throw IllegalStateException if transformation is missing") {
    val config = Config(
      importer = Some(mockImporter),
      filters = Seq(mockFilter1),
      transformation = None,
      exporters = Seq(mockExporter1)
    )

    val thrown = intercept[IllegalStateException] {
      config.validateBeforeConversion()
    }

    assert(thrown.getMessage == "Invalid configuration: transformation in not defined!")
  }

  test("getImporter should return the correct importer") {
    val config = Config(
      importer = Some(mockImporter),
      filters = Seq(),
      transformation = None,
      exporters = Seq()
    )

    assert(config.getImporter.contains(mockImporter), "Importer should be retrieved correctly")
  }

  test("getFilters should return the correct filters") {
    val config = Config(
      importer = None,
      filters = Seq(mockFilter1, mockFilter2),
      transformation = None,
      exporters = Seq()
    )

    assert(config.getFilters.contains(mockFilter1), "First filter should be present")
    assert(config.getFilters.contains(mockFilter2), "Second filter should be present")
    assert(config.getFilters.size == 2, "Filters size should be 2")
  }

  test("getTransformation should return the correct transformation") {
    val config = Config(
      importer = None,
      filters = Seq(),
      transformation = Some(mockTransformation),
      exporters = Seq()
    )

    assert(config.getTransformation.contains(mockTransformation), "Transformation should be retrieved correctly")
  }

  test("getExporters should return the correct exporters") {
    val config = Config(
      importer = None,
      filters = Seq(),
      transformation = None,
      exporters = Seq(mockExporter1, mockExporter2)
    )

    assert(config.getExporters.contains(mockExporter1), "First exporter should be present")
    assert(config.getExporters.contains(mockExporter2), "Second exporter should be present")
    assert(config.getExporters.size == 2, "Exporters size should be 2")
  }

  test("setImporter should not affect the original Config instance") {
    val originalConfig = Config()
    val newConfig = originalConfig.setImporter(mockImporter)

    assert(originalConfig.getImporter.isEmpty, "Original Config importer should remain unchanged")
    assert(newConfig.getImporter.contains(mockImporter), "New Config importer should be set")
  }

  test("addFilter should not affect the original Config instance") {
    val originalConfig = Config()
    val newConfig = originalConfig.addFilter(mockFilter1)

    assert(originalConfig.getFilters.isEmpty, "Original Config filters should remain unchanged")
    assert(newConfig.getFilters.contains(mockFilter1), "New Config filters should contain the added filter")
  }

  test("setTransformation should not affect the original Config instance") {
    val originalConfig = Config()
    val newConfig = originalConfig.setTransformation(mockTransformation)

    assert(originalConfig.getTransformation.isEmpty, "Original Config transformation should remain unchanged")
    assert(newConfig.getTransformation.contains(mockTransformation), "New Config transformation should be set")
  }

  test("addExporter should not affect the original Config instance") {
    val originalConfig = Config()
    val newConfig = originalConfig.addExporter(mockExporter1)

    assert(originalConfig.getExporters.isEmpty, "Original Config exporters should remain unchanged")
    assert(newConfig.getExporters.contains(mockExporter1), "New Config exporters should contain the added exporter")
  }

  test("addFilter should allow adding multiple filters") {
    val config = Config()
    val configWithFilter1 = config.addFilter(mockFilter1)
    val configWithFilters = configWithFilter1.addFilter(mockFilter2)

    assert(configWithFilters.getFilters.contains(mockFilter1), "Filters should contain  first added filter")
    assert(configWithFilters.getFilters.contains(mockFilter2), "Filters should contain second added filter")
    assert(configWithFilters.getFilters.size == 2, "Filters seq size should be 2")
  }

  test("addExporter should allow adding multiple exporters") {
    val config = Config()
    val configWithExporter1 = config.addExporter(mockExporter1)
    val configWithExporters = configWithExporter1.addExporter(mockExporter2)

    assert(configWithExporters.getExporters.contains(mockExporter1), "Exporters should contain the first added exporter")
    assert(configWithExporters.getExporters.contains(mockExporter2), "Exporters should contain the second added exporter")
    assert(configWithExporters.getExporters.size == 2, "Exporters seq size should be 2")
  }

  test("Initial Config should have no importer, no filters, no transformation, and no exporters") {
    val config = Config()

    assert(config.getImporter.isEmpty, "Importer should be empty")
    assert(config.getFilters.isEmpty, "Filters should be empty")
    assert(config.getTransformation.isEmpty, "Transformation should be empty")
    assert(config.getExporters.isEmpty, "Exporters should be empty")
  }
}
