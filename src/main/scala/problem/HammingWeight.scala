package problem

// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/
//
object HammingWeight {
  def hammingWeight(n: Int): Int = {
    Integer.toBinaryString(n).count(_ == '1')
  }
}
