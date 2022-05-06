// 2181. Merge Nodes in Between Zeros

/**
  * Definition for singly-linked list.
  * class ListNode(_x: Int = 0, _next: ListNode = null) {
  *   var next: ListNode = _next
  *   var x: Int = _x
  * }
  */
object MergeNodesInBetweenZeros extends App {
  implicit class ArrayOps[T](a: Array[T]) {
    def toListNode: ListNode[T] = {
      a.reverse.foldLeft(null: ListNode[T]) {
        case (ln, elem) =>
          ListNode(elem, ln)
      }
    }
  }

  case class ListNode[T](var x: T, var next: ListNode[T] = null)

  def mergeNodes(head: ListNode[Int]): ListNode[Int] = {
    var current = head.next
    var stepper = current
    var acc     = 0

    while (stepper.next != null) {
      if (stepper.x == 0) {
        current.x = acc
        current.next = stepper.next
        current = current.next
        stepper = current
        acc = 0
      } else {
        acc += stepper.x
        stepper = stepper.next
      }
    }

    current.x = acc
    current.next = stepper.next

    head.next
  }

  assert(
    mergeNodes(Array(0, 3, 1, 0, 4, 5, 2, 0).toListNode) ==
      Array(4, 11).toListNode
  )
  assert(
    mergeNodes(Array(0, 1, 0, 3, 0, 2, 2, 0).toListNode) ==
      Array(1, 3, 4).toListNode
  )

}
