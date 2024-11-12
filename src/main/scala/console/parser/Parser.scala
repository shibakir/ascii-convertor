package console.parser

case class Argument(name: String, params: Seq[String]) {
  override def toString: String = {
    s"Argument(name: $name, params: [${params.mkString(", ")}])"
  }
}

class Parser(args: Array[String]) {

  def parse(): Seq[Argument] = {
    if (args.isEmpty)
      throw new IllegalArgumentException("Arguments not found!")
    else if (!args.head.startsWith("--"))
      throw new IllegalArgumentException("Expected flag at the beginning!")

    var parsedArguments: Seq[Argument] = Seq.empty
    var currentArg = args.head
    var values: Seq[String] = Seq.empty
    var remainingArgs = args.tail

    while (currentArg.startsWith("--")) {
      while (remainingArgs.nonEmpty && !remainingArgs.head.startsWith("--")) {
        values = values :+ remainingArgs.head
        remainingArgs = remainingArgs.tail
      }

      parsedArguments :+= Argument(currentArg.drop(2), values)
      values = Seq.empty

      if (remainingArgs.nonEmpty) {
        currentArg = remainingArgs.head
        remainingArgs = remainingArgs.tail
      } else {
        currentArg = ""
      }
    }
    parsedArguments
  }
}
