package silverstar.udemy.learningkotlin.lambdas

fun main() {

    // run lambda directly using 'run' command
    run { println("Hello Lambdas !!!") }

    val employees = LambdaEmployee.employees

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
