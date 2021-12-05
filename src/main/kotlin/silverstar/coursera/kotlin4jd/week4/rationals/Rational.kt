package silverstar.coursera.kotlin4jd.week4.rationals

import java.math.BigDecimal
import java.math.BigInteger

class RationalRange(override val start: Rational, override val endInclusive: Rational) :
    ClosedRange<Rational>

data class Rational
private constructor(private val numerator: BigInteger, private val denominator: BigInteger) :
    Comparable<Rational> {

    companion object {
        fun integer(numerator: BigInteger): Rational = Rational(numerator, BigInteger.ONE)

        fun create(n: BigInteger, d: BigInteger): Rational {
            require(d != BigDecimal.ZERO) { "Denominator must be non-zero" }
            val gcd = n.gcd(d)
            val sign = d.signum().toBigInteger()
            return Rational(n / gcd * sign, d / gcd * sign)
        }
    }

    operator fun plus(r: Rational): Rational {
        val a = this.toComDen(r)
        val b = r.toComDen(this)
        return create(a.numerator + b.numerator, a.denominator)
    }

    operator fun minus(r: Rational): Rational {
        val a = this.toComDen(r)
        val b = r.toComDen(this)
        return create(a.numerator - b.numerator, a.denominator)
    }

    operator fun times(r: Rational): Rational =
        create(this.numerator * r.numerator, this.denominator * r.denominator)

    operator fun div(r: Rational): Rational = this * create(r.denominator, r.numerator)

    operator fun rangeTo(r: Rational): ClosedRange<Rational> =
        RationalRange(this.toComDen(r), r.toComDen(this))

    operator fun unaryMinus(): Rational = create(numerator.negate(), denominator)

    override fun compareTo(other: Rational): Int {
        val a = this.toComDen(other)
        val b = other.toComDen(this)
        return a.numerator.compareTo(b.numerator)
    }

    override fun toString(): String =
        if (denominator == BigInteger.ONE) "$numerator" else "$numerator/$denominator"

    // toCommonDenominator
    private fun toComDen(r: Rational): Rational =
        Rational(numerator * r.denominator, denominator * r.denominator)
}

infix fun Int.divBy(i: Int): Rational = Rational.create(this.toBigInteger(), i.toBigInteger())

infix fun Long.divBy(l: Long): Rational = Rational.create(this.toBigInteger(), l.toBigInteger())

infix fun BigInteger.divBy(bi: BigInteger): Rational = Rational.create(this, bi)

fun String.toRational(): Rational =
    if (this.contains('/')) {
        val (n, d) = this.trim().split('/')
        Rational.create(n.toBigInteger(), d.toBigInteger())
    } else {
        Rational.integer(this.toBigInteger())
    }

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}
