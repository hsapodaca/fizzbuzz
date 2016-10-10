package org.fizzbuzz

object FizzBuzzBasic extends FizzBuzzCore {
  /* fizzbuzz implementation with basic if/else check */
  def parse(n: Int): String = {
    if (n % 3 == 0 && n % 5 == 0) "Fizzbuzz"
    else if (n % 3 == 0) "Fizz"
    else if (n % 5 == 0) "Buzz"
    else n.toString
  }
  (1 to 100).foreach(n => println(parse(n)))
}
