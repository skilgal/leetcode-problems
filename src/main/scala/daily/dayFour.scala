package daily

import scala.collection.mutable

object DayFour {

  def kthFactor(n: Int, k: Int): Int = {
    val gathered = mutable.ArrayBuffer[Int]()
    val factors = for (i <- 1 to n if n % i == 0 && gathered.forall(elem => elem % i != 0)) {
      gathered += i
    }
    gathered.drop(k - 1).headOption.getOrElse(-1)
  }
}
