package ui.handling.commands

import scala.util.{Try, Failure, Success}

import filter.greyscale.{ImageGSFilterBrightness, ImageGSFilterRotate}
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class BrightnessFilterCommandHandler extends CommandHandler("--brightness\\s+([+-]?\\d+)".r) {

  override def commandName: String = "Brightness"
  val patterns: Seq[String] = Seq(
    "--brightness",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    val updatedConfig = commands.foldLeft(config) {
      case (currentConfig, (_, arg)) =>
        arg.toIntOption match {
          case Some(brightnessValue) =>
            currentConfig.addFilter(new ImageGSFilterBrightness(brightnessValue))
          case None =>
            throw new IllegalArgumentException(
              s"Invalid argument call of $commandName command. Argument type error!"
            )
        }
    }
    updatedConfig
  }
}