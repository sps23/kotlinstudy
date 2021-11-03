package silverstar.learningkotlin.kotlinvsjava

typealias EmployeeSet = Set<Employee>

fun main() {
    println("Hello world !!!")

    var number: Int = 1
    number = 10
    number = 20

    val names = arrayListOf<String>("a", "b", "c")
    println("array by index")
    println(names[0])
    println(names[1])
    println(names[2])
    println()

    val empl0 = Employee("John", 1)
    val empl1 = Employee("John", 1)
    val empl2 = Employee("Jane", 2)
    val empl4 = empl0

    println("smart casting")
    val empl5: Any = empl4
    if (empl5 is Employee) {
        println(empl5.name)
    }
    println()

    println("==")
    println(empl0 == empl1)
    println(empl0 == empl2)
    println(empl0 == empl4)
    println()

    println("===")
    println(empl0 === empl1)
    println(empl0 === empl2)
    println(empl0 === empl4)
    println()

    val hex1: Int = 0x00001111
    val hex2: Int = 0x11110000

    println("binary operators")
    println(hex1 or hex2)
    println(hex1 and hex2)
    println(hex1 xor hex2)
    println()

    empl1.name = "James"
    // empl1 = Employee("Tom",3)

    val empl3: Employee
    val num2 = 100

    if (number < num2) {
        empl3 = Employee("Adam", num2)
    } else {
        empl3 = Employee("Alan", number)
    }

    val employeeSet: EmployeeSet
    employeeSet = setOf<Employee>(empl1, empl2, empl3)

    println("String template")
    employeeSet.forEach { println(it) }
    println()
    println("Escape the dollar sign \$")

    val num = 4.66
    val den = 30.0
    println("$num / $den = ${num / den}")
    println()

    println("Raw Strings (triple quoted strinngs)")
    println("""c:\path1\path2\etc""")
    val multilineString = """Line1 test
        |line2 text
        |line3 text
        |the end!!!
    """.trimMargin()
    println(multilineString)
    println()


}

class Employee(var name: String, val id: Int) {
    // string template with $ sign
    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }
}