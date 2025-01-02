package ui.handling.commands

import filter.greyscale.ImageGSFilterBrightness
import ui.config.Config
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*

class BrightnessFilterCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles valid brightness argument") {
    val brightnessCommandHandler: CommandHandler =
      new BrightnessFilterCommandHandler()

    val args = List("--brightness 10")
    val value = args.mkString(" ")
    val expectedConfig = new Config(
      filters = Seq(new ImageGSFilterBrightness(10))
    )

    val config = mock[Config]
    when(config.addFilter(any[ImageGSFilterBrightness])).thenReturn(expectedConfig)

    val data = DataHandler(value, config)
    val resultConfig = brightnessCommandHandler.processCommand(args, config)

    assert(resultConfig.getFilters.size == 1)
    assert(resultConfig.getFilters.head.isInstanceOf[ImageGSFilterBrightness])
    verify(config, times(1)).addFilter(any[ImageGSFilterBrightness])
  }

  test("processCommand handles invalid brightness argument") {
    val brightnessCommandHandler: CommandHandler =
      new BrightnessFilterCommandHandler()

    val args = List("--brightness dumb")
    val value = args.mkString(" ")

    val config = new Config()

    val data = DataHandler(value, config)

    intercept[IllegalArgumentException] {
      brightnessCommandHandler.processCommand(args, config)
    }
  }

}
