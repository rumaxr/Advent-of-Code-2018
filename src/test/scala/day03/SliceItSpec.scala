package day03

import org.specs2.mutable.Specification

import scala.io.Source

class SliceItSpec extends Specification {
  "A `SliceIt`" should {
    "when calling extractClaimDetail" >> {
      "return a valid ClaimDetail from input" >> {
        "#1 @ 1,3: 4x4" >> {
          SliceIt.extractClaimDetail("#1 @ 1,3: 4x4") === ClaimDetail(1, 1, 3, 4, 4)
        }
        "#2 @ 3,1: 4x4" >> {
          SliceIt.extractClaimDetail("#2 @ 3,1: 4x4") === ClaimDetail(2, 3, 1, 4, 4)
        }
        "#3 @ 5,5: 2x2" >> {
          SliceIt.extractClaimDetail("#3 @ 5,5: 2x2") === ClaimDetail(3, 5, 5, 2, 2)
        }
        "#4 @ 5,5: 2x2" >> {
          SliceIt.extractClaimDetail("#4 @ 5,6: 7x8") === ClaimDetail(4, 5, 6, 7, 8)
        }
      }
    }
    "when calling calculateOverlappingFabric" >> {
      "return a updated fabric" >> {
        "from test input" >> {
          val list = List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")

          SliceIt.calculateOverlappingFabric(list, 8, 8) === (4, 3)
        }
        "from actual input" >> {
          val list: List[String] = Source.fromFile(getClass.getResource("/day03/input.txt").getPath).getLines.toList

          SliceIt.calculateOverlappingFabric(list, 1000, 1000) === (107043, 346)
        }
      }
    }
  }
}
