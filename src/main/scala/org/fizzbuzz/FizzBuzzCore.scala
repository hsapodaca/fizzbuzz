package org.fizzbuzz

// All fizzbuzzes extend this, to simplify tests
trait FizzBuzzCore extends App {
  /*Given a number, all fizzbuzzes should return correct printable value */
  def parse(i:Int): String
}
