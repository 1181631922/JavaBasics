package myqueue

import org.junit.Test
import java.util.*

/**
 * Author： fanyafeng
 * Data： 2020/6/23 15:17
 * Email: fanyafeng@live.cn
 */
class TestDeque1 {
    @Test
    fun testArrayDeque() {
        val arrayDeque = ArrayDeque<Int>()
        (0 until 10).forEach {
            arrayDeque.add(it)
        }
        println(arrayDeque.toString())
        arrayDeque.addLast(10)
        println(arrayDeque.toString())
        arrayDeque.addFirst(11)
        println(arrayDeque.toString())
        arrayDeque.descendingIterator().forEach {
            /**
             * 倒序
             */
            print("$it,")
        }
        println()
        arrayDeque.forEach {
            /**
             * 正序
             */
            print("$it,")
        }
    }
}