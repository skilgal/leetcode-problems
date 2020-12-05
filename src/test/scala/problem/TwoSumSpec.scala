package problem

import org.scalatest._
import matchers.should._
import org.scalatest.wordspec.AnyWordSpec

class TwoSumSpec extends AnyWordSpec with Matchers {
  "two sum" must {
    "return 0, 1 for [2,7,11,15] 9" in {
      TwoSum.twoSum(Array(2, 7, 11, 15), 9) shouldBe Array(0, 1)
    }

    "return 1, 2 for [3,2,4] 6" in {
      TwoSum.twoSum(Array(3, 2, 4), 6) shouldBe Array(1, 2)
    }

    "return 0,1 for [3,3] 6" in {
      TwoSum.twoSum(Array(3, 3), 6)
    }
  }
}
