package uebung5


object HOF {

  def filter(I:List[Int], pred: Int => Boolean): List[Int] ={
    I match {
      case Nil => Nil
      case x::xs =>
        if(pred(x))x::filter(xs, pred) // if (true) return x else do not return x 
                    else filter(xs, pred)
    }
  }

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

    println("summe: " + fold(List(1,2,3,4), 0, (x:Int,y:Int)=>x+y));
    println("summe: " + List(1,2,3,4).reduceLeft((x,y)=>x+y))
  }
}
