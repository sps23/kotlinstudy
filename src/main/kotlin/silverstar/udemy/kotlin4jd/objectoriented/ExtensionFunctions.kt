package silverstar.udemy.kotlin4jd.objectoriented

fun main() {

    println(Utils().upperFirstAndLast("test"))
    println(Utils().upperFirstAndLastJ("test"))
    println("test".upperFirstAndLast())
    println(Utils().upperFirstAndLast(""))
    println(Utils().upperFirstAndLast("a"))
    println(Utils().upperFirstAndLast("us"))
    println(Utils().upperFirstAndLast("This is all in lower case"))
    println("This is all in lower case".upperFirstAndLast())
}

// extension function can add functionality to the existing class
// String is a receiver class for this extension function
fun String.upperFirstAndLast(): String =
    if (this.length > 1) {
        this.first().uppercase() + this.drop(1).dropLast(1) + this.last().uppercase()
    } else if (this.length == 1) {
        this.uppercase()
    } else {
        this
    }

class Utils {

    fun upperFirstAndLastJ(s: String): String {
        val upperFirst: String = s.substring(0, 1).uppercase()
        val upperLast: String = s.substring(s.length - 1, s.length).uppercase()
        val middle: String = s.substring(1, s.length - 1)
        return upperFirst + middle + upperLast
    }

    fun upperFirstAndLast(s: String): String =
        if (s.length > 1) {
            s.first().uppercase() + s.drop(1).dropLast(1) + s.last().uppercase()
        } else if (s.length == 1) {
            s.uppercase()
        } else {
            s
        }
}
