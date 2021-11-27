package silverstar.udemy.kotlin4jd.datatypes

fun main() {

    val strNull: String? = null
    val str1: String? = "Not null String"

    if (str1 != null) println(str1.uppercase())
    if (strNull != null) println(strNull.uppercase()) else println("null")

    println(str1?.uppercase())
    println(strNull?.uppercase())

    // Elvis operator ?:
    val str2: String = strNull ?: "Default value"
    println(str2)
    println(str1 ?: "Default value2")

    val array1: Any = arrayOf(1, 2, 3, 4)
    // safe cast operator as?
    val str3 = array1 as? String
    println(str3)

    // NotNull assertion operator !!
    val str4: String = str1!!.uppercase()
    println(str4)
    // println(strNull!!.lowercase()) // NullPointerException
    //val str5 = strNull!! // NullPointerException

    // let function
    printText(str1!!)
    if (str1 != null) printText(str1)
    str1?.let { println(it) }

    // nullable arrays
    val nullableInts = arrayOfNulls<Int?>(5)
    nullableInts.forEach { println(it) }
    println(nullableInts[0]?.toLong())
}

fun printText(str: String) = println(str)