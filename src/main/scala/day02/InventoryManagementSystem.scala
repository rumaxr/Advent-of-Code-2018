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
}
