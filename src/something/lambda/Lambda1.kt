package something.lambda

import java.io.BufferedReader
import java.io.FileReader

/**
 * Author： fanyafeng
 * Data： 2020/3/18 00:19
 * Email: fanyafeng@live.cn
 */
object Lambda1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val ca = getCa(Delivery.EX)
        println(ca(Order(6)))

        IntRange

//         BufferedReader(FileReader("path")).use {
//            return it.readLine()
//        }
    }
}

enum class Delivery { ST, EX }

class Order(val itemCount: Int)

fun getCa(de: Delivery): (Order) -> Double {
    if (de == Delivery.EX) {
        return { it -> it.itemCount + 90.6 }
    }
    return { order -> order.itemCount + 0.6 }
}