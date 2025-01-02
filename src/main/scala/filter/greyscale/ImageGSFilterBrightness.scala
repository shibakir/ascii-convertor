package filter.greyscale

import model.image.{Image, ImageGS}
import model.pixel.PixelGS

class ImageGSFilterBrightness(brightnessValue: Int) extends ImageGSFilter {

  override def apply(image: Image[PixelGS]): Image[PixelGS] = {
    validateInputImage(image)

    val height = image.getHeight
    val width = image.getWidth

    val convertedPixels: Seq[Seq[PixelGS]] =
      (0 until height).map { row =>
        (0 until width).map { col =>
          try {
            val originalPixel = image.getPixel(row, col)
            val newBrightness = originalPixel.toInt + brightnessValue
            val clampedBrightness = math.max(0, math.min(255, newBrightness))
            PixelGS(clampedBrightness)
          } catch {
            case e: Exception =>
              throw new RuntimeException(s"Filter: Error processing pixel at ($row, $col): ${e.getMessage}")
          }
        }
      }
    ImageGS(convertedPixels)
  }
}
