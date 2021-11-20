package silverstar.learningkotlin.lambdas

fun main() {

    val ints = listOf(1, 2, 3, 4)
    val shorts = listOf<Short>(1, 2, 3, 4)

    // it works because List is covariant (works for subtypes of <T>)
    convertListToInt(ints)
    convertListToInt(shorts)

    val intsMutableList = mutableListOf(1, 2, 3, 4)
    val shortsMutableList = mutableListOf<Short>(1, 2, 3, 4)

    // this is still working, MutableList is subtype of List
    convertListToInt(intsMutableList)
    convertListToInt(shortsMutableList)

    // this will not compile, MutableList is invariant
    // convertMutableListToInt(intsMutableList)
}

// List is a class, List<String> is a type
// List<Int> is a subtype of List<Number>
// Short is a subclass of Number
// Nullable is supertype of NonNullable

// List<T> is covariant
fun convertListToInt(list: List<Number>) {
    for (n in list) {
        println(n.toInt())
    }
}

fun convertMutableListToInt(list: MutableList<Number>) {
    for (n in list) {
        println(n.toInt())
    }
}

fun waterGarden(garden: Garden<Flower>) {}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

// covariant class Garden
// can be used in only in the 'out' position
// it can be in return position
// you can use covariant parameter in the constructor
class Garden<out T : Flower>(val flower: T, private var myFlower: T) {

    private val flowers: List<T> = listOf(flower)

    fun pickFlower(i: Int): T = flowers[i]

    // we cannot use 'T' as an argument to the function
    // fun plantFlower(flower: T){}
}