package ui.console

import facades.ImageFacade
import ui.handling.CommandHandler
import ui.handling.commands.*

object Console {

  def processCommand(args: String): Unit = {
    try {
    ImageFacade.convert(
      ImageFacade.setupConfig(args, commands())
    )
    } catch
      case e: Exception =>
        println(s"Error while processing command: ${e.getMessage}")
  }

  private def commands(): Seq[CommandHandler] = {
    Seq(
      TransformationTableCommandHandler(),
      ImporterCommandHandler(),
      RotationCommandHandler(),
      ScaleFilterCommandHandler(),
      FlipFilterCommandHandler(),
      BrightnessFilterCommandHandler(),
      InversionCommandHandler(),
      ExporterCommandHandler(),
    )
  }
}
