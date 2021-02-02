package problem

import org.scalatest.wordspec.AnyWordSpec
import data._
import helpers.ArrayOps
import org.scalatest.matchers.should.Matchers
import BinaryTree._

class BinaryTreeSpec extends AnyWordSpec with Matchers {

  "preOrder traverse" must {
    "example 1" in {
      Array[Integer](
        1,
        null,
        2,
        3
      ).toBinaryTree.preOrderTraversal shouldBe List(1, 2, 3)
    }

    "example 2" in {
      Array[Integer]().toBinaryTree.preOrderTraversal shouldBe List()
    }
    "example 3" in {
      BinaryTree.preOrderTraversal(
        Array[Integer](1).toBinaryTree
      ) shouldBe List(1)
    }
    "example 4" in {
      BinaryTree.preOrderTraversal(
        Array[Integer](1, 2).toBinaryTree
      ) shouldBe List(1, 2)
    }
    "example 5" in {
      BinaryTree.preOrderTraversal(
        Array[Integer](1, 2).toBinaryTree
      ) shouldBe List(1, 2)
    }
  }

  "inOrder traverse" must {
    "example 1" in {
      Array[Integer](1, null, 2, 3).toBinaryTree.inOrderTraversal shouldBe List(
        1,
        3,
        2
      )
    }

    "example 2" in {
      Array[Integer]().toBinaryTree.inOrderTraversal shouldBe List()
    }

    "example 3" in {
      Array[Integer](1).toBinaryTree.inOrderTraversal() shouldBe List(1)
    }
  }

  "postOrder traverse" must {
    "example 1" in {
      Array[Integer](1, null, 2, 3).toBinaryTree
        .postOrderTraversal() shouldBe List(3, 2, 1)
    }
    "example 2" in {
      Array[Integer]().toBinaryTree.postOrderTraversal() shouldBe List()
    }

    "example 3" in {
      Array[Integer](1).toBinaryTree.postOrderTraversal() shouldBe List(1)
    }

    "example 4" in {
      Array[Integer](1, 2).toBinaryTree.postOrderTraversal() shouldBe List(2, 1)
    }

    "example 5" in {
      Array[Integer](1, null, 2).toBinaryTree
        .postOrderTraversal() shouldBe List(2, 1)
    }

  }
}
