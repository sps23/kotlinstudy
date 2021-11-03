package silverstar.leariningkotlin.textadventure

import java.io.File


fun readLocationInfo() : Map<Int, KotlinLocation> {

    val locations = mutableMapOf<Int, KotlinLocation>()

    File("locations_big.txt").reader().forEachLine {
        val tokens = it.split(";")

        val location = KotlinLocation(tokens[0].toInt(), tokens[1])
        locations[location.locationID] = location
    }

    File("directions_big.txt").reader().forEachLine {
        val tokens = it.split(",")

        locations[tokens[0].toInt()]?.addExit(tokens[1], tokens[2].toInt())
    }

    return locations

}