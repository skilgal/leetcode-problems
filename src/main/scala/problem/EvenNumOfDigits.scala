package problem

// 1295. Find Numbers with Even Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
//
object EvenNumOfDigits {

  def digits(num: Int) = {
    @scala.annotation.tailrec
    def run(num: Int, digits: Int): Int =
      if (num > 0) run(num / 10, digits + 1)
      else digits

    run(math.abs(num), 0)
  }

  def findNumbers(nums: Array[Int]): Int = {
    nums.map(digits).count(_ % 2 == 0)
  }

}
