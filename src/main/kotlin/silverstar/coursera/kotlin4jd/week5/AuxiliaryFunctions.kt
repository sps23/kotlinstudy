package silverstar.coursera.kotlin4jd.week5

interface X {
    var first: Int
    var second: Int
    var third: Int
}

interface Y {
    fun start()
    fun finish()
}

interface Z {
    fun init()
}

fun foo(x: X, y: Y?, z: Z) {
    with(x) {
        first = 1
        second = 2
        third = 3
    }
    y?.run {
        start()
        finish()
    }
    val result = z.apply { init() }
}

fun main(){
    foo(
        object: X{
            override var first: Int = 1
            override var second: Int = 1
            override var third: Int = 1
        },
        object : Y {
            override fun start() {
                println("Y start")
            }

            override fun finish() {
                println("Y finish")
            }

        },
        object : Z {
            override fun init() {
                println("Z init")
            }

        }
    )
}