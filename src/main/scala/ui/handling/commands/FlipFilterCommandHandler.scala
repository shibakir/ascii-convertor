package ui.handling.commands

import filter.greyscale.{ImageGSFilterFlipX, ImageGSFilterFlipY}
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class FlipFilterCommandHandler extends CommandHandler("--flip\\s+([x|y])".r) {

  override def commandName: String = "Flip"
  val patterns: Seq[String] = Seq(
    "--flip",
  )
  private val validArguments: Seq[String] = Seq(
    "x",
    "y",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    val updatedConfig = commands.foldLeft(config) {
      case (currentConfig, (_, arg)) =>
        //if (!validArguments.contains(arg.strip())) {
          //println(s"\u001b[31m ERROR: $commandName \u001b[0m")
        //}
        arg match
          case "x" =>
            currentConfig.addFilter(new ImageGSFilterFlipX())
          case "y" =>
            currentConfig.addFilter(new ImageGSFilterFlipY())
          case _ =>
            throw new IllegalArgumentException(
              s"Invalid argument call of $commandName command." +
                s" Expected $validArguments. Provided: ${arg}"
            )
    }
    updatedConfig
  }
}