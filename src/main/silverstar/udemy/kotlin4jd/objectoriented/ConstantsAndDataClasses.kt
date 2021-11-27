package silverstar.udemy.kotlin4jd.objectoriented

// top level constant
const val CONST1 = 100

fun main() {

    println(CONST1)
    val car1 = Car("blue", "Toyota", 2020)
    val car2 = Car("blue", "Toyota", 2020)
    val car3 = car1.copy()
    val car4 = car2.copy(color = "red")
    println(car1)
    println(car2)
    println(car3)
    println(car4)
    println(car1 == car2)
    println(car1 === car2)
}

// data class just for storing the state, fields no methods
// it has implemented: toString, hashcode, equals, copy, desturctor
data class Car(val color: String, val make: String, val year: Int) {
    // you cannot define methods inside data class
}
