package org.fizzbuzz

object FizzBuzzHigherOrder extends FizzBuzzCore {

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

  val fizzbuzz: intToBooleanTranslator = both(fizz, buzz)

  // match case implementation of parse
  def parse(i: Int): String = i match { //TODO fix 31 out of 116 failing tests
    case i:Int if fizzbuzz(i) => "Fizzbuzz"
    case i:Int if fizz(i) => "Fizz"
    case i:Int if buzz(i) => "Buzz"
    case i:Int => i.toString
  }

  // true if number is one to hundred
  def oneToHundred(i:Int):Boolean = i > 0 && i <= 100

  val limitedFizzbuzz = both(fizzbuzz, oneToHundred)
}