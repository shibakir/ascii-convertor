package ui.handling.commands

import filter.greyscale.ImageGSFilterInvert
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class InversionCommandHandler extends CommandHandler("--invert".r) {

  override def commandName: String = "Invert"
  val patterns: Seq[String] = Seq(
    "--invert",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    val updatedConfig = commands.foldLeft(config) {
      case (currentConfig, (_, arg)) =>
        currentConfig.addFilter(new ImageGSFilterInvert())
    }
    updatedConfig
  }
}