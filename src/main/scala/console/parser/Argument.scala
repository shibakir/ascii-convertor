package console.parser

case class Argument(name: String, params: Seq[String]) {
  override def toString: String = {
    s"Argument(name: $name, params: [${params.mkString(", ")}])"
  }
}