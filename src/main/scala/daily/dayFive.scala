package daily

object DayFive {

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    type Size = Int
    type Num  = Int

    def findGapsBetween(source: Array[Num], n: Num): Size = {
      val indexes = (Array(1, 0) ++ source ++ Array(0,1)).zipWithIndex.collect {
        case (1, index) => index
      }

      indexes.foreach(println)

      val gaps = indexes zip (indexes drop 1)

      gaps.foreach(println)

      gaps
        .map(t => t._2 - t._1 - 1)
        .map{size => println(s"Size of gap: ${size}"); size}
        .filter(_ > 2)
        .map { gapCount =>
          println(s"gap count: ${gapCount}")
          (gapCount - 1) / 2
        }
        .sum
    }

    findGapsBetween(flowerbed, 1) >= n
  }
}
