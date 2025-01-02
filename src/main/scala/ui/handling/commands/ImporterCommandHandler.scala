package ui.handling.commands

import importer.{FileSystemJPGImageImporter, FileSystemPNGImageImporter, Image2DRandomImporter}
import ui.config.Config
import ui.handling.CommandHandler
import ui.filter.console.ConsoleInputFilter

import java.nio.file.Paths

class ImporterCommandHandler()
  extends CommandHandler("--image\\s+\"([^\"]+)\"|--image\\s+(\\S+)|--image-random".r) {

  override def commandName: String = "Importer"
  val patterns: Seq[String] = Seq(
    "--image-random",
    "--image",
  )

  override def processCommand(args: Seq[String], config: Config): Config = {
    //println(s"processCommand: $commandName with args: $args")
    val commands = ConsoleInputFilter.filterSplitter(patterns, args)

    if (commands.length != 1) {
      throw new IllegalArgumentException(
        s"Invalid count of calls of $commandName command." +
          s" Expects exactly 1 call. Provided: ${commands.length}"
      )
    }
    
    val inputType = commands.head._1
    val inputPath = commands.head._2

    inputType match
      case "--image" =>
        val fileExtension = getFileExtension(inputPath)
        fileExtension match {
          case "jpg" | "jpeg" => config.setImporter(new FileSystemJPGImageImporter(inputPath))
          case "png" => config.setImporter(new FileSystemPNGImageImporter(inputPath))
          case _ => throw new IllegalArgumentException(s"Unsupported image type: $fileExtension for file $inputPath.")
        }
      case "--image-random" =>
        config.setImporter(new Image2DRandomImporter())
      case _ =>
        throw new IllegalArgumentException(
          s"Invalid argument call of $commandName command." +
            s" Expected $patterns. Provided: ${inputType}"
        )
  }

  private def getFileExtension(path: String): String = {
    val fileName = Paths.get(path).getFileName.toString
    val extension = fileName.lastIndexOf(".")
    if (extension != -1) fileName.substring(extension + 1).toLowerCase
    else ""
  }
}