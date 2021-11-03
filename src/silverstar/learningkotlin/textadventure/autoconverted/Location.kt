package silverstar.learningkotlin.textadventure.autoconverted


class Location(val locationID: Int, val description: String) {
    private val exits: MutableMap<String?, Int?>
    fun getExits(): Map<String?, Int?> {
        return HashMap(exits)
    }

    fun addExit(direction: String?, location: Int) {
        exits[direction] = location
    }

    init {
        exits = HashMap()
        exits["Q"] = 0
    }
}