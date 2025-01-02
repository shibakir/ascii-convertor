package ui.handling.commands

import transformation.tables.*
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

class TransformationTableCommandHandler
  extends CommandHandler("--table-(basic|advance|pro|non-linear-basic)|--custom-table '(.*)'".r) {

  override def commandName: String = "TransformationTable"
  val patterns: Seq[String] = Seq(
    "--table-basic",
    "--table-advance",
    "--table-pro",
    "--table-non-linear-basic",
    "--custom-table",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    // println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    if (commands.length != 1) {
      throw new IllegalArgumentException(
        s"Invalid count of calls of $commandName command." +
          s" Expects exactly 1 call. Provided: ${commands.length}"
      )
    }

    val tableType = commands.head._1
    val tableContent = commands.head._2

    tableType match
      case "--table-basic" =>
        config.setTransformation(new BasicLinearTransformation())
      case "--table-advance" =>
        config.setTransformation(new AdvanceLinearTransformation())
      case "--table-pro" =>
        config.setTransformation(new ProLinearTransformation())
      case "--table-non-linear-basic" =>
        config.setTransformation(new BasicNonLinearTransformation())

      case "--custom-table" =>
        config.setTransformation(new CustomTransformation(tableContent))

      case _ =>
        throw new IllegalArgumentException(
          s"Invalid argument call of $commandName command. Argument type error!"
        )
  }
}