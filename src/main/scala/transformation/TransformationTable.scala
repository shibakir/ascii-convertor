package transformation

object TransformationTable {

  val tables: Map[String, LinearTransformation] = Map(
    "basic" -> LinearTransformation("@#%*+=-:. "),
    "advance" -> LinearTransformation("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. "),
    "pro" -> LinearTransformation("MWNXK0Okxdolc:. "),
  )
}