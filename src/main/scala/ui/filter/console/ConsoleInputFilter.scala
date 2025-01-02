package ui.filter.console

import ui.filter.InputFilter

class ConsoleInputFilter(patterns: Seq[String]) extends InputFilter {

  override def filter(input: String): String = {
    var result = input.trim

    patterns.foreach { pattern =>
      result = result.replaceAll(pattern, "")
    }
    result
  }
}

object ConsoleInputFilter {

  def filterSplitter(patterns: Seq[String], input: Seq[String]): Seq[(String, String)] = {
    input.map { line =>
      var currentLine = line.trim
      var lineRemoved = ""

      patterns.foreach { pattern =>
        val regex = pattern.r
        val matches = regex.findAllIn(currentLine).toSeq

        if (matches.nonEmpty) {
          lineRemoved += matches.mkString(" ")
          currentLine = currentLine.replaceAll(pattern, "")
        }
      }
      val cleanedCurrentLine = currentLine.trim.stripPrefix("\"").stripSuffix("\"")
      (lineRemoved.trim, cleanedCurrentLine.trim)
    }
  }
}