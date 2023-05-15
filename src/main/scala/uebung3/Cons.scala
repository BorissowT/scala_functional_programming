package uebung3

trait IntList{
  def isEmpty:Boolean
  def contains(e: Int):Boolean
  def get(i: Int): Int
  def delete(e:Int):IntList
}

/**
 * @param head: head of the list
 * @param tail: tail of the list
 */
class Cons (val head: Int, val tail:IntList) extends IntList{
  override def isEmpty: Boolean = false
  override def toString: String = "List("+head+","+tail+")"

  def contains(e:Int): Boolean ={
    if(e==head) true
    else this.tail.contains(e)
  }

  def get(i: Int): Int = {
  if (i==0) head
  else tail.get(i-1)
  }

  def prepend(x:Int): IntList = new Cons(x, this)

  override def delete(e: Int): IntList = {
    if(e==head)tail
    else new Cons(head,this.tail.delete(e))
  }
}

object Empty extends IntList {

  def prepend(x: Int): IntList =
    new Cons(x, Empty)

  override def isEmpty: Boolean = true

  override def contains(e: Int): Boolean = false

  override def get(i: Int): Int = -1

  override def delete(e: Int): IntList = ???
}


object App {

  def main(args: Array[String]): Unit = {

    val x = new Cons(4, new Cons(7, new Cons(3, Empty)))
    val y = x.delete(7)
    println("hel")
  }
}