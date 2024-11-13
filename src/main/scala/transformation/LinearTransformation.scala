package transformation

class LinearTransformation(table: String) extends Transformation {

  override def convert(baseType: Int): Char = {
    val result: Int = (baseType * table.length / 256)
    table(result)
  }
}
