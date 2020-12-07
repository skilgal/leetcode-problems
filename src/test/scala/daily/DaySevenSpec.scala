package daily

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class DaySevenSpec extends AnyWordSpec with Matchers {

  "Matrix generation" must {
    "return 1 elem matrif" ignore {
      DaySeven.generateMatrix(1) shouldBe Array(Array(1))
    }

    "gen correct matrix" in {
      printMatrix(DaySeven.generateMatrix(3))
      DaySeven.generateMatrix(3) shouldBe Array(
        Array(1, 2, 3),
        Array(8, 9, 4),
        Array(7, 6, 5)
      )
    }
  }

  def printMatrix[T](m: Array[Array[T]]): Unit = {
    for (i <- 0 to m.length - 1) {
      print("|\t")
      for (j <- 0 to m(i).length - 1) {
        print(m(i)(j) + "\t|\t")
      }
      println()
    }
  }
}
