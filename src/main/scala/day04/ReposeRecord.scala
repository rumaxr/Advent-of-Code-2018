package day04

import com.github.nscala_time.time.Imports._
import org.joda.time.format.DateTimeFormatter

import scala.util.matching.Regex

trait Event {
  def timestamp: DateTime
}

case class BeginsShiftEvent(timestamp: DateTime, guardId: Int) extends Event

case class FallAsleepEvent(timestamp: DateTime) extends Event

case class WakesUpEvent(timestamp: DateTime) extends Event

object ReposeRecord {

  private val eventRegex: Regex = """(?i)\[(\d{4}\-\d{2}\-\d{2}\s\d{2}:\d{2})\]\s([a-z#0-9\s]+)""".r
  private val beginsShiftRegex: Regex = """(?i)[a-z\s#]+(\d+)[a-z\s]+""".r
  private val dateTimeFormat: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")

  case class SleepTime(id: Int, start: Int, end: Int)

  def lineListToEventList(list: List[String]): List[Event] = {
    list.map {
      case eventRegex(datetime, detail) => {
        detail match {
          case beginsShiftRegex(id) => BeginsShiftEvent(DateTime.parse(datetime, dateTimeFormat), id.toInt)
          case x => if (x == "wakes up") WakesUpEvent(DateTime.parse(datetime, dateTimeFormat)) else FallAsleepEvent(DateTime.parse(datetime, dateTimeFormat))
        }
      }
    }
      .sortBy(_.timestamp)
  }
}
