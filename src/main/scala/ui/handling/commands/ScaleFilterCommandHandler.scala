package ui.handling.commands

import filter.greyscale.ImageGSFilterScale
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class ScaleFilterCommandHandler extends CommandHandler("--scale\\s+(\\d*\\.?\\d+)".r) {

  override def commandName: String = "Scale"
  val patterns: Seq[String] = Seq(
    "--scale",
  )
  private val validArguments: Seq[Double] = Seq(
    0.25,
    0.1,
    4,
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    val updatedConfig = commands.foldLeft(config) {
      case (currentConfig, (_, arg)) =>
        arg.toDoubleOption match {
          case Some(scaleValue) =>
            currentConfig.addFilter(new ImageGSFilterScale(scaleValue))
          case None =>
            throw new IllegalArgumentException(
              s"Invalid argument call of $commandName command. Argument type error!"
            )
        }
    }
    updatedConfig
  }
}