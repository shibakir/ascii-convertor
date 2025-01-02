package ui.handling.commands

import exporter.file.ascii.{ASCIIToConsoleExport, ASCIIToFileExport}
import ui.config.Config
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*

class ExporterCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles valid --output-console argument") {
    val exporterCommandHandler: CommandHandler =
      new ExporterCommandHandler()

    val args = List("--output-console")
    val value = args.mkString(" ")
    val expectedExporter = new ASCIIToConsoleExport()
    val expectedConfig = new Config(
      exporters = Seq(expectedExporter)
    )

    val config = mock[Config]
    when(config.addExporter(any[ASCIIToConsoleExport])).thenReturn(expectedConfig)

    val data = DataHandler(value, config)
    val resultConfig = exporterCommandHandler.processCommand(args, config)

    assert(resultConfig.getExporters.size == 1)
    assert(resultConfig.getExporters.head.isInstanceOf[ASCIIToConsoleExport])
    verify(config, times(1)).addExporter(any[ASCIIToConsoleExport])
  }

  test("processCommand throws exception for no arguments") {
    val exporterCommandHandler: CommandHandler =
      new ExporterCommandHandler()

    val args = List()
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      exporterCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for invalid argument") {
    val exporterCommandHandler: CommandHandler =
      new ExporterCommandHandler()

    val args = List("--output-unknown", "value")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      exporterCommandHandler.processCommand(args, config)
    }
  }
}
