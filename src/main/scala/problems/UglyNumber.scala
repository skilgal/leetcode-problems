package problem

import scala.annotation.tailrec

// 263
// Write a program to check whether a given number is an ugly number.
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
object UglyNumber {

  def isUgly(num: Int): Boolean =
    num match {
      case 1           => true
      case n if n <= 0 => false
      case n if n % 5 == 0 => isUgly(n / 5)
      case n if n % 3 == 0 => isUgly(n / 3)
      case n if n % 2 == 0 => isUgly(n / 2)
      case _ => false
    }

}
