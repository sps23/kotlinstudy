package silverstar.learningkotlin.objectoriented

import java.time.Year

fun main() {

    println(Singleton.getTagLine())
    println(Singleton.copyright())
}

// object cannot have any constructors
object Singleton {

    private val currentYear = Year.now().value

    fun getTagLine() = "Our company is the best !!!"
    fun copyright() = "Copyright \u00A9 $currentYear. All rights reserved"
}
