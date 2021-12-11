package silverstar.coursera.kotlin4jd.week5

class Words {
    private val list = mutableListOf<String>()

    fun String.record() = list.add(this)

    operator fun String.unaryPlus() = record()

    override fun toString() = list.toString()
}

fun main() {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"

    words.addTest()
    words.toString() eq "[one, two, test]"
}

fun Words.addTest() {
    "test".record()
}
