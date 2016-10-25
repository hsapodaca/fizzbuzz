package org.fizzbuzz

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

// this is a brute force approach with large number ranges - there are better ways to do this
class FizzbuzzBruteForceTests extends FeatureSpec with GivenWhenThen with Matchers with FizzbuzzTests {

  val range = -100 to 99999

  fizzbuzzes.foreach { f => // let's test each fizzbuzz
    scenario(s"${getName(f)} - test that multiples of 3 but not 5 return fizz") {
      Given(s"a fizzbuzz implementation (${getName(f)}) and a range of ${range.size} numbers divisible by 3 but not 5")
      When("fizzbuzz processes each value")
      Then("it should only return Fizz")
      for (i <- range.map(_ * 3) if i % 15 != 0)
        f.parse(i) should be ("Fizz")
    }
    scenario(s"${getName(f)} - test that multiples of 5 but not 3 return buzz") {
      Given(s"a fizzbuzz implementation (${getName(f)}) and a range of ${range.size} numbers divisible by 5 but not 3")
      When("fizzbuzz processes each value")
      Then("it should only return Buzz")
      for (i <- range.map(_ * 5) if i % 15 != 0)
        f.parse(i) should be ("Buzz")
    }

    scenario(s"${getName(f)} - test that multiples of 5 times 3 return fizzbuzz") {
      Given(s"a fizzbuzz implementation (${getName(f)}) and a range of ${range.size} numbers divisible by 3 and by 5")
      When("fizzbuzz processes each value")
      Then("it should only return Fizzbuzz")
      for (i <- range.map(_ * 15))
        f.parse(i) should be ("Fizzbuzz")
    }

    scenario(s"${getName(f)} - test that numbers not divisible by 5 or 3 or 15 return number itself as string") {
      Given(s"a fizzbuzz implementation (${getName(f)}) and a range of ${range.size} numbers not divisible by 3 or by 5")
      When("fizzbuzz processes each value")
      Then("it should only return string representation of number itself")
      for (i <- range.map(_ * 1) if i % 3 != 0 && i % 5 != 0)
        f.parse(i) should be (i.toString)
    }
  }
}
