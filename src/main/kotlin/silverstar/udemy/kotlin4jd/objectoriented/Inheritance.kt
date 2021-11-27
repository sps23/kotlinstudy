package silverstar.udemy.kotlin4jd.objectoriented

fun main() {

    val laserPrinter = LaserPrinter("ABC1433")
    laserPrinter.printModel()
    println(laserPrinter.bestSellingPrice())

    SomethingElse("ABC")
}

// class is by default public final
// open means it can be extended
// abstract class is by default open (not final)
abstract class Printer(val modelName: String) {

    // function by default is final
    // open function can be overridden
    open fun printModel() = println("modelName: $modelName")

    // abstract function is open by default
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String) : Printer(modelName) {

    // override means that function is overriding the parent class
    // override function is open by default (can be overridden)
    // final cannot be overridden
    final override fun printModel() = println("laser modelName: $modelName")
    override fun bestSellingPrice(): Double = 89.99
}

class SpecialLaserPrinter(modelName: String) : LaserPrinter(modelName) {}

// constructors parent/child

// class with no primary constructor
// it is good practise to declare primary constructor and secondary only if necessary
open class Something {

    // initialize property in primary constructor
    val property: String

    // secondary constructor
    constructor(param: String) {
        property = param
        println("parent constructor")
    }
}

class SomethingElse : Something {

    // call secondary constructor from super class
    constructor(otherParam: String) : super(otherParam) {
        println("child constructor")
    }
}
