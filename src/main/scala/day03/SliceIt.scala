package day03

object SliceIt {
  def createFabric(width: Int, height: Int): Array[Array[List[Int]]] = {
    Array.ofDim[List[Int]](width, height)
  }

  def calculateOverlappingFabric(claimList: List[String]): Int = {
    claimList.fold(createFabric(7, 7)) {
      (claim, fabric) match {
        val claimDetail = extractClaimDetail (claim)
      }
    }
  }

  def extractClaimDetail(claim: String): List[String] = {
    List.empty[String]
  }
}
