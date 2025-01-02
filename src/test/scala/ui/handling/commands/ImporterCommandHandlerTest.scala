package ui.handling.commands

import importer.{FileSystemImage2DImporter, Image2DRandomImporter}
import ui.config.Config
import ui.filter.console.ConsoleInputFilter
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*

class ImporterCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles valid --image-random argument") {
    val importerCommandHandler: CommandHandler =
      new ImporterCommandHandler()

    val args = List("--image-random")
    val value = args.mkString(" ")
    val expectedImporter = new Image2DRandomImporter()
    val expectedConfig = new Config(
      importer = Some(expectedImporter)
    )

    val config = mock[Config]
    when(config.setImporter(any[Image2DRandomImporter])).thenReturn(expectedConfig)

    val resultConfig = importerCommandHandler.processCommand(args, config)

    assert(resultConfig.getImporter.isDefined)
    assert(resultConfig.getImporter.get.isInstanceOf[Image2DRandomImporter])
    verify(config, times(1)).setImporter(any[Image2DRandomImporter])
  }

  test("processCommand throws exception for multiple commands") {
    val importerCommandHandler: CommandHandler =
      new ImporterCommandHandler()

    val args = List("""--image "path/dumbImage.png" --image-random""")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      importerCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for no arguments") {
    val importerCommandHandler: CommandHandler =
      new ImporterCommandHandler()

    val args = List()
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      importerCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for invalid command") {
    val importerCommandHandler: CommandHandler =
      new ImporterCommandHandler()

    val args = List("--invalid-command")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      importerCommandHandler.processCommand(args, config)
    }
  }

}
