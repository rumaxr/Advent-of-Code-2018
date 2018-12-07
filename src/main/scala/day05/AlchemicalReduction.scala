package day05

object AlchemicalReduction {

  def isOppositeCase(a: Char, b: Char): Boolean = {
    a.isUpper && !b.isUpper || !a.isUpper && b.isUpper
  }

  def isSameCharacterCaseInsensitive(a: Char, b: Char): Boolean = {
    a.toLower == b.toLower
  }

  def check(a: Char, b: Char): Boolean = {
//    println("check", a, b)
    isSameCharacterCaseInsensitive(a, b) && isOppositeCase(a, b)
  }

  def scan(input: String): Int = {
//    println("input", input)

    def checkEnd(char: Char) = {
      if (char == '-') input.takeRight(1).toString else ""
    }

    def go(input: String): String = {
      val result: (Char, String) = input
        .sliding(2, 1)
        .foldLeft(('-', "")) {
          (dataTuple: (Char, String), subject: String) => {
            // dataTuple._1 is last char
            // dataTuple._2 is result string
//            println("resultString", dataTuple._2, "lastChar", dataTuple._1, "subject", subject)

            if (!check(subject(0), subject(1))) { // geen gelijke characters
              if(check(dataTuple._1, subject(0))) // vorige matched
                ('-', dataTuple._2)
              else
                ('-', dataTuple._2 + subject(0))
            }
            else { // gelijke characters
              if(check(dataTuple._1, subject(0))) // vorige matched
                (subject(0), dataTuple._2 + subject(0))
              else
                (subject(0), dataTuple._2)
            }

//            if (check(subject(0), subject(1))) {
//              if (check(dataTuple._1, subject(0))) {
//                (subject(1), dataTuple._2 + subject(0))
//              }
//              else {
//                (subject(1), dataTuple._2)
//              }
//            }
//            else if (dataTuple._1 == ' ') {
//              (subject(1), dataTuple._2)
//            }
//            else {
//              (' ', dataTuple._2 + subject(0))
//            }
        }
      }

//      println("result._1", result._1)
      val fixedResult = result._2 + checkEnd(result._1)

      if (input == fixedResult) {
        fixedResult
      }
      else if (fixedResult.isEmpty)
        ""
      else {
//        println("fixedResult", fixedResult)
        go(fixedResult)
      }
    }

    val result: String = go(input)

//    println("result", result)

    result.length



    //    println("input", input)
    //
    //    def go(input: String): String = {
    //      val result = input.scanLeft("") {
    //        (characterA, characterB) =>
    //          println("a", characterA, "b", characterB)
    //
    //          if (characterA == "*") {
    //            characterB.toString
    //          }
    //          else if (characterB == '*') {
    //            ""
    //          }
    //          else if (characterA == "") {
    //            characterB.toString
    //          }
    //          else if (check(characterA(0), characterB)) {
    //            "*"
    //          }
    //          else {
    //            characterB.toString
    //          }
    //      }.mkString
    //
    //      if (input.length == result.length && !result.contains("*")) {
    //        result
    //      }
    //      else {
    //        println("result", result)
    //        go(result)
    //      }
    //    }
    //
    //    val result = go(input)
    //
    //    println("result", result)
    //
    //    result.length
  }
}
