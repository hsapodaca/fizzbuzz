package org.fizzbuzz

trait FizzbuzzTests {

  val fizzbuzzes = List(FizzBuzzBasic, FizzBuzzOneLiner, FizzBuzz, FizzBuzzHigherOrder)

  case class TestCase(inputs: List[Int], expected: String = "", hasUniqueResult: Boolean = false)

  // gets name of class
  def getName(i: Any): String = i.getClass.getSimpleName
}
