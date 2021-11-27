package silverstar.udemy.learningkotlin.objectoriented


fun main() {

    // anonymous object - object expression,
    // it is not singleton, it is used and discarded
    todo(object : SomeInterface {
        override fun simpleFunction(i: Int): String = "simpleFunction: ${i * 100}"
    })
}

interface SomeInterface {
    fun simpleFunction(i: Int): String
}

fun todo(s: SomeInterface) {
    println("todo: ${s.simpleFunction(23)}")
}