package silverstar.udemy.kotlin4jd.lambdas

fun main() {

    val cars1 = mutableListOf(MyCar(), MyCar())
    val cars2 = mutableListOf<MyCar>()
    copyCars(cars1, cars2)


    val fords1 = mutableListOf(Ford(), Ford())
    val fords2 = mutableListOf<Ford>()
    copyCars(fords1, fords2)

    val cars3 = mutableListOf<MyCar>(Ford())

    copyCars(fords1, cars2)

    val toyotas = mutableListOf(Toyota(), Toyota())

    copyCars(toyotas, cars2)
    copyCars(toyotas, cars3)

}

// 'use-site' variance, adding variance into the function attribute
// it is also called 'type projection'
fun <T : MyCar> copyCars(source: MutableList<out T>, destin: MutableList<T>) {
    for (car in source) {
        destin.add(car)
        println(destin.joinToString("; "))
    }
}

open class MyCar

class Toyota : MyCar()

class Ford : MyCar()
