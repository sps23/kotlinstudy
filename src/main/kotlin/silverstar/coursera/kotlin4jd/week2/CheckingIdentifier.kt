package silverstar.coursera.kotlin4jd

/*
Implement the function that checks whether a string is a valid identifier.
A valid identifier is a  non-empty string that
- starts with a letter or underscore and
- consists of only letters, digits and underscores.
 */

fun isValidIdentifier(s: String): Boolean {
    val nonEmpty = s.isNotEmpty()
    fun validFirstChar(c: Char) = c == '_' || c.isLetter()
    fun validNextChar(c: Char) = c == '_' || c.isLetterOrDigit()

    return nonEmpty && validFirstChar(s[0]) && s.drop(1).all { validNextChar(it) }
}

fun main() {
    println(isValidIdentifier("name")) // true
    println(isValidIdentifier("_name")) // true
    println(isValidIdentifier("_12")) // true
    println(isValidIdentifier("")) // false
    println(isValidIdentifier("012")) // false
    println(isValidIdentifier("no$")) // false
}
