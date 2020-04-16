package something.method

import org.junit.jupiter.api.Test

/**
 * Author： fanyafeng
 * Data： 2020/3/6 09:47
 * Email: fanyafeng@live.cn
 */
object Method {

    @JvmStatic
    fun main(args: Array<String>) {
//        test2(3, { numb1: Int, numb2: Int -> numb1 * numb2 })
//
//        test2(2) { a, b ->
//            a * a + b * b
//        }
//
//        test3(2, b = { 5 + 6 })
//
//        test4(10, { it > 5 })
//
//        var a: String? = null
//        a?.let {
//
//        }
//
//        val pair = Pair(3, 4)
//        val (x, y) = pair

        val strList = mutableListOf<String>()
        var a: String? = null
        a = "name"
        a?.let { strList.add(it) }
//        println(strList.toString())
        println(111100.personFormat())
    }

    val test1: (Int, Int) -> Int = { a, b ->
        a + b
    }

    fun test2(a: Int, b: (numb1: Int, numb2: Int) -> Int) {
        println(a + b.invoke(3, 4))
    }

    fun test3(a: Int, b: () -> Unit) {

    }

    fun test4(num1: Int, funBool: (Int) -> Boolean): Int {
        return if (funBool(num1)) {
            num1
        } else 0
    }
}

fun Int.personFormat(): String {
    return if (this < 9999) {
        this.toString()
    } else if (this == 10000) {
        return "1万"
    } else {
        val temp = this / 10000
        val temp1 = (this - temp * 10000) / 1000
        temp.toString() + "." + temp1 + "万"
    }
}

