package problem

import scala.collection.mutable.ArrayBuffer

// Problem 120
object Triangle {
  type TriangleRepr[T] = List[List[T]]

  def minimumTotalRec(triangle: TriangleRepr[Int]): Int = {

    def findMin(currLine: Int, mins: List[Int]): Int = {
      println(mins.mkString(","))
      if (currLine < 0) mins.min
      else {
        val minPaths = mins
          .zip(mins.drop(1))
          .map(t => Math.min(t._1, t._2))
          .zip(triangle(currLine))
          .map(t => t._1 + t._2)

        findMin(currLine - 1, minPaths)
      }
    }

    findMin(triangle.size - 2, triangle.last)

  }

}
