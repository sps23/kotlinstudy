package silverstar.learningkotlin.lambdas

fun main() {

    // run lambda directly using 'run' command
    run { println("Hello Lambdas !!!") }

    val employees =
        listOf<LambdaEmployee>(
            LambdaEmployee("A", "AAA", 2020),
            LambdaEmployee("B", "BBB", 2014),
            LambdaEmployee("C", "CCC", 2017),
            LambdaEmployee("A", "CCC", 2019),
        )

    // explicitly use lambda argument 'e'
    println(employees.minByOrNull { e -> e.startYear })
    // it is argument of lambda
    println(employees.maxByOrNull { it.startYear })
    // use member reference inside lambda
    println(employees.sortedBy(LambdaEmployee::startYear))

    // access local variable within lambda (variable has to be declared before lambda
    var num = 10
    run {
        num += 10
        println(num)
    }

    // use top level function inside lambda
    run(::topLevelFun)
}

fun topLevelFun() = println("topLevelFun !!!")

data class LambdaEmployee(val firstName: String, val lastName: String, val startYear: Int)
