package silverstar.coursera.kotlin4jd.week5

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK") else println("Error: $this != $other")
}