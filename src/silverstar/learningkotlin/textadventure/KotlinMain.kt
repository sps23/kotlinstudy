package silverstar.learningkotlin.textadventure

fun main() {

    val locations = readLocationInfo()
    var loc = 64

    while (true) {

        // we should never get null back, so we return default Location
        val location = locations[loc] ?: KotlinLocation(0,
                       "Sorry, something went wrong, so the game will terminate")

        println(location.description)

        if (location.locationID == 0) {
            break
        }

        print("Available exits are: ")
        location.exits.keys.forEach {
            print("$it, ")
        }

        val direction = readLine()?.uppercase() ?: "Z" // default direction
        if (location.exits.containsKey(direction)) {
            loc = location.exits[direction]!! // we can use not null assertion if we are sure no null
        }
        else {
            println("You can't go in that direction")
        }
    }
}