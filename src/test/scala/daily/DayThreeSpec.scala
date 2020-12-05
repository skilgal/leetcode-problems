package daily

import org.scalatest._
import matchers.should._
import org.scalatest.wordspec.AnyWordSpec

import structure._

class DayThreeSpec extends AnyWordSpec with Matchers {
  import DayThree._

  "increasing bst" should {
    "return correct for tests" in {
      increasingBST(
        new TreeNode(
          5,
          new TreeNode(
            3,
            new TreeNode(2, new TreeNode(1, null, null), null),
            new TreeNode(4, null, null)
          ),
          new TreeNode(
            6,
            null,
            new TreeNode(
              8,
              new TreeNode(7, null, null),
              new TreeNode(9, null, null)
            )
          )
        )
      )
    }
    "return 1 2 3" ignore {
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

    "return 1 2" ignore {
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
      findRight(
        new TreeNode(2, new TreeNode(1, null, null), null)
      ).value shouldBe 1
    }
  }
}
