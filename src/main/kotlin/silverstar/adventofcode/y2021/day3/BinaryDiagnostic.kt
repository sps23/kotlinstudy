package silverstar.adventofcode.y2021.day3

import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException

/*
--- Day 3: Binary Diagnostic ---
The submarine has been making some odd creaking noises, so you ask it to produce a diagnostic report just in case.
The diagnostic report (your puzzle input) consists of a list of binary numbers which, when decoded properly,
can tell you many useful things about the conditions of the submarine.
The first parameter to check is the power consumption.
You need to use the binary numbers in the diagnostic report to generate two new binary numbers
(called the gamma rate and the epsilon rate). The power consumption can then be found by multiplying
the gamma rate by the epsilon rate.

Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position
of all numbers in the diagnostic report. For example, given the following diagnostic report:
00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010

Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.
The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.
The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.
So, the gamma rate is the binary number 10110, or 22 in decimal.
The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used.
So, the epsilon rate is 01001, or 9 in decimal.
Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.
Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
 */

fun main() {

  val sampleInput =
      sequenceOf(
          "00100",
          "11110",
          "10110",
          "10111",
          "10101",
          "01111",
          "00111",
          "11100",
          "10000",
          "11001",
          "00010",
          "01010")
  fun readInput(): Sequence<String> =
      {}.javaClass.getResourceAsStream("/BinaryDiagnostic.txt")?.bufferedReader()?.lineSequence()
          ?: sequenceOf()

  println(calculatePowerConsumption(sampleInput)) // expected 198
  println(calculatePowerConsumption(readInput())) // expected 4160394
}

fun calculatePowerConsumption(input: Sequence<String>): Int =
    input.map { BitCount.create(it) }.reduce { acc, bitCount -> acc + bitCount }.powerConsumption

data class BitCount private constructor(private val bitCount: List<Int>) {

  private val size = bitCount.size

  val powerConsumption: Int
    get() = this.gamma * this.epsilon

  private fun bitCountFold(operation: (acc: StringBuilder, Int) -> StringBuilder): Int =
      bitCount.fold(StringBuilder(), operation).toString().toInt(2)

  private val gamma: Int = bitCountFold { acc, count ->
    if (count <= 0) acc.append('0') else acc.append('1')
  }
  private val epsilon: Int = bitCountFold { acc, count ->
    if (count <= 0) acc.append('1') else acc.append('0')
  }

  operator fun plus(b: BitCount): BitCount =
      if (b.size == size) {
        BitCount(b.bitCount.zip(bitCount).map { it.first + it.second })
      } else {
        throw UnsupportedOperationException("Cannot add instances of different size")
      }

  companion object {
    fun create(s: String): BitCount =
        BitCount(
            s.toCharArray().map {
              when (it) {
                '0' -> -1
                '1' -> 1
                else -> throw IllegalArgumentException("Input must be a binary number string")
              }
            })
  }
}
