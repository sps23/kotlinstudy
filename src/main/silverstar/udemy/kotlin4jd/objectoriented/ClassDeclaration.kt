package silverstar.udemy.kotlin4jd.objectoriented

fun main() {

    val empl1 = MyEmployee("John", "Smith", 1)
    println(empl1.firstName)
    println(MyEmployee2("Adam").firstName)
    println(MyEmployee3("Tom").firstName)

    val empl2 = MyEmployee2("Peter")
    println(empl2.firstName)
    println(empl2.fullTime)

    val empl3 = MyEmployee2("Ted", false)
    println(empl3.firstName)
    println(empl3.fullTime)
    empl3.fullTime = true
    println(empl3.fullTime)

    val empl4 = MyEmployee3("James")
    println(empl4.firstName)
    println(empl4.fullTime)
    val empl5 = MyEmployee3("Jim", false)
    println(empl5.firstName)
    println(empl5.fullTime)

    println(WithoutPrimConstr().a)
}

// primary constructor
class MyEmployee constructor(firstName: String, lastName: String, val id: Int) {

    // property declaration
    val firstName: String

    // property declaration with initialization
    val lastName: String = lastName

    // initializer block, used in conjunction with primary constructor
    init {
        this.firstName = firstName
    }
}

// use constractor syntax if you need access modifier for it
class MyEmployee2 internal constructor(val firstName: String) {

    var fullTime: Boolean = true

    // secondary constructor
    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }
}

// primary constructor with default value
// properties by default are public but can be declared private
class MyEmployee3(val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
        get() {
            println("Custom get for fullTime property")
            return field
        }
        set(value) {
            println("Custom set for fullTime property")
            field = value
        }
}

// example of a class without primary constructor
class WithoutPrimConstr {

    val a: Int

    constructor() {
        this.a = -1
    }
}
