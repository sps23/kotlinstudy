package silverstar.learningkotlin.lambdas

fun main() {

    val flowerTender =
        object : FlowerCare<Flower> {
            override fun prune(flower: Flower) = println("I'm pruning a ${flower.name}")
        }

    val roseTender =
        object : FlowerCare<Rose> {
            override fun prune(flower: Rose) = println("I'm pruning rose")
        }

    val roseGarden = MyGarden(listOf(Rose(), Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)

    val daffodilTender =
        object : FlowerCare<Daffodil> {
            override fun prune(flower: Daffodil) = println("I'm pruning daffodil")
        }
    val daffodilGarden = MyGarden(listOf(Daffodil(), Daffodil()), daffodilTender)
    daffodilGarden.tendFlower(1)

    // using contravariant FlowerCare<Flower>
    val roseGardenC = MyGarden(listOf(Rose(), Rose(), Rose()), flowerTender)
    roseGardenC.tendFlower(0)

    val daffodilGardenC = MyGarden(listOf(Daffodil(), Daffodil()), flowerTender)
    daffodilGardenC.tendFlower(1)
}

class MyGarden<T : Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) = flowerCare.prune(pickFlower(i))
}

// contravariance - we want to accept all the superclasses of 'T'
// we cannot return the contravariant type, we can only accept them as input parameters
interface FlowerCare<in T> {

    fun prune(flower: T) {}
}
