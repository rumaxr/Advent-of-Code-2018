package day04

import org.specs2.mutable.Specification

class ResposeRecordSpec extends Specification {
  "A `ResposeRecord`" should {
    "when calling lineListToEventList" >> {
      "return a list of events" >> {
        val list = List(
          "[1518-11-01 00:05] falls asleep",
          "[1518-11-01 00:00] Guard #10 begins shift",
          "[1518-11-01 00:25] wakes up"
        )
        val result = ReposeRecord.lineListToEventList(list)

        result.length === 3

        result.head.isInstanceOf[BeginsShiftEvent]
        result.head.timestamp.getDayOfMonth === 1
        result.head.timestamp.getMonthOfYear === 11
        result.head.timestamp.getYear === 1518
        result.head.timestamp.getHourOfDay === 0
        result.head.timestamp.getMinuteOfHour === 0
        result.head.asInstanceOf[BeginsShiftEvent].guardId === 10

        result(1).isInstanceOf[FallAsleepEvent]
        result(1).timestamp.getHourOfDay === 0
        result(1).timestamp.getMinuteOfHour === 5

        result(2).isInstanceOf[WakesUpEvent]
        result(2).timestamp.getHourOfDay === 0
        result(2).timestamp.getMinuteOfHour === 25
      }
    }
  }
}
