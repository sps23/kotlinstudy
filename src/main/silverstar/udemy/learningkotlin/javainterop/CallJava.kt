package silverstar.udemy.learningkotlin.javainterop

import silverstar.udemy.learningkotlin.javainterop.java.Car

fun main() {

    val car = Car("blue", "Ford", 2015)
    println(car)
    // if java class has both getter and setter we can use dot notation
    car.color = "green"
    println(car)

    println(car.model.javaClass)
    car.model = null
    val model: String? = car.model
    println(model)
    println(car.model)

    car.variableMethod(5, "hello", "goodbye")
    val strings = arrayOf("hello", "goodbye")
    // we have to use spread operator to call vararg param in java
    car.variableMethod(4, *strings)

    car.wantsIntArray(arrayOf(1, 2, 3).toIntArray()) // pass primitive type array
    car.wantsIntArray(intArrayOf(3, 4, 5))

    // (car.anObject as java.lang.Object).notify()

    // access static objects from java
    println(Car.x)
    println(Car.xString())

    // SAM - single abstract method
    // we can just pass lambda
    car.demoMethod({ println("I'm in a thread") })
}
