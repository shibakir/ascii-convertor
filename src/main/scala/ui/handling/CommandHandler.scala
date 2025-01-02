package ui.handling

import ui.config.Config
import scala.util.matching.Regex
import ui.handling.DataHandler

abstract class CommandHandler(regExp: Regex) {

  def commandName: String

  def handle(dataHandler: DataHandler): DataHandler = {

    val matches = regExp.findAllIn(dataHandler.value).toList
    val arguments = matches
    
    if (arguments.nonEmpty) {
        DataHandler(dataHandler.value, processCommand(arguments, dataHandler.config))
    } else {
      dataHandler
    }
  }

  def processCommand(args: Seq[String], config: Config): Config

}