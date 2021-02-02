package problem

// Problem 1480

object RunningSum1dArray {
  def runningSum(nums: Array[Int]): Array[Int] = {
    def runSumRec(prevSum: Int, index: Int): Array[Int] = {
      if (index == nums.length) nums
      else {
        val el = nums(index)
        nums(index) = el + prevSum
        runSumRec(nums(index), index + 1)
      }
    }

    runSumRec(0, 0)
  }
}
