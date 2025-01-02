package ui.handling.commands

import transformation.tables.*
import ui.config.Config
import ui.handling.CommandHandler
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._

class TransformationTableCommandHandlerTest extends AnyFunSuite with MockitoSugar {

  test("processCommand handles --table-basic argument") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List("--table-basic")
    val value = args.mkString(" ")
    val expectedTransformation = new BasicLinearTransformation()
    val expectedConfig = new Config(
      transformation = Some(expectedTransformation)
    )

    val config = mock[Config]
    when(config.setTransformation(any[BasicLinearTransformation])).thenReturn(expectedConfig)

    val resultConfig = transformationCommandHandler.processCommand(args, config)

    assert(resultConfig.getTransformation.isDefined)
    assert(resultConfig.getTransformation.get.isInstanceOf[BasicLinearTransformation])
    verify(config, times(1)).setTransformation(any[BasicLinearTransformation])
  }

  test("processCommand handles --table-advance argument") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List("--table-advance")
    val value = args.mkString(" ")
    val expectedTransformation = new AdvanceLinearTransformation()
    val expectedConfig = new Config(
      transformation = Some(expectedTransformation)
    )

    val config = mock[Config]
    when(config.setTransformation(any[AdvanceLinearTransformation])).thenReturn(expectedConfig)

    val resultConfig = transformationCommandHandler.processCommand(args, config)

    assert(resultConfig.getTransformation.isDefined)
    assert(resultConfig.getTransformation.get.isInstanceOf[AdvanceLinearTransformation])
    verify(config, times(1)).setTransformation(any[AdvanceLinearTransformation])
  }

  test("processCommand handles --table-pro argument") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List("--table-pro")
    val value = args.mkString(" ")
    val expectedTransformation = new ProLinearTransformation()
    val expectedConfig = new Config(
      transformation = Some(expectedTransformation)
    )

    val config = mock[Config]
    when(config.setTransformation(any[ProLinearTransformation])).thenReturn(expectedConfig)

    val resultConfig = transformationCommandHandler.processCommand(args, config)

    assert(resultConfig.getTransformation.isDefined)
    assert(resultConfig.getTransformation.get.isInstanceOf[ProLinearTransformation])
    verify(config, times(1)).setTransformation(any[ProLinearTransformation])
  }

  test("processCommand handles --table-non-linear-basic argument") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List("--table-non-linear-basic")
    val value = args.mkString(" ")
    val expectedTransformation = new BasicNonLinearTransformation()
    val expectedConfig = new Config(
      transformation = Some(expectedTransformation)
    )

    val config = mock[Config]
    when(config.setTransformation(any[BasicNonLinearTransformation])).thenReturn(expectedConfig)

    val resultConfig = transformationCommandHandler.processCommand(args, config)

    assert(resultConfig.getTransformation.isDefined)
    assert(resultConfig.getTransformation.get.isInstanceOf[BasicNonLinearTransformation])
    verify(config, times(1)).setTransformation(any[BasicNonLinearTransformation])
  }

  test("processCommand throws exception for multiple commands") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List("--table-basic --table-pro")
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      transformationCommandHandler.processCommand(args, config)
    }
  }

  test("processCommand throws exception for empy arguments") {
    val transformationCommandHandler: CommandHandler =
      new TransformationTableCommandHandler()

    val args = List()
    val value = args.mkString(" ")

    val config = mock[Config]

    intercept[IllegalArgumentException] {
      transformationCommandHandler.processCommand(args, config)
    }
  }
}
