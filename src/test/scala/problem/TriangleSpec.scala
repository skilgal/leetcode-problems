package problem

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers


class TriangleSpec extends AnyWordSpec with Matchers {
  "minimum total" should {
    "example 1" in {
      Triangle.minimumTotalRec(
        List(List(2),List(3,4),List(6,5,7),List(4,1,8,3))
      ) shouldBe 11
    }

    "example 2" in {
      Triangle.minimumTotalRec(
        List(List(-10))
      )
    }
  }
}
