package converter

import model.image.Image

trait ImageConverter[A, B] extends Converter[Image[A], B] {}