package problem

object RemoveAllAdjacentDuplicatesInString extends App {
  def removeDuplicates(s: String): String = {
    import scala.collection.mutable.Stack

    val buffer = new Stack[Char]()

    s.foreach { elem =>
      if (buffer.nonEmpty && buffer.last == elem) buffer.dropRightInPlace(1)
      else buffer += elem
    }

    buffer.mkString

  }

  println(removeDuplicates("abbaca"))
}
