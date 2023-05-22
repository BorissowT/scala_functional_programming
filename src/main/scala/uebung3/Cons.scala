package uebung3

trait IntList{
  def head:Int
  def tail:IntList

  def isEmpty:Boolean
  def contains(e: Int):Boolean
  def get(i: Int): Int
  def delete(e:Int):IntList
  def prefix(beforeList: IntList): IntList
  def prepend(x:Int): IntList
  def flip(): IntList
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



  override def prefix(beforeList: IntList): IntList = {
    beforeList.isEmpty match {
      case true => this
      case false => new Cons(beforeList.head, this.prefix(beforeList.tail))
    }
  }


  override def flip(): IntList = {
    // TODO is it possible to solve without prefix?
    this.tail.isEmpty match {
      case true => this
      case false => new Cons(this.head, Empty).prefix(this.tail.flip())
    }
  }
}

object Empty extends IntList {

  def prepend(x: Int): IntList =
    new Cons(x, Empty)

  override def isEmpty: Boolean = true

  override def contains(e: Int): Boolean = false

  override def get(i: Int): Int = -1

  override def delete(e: Int): IntList = ???

  override def prefix(beforeList: IntList): IntList = ???

  override def head: Int = ???

  override def tail: IntList = ???

  override def flip(): IntList = ???
}


object App {

  def main(args: Array[String]): Unit = {

    (x: Int) => x*x*x
  }
}