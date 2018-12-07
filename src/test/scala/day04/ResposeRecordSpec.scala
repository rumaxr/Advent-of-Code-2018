package day04

import day04.ReposeRecord.{BeginShift, FallAsleep, Record, WakeUp}
import org.specs2.mutable.Specification

import scala.io.Source

class ResposeRecordSpec extends Specification {
  "A `ResposeRecord`" should {
    "when calling parseRecords" >> {
      "return a list of Record" >> {
        val input =
          """[1518-11-01 00:05] falls asleep
[1518-11-01 00:00] Guard #10 begins shift
[1518-11-01 00:25] wakes up"""

        ReposeRecord.parseRecords(input) === List(
          Record("1518-11-01 00:00", BeginShift(10)),
          Record("1518-11-01 00:05", FallAsleep),
          Record("1518-11-01 00:25", WakeUp),
        )
      }
    }
    "when calling parseRecords" >> {
      "Strategy1" >> {
        "on test input" >> {
          val input: String = Source.fromInputStream(getClass.getResourceAsStream("/day04/input_test.txt")).mkString.trim
          ReposeRecord.Strategy1.choose(input) === 240
        }
        "on actual input" >> {
          val input: String = Source.fromInputStream(getClass.getResourceAsStream("/day04/input.txt")).mkString.trim
          ReposeRecord.Strategy1.choose(input) === 118599
        }
      }
      "Strategy2" >> {
        "on test input" >> {
          val input: String = Source.fromInputStream(getClass.getResourceAsStream("/day04/input_test.txt")).mkString.trim
          ReposeRecord.Strategy2.choose(input) === 4455
        }
        "on actual input" >> {
          val input: String = Source.fromInputStream(getClass.getResourceAsStream("/day04/input.txt")).mkString.trim
          ReposeRecord.Strategy2.choose(input) === 33949
        }
      }
    }
  }
}
