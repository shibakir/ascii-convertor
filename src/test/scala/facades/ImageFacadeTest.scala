package facades

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*
import ui.config.Config
import ui.handling.CommandHandler
import importer.ImageRGBImporter
import exporter.ASCIIToImageExporter
import transformation.Transformation
import ui.handling.DataHandler
import facades.ImageFacade

class ImageFacadeTest extends AnyFunSuite with MockitoSugar {

  test("setupConfig should throw exception if a command handler fails") {

    val mockCommand1 = mock[CommandHandler]
    val mockCommand2 = mock[CommandHandler]

    when(mockCommand1.handle(any[DataHandler])).thenReturn(DataHandler("args", Config()))
    when(mockCommand2.handle(any[DataHandler])).thenThrow(new RuntimeException("Command failed"))

    val commands = Seq(mockCommand1, mockCommand2)

    val thrown = intercept[RuntimeException] {
      ImageFacade.setupConfig("args", commands)
    }

    assert(thrown.getMessage == "Command failed")

    verify(mockCommand1, times(1)).handle(any[DataHandler])
    verify(mockCommand2, times(1)).handle(any[DataHandler])
  }

  test("convert should throw exception if importer is missing") {

    val config = Config(
      importer = None,
      filters = Seq(),
      transformation = Some(mock[Transformation]),
      exporters = Seq(mock[ASCIIToImageExporter])
    )

    val thrown = intercept[IllegalStateException] {
      ImageFacade.convert(config)
    }

    assert(thrown.getMessage == "Invalid configuration: importer in not defined!")
  }

  test("convert should throw exception if transformation is missing") {

    val config = Config(
      importer = Some(mock[ImageRGBImporter]),
      filters = Seq(),
      transformation = None,
      exporters = Seq(mock[ASCIIToImageExporter])
    )

    val thrown = intercept[IllegalStateException] {
      ImageFacade.convert(config)
    }

    assert(thrown.getMessage == "Invalid configuration: transformation in not defined!")
  }

  test("convert should throw exception if there is no exporters") {

    val config = Config(
      importer = Some(mock[ImageRGBImporter]),
      filters = Seq(),
      transformation = Some(mock[Transformation]),
      exporters = Seq()
    )

    val thrown = intercept[IllegalStateException] {
      ImageFacade.convert(config)
    }

    assert(thrown.getMessage == "Invalid configuration: no exporters are defined!")
  }
}
