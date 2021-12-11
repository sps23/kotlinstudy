package silverstar.coursera.kotlin4jd.week5

inline fun buildString(
    builderAction: StringBuilder.() -> Unit
): String {
    val stringBuilder = StringBuilder()
    stringBuilder.builderAction()
    return stringBuilder.toString()
}

fun main() {
    val sb = buildString {
        append("Test")
        append(123)
    }
    println(sb.toString())
}