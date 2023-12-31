package silverstar.coursera.kotlin4jd.week3

fun String?.isEmptyOrNull() = this == null || this?.isEmpty()

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK") else println("Error: $this != $other")
}

fun main() {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}