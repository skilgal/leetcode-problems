package helpers

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class ArrayOpsSpec extends AnyWordSpec with Matchers {
  "array to binary tree" should {
    "[null] and empty array must be transformed into null tree" in {
      Array[Integer]().toBinaryTree shouldBe null
      Array.empty[Integer].toBinaryTree shouldBe null
    }

    "[1] must be transformed to only root tree" in {
      val tree = Array[Integer](1).toBinaryTree
      tree.value shouldBe 1
      tree.left shouldBe null
      tree.right shouldBe null
    }

    "transform [1,2,3] into correct tree" in {
      val tree = Array[Integer](1, 2, 3).toBinaryTree
      tree.value shouldBe 1
      tree.left.value shouldBe 2
      tree.right.value shouldBe 3
    }

    "transform nulls to empty branch" in {
      val tree = Array[Integer](1, null, 2, null, 3).toBinaryTree

      tree.value shouldBe 1
      tree.left shouldBe null
      val fLevel = tree.right
      fLevel.value shouldBe 2
      fLevel.left shouldBe null
      val sLevel = fLevel.right
      sLevel.value shouldBe 3
      sLevel.left shouldBe null
      sLevel.right shouldBe null
    }
  }
}
