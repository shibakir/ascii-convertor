package ui.handling.commands

import exporter.file.ascii.{ASCIIToConsoleExport, ASCIIToFileExport}
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class ExporterCommandHandler extends CommandHandler("--output-(file\\s(?!--)(?:\"[^\"]*\"|\\S+)|console)".r) {

  override def commandName: String = "Exporter"
  val patterns: Seq[String] = Seq(
    "--output-file",
    "--output-console"
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    if (commands.isEmpty) {
      throw new IllegalArgumentException(
        s"Invalid count of calls of $commandName command." +
          s" Expects at least 1 call. Provided: ${commands.length}"
      )
    }

    commands.foldLeft(config) { (currentConfig, commandPair) =>
      commandPair._1 match {
        case "--output-file" =>
          currentConfig.addExporter(new ASCIIToFileExport(commandPair._2))
        case "--output-console" =>
          currentConfig.addExporter(new ASCIIToConsoleExport())
        case _ =>
          throw new IllegalArgumentException(
            s"Invalid argument call of $commandName command. Argument type error!"
          )
          currentConfig
      }
    }
  }
}