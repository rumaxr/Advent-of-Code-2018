package day01

import scala.annotation.tailrec

object ChronalCalibration {
  def calibrate(rowList: List[String]): Int = rowList.map(_.toInt).sum
  def calibrate2(rowList: List[String]): Int = {

    val rowListInt: List[Int] = rowList.map(_.toInt)

    @tailrec
    def go(list: List[Int], resultList: List[Int], current: Int): Int = {

      if (list.isEmpty) {
        go(rowListInt, resultList, current)
      }
      else {
        val result: Int = current + list.head
        if (!resultList.contains(result)) {
          go(list.tail, result :: resultList, result)
        }
        else {
          result
        }
      }
    }

    go(rowListInt, List(0), 0)
  }
}
