package day02

object InventoryManagementSystem {
  def checkSum(idList: List[String]): Int = {
    val charCountList = idList.map(_
      .groupBy(identity)
      .values
      .map(_.length)
      .toSet
    )
      .foldLeft((0, 0)) {
        case (countData, charCount) =>
          (countData._1 + charCount.count(_ == 2), countData._2 + charCount.count(_ == 3))
      }

    charCountList._1 * charCountList._2
  }

  def findCorrectBoxes(idList: List[String]): List[String] = {
    idList
      .combinations(2)
      .map(combination => {
        if ((combination.head, combination.last).zipped.map(_ == _).count(_ == true) == combination.head.length - 1) {
          combination
        }
        else
          List.empty[String]
      })
      .filter(_.nonEmpty)
      .flatten
      .toList
  }

  def removeDiffer(strA: String, strB: String): String = {
    (strA, strB).zipped.filter(_ == _)._1
  }
}
