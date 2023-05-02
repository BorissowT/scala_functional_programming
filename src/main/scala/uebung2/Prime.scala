package uebung2

import scala.annotation.tailrec

object Prime {

  @tailrec
  private def findPrime(x:Int): Int = {

    @tailrec
    def primeTest(x: Int, start: Int): Boolean = {
      if ((x % start) == 0 && start < x)
        false
      else if (start == x)
        true
      else
        primeTest(x, start + 1)
    }

    if(!primeTest(x,2))
      findPrime(x-1)
    else
      x
  }

  def main(args: Array[String]): Unit = {
    println(findPrime(10001))
  }

}
