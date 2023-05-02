package uebung2

import scala.annotation.tailrec

object PatternMatching {

  def multiple2(y: Double): Double = y match {
    case 0 => 0
    case _ if ((y % 3 == 0) || (y % 5 == 0)) => (y + multiple2(y - 1))
    case _ if (y > 0) => multiple2(y - 1)
    case _ => throw new Error("No negative Numbers!")
  }

  @tailrec
  def contains(l: List[Int], e: Int): Boolean = l match {
    case Nil => false
    case x :: xs if (x == e) => true
    case x :: xs => contains(xs, e)
  }

  def main(args: Array[String]): Unit = {

  }

}
