package problem

object RemoveDuplicateLetters extends App {

  def removeDuplicateLetters(s: String): String = {
    import scala.collection.mutable.Stack

    val stack = new Stack[Char]()
    val lastIndex: Map[Char, Int] =
      s.distinct.map(c => (c, s.lastIndexOf(c))).toMap

    for (index <- s.indices) {
      val elem = s(index)
      if (stack.isEmpty) stack += elem
      else if (!stack.contains(elem)) {
        while (
          stack.nonEmpty && stack.last > elem && index < lastIndex(stack.last)
        ) {
          stack.dropRightInPlace(1)
        }
        stack += elem
      }
    }

    stack.mkString
  }

  println(removeDuplicateLetters("bcabc") == "abc")
  println(removeDuplicateLetters("cbacdcbc") == "acdb")

}
