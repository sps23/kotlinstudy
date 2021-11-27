package silverstar.udemy.kotlin4jd.textadventure


data class KotlinLocation(val locationID: Int, val description: String) {

    val exits = mutableMapOf<String, Int>() // initialised inside the class

    init {
        exits["Q"] = 0 // using [] to deal with Map
    }

    fun addExit(direction: String, destinationID: Int) {
        exits[direction] = destinationID
    }

}