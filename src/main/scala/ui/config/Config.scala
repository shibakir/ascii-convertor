package ui.config

import exporter.ASCIIToImageExporter
import filter.greyscale.ImageGSFilter
import importer.ImageRGBImporter
import transformation.Transformation

class Config(
              importer: Option[ImageRGBImporter] = None,
              filters: Seq[ImageGSFilter] = Seq.empty,
              transformation: Option[Transformation] = None,
              exporters: Seq[ASCIIToImageExporter] = Seq.empty,
            )
{

  def validateBeforeConversion(): Unit = {
    if (importer.isEmpty) {
      throw new IllegalStateException("Invalid configuration: importer in not defined!")
    }
    if (exporters.isEmpty) {
      throw new IllegalStateException("Invalid configuration: no exporters are defined!")
    }
    if (transformation.isEmpty) {
      throw new IllegalStateException("Invalid configuration: transformation in not defined!")
    }
  }

  def getImporter: Option[ImageRGBImporter] = importer

  def setImporter(newImporter: ImageRGBImporter): Config = {
    new Config(Some(newImporter), filters, transformation, exporters)
  }

  def getFilters: Seq[ImageGSFilter] = filters

  def addFilter(newFilter: ImageGSFilter): Config = {

    val newFilters = filters.appended(newFilter)
    new Config(importer, newFilters, transformation, exporters)
  }

  def getTransformation: Option[Transformation] = transformation

  def setTransformation(newTransformation: Transformation): Config = {
    new Config(importer, filters, Some(newTransformation), exporters)
  }

  def getExporters: Seq[ASCIIToImageExporter] = exporters

  def addExporter(newExporter: ASCIIToImageExporter): Config = {

    val newExporters = exporters.appended(newExporter)
    new Config(importer, filters, transformation, newExporters)
  }
}