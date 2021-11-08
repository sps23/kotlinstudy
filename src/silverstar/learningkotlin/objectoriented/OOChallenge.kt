package academy.learnprogramming.oochallenge

// use var if you want to set class attributes
open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int) {

    fun applyBreak(decrement: Int): Unit {
        speed -= decrement
    }

    fun speedUp(increment: Int): Unit {
        speed += increment
    }
}

// use val if you d not want to change class attributes
class KotlinMountainBike(val seatHeight: Int, cadence: Int, speed: Int, gear: Int) :
    KotlinBicycle(cadence, speed, gear)

// no val nor var, attributes are declared in the super class
class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int) :
    KotlinBicycle(cadence, speed, gear)
