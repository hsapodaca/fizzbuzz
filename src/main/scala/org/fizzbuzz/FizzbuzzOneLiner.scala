package org.fizzbuzz

object FizzbuzzOneLiner extends FizzbuzzCore {
  /* fizzbuzz 'one liner' with scala collections */
  def parse(i: Int) = Seq(15 -> "Fizzbuzz", 3 -> "Fizz", 5 -> "Buzz")
    .find(i % _._1 == 0)
    .map(_._2)
    .getOrElse(i.toString)

  for (i <- 1 to 100)
    println(parse(i))
}
