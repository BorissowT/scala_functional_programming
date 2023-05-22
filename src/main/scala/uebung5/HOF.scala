package uebung5

import scala.annotation.tailrec


object HOF {

  def filter(I:List[Int], pred: Int => Boolean): List[Int] ={
    I match {
      case Nil => Nil
      case x::xs =>
        if(pred(x))x::filter(xs, pred) // if (true) return x else do not return x 
                    else filter(xs, pred)
    }
  }

  @tailrec
  def fold(I:List[Int], base: Int, func: (Int, Int) => Int): Int ={
    I match {
      case Nil => base
      case x::xs => fold(xs, base+x, func)

    }
  }

  def main(args: Array[String]): Unit = {

    println("summe: " + fold(List(1,2,3,4), 0, (x,y)=>x+y))

  }
}
