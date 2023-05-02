package test
import org.scalatest.funsuite.AnyFunSuite
import uebung1.Rational

class RationalTest extends AnyFunSuite {

  test("Rational Inititalisation 1") {
    val x = new Rational(1,2)
    assert(x.value === 0.5)
  }
  
  test("Rational Inititalisation 2") {
    val x = new Rational(1,2)
    assertResult("1/2"){x.toString}
  }

  test("Test requirement (denominator!=0)"){
      intercept [IllegalArgumentException] {
        new Rational(1,0)}
  }

  test("Test addition"){
    val x = new Rational(1,2)
    val y = x.add(new Rational(1,6))
    assertResult("2/3"){y.toString}
  }

  test("Test subtraction"){
    val x = new Rational(1,2)
    val y = x.sub(new Rational(1,6))
    assertResult("1/3"){y.toString}
  }

  test("Test negation"){
    val x = new Rational(1,2).neg()
    assertResult("-1/2"){x.toString}
  }

  test("Test multiplication"){
    val x = new Rational(1,2)
    val y = x.mul(new Rational(1,2))
    assertResult("1/4"){y.toString}
  }

  test("Test both negative"){
    val x = new Rational(-1,-2)
    assertResult("1/2"){x.toString}
  }

  test("Test denom is negative"){
    val x = new Rational(1,-2)
    assertResult("-1/2"){x.toString}
  }


}
