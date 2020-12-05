package daily

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class DayFiveSpec extends AnyWordSpec with Matchers {

  "find free place" must {
    "flowerbed = [1,0,0,0,1], n = 1 is true" in {
      DayFive.canPlaceFlowers(Array(1,0,0,0,1), 1) shouldBe true
    }

    "flowerbed = [1,0,0,0,1], n = 2 is false" in {
      DayFive.canPlaceFlowers(Array(1,0,0,0,1), 2) shouldBe false
    }

    "flowerbed = [0,0,1,0,1], n = 1 is true" in {
      DayFive.canPlaceFlowers(Array(0,0,1,0,1), 1) shouldBe true
    }
  }

}
