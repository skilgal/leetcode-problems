package daily

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class DayFourSpec extends AnyWordSpec with Matchers {
  "kthFactor" must {
    "return 3" in {
      DayFour.kthFactor(12, 3) shouldBe 3
    }

    "return 7" in {
      DayFour.kthFactor(7, 2) shouldBe 7
    }

    "rutern -1" in {
      DayFour.kthFactor(4, 4) shouldBe -1
    }

    "return 1" in {
      DayFour.kthFactor(1, 1) shouldBe 1

    }
    "return 4" in {
      DayFour.kthFactor(1000, 3) shouldBe 4
    }
  }
}
