package silverstar.coursera.kotlin4jd

/*
Implement the function that checks whether a string is a valid identifier.
A valid identifier is a  non-empty string that
- starts with a letter or underscore and
- consists of only letters, digits and underscores.
 */

fun isValidIdentifier(s: String): Boolean {
    val nonEmpty = s.isNotEmpty()
    fun validFirstChar() =
        when (s[0]) {
            '_' -> true
            in 'a'..'z' -> true
            in 'A'..'z' -> true
            else -> false
        }

    fun allDigitsLettersOrUnderscores() = s.drop(1).all { c -> c.isLetterOrDigit() || c == '_' }

    return nonEmpty && validFirstChar() && allDigitsLettersOrUnderscores()
}

fun main() {
    println(isValidIdentifier("name")) // true
    println(isValidIdentifier("_name")) // true
    println(isValidIdentifier("_12")) // true
    println(isValidIdentifier("")) // false
    println(isValidIdentifier("012")) // false
    println(isValidIdentifier("no$")) // false
}
