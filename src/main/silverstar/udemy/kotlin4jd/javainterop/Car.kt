@file:JvmName("StaticCar") // name that we will use for static members
// the default name in Java for the Kotlin file is <filename>Kt
// you can change that by using annotation @file:JvmName

package silverstar.udemy.kotlin4jd.javainterop

import java.io.IOException

fun topLevel() = println("I'm in the car file!")

@Throws(IOException::class)
fun doIO() {
    throw IOException()
}

@JvmOverloads
fun defaultArgs(str: String, int: Int = 23) = {}

class Car(color: String, val model: String, @JvmField val year: Int, val auto: Boolean) {
    var color: String = color
        set(value) {
            field = "always black" // custom setter
        }

    companion object {
        const val constant = 23
        @JvmField
        val isAuto = false
        @JvmStatic
        fun carComp() = println("I'm in companion object")
    }

    fun printMe(text: String) = println("I do not expect null from $text")
}

fun String.myPrint() {
    println(this.uppercase())
}

object SingletonObj {
    @JvmStatic
    fun doSth() = println("doing sth in teh singleton object")
}
