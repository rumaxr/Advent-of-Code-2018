package day05

import org.specs2.mutable.Specification

import scala.io.Source

class AlchemicalReductionSpec extends Specification {

  sequential

  "A `AlchemicalReduction`" should {
    "when calling scan" >> {
      "with test input" >> {
        "Aa" >> {
          AlchemicalReduction.scan("Aa") === 0
        }
        "abBA" >> {
          AlchemicalReduction.scan("Aa") === 0
        }
        "abAB" >> {
          AlchemicalReduction.scan("abAB") === 4
        }
        "aabAAB" >> {
          AlchemicalReduction.scan("aabAAB") === 6
        }
        "dabAcCaCBAcCcaDA" >> {
          AlchemicalReduction.scan("dabAcCaCBAcCcaDA") === 10
        }
        "aabBccdDd" >> {
          AlchemicalReduction.scan("aabBccdDd") === 5
        }
        "abcCBA" >> {
          AlchemicalReduction.scan("abcCBA") === 0
        }
//        "JGgjCcpPeuUEPpvcDdCsSgGVNDdKkKkQJjqQLlSkKssSqKfFkNnwWlLnuxXaAUpPtBppPPMmiIbAaTllLYyLeRrjMmJFgJjGfPpElLl" >> {
//          AlchemicalReduction.scan("JGgjCcpPeuUEPpvcDdCsSgGVNDdKkKkQJjqQLlSkKssSqKfFkNnwWlLnuxXaAUpPtBppPPMmiIbAaTllLYyLeRrjMmJFgJjGfPpElLl") === 0
//        }

      }
      "with actual input" >> {
        val input: String = Source.fromInputStream(getClass.getResourceAsStream("/day05/input.txt")).mkString.trim
        AlchemicalReduction.scan(input) === 12380
      }
    }
  }
}
