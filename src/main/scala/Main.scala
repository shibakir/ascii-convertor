import controller.AppController
import controller.parser.Parser

object Main extends App {

  private val app = new AppController(
                                      new Parser(args),
                                      )

  app.run()
}