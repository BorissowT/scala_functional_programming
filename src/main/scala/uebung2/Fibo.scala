package uebung2

import scala.annotation.tailrec

object  Fibo {
  // no variables
  // no while loops

  def fibo(searchedGlob: Int):Long={
    @tailrec
    def fiboHelper(f1:Long, f2:Long, step:Int): Long = {
      if (step <= searchedGlob) fiboHelper(f2, f1+f2, step+1)
      else f1+f2
    }
    if(searchedGlob==0)0
    else if (searchedGlob==1)1
    else
      fiboHelper(1, 0, 2)
  }

  def main(args: Array[String]): Unit = {
    println(fibo(80))
  }

}
