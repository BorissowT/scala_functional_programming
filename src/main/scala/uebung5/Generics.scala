package uebung5

object Generics {

  //@tailrec
  def fold[In, Out](I:List[In], base: Out, func: (In, Out) => Out): Out ={
    I match {
      case Nil => base
      case x::xs =>
        func(x, fold(xs, base, func))
      //fold(xs, func(base:In, x), func)

    }
  }

  def main(args: Array[String]): Unit = {

    //println("summe: " + fold(List(1,2,3,4), 0.0, (x: Int,y:Float) =>x+y))
    println("summe: " + List(1,2,3,4).reduceLeft((x,y)=>x+y))
  }

}
