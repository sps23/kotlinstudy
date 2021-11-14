package silverstar.learningkotlin.lambdas

data class LambdaEmployee(val firstName: String, val lastName: String, val startYear: Int) {

    companion object {
        val employees =
            listOf<LambdaEmployee>(
                LambdaEmployee("A", "AAA", 2020),
                LambdaEmployee("B", "BBB", 2014),
                LambdaEmployee("C", "CCC", 2017),
                LambdaEmployee("A", "CCC", 2019),
            )
    }
}