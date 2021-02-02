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

  // def minimumTotal(triangle: TriangleRepr[Int]): Int = {
  //   val cachedMinimums: Array[List[Int]] =
  //     Array.fill(triangle.last.size)(List.empty[Int])
  //   cachedMinimums(0) = List(triangle.head.head)

  //   implicit class ArrayOps[T](arr: Array[T]) {
  //     def get(index: Int): Option[T] = {
  //       if (index < arr.size && 0 <= index) Some(arr(index))
  //       else None
  //     }
  //   }

  //   def minimumTotalStep(index: Int): Int = {
  //     if (index < triangle.size) {
  //       val newPaths = triangle(index)
  //       for (indices <- newPaths.indices.reverse) {
  //         cachedMinimums(indices) = (cachedMinimums(indices) ++ cachedMinimums
  //           .get(indices - 1)
  //           .getOrElse(ArrayBuffer.empty[Int])).map(_ + newPaths(indices))
  //       }

  //       minimumTotalStep(index + 1)
  //     } else cachedMinimums.flatMap(identity).min
  //   }

  //   minimumTotalStep(1)
  // }

  // def minimumTotalRec(triangle: TriangleRepr[Int]): Int = {
  //   def minTotal(line: Int, column: Int, sum: Int): Int = {
  //     if (line < triangle.size && column < triangle(line).size) {
  //       val currentSum = sum + triangle(line)(column)
  //       Math.min(
  //         minTotal(line + 1, column, currentSum),
  //         minTotal(line + 1, column + 1, currentSum)
  //       )
  //     } else sum
  //   }
  //   minTotal(0, 0, 0)
  // }


}
