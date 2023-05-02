package uebung2

import scala.annotation.tailrec

object Prime1 {

  private def findPrime(globalSteps: Int): Long = {
    @tailrec
    def primeTest(x: Long, start: Long): Boolean = {
      if ((x % start) == 0 && start < x)
        false
      else if (start == x)
        true
      else
        primeTest(x, start + 1)
    }
    @tailrec
    def searchPrime(start: Long): Long ={
      if(!primeTest(start,2))
        searchPrime(start+1)
      else
        start
    }
    @tailrec
    def primeStepHelper(step: Int, start: Long): Long = {
      if(step < globalSteps) {
        primeStepHelper(step+1, searchPrime(start+1))
      }
      else
        start
    }
    primeStepHelper(1,2)
  }

  def main(args: Array[String]): Unit = {
    println(findPrime(10001))
  }
}
