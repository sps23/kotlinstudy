package silverstar.coursera.kotlin4jd.week5.games.game2048

/*
 * This function moves all the non-null elements to the beginning of the list
 * (by removing nulls) and merges equal elements.
 * The parameter 'merge' specifies the way how to merge equal elements:
 * it returns a new element that should be present in the resulting list
 * instead of two merged elements.
 *
 * If the function 'merge("a")' returns "aa",
 * then the function 'moveAndMergeEqual' transforms the input in the following way:
 *   a, a, b -> aa, b
 *   a, null -> a
 *   b, null, a, a -> b, aa
 *   a, a, null, a -> aa, a
 *   a, null, a, a -> aa, a
 *
 * You can find more examples in 'TestGame2048Helper'.
*/
fun <T : Any> List<T?>.moveAndMergeEqual(merge: (T) -> T): List<T> {
    fun iter(l: List<T>, acc: List<T>): List<T> =
        when {
            l.isEmpty() -> acc
            l.size == 1 -> acc + l.take(1)
            l[0] == l[1] -> iter(l.drop(2), acc + merge(l[0]))
            else -> iter(l.drop(1), acc + l[0])
        }

    return iter(this.filterNotNull(), emptyList())
}
