package ui.handling.commands

import ui.config.Config
import ui.handling.CommandHandler
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

class RotationCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand throws exception for non-integer degree") {
    val rotationCommandHandler: CommandHandler =
      new RotationCommandHandler()

    val args = List("--rotate dumb")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      rotationCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for --rotate without degree") {
    val rotationCommandHandler: CommandHandler =
      new RotationCommandHandler()

    val args = List("--rotate")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      rotationCommandHandler.processCommand(args, config)
    }
  }
}
