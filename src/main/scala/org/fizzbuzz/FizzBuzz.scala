package org.fizzbuzz

object FizzBuzz extends FizzBuzzCore {
  // If number is divisible by 3 and by 5: return Fizzbuzz
  // if divisible by 5, return Buzz
  // if by 3: Fizz
  // otherwise: number itself
  def parse(n: Int): String = {
    val conditions = Seq(15 -> "Fizzbuzz", 3 -> "Fizz", 5 -> "Buzz")
    for ((key, value) <- conditions) if (n % key == 0) return value
    n.toString
  }
  (1 to 100).map(parse _ andThen println)
}