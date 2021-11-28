package silverstar.coursera.kotlin4jd.week3

fun main(args: Array<String>) {
    val s: String? = "test"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}