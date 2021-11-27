package silverstar.udemy.kotlin4jd.objectoriented

fun main() {
    println(labelMultiply(2, 5, "test1"))
    println(labelMultiply(i1 = 2, i2 = 5, label = "test1")) // named arguments
    println(test1())
    println(Human("Tom").nameUppercase())

    val h1 = Human("A")
    val h2 = Human("B")
    val h3 = Human("C")
    val humans1 = arrayOf(h3, h1, h2)
    val humans2 = arrayOf(h2, h3)
    // unpack an array of arrays with spread operator
    val humans3 = arrayOf(*humans1, *humans2)

    printNames(h1)
    printNames(h1, h2)
    printNames(h3, h1, h2)
    // spread operator '*' to use array as a vararg
    printNames(*humans1)
    printNames(*humans3)
    printNames(h3, h1, h2, header = "Welcome: ")
}

fun labelMultiply(i1: Int, i2: Int, label: String): String = "$label:    ${i1 * i2}"

fun test1() = 3 * 5

class Human(val name: String) {

    fun nameUppercase() = name.uppercase()

    // use 'return' if function is an expression {}
    fun nameLowercase(): String {
        return name.lowercase()
    }
}

// variable argument, only one vararg in the function signature
// keep vararg as teh last argument
fun printNames(vararg human: Human): Unit {
    for (h in human) println(h.nameUppercase())
}

fun printNames(vararg human: Human, header: String): Unit {
    val text = header + human.map { h -> h.nameUppercase() }.joinToString(", ")
    println(text)
}
