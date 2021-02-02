package daily

import org.scalatest._
import matchers.should._
import org.scalatest.wordspec.AnyWordSpec
import helpers._

import structure._

class DayThreeSpec extends AnyWordSpec with Matchers {
  import DayThree._

  "increasing bst" should {
    "return correct for tests" in {
      // increasingBST(
      //   Array(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9).toBinaryTree
      // ).value shouldBe 1
    }
    "return 1 2 3" in {
      val root = increasingBST(
        new TreeNode(
          2,
          new TreeNode(1, null, null),
          new TreeNode(3, null, null)
        )
      )
      root.value shouldBe 1
      root.left shouldBe null
      root.right.value shouldBe 2
      root.right.right.value shouldBe 3
    }

    "return 1 2" in {
      val root = increasingBST(
        new TreeNode(2, new TreeNode(1, null, null), null)
      )
      root.value shouldBe 1
      root.left shouldBe null
      root.right.value shouldBe 2
      root.right.right shouldBe null
      root.right.left shouldBe null
    }
  }

  "find left" should {
    "return 1" in {
      findRight(
        new TreeNode(1, null, null)
      ).value shouldBe 1
    }

    "return 1 from 2" in {
      findRight(Array[Integer](2, 1).toBinaryTree).value shouldBe 1
    }
  }
}
