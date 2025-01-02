package filter.greyscale

import filter.ImageFilter
import model.image.Image
import model.pixel.PixelGS

trait ImageGSFilter extends ImageFilter[PixelGS] {
  
  def validateInputImage(image: Image[PixelGS]) : Unit = {
    if (image == null) {
      throw new IllegalArgumentException("Filter: Input image cannot be null")
    }
    val height = image.getHeight
    val width = image.getWidth
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException(s"Filter: Invalid image dimensions: height = $height, width = $width")
    }
  }   
}