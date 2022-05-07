// 1209. Remove All Adjacent Duplicates in String II
//
//
package problem

object RemoveAllAdjucentDuplicatesInStringII extends App {

  def removeDuplicates(s: String, k: Int): String = {
    import scala.collection.mutable.Stack

    // 1123 ms	88.6 MB	scala
    // s.foldLeft(new Stack[(Char, Int)]()) {
    //   case (stack, elem) =>
    //     lazy val (ch, count) = stack.last
    //     stack match {
    //       case Nil                 => stack += ((elem, 1))
    //       case _ if ch != elem     => stack += ((elem, 1))
    //       case _ if count == k - 1 => stack.dropRightInPlace(1); stack
    //       case _                   => stack(stack.size - 1) = ((ch, count + 1)); stack
    //     }
    // }.map(t => t._1.toString * t._2)
    //   .mkString

    // 728 ms	59 MB	scala
    val buffer = new Stack[(Char, Int)]() addOne (s(0), 1)

    for (ind <- s.indices.drop(1)) {
      lazy val (ch, count) = buffer.last
      if (buffer.nonEmpty && s(ind) == ch) {
        if (count == k - 1) buffer.dropRightInPlace(1)
        else buffer(buffer.size - 1) = (ch, count + 1)
      } else buffer += ((s(ind), 1))

    }

    buffer.map(t => t._1.toString * t._2).mkString

  }

  println(removeDuplicates("deeedbbcccbdaa", 3) == "aa")
  println(removeDuplicates("abcd", 2) == "abcd")

}
