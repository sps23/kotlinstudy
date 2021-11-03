package silverstar.learningkotlin.kotlinvsjava

fun main() {

    val hello1 = "Hello"
    val hello2 = "Hello"

    println("hello1 is referentially equal to hello2 ${hello1 === hello2}")
    println("hello1 is structurally equal to hello2 ${hello1 === hello2}")

    var i = 2988
    val any: Any = "The Any type is the root of the Kotlin class hierarchy"
    if(any is String) {
        println(any.uppercase())
    }

    val ones = """    1
        |   11
        |  111
        | 1111""".trimMargin()
    println(ones)
}