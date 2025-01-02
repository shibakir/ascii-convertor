package ui.handling.commands

import filter.greyscale.ImageGSFilterScale
import ui.config.Config
import ui.filter.console.ConsoleInputFilter
import ui.handling.{CommandHandler, DataHandler}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._

class ScaleFilterCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand throws exception for invalid scale value") {
    val scaleCommandHandler: CommandHandler =
      new ScaleFilterCommandHandler()

    val args = List("--scale large")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      scaleCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for missing value") {
    val scaleCommandHandler: CommandHandler =
      new ScaleFilterCommandHandler()

    val args = List("--scale")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      scaleCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for invalid format") {
    val scaleCommandHandler: CommandHandler =
      new ScaleFilterCommandHandler()

    val args = List("--scale 2,5")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      scaleCommandHandler.processCommand(args, config)
    }
  }
}
