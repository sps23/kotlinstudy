package silverstar.coursera.kotlin4jd.week3.nicestring

fun String.isNice(): Boolean {
    val hasNoForbiddenSubstrings = setOf("bu", "ba", "be").none { this.contains(it) }
    val hasMinNumberOfVowels = this.count { it in setOf('a', 'e', 'i', 'o', 'u') } >= 3
    val hasDoubleLetter = this.zipWithNext().any { it.first == it.second }

    return listOf(hasNoForbiddenSubstrings, hasMinNumberOfVowels, hasDoubleLetter).count { it } >= 2
}
