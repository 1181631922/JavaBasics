package leetcode

import link.TestLinkedHashMap
import kotlin.math.sqrt

/**
 * Author： fanyafeng
 * Data： 2019-12-23 14:57
 * Email: fanyafeng@live.cn
 */
object LeetCode441 {
    @JvmStatic
    fun main(args: Array<String>) {
//        solution441(1)
//        println(sum1UntilN(3))
//        2147483647
//        846930886
//        println(solution441(846930886))
//        println(solution(846930886))
        fundMethod()

        Math.random()
    }

    fun fundMethod() {
        val clazz = Class.forName("link.TestLinkedHashMap")
        clazz.methods.forEachIndexed { index, method ->
            println(method.name)
        }

        val testLink = TestLinkedHashMap
        clazz.getDeclaredMethod("getPrint", String::class.java).invoke(testLink, "test")

    }

    fun solution(n: Int): Int {
        return (Math.sqrt(2.toDouble()) * Math.sqrt(n + 1.toDouble() / 8) - 1.toDouble() / 2).toInt()
    }

    fun solution441(n: Int): Int {
        var isOverFlow = false
        var index = 0
        var result = 0
        var start = n
        var startSum = 0
        var end = n
        var endSum = 0
        while (!isOverFlow) {
            start = index
            index += 1
            end = index

            startSum = sum1UntilN(start)
            endSum = sum1UntilN(end)

            if (n == startSum) {
                isOverFlow = true
                result = start
            }
            if (n == endSum) {
                isOverFlow = true
                result = end
            }
            if (n > startSum && n < endSum) {
                isOverFlow = true
                result = start
            }
        }


        return result
    }


    fun sum1UntilN(n: Int = 1): Int {
        var sum = 0
        (1 until n + 1).forEachIndexed { index, i ->
            sum += i
        }
        return sum
    }

}

