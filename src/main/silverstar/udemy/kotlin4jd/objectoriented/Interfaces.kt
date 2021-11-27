package silverstar.udemy.kotlin4jd.objectoriented

fun main() {

    val m1: MyInterface = MyClass('m')
    val m2: MyInterface = MyClass('n')

    println(m1.toString())
    println(m2.toString())
}

// interface is public open by default
interface MyInterface {

    val number: Int
    val char: Char
    val double: Double // property cannot be initialized in the interface
        get() = 234.44 // we have to use custom get

    fun myFunction(s: String): String
}

interface MySubInterface : MyInterface {

    fun mySubFunction(i: Int): Int
    override val double: Double // we can override the property initialized in parent interface
        get() = super.double * 2
}

// implement interface parameter in a default constructor
data class MyClass(override val char: Char) : MySubInterface {
    override fun mySubFunction(i: Int): Int {
        return i + 2
    }

    // implement interface parameter in the class body
    override val number: Int = 23

    override fun myFunction(s: String): String {
        return s.lowercase()
    }
}
