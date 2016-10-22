package org.fizzbuzz

object FizzbuzzHigherOrder extends FizzbuzzCore {

  // describes functions like fizz and buzz
  type intToBooleanTranslator = Int => Boolean

  // 'superfunction' that makes a more complex function out of two functions
  def both(f1: intToBooleanTranslator, f2: intToBooleanTranslator): intToBooleanTranslator = {
    (i: Int) => f1(i) && f2(i)
  }

  // returns true if number is divisible by 3
  def fizz(i: Int): Boolean = i % 3 == 0

  // returns true if number is divisible by 5
  def buzz(i: Int): Boolean = i % 5 == 0

  // returns true if fizz and buzz
  def fizzbuzz: intToBooleanTranslator = both(fizz, buzz)

  def parse(i: Int): String = {
    if (fizzbuzz(i)) "Fizzbuzz"
    else if (fizz(i)) "Fizz"
    else if (buzz(i)) "Buzz"
    else i.toString
  }

  // true if number is one to hundred
  def oneToHundred(i:Int):Boolean = i > 0 && i <= 100

  val limitedFizzbuzz = both(fizzbuzz, oneToHundred)
}