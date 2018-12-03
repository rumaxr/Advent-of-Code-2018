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
  }
}
