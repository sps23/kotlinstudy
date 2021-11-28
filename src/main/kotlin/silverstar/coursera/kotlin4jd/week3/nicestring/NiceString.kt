package silverstar.coursera.kotlin4jd.week3.nicestring

fun String.isNice(): Boolean {
    val forbiddenSubstrings = setOf("bu", "ba", "be")
    val hasNoForbiddenSubstrings = forbiddenSubstrings.none { this.contains(it) }

    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val minNumberOfVowels = 3
    val hasMinNumberOfVowels = this.filter { vowels.contains(it) }.length >= minNumberOfVowels

    val containsDoubleLetter = this.zipWithNext().any { it.first == it.second }

    return listOf(hasNoForbiddenSubstrings, hasMinNumberOfVowels, containsDoubleLetter)
        .filter { it }
        .size >= 2
}
