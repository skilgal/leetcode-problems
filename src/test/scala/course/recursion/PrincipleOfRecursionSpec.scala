package course.recursion

import helpers._
import org.scalatest._
import matchers.should._
import wordspec.AnyWordSpec
import data.ListNode

class PrincipleOfRecursionSpec extends AnyWordSpec with Matchers {

  "swap pairs" must {
    "example 1" in {
      val swapped = PrincipleOfRecursion.swapPairs(
        Array[Integer](1, 2, 3, 4).toLinkedList
      )
      swapped.values shouldBe Array[Integer](2, 1, 4, 3).toLinkedList.values
    }

    "example 2" in {
      PrincipleOfRecursion
        .swapPairs(Array[Integer]().toLinkedList)
        .values shouldBe List()
    }

    "example 3" in {
      PrincipleOfRecursion
        .swapPairs(Array[Integer](1).toLinkedList)
        .values shouldBe new ListNode(1).values
    }
  }

  "pascal's triangle" must {
    "show only 1 for 1 row" in {
      RecurrenceRelation.pascalsTriangle(1) shouldBe Array(Array(1))
    }

    "show correct triangle" in {
      RecurrenceRelation.pascalsTriangle(5) shouldBe Array(
        Array(1),
        Array(1, 1),
        Array(1, 2, 1),
        Array(1, 3, 3, 1),
        Array(1, 4, 6, 4, 1)
      )
    }
  }

  "reverse list" must {
    "example 1" in {
      val output = Array[Integer](5, 4, 3, 2, 1).toLinkedList

      RecurrenceRelation
        .reverseListIteratively(Array[Integer](1, 2, 3, 4, 5).toLinkedList)
        .values shouldBe output.values
      RecurrenceRelation
        .reverseListRecursively(Array[Integer](1, 2, 3, 4, 5).toLinkedList)
        .values shouldBe output.values
    }
  }

  "search in BST" must {
    "example 1" in {
      val searchedSubTree = RecurrenceRelation
        .searchBST(
          Array[Integer](4, 2, 7, 1, 3).toBinaryTree,
          2
        )
        .values shouldBe Array[Integer](2, 1, 3).toBinaryTree.values
    }

    "example 2" in {
      RecurrenceRelation
        .searchBST(
          Array[Integer](4, 2, 7, 1, 3).toBinaryTree,
          5
        )
        .values shouldBe Array[Integer]().toBinaryTree.values
    }
  }

  "pascals row generation" must {
    "return [1,3,3,1] for 3d" in {
      RecurrenceRelation.getPascalTriangleRow(3) shouldBe List(1, 3, 3, 1)
    }

    "return [1] for 0th" in {
      RecurrenceRelation.getPascalTriangleRow(0) shouldBe List(1)
    }
    "return [1,1] for 1st" in {
      RecurrenceRelation.getPascalTriangleRow(1) shouldBe List(1, 1)
    }
  }

  "memoized fibonacci" must {
    "return 1 for 2" in {
      Memoization.fib(2) shouldBe 1
    }
    "return 2 for 3" in {
      Memoization.fib(3) shouldBe 2
    }
  }

  "climbing staircase" must {
    "return 2 for 2" in { Memoization.climbStairs(2) shouldBe 2 }
    "return 3 for 3" in { Memoization.climbStairs(3) shouldBe 3 }
  }
}
