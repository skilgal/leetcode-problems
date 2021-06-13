import structure.TreeNode
import scala.collection.mutable.Queue

import java.util.{Arrays}
import data._
import scala.collection.mutable.ArrayBuffer

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

    def toLinkedList: ListNode = {
      if (arr.size < 1 || arr(0).equals(null)) null
      else {
        val head = new ListNode(arr(0))
        var curr = head
        for (i <- arr.indices.drop(1)) {
          val tmp = new ListNode(arr(i))
          curr.next = tmp
          curr = tmp
        }
        head
      }
    }
  }

  implicit class ListNodeOps(list: ListNode) {
    def values: List[Int] = {
      var curr       = list
      val aggregator = ArrayBuffer[Int]()

      while (curr != null) {
        aggregator += curr.x
        curr = curr.next
      }
      aggregator.toList
    }
  }

  implicit class TreeNodeOps(tree: TreeNode) {
    def values: List[Int] = {
      if (tree == null) List()
      else {
        var data = ArrayBuffer[Int]()
        val q    = Queue[TreeNode]()
        q.enqueue(tree)

        while (q.nonEmpty) {
          val node = q.dequeue()
          data += node.value
          if (node.right != null) q.enqueue(node.right)
          if (node.left != null) q.enqueue(node.left)
        }

        data.toList
      }
    }
  }
}
