package ui.handling.commands

import filter.greyscale.ImageGSFilterInvert
import ui.config.Config
import ui.filter.console.ConsoleInputFilter
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._

class InversionCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles single --invert argument") {
    val inversionCommandHandler: CommandHandler =
      new InversionCommandHandler()

    val args = List("--invert")
    val value = args.mkString(" ")
    val expectedFilter = new ImageGSFilterInvert()
    val expectedConfig = new Config(
      filters = Seq(expectedFilter)
    )

    val config = mock[Config]
    when(config.addFilter(any[ImageGSFilterInvert])).thenReturn(expectedConfig)

    val resultConfig = inversionCommandHandler.processCommand(args, config)

    assert(resultConfig.getFilters.size == 1)
    assert(resultConfig.getFilters.head.isInstanceOf[ImageGSFilterInvert])
    verify(config, times(1)).addFilter(any[ImageGSFilterInvert])
  }

  test("processCommand ignore unknown arguments") {
    val inversionCommandHandler: CommandHandler =
      new InversionCommandHandler()

    val args = List("--invert --unknown")
    val value = args.mkString(" ")
    val expectedFilter = new ImageGSFilterInvert()
    val expectedConfig = new Config(
      filters = Seq(expectedFilter)
    )

    val config = mock[Config]
    when(config.addFilter(any[ImageGSFilterInvert])).thenReturn(expectedConfig)

    val resultConfig = inversionCommandHandler.processCommand(args, config)

    assert(resultConfig.getFilters.size == 1)
    assert(resultConfig.getFilters.head.isInstanceOf[ImageGSFilterInvert])
    verify(config, times(1)).addFilter(any[ImageGSFilterInvert])
  }
}
