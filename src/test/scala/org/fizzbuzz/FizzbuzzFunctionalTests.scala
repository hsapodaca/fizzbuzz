package org.fizzbuzz

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

import scala.collection.immutable.Iterable

// this tests more functionality with less code than FizzbuzzTests
class FizzbuzzFunctionalTests extends FeatureSpec with GivenWhenThen with Matchers with FizzbuzzTests {

  lazy val tests: Iterable[TestCase] = Map(
    List(-3, 3, 6, 9, 99, 999999999) -> "Fizz",
    List(-5000, 5, 10, 50, 100, 5555) -> "Buzz",
    List(-15, 15, 30, 45, 15000000) -> "Fizzbuzz",
    List(0, -1, 1, 2, 44, 1000001, -11111111) -> "String representation of a number"
  ).map(t => TestCase(t._1, t._2, !t._2.startsWith("String rep")))

  for (t <- tests; f <- fizzbuzzes; i <- t.inputs) {
    scenario(s"${f.getClass.getSimpleName}($i) should be ${t.expected}") {
      Given(s"a fizzbuzz implementation ${getName(f)}")
      When(s"we give it a $i")
      t.hasUniqueResult match {
        case true =>
          Then(s"for each number ($i), a correct value (${t.expected}) should be returned")
          f.parse(i) should be(t.expected)
        case false =>
          Then(s"for each number ($i), string representation of the number ($i) should be returned")
          f.parse(i) should be(i.toString)
      }
    }
  }

  fizzbuzzes.foreach { f =>
    scenario(s"${getName(f)} if 42 then") {
      Given(s"a fizzbuzz implementation ${getName(f)}")
      When("we give it 42")
      Then("42 the answer to life, the universe and everything")
    }
  }
}