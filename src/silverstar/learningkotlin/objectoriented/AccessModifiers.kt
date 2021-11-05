package silverstar.learningkotlin.objectoriented

fun main() {

    // classes are public and final by default
    val comp1 = Company()


    // private class - accessible in the same file
    val empl1 = Employee()

    // internal class - visible in the same module
    // internal is compiled to public (it will be public if accessed in Java)
    val user1 = User()

    // classes cannot se private members belonging to inner classes
}

class Company

private class Employee

internal class User

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // public by default

    protected class Nested {
        val e: Int = 5
        private val f: Int = 20
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible
    // Nested f is not visible
    private val n = Nested()
    private val ne = n.e

    override val b = 5   // 'b' is protected
    override val c = 7   // 'c' is internal
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e and Nested::f are not visible either
}