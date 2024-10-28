
package controller

class ControllerConsole extends Controller {

  override def importData(): Unit = {
    println("runs importData()")
  }

  override def exportData(): Unit = {
    println("runs exportData()")
  }
  
}

