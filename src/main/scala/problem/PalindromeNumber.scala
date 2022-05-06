package problem

/**  9. Palindrome Number
  * Easy
  *
  * 4972
  *
  * 2003
  *
  * Add to List
  *
  * Share
  * Given an integer x, return true if x is palindrome integer.
  *
  * An integer is a palindrome when it reads the same backward as forward.
  *
  * Constraints:
  *
  * -231 <= x <= 231 - 1
  */

object PalindromeNumber extends App {

  private def toDigits(x: Int): List[Int] =
    if (x < 10) List(x)
    else toDigits(x / 10) :+ (x % 10)

  private def isPalindrome[A](list: List[A]): Boolean = {
    if (list.size < 2) true
    else if (list.head == list.last) isPalindrome(list.drop(1).dropRight(1))
    else false
  }

  def isPalindrome(x: Int): Boolean = {
    if (x < 0) false
    else isPalindrome(toDigits(x))
  }

  assert(isPalindrome(121) == true)
  assert(isPalindrome(-121) == false)
  assert(isPalindrome(1221) == true)
  assert(isPalindrome(10) == false)

}
