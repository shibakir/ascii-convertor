package transformation

import converter.Converter
import model.image.Image

trait Transformation extends Converter[Int, Char] {}


object Transformation {
  
  val tables: Map[String, String] = Map(
    "basic" -> "@#%*+=-:. ",
    "advance" -> "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ",
    "pro" -> "MWNXK0Okxdolc:. ",
  )
}
