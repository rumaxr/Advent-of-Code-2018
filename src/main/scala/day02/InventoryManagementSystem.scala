package day02

object InventoryManagementSystem {
  def checkSum(idList: List[String]): Int = {
    val result = idList.map(line => {
      val map = line.groupBy(identity).mapValues(_.length)
      val valueList = map.values.toList
      val containsTwo = valueList.contains(2)
      val containsThree = valueList.contains(3)

      if (containsTwo && containsThree)
        (1, 1)
      else if (containsTwo)
        (1, 0)
      else if (containsThree)
        (0, 1)
      else
        (0, 0)
    })
      .foldLeft((0, 0))((tuple, acc) => {
        (acc._1 + tuple._1, acc._2 + tuple._2)
      })

    result._1 * result._2
  }
}
