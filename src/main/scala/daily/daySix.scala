package daily

// Populating Next Right Pointers in Each Node II

import structure.Node
import scala.collection.mutable.{Queue => mQueue}

object DaySix {

  def fill(collection: mQueue[Node]): Unit = {
    var prevNode: Node = null
    val nextLevel      = new mQueue[Node]
    while (collection.nonEmpty) {
      val node = collection.dequeue()
      if (node.left != null) nextLevel.enqueue(node.left)
      if (node.right != null) nextLevel.enqueue(node.right)
      if (prevNode != null) prevNode.next = node
      prevNode = node
    }

    if (nextLevel.nonEmpty) {
      fill(nextLevel)
    }

  }

  def connect(root: Node): Node = {
    fill(new mQueue[Node] {
      enqueue(root)
    })

    root
  }
}
