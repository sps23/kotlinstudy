package silverstar.udemy.kotlin4jd.textadventure.autoconverted

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.*

object Locations {
    var locations: MutableMap<Int?, Location?> = HashMap<Int?, Location?>()

    init {
        var scanner: Scanner? = null

        // Read locations
        try {
            scanner = Scanner(FileReader("locations_big.txt"))
            scanner.useDelimiter(";")
            while (scanner.hasNextLine()) {
                val loc = scanner.nextInt()
                scanner.skip(scanner.delimiter())
                val description = scanner.nextLine()
                locations[loc] = Location(loc, description)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            scanner?.close()
        }

        // Now read the exits
        try {
            scanner = Scanner(BufferedReader(FileReader("directions_big.txt")))
            scanner.useDelimiter(",")
            while (scanner.hasNextLine()) {
                val input = scanner.nextLine()
                val data = input.split(",".toRegex()).toTypedArray()
                val loc = data[0].toInt()
                val direction = data[1]
                val destination = data[2].toInt()
                val location = locations[loc]
                location!!.addExit(direction, destination)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            scanner?.close()
        }
    }
}