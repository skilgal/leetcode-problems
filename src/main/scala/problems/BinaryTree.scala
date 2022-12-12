package problem

import structure.TreeNode
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack

object BinaryTree {

  implicit class BinaryTreeOps(tree: TreeNode) {
    def postOrderTraversal(): List[Int] = BinaryTree.postOrderTraversal(tree)
    def inOrderTraversal(): List[Int]   = BinaryTree.inOrderTraversal(tree)
    def preOrderTraversal(): List[Int]  = BinaryTree.preOrderTraversal(tree)
  }

  def postOrderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return List.empty[Int]

    val traverse = ListBuffer[TreeNode]()
    val stack    = new Stack[TreeNode]()

    def pushLeftBranch(tree: TreeNode): Unit = {
      var node = tree
      while (node != null) {
        stack.push(node)
        node = node.left
      }
    }

    pushLeftBranch(root)
    var i = 0

    while (stack.nonEmpty) {
      i += 1
      if (i > 5) {
        System.exit(1)
      }

      val node = stack.top
      if (node.right != null) {
        if (traverse.nonEmpty && traverse.last == node.right) {
          val poped = stack.pop()
          traverse addOne poped
        } else
          pushLeftBranch(node.right)
      } else {
        val popped = stack.pop()
        traverse addOne popped
      }
    }
    traverse.map(_.value).toList
  }

  def inOrderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return List.empty[Int]

    val traverse = ListBuffer[Int]()
    val stack    = new Stack[TreeNode]()

    def pushLeftBranch(tree: TreeNode): Unit = {
      var node = tree
      while (node != null) {
        stack.push(node)
        node = node.left
      }
    }

    pushLeftBranch(root)

    while (stack.nonEmpty) {
      val node = stack.pop()
      traverse.addOne(node.value)

      if (node.right != null) {
        pushLeftBranch(node.right)
      }

    }

    traverse.toList
  }

  def preOrderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return List.empty[Int]

    val traverse = ListBuffer[Int]()
    val stack    = new Stack[TreeNode]()

    stack.push(root)

    while (stack.nonEmpty) {
      val node = stack.pop()
      traverse.addOne(node.value)

      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)
    }

    traverse.toList
  }
}
