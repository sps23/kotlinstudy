package silverstar.udemy.learningkotlin.objectoriented

fun main() {

    // for all enums from Department
    Department.values().forEach { println(it.getDepartmentInfo()) }
    println(Department.Sales.getDepartmentInfo())
}

enum class Department(val fullName: String, val floor: Int) {
    HR("Human Resources", 1),
    IT("Information Technology", 5),
    Sales("Sales", 2);

    fun getDepartmentInfo() = "The $fullName department, floor: $floor"
}
