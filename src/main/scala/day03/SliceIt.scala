package day03

import scala.util.matching.Regex.Match

case class ClaimDetail(index: Int, x: Int, y: Int, width: Int, height: Int)

case class Fabric(matrix: Array[Array[List[Int]]])

case class FabricAndIntact(fabric: Fabric, intactList: List[Int])

object SliceIt {

  def calculateOverlappingFabric(claimList: List[String], width: Int, height: Int): (Int, Int) = {
    val updatedFabricAndIntact = claimList.foldLeft(FabricAndIntact(Fabric(Array.ofDim[List[Int]](width, height)), List.empty[Int])) {
      (data, claim) =>
        var intact = true
        var overwriteList = List.empty[Int]
        val claimDetail = extractClaimDetail(claim)

        for (y <- claimDetail.x until claimDetail.x + claimDetail.width)
          for (x <- claimDetail.y until claimDetail.y + claimDetail.height) {
            val currentCell = data.fabric.matrix(x)(y)

            if (currentCell == null)
              data.fabric.matrix(x)(y) = List(claimDetail.index)
            else {
              data.fabric.matrix(x)(y) = claimDetail.index :: currentCell
              overwriteList = currentCell.diff(overwriteList) ::: overwriteList
              intact = false
            }
          }

        FabricAndIntact(data.fabric, updateIntactList(data.intactList, intact, claimDetail.index, overwriteList))
    }

    (getOverlappingCount(updatedFabricAndIntact.fabric), updatedFabricAndIntact.intactList.head)
  }

  def updateIntactList(intactList: List[Int], intact: Boolean, id: Int, overwriteList: List[Int]): List[Int] = {
    if (intact)
      id :: intactList
    else
      intactList.filter(!overwriteList.contains(_))
  }

  def getOverlappingCount(fabric: Fabric): Int = {
    fabric.matrix.map(row => row.count(col => col != null && col.length > 1)).sum
  }

  def printFabric(fabric: Fabric): Unit = {
    fabric.matrix.foreach {
      row => {
        row.foreach(
          col =>
            if (col == null)
              print(".")
            else if (col.length > 1)
              print("X")
            else if (col.length == 1)
              print(col.head)
            else
              print(".")
        )
        print("\n")
      }
    }
  }

  def extractClaimDetail(claim: String): ClaimDetail = {
    val m: Match = """#([\d]+)\s@\s(\d+),(\d+):\s(\d+)x(\d+)""".r.findFirstMatchIn(claim).toList.head

    def getIntFromGroup(regexMatch: Match, groupId: Int): Int = regexMatch.group(groupId).toInt

    ClaimDetail(
      index = getIntFromGroup(m, 1),
      x = getIntFromGroup(m, 2),
      y = getIntFromGroup(m, 3),
      width = getIntFromGroup(m, 4),
      height = getIntFromGroup(m, 5)
    )
  }
}
