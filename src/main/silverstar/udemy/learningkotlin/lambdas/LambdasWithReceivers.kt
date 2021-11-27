package silverstar.udemy.learningkotlin.lambdas

fun main() {

    println(countTo20())
    println(countTo30())
    println(countTo40())

    findByLastName1(LambdaEmployee.employees, "AAA")
    findByLastName1(LambdaEmployee.employees, "XYZ")
    findByLastName2(LambdaEmployee.employees, "AAA")
    findByLastName2(LambdaEmployee.employees, "XYZ")

    upperLowerCase("First Lambda", "Second Lambda")
}

// block value function
fun countTo20(): String {
    val s = StringBuilder()
    for (i in 1..19) {
        s.append(i)
        s.append(", ")
    }
    s.append(20)
    return s.toString()
}

// using 'with' lambda
// using expression function '=' and no 'return'
fun countTo30(): String =
    with(StringBuilder()) {
        // we do not have to refer to the instance of 'StringBuilder' inside 'with'
        for (i in 1..29) {
            append(i)
            append(", ")
        }
        append(30)
        toString()
    }

// using 'apply' function
fun countTo40(): String =
    StringBuilder()
        .apply {
            // we do not have to refer to the instance of 'StringBuilder' inside 'apply'
            for (i in 1..39) {
                append(i)
                append(", ")
            }
            append(40)
        }
        .toString()

fun findByLastName1(empl: List<LambdaEmployee>, lastName: String) {
    for (e in empl) {
        if (e.lastName == lastName) {
            println("Found employee with name $lastName")
            return // this returns from the whole function
        }
    }
    println("There is no employee with last name $lastName")
}

// using 'foreach' lambda
fun findByLastName2(empl: List<LambdaEmployee>, lastName: String) {
    empl.forEach {
        if (it.lastName == lastName) {
            println("Found employee with name $lastName")
            return // this returns from the whole function
        }
    }
    println("There is no employee with last name $lastName")
}

// use label to refer to attribute from outer lambda
fun upperLowerCase(s1: String, s2: String) {
    s1.apply s1Label@{
        s2.apply {
            println(this@s1Label.uppercase())
            println(lowercase())
        }
    }
}
