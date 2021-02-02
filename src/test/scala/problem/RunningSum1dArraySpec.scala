package problem

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class RunningSum1dArraySpec extends AnyWordSpec with Matchers {
  "running sum" must {
    "be correct" in {
      RunningSum1dArray
        .runningSum(Array(1, 2, 3, 4)) shouldBe Array(1, 3, 6, 10)
    }

    "example 2 " in {
      RunningSum1dArray
        .runningSum(Array(1, 1, 1, 1, 1)) shouldBe Array(1, 2, 3, 4, 5)
    }

    "example 3" in {
      RunningSum1dArray
        .runningSum(Array(3, 1, 2, 10, 1)) shouldBe Array(3, 4, 6, 16, 17)
    }
  }
}
