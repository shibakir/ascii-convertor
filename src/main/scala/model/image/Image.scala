package model.image

import model.file.File
import model.pixel.Pixel

trait Image[T <: Pixel] extends File {}