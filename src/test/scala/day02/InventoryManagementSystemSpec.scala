package day02

import org.specs2.mutable.Specification

import scala.io.Source

class InventoryManagementSystemSpec extends Specification {
  "A `InventoryManagementSystem`" should {
    "when calling checksum" >> {
      "return checkSum of test input" >> {
        val list = List("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
        InventoryManagementSystem.checkSum(list) === 12
      }
      "return checkSum of actual input" >> {
        val list: List[String] = Source.fromFile(getClass.getResource("/day02/input.txt").getPath).getLines.toList
        InventoryManagementSystem.checkSum(list) === 7163
      }
    }

    "when calling findCorrectBoxes" >> {
      "return the correct boxes" >> {
        "from test input" >> {
          val list: List[String] = List[String]("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
          InventoryManagementSystem.findCorrectBoxes(list) === List("fghij", "fguij")
        }
        "from the actual input" >> {
          val list: List[String] = Source.fromFile(getClass.getResource("/day02/input.txt").getPath).getLines.toList
          InventoryManagementSystem.findCorrectBoxes(list) === List("ighfbbyijnoumxjlxevacpwqtr", "ighfbsyijnoumxjlxevacpwqtr")
        }
      }
    }

    "when calling removeDiffer" >> {
      "return the diff of the" >> {
        "test input" >> {
          InventoryManagementSystem.removeDiffer("fghij", "fguij") === "fgij"
        }
        "actual input" >> {
          InventoryManagementSystem.removeDiffer("ighfbbyijnoumxjlxevacpwqtr", "ighfbsyijnoumxjlxevacpwqtr") === "ighfbyijnoumxjlxevacpwqtr"
        }
      }
    }
  }
}
