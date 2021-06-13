package course.recursion

import data.ListNode
import structure.TreeNode
import scala.collection.mutable.Queue

object PrincipleOfRecursion {

  def reverseString(s: Array[Char]): Unit = {
    def reverseStringInt(s: Array[Char]): Array[Char] =
      s match {
        case arr @ Array(head) => arr
        case Array(h, tail @ _*) =>
          reverseStringInt(tail.toArray) ++ Array(h)
      }

    reverseStringInt(s).foreach(print)
    for (i <- (s.size - 1) to 0 by -1) {
      System.out.print(s(i))
    }
  }

  def swapPairs(head: ListNode): ListNode = {
    if (head != null && head.next != null) {
      val newHead = head.next
      head.next = swapPairs(newHead.next)
      newHead.next = head
      newHead
    } else head
  }

}

object RecurrenceRelation {
  def pascalsTriangleElement(i: Int, j: Int): Int = {
    def f(i: Int, j: Int): Int = {
      if (i == j || j == 1) 1
      else f(i - 1, j - 1) + f(i - 1, j)
    }

    f(i, j)
  }

  def pascalsTriangle(rows: Int) = {

    def pascalsLine(triangle: Array[Array[Int]]): Array[Array[Int]] = {
      val prev = triangle.last
      val line = (1 +: ((prev, prev drop 1).zipped.map(_ + _)) :+ 1).toArray

      if (line.size >= rows) triangle :+ line
      else pascalsLine(triangle :+ line)
    }

    if (rows == 1) Array(Array(1))
    else pascalsLine(Array(Array(1)))
  }

  def getPascalTriangleRow(rowIndex: Int): List[Int] = {
    var line = List(1)
    for (_ <- 0 until rowIndex) {
      line = 1 +: (line, line drop 1).zipped.map(_ + _) :+ 1
    }
    line
  }

  def reverseListIteratively(head: ListNode): ListNode = {
    var current: ListNode = head
    var prev: ListNode    = null

    while (current != null) {
      val following = current.next
      current.next = prev
      prev = current
      current = following
    }

    prev
  }

  def reverseListRecursively(head: ListNode): ListNode = {
    def reverse(prev: ListNode, current: ListNode): ListNode = {
      if (current == null) prev
      else {
        val following = current.next
        current.next = prev
        reverse(current, following)
      }
    }

    reverse(null, head)
  }

  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) null
    else {
      if (root.value == `val`) root
      else {
        val leftResult = searchBST(root.left, `val`)
        if (leftResult == null) searchBST(root.right, `val`)
        else leftResult
      }
    }
  }

}

object Memoization {

  def fib(n: Int): Int = {
    val cache: scala.collection.mutable.Map[Int, Int] =
      scala.collection.mutable.Map()
    def fibMem(n: Int): Int = {
      if (n == 1 || n == 0) n
      else {
        if (!cache.contains(n)) {
          cache(n) = fibMem(n - 1) + fibMem(n - 2)
        }
        cache(n)
      }
    }

    fibMem(n)
  }

  def climbStairs(n: Int): Int = {
    import scala.collection.mutable.{Map => mMap}
    val cache: mMap[Int, Int] = mMap()

    def cases(n: Int): Int = {
      if (n <= 1) 1
      else {
        if (!cache.contains(n)) {
          cache(n) = cases(n - 1) + cases(n - 2)
        }
        cache(n)
      }
    }

    cases(n)
  }

}
