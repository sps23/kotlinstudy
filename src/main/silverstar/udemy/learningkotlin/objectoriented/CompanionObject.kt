package silverstar.udemy.learningkotlin.objectoriented

fun main() {

    // accessing function from companion object without instantiating the class
    CompanionObjectExample1.printPrivateInt()
    // no need to use Companion
    CompanionObjectExample1.Companion.printPrivateInt()

    CompanionObjectExample2.printPasswordEncrypted()
    // no need to use Secret
    CompanionObjectExample2.Secret.printPasswordEncrypted()

    println(FactoryCompanionObjectExample1("Test"))
    println(FactoryCompanionObjectExample1.factory("Test", false))
    println(FactoryCompanionObjectExample1.factory("Test", true))

    // println(FactoryCompanionObjectExample2("Test")) // we cannot do that
    println(FactoryCompanionObjectExample2.factory1("Test")) // we have to use factory
    println(FactoryCompanionObjectExample2.factory2("Test", false))
    println(FactoryCompanionObjectExample2.factory2("Test", true))
}

// we cannot have static class members
// but we can use companion objects for that

class CompanionObjectExample1 {

    // anonymous companion object
    // only one companion object is allowed per class
    // can be used to declare 'static' variables and functions
    companion object {
        private const val privateInt = 34

        fun printPrivateInt(): Unit = println("privateInt = $privateInt")
    }
}

class CompanionObjectExample2 {

    // companion object called 'Secret'
    companion object Secret {
        private const val password: String = "pass"

        fun printPasswordEncrypted(): Unit =
            println(password.toCharArray().map { it.code }.joinToString(""))
    }
}

// default constructor
// we can still create objects with default constructor
data class FactoryCompanionObjectExample1(val s: String) {

    companion object {
        // factory method inside companion object
        fun factory(s: String, uppercase: Boolean): FactoryCompanionObjectExample1 {
            val str = if (uppercase) s.uppercase() else s.lowercase()
            return FactoryCompanionObjectExample1(str)
        }
    }
}

// default constructor is private
// we can only use factory method from companion object
data class FactoryCompanionObjectExample2 private constructor(val s: String) {

    companion object {
        // factory methods inside companion object
        fun factory1(s: String): FactoryCompanionObjectExample1 = FactoryCompanionObjectExample1(s)
        fun factory2(s: String, uppercase: Boolean): FactoryCompanionObjectExample1 {
            val str = if (uppercase) s.uppercase() else s.lowercase()
            return FactoryCompanionObjectExample1(str)
        }
    }
}
