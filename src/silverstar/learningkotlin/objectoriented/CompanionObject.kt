package silverstar.learningkotlin.objectoriented

fun main() {

    // accessing function from companion object without instantiating the class
    CompanionObjectExample1.printPrivateInt()
    // no need to use Companion
    CompanionObjectExample1.Companion.printPrivateInt()

    CompanionObjectExample2.printPasswordEncrypted()
    // no need to use Secret
    CompanionObjectExample2.Secret.printPasswordEncrypted()

    println(FactoryCompanionObjectExample("Test"))
    println(FactoryCompanionObjectExample.factory("Test", false))
    println(FactoryCompanionObjectExample.factory("Test", true))
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
data class FactoryCompanionObjectExample(val s: String) {

    companion object {
        // factory method inside companion object
        fun factory(s: String, uppercase: Boolean): FactoryCompanionObjectExample {
            val str = if (uppercase) s.uppercase() else s.lowercase()
            return FactoryCompanionObjectExample(str)
        }
    }
}
