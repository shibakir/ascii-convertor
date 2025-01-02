package ui.handling.commands

import filter.greyscale.{ImageGSFilterFlipX, ImageGSFilterFlipY}
import ui.config.Config
import ui.filter.console.ConsoleInputFilter
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*

class FlipFilterCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles valid --flip x argument") {
    val flipCommandHandler: CommandHandler =
      new FlipFilterCommandHandler()

    val args = List("--flip x")
    val value = args.mkString(" ")
    val expectedFilter = new ImageGSFilterFlipX()
    val expectedConfig = new Config(
      filters = Seq(expectedFilter)
    )

    val config = mock[Config]
    when(config.addFilter(any[ImageGSFilterFlipX])).thenReturn(expectedConfig)

    val resultConfig = flipCommandHandler.processCommand(args, config)

    assert(resultConfig.getFilters.size == 1)
    assert(resultConfig.getFilters.head.isInstanceOf[ImageGSFilterFlipX])
    verify(config, times(1)).addFilter(any[ImageGSFilterFlipX])
  }

  test("processCommand handles valid --flip y argument") {
    val flipCommandHandler: CommandHandler =
      new FlipFilterCommandHandler()

    val args = List("--flip y")
    val value = args.mkString(" ")
    val expectedFilter = new ImageGSFilterFlipY()
    val expectedConfig = new Config(
      filters = Seq(expectedFilter)
    )

    val config = mock[Config]
    when(config.addFilter(any[ImageGSFilterFlipY])).thenReturn(expectedConfig)

    val resultConfig = flipCommandHandler.processCommand(args, config)

    assert(resultConfig.getFilters.size == 1)
    assert(resultConfig.getFilters.head.isInstanceOf[ImageGSFilterFlipY])
    verify(config, times(1)).addFilter(any[ImageGSFilterFlipY])
  }

  test("processCommand throws exception for invalid argument") {
    val flipCommandHandler: CommandHandler =
      new FlipFilterCommandHandler()

    val args = List("--flip z")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      flipCommandHandler.processCommand(args, config)
    }
  }
}
