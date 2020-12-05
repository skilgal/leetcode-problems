package daily

import scala.util.Random

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int         = _x
}

class DayTwo(_head: ListNode) {

  /** @param head The linked list's head.
    *        Note that the head is guaranteed to be not null, so it contains at least one node.
    */

  def size(): Int = {
    var elem  = _head
    var count = 1
    while (elem.next != null) {
      count += 1
      elem = elem.next
    }
    count
  }

  /** Returns a random node's value. */
  def getRandom(): Int = {
    var randIndex = new Random().nextInt(size())
    var elem      = _head
    while (randIndex != 0) {
      elem = elem.next
      randIndex -= 1
    }
    elem.x
  }

}
