package silverstar.coursera.kotlin4jd.week4

open class AA(open val value: String) {
    init {
        println(value.uppercase())
    }
}

class BB(override val value: String) : AA(value)

fun main() {
    BB("a")
}