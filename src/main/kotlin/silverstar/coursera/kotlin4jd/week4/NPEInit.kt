package silverstar.coursera.kotlin4jd.week4

open class AA(open val value: String) {
    init {
        println(value.uppercase()) // do not call open attributes in parent
    }
}

class BB(override val value: String) : AA(value)

fun main() {
    BB("a") // NPE will be thrown here, 'value' is not yet initialized in BB
}