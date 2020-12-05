package daily

import structure._

object DayThree {
  def increasingBST(root: TreeNode): TreeNode = {
    def inOrder(root: TreeNode): TreeNode = {
      if (root.left != null) {
        println(s"root left is not null. ${root.left.value}")
        val left     = inOrder(root.left)
        val leftTail = findRight(left)
        println(s"map ${leftTail.value} -> ${root.value}")
        leftTail.right = root
        root.left = null

        if (root.right != null) {
          println(s"root right is not null ${root.right.value}")
          val right = inOrder(root.right)
          println(s"map ${root.value} -> ${right.value}")
          root.right = right
          root
        }

        left
      } else if (root.right != null) {
        println("root left is null, but right is not. ${root.right.value}")
        val right = inOrder(root.right)
        println(s"map ${root.value} -> ${right.value}")
        root.right = right
        root
      } else {
        println("root left and right are null")
        root
      }
    }

    inOrder(root)
  }

  def findRight(root: TreeNode): TreeNode = {
    if (root.right == null) {
      root
    } else findRight(root.right)
  }

}
