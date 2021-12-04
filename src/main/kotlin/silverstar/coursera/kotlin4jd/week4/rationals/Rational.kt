package silverstar.coursera.kotlin4jd.week4.rationals

import java.math.BigInteger

class RationalRange(override val start: Rational, override val endInclusive: Rational) :
    ClosedRange<Rational>

class Rational(private val numerator: BigInteger, private val denominator: BigInteger) :
    Comparable<Rational> {

    companion object {
        val ZERO = Rational(BigInteger.ZERO, BigInteger.ONE)
        fun integer(numerator: BigInteger): Rational = Rational(numerator, BigInteger.ONE)
    }

    fun normalized(): Rational {
        val gcd = numerator.gcd(denominator)
        return if (gcd > BigInteger.ZERO) {
            Rational(numerator / gcd, denominator / gcd)
        } else {
            Rational(numerator, denominator)
        }
    }

    operator fun plus(r: Rational): Rational {
        val a = this.toComDen(r)
        val b = r.toComDen(this)
        val result = Rational(a.numerator + b.numerator, a.denominator)
        return result.normalized()
    }
    operator fun minus(r: Rational): Rational {
        val a = this.toComDen(r)
        val b = r.toComDen(this)
        val result = Rational(a.numerator - b.numerator, a.denominator)
        return result.normalized()
    }
    operator fun times(r: Rational): Rational =
        Rational(this.numerator * r.numerator, this.denominator * r.denominator).normalized()
    operator fun div(r: Rational): Rational = this * Rational(r.denominator, r.numerator)
    operator fun rangeTo(r: Rational): ClosedRange<Rational> =
        RationalRange(this.toComDen(r), r.toComDen(this))
    operator fun unaryMinus(): Rational = Rational(numerator.negate(), denominator)

    override fun compareTo(other: Rational): Int {
        val a = this.toComDen(other)
        val b = other.toComDen(this)
        return a.numerator.compareTo(b.numerator)
    }

    override fun toString(): String =
        if (denominator == BigInteger.ONE) "$numerator" else "$numerator/$denominator"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    // toCommonDenominator
    private fun toComDen(r: Rational): Rational =
        Rational(numerator * r.denominator, denominator * r.denominator)
}

infix fun Int.divBy(i: Int): Rational = "$this/$i".toRational()

infix fun Long.divBy(l: Long): Rational = "$this/$l".toRational()

infix fun BigInteger.divBy(bi: BigInteger): Rational = "$this/$bi".toRational()

fun String.toRational(): Rational {
    if (this.contains('/')) {
        val (n, d) = this.trim().split('/')
        val num = n.toBigInteger()
        val den = d.toBigInteger()
        val result =
            when {
                num == BigInteger.ZERO -> Rational.ZERO
                den == BigInteger.ONE -> Rational.integer(num)
                den < BigInteger.ZERO -> Rational(num.negate(), den.negate())
                den > BigInteger.ZERO -> Rational(num, den)
                else -> throw IllegalArgumentException()
            }
        return result.normalized()
    } else {
        return Rational.integer(this.toBigInteger())
    }
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
