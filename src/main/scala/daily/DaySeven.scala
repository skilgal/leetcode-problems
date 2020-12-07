package daily

import java.util.concurrent.atomic.AtomicInteger

object DaySeven {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    var matrix = Array.fill(n)(Array.fill(n)(0))
    var value  = new AtomicInteger(1)

    for (level <- 0 to (n / 2)) {
      for (i <- level to n - level - 1) {
        matrix(level)(i) = value.getAndIncrement()
      }
      for (i <- level + 1 to n - level - 1) {
        matrix(i)(n - level - 1) = value.getAndIncrement()
      }

      for (i <- n - level - 2 to level by -1) {
        matrix(n - level - 1)(i) = value.getAndIncrement()
      }
      for (i <- n - level - 2 to level + 1 by -1) {
        matrix(i)(level) = value.getAndIncrement()
      }
    }
    matrix
  }
}
