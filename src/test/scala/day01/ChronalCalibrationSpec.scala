package day01

import org.specs2.mutable.Specification

import scala.io.Source

class ChronalCalibrationSpec extends Specification {

  "A `ChronalCalibration`" should {
    "when calling calibrate" >> {
      "calibrate a list of positive elements" >> {
        ChronalCalibration.calibrate(List("+1", "+1", "+1")) === 3
      }
      "calibrate a list of positive and negative elements" >> {
        ChronalCalibration.calibrate(List("+1", "+1", "-2")) === 0
      }
      "calibrate a list of negative elements" >> {
        ChronalCalibration.calibrate(List("-1", "-2", "-3")) === -6
      }
      "calibrate the input list" >> {
        val lineList: List[String] = Source.fromFile(getClass.getResource("/day01/input.txt").getPath).getLines.toList
        ChronalCalibration.calibrate(lineList) === 402
      }
    }
    "when calling calibrate2" >> {
      "calibrate the list +1 -1" >> {
        ChronalCalibration.calibrate2(List("+1", "-1")) === 0
      }
      "calibrate the list +3, +3, +4, -2, -4" >> {
        ChronalCalibration.calibrate2(List("+3", "+3", "+4", "-2", "-4")) === 10
      }
      "calibrate the list -6, +3, +8, +5, -6" >> {
        ChronalCalibration.calibrate2(List("-6", "+3", "+8", "+5", "-6")) === 5
      }
      "calibrate the list +7, +7, -2, -7, -4" >> {
        ChronalCalibration.calibrate2(List("+7", "+7", "-2", "-7", "-4")) === 14
      }
      "calibrate the input list" >> {
        val lineList: List[String] = Source.fromFile(getClass.getResource("/day01/input.txt").getPath).getLines.toList
        ChronalCalibration.calibrate2(lineList) === 481
      }
    }
  }

}
