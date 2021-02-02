import structure.TreeNode
import scala.collection.mutable.Queue

import java.util.{Arrays}

package object helpers {

  implicit class ArrayOps(arr: Array[Integer]) {

    def toBinaryTree: TreeNode = {
      if (arr.length < 1 || arr(0).equals(null)) null
      else {
        val queue   = new Queue[TreeNode]
        val topNode = new TreeNode(arr(0), null, null)

        queue.enqueue(topNode)
        for (i <- 1 until arr.length by 2) {
          val root = queue.dequeue()
          if (arr(i) != null) {
            val left = new TreeNode(arr(i), null, null)

            root.left = left
            queue.enqueue(left)
          }

          if (i + 1 < arr.length && arr(i + 1) != null) {
            val right = new TreeNode(arr(i + 1), null, null)

            root.right = right
            queue.enqueue(right)
          }
        }

        topNode
      }
    }
  }
}
