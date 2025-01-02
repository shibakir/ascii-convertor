package transformation

abstract class NonLinearTransformationTable(table: String) extends Transformation {

  override def convert(baseType: Int): Char = {
    val index = baseType % table.length
    table(index)
  }
}
