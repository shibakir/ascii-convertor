package ui.handling.commands

import filter.greyscale.ImageGSFilterRotate
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class RotationCommandHandler extends CommandHandler("--rotate\\s+([+-]?\\d+)".r) {

  override def commandName: String = "Rotate"
  val patterns: Seq[String] = Seq(
    "--rotate",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    val updatedConfig = commands.foldLeft(config) {
      case (currentConfig, (_, arg)) =>
        arg.toIntOption match {
          case Some(rotationDegree) =>
            currentConfig.addFilter(new ImageGSFilterRotate(rotationDegree))
          case None =>
            throw new IllegalArgumentException(
              s"Invalid argument call of $commandName command. Argument type error!"
            )
        }
    }
    updatedConfig
  }
}