package academy.learnprogramming.oochallenge

fun main() {

    val bicycle1 = KotlinBicycle(1, 2, 3)
    bicycle1.printDescription()

    val mountainBike1 = KotlinMountainBike(1, 2, 3, 4)
    mountainBike1.printDescription()

    val roadBike1 = KotlinRoadBike(1, 2, 3, 4)
    roadBike1.printDescription()

    val bicycle2 = KotlinBicycle(1, 2)
    bicycle2.printDescription()

    val mountainBike2 = KotlinMountainBike(1, 2, 3)
    mountainBike2.printDescription()

    val roadBike2 = KotlinRoadBike(1, 2, 3)
    roadBike2.printDescription()

    val mountainBike3 = KotlinMountainBike("red")
    mountainBike2.printDescription()

    println(KotlinMountainBike.availableColors.joinToString(", "))
}

// use var if you want to set class attributes
open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBreak(decrement: Int): Unit {
        speed -= decrement
    }

    fun speedUp(increment: Int): Unit {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }
}

// use val if you d not want to change class attributes
class KotlinMountainBike(val seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) :
    KotlinBicycle(cadence, speed, gear) {

    companion object {
        val availableColors = listOf("blue", "red", "white", "black", "green", "brown")
    }

    constructor(color: String) : this(0, 0, 0) {
        println("color: $color")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }
}

// no val nor var, attributes are declared in the super class
class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10) :
    KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }
}
