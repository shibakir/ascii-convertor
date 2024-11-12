package importer

import model.file.File

trait FileSystemImporter[T <: File] extends Importer[T] {}