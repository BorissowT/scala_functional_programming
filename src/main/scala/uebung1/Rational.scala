package uebung1

class Rational (val numerator:Int, val denominator:Int){

  def this (denom:Int) = this(1,denom)
  require (denominator!=0,"Denominator muss != 0 sein")

  override def toString:String = s"$num/$denom"
  def num:Int=numerator/divisor
  def denom:Int= denominator/divisor
  def value:Double = (num.toDouble / denom)

  private val divisor = gcd(numerator, denominator)

  private def gcd(a:Int, b:Int ): Int = {
    if(b == 0) {
      if(this.denominator<0 && this.numerator<0)
        -a.abs
      else if(this.denominator<0 && this.numerator>0)
        -a.abs
      else a.abs
    } else gcd(b,a%b)
  }
  def max(x:Rational): Rational = {

    if (numerator/denominator<x.num/x.denom) this else x
  }
  def add(y:Rational): Rational = {
    val newNum = this.numerator*y.denominator+y.numerator*this.denominator
    val newDen = this.denominator*y.denominator
    new Rational(newNum,newDen)
  }
  def sub(y:Rational): Rational = add(y.neg())
  def neg(): Rational = {
    new Rational(-this.numerator, this.denominator)
  }
  def mul(y:Rational): Rational = {
    val denominator = this.denominator*y.denominator
    new Rational(this.numerator*y.numerator, denominator)
  }

}

