package silverstar.leariningkotlin.textadventure.autoconverted

import com.timbuchalka.Location
import java.util.*

object Main {
    private val locations: MutableMap<Int?, Location?> = Locations.locations

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        var loc = 64
        while (true) {
            println(locations[loc]!!.description)
            if (loc == 0) {
                break
            }
            val exits = locations[loc]!!.getExits()
            print("Available exits are ")
            for (exit in exits.keys) {
                print("$exit, ")
            }
            println()
            val direction = scanner.nextLine().uppercase(Locale.getDefault())
            if (exits.containsKey(direction)) {
                loc = exits[direction]!!
            } else {
                println("You cannot go in that direction")
            }
        }
    }
}