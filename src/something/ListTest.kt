package something

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Author： fanyafeng
 * Data： 2019-12-09 16:56
 * Email: fanyafeng@live.cn
 */
object ListTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val testList = arrayListOf(3, 100, 9, 101, 2, 4, 10, 11, 102, 8, 12)
        val listSet: TreeSet<Int> = TreeSet(ArrayList<Int>(testList))
        val sortList = ArrayList<Int>(listSet)
        println(sortList.toString())

        println(findLengthOfLCIS(testList))
    }

    fun findLengthOfLCIS(nums: ArrayList<Int>): Int {
        val numsLen = nums.size

        var max = 0
        var cur = 0

        // 若数组序列长度小于2（不包括2），直接输出长度
        if (numsLen < 2) {
            return numsLen
        }
        for (i in 0 until numsLen - 1) {
            // 连续递增的数组元素
            cur++
            if (max < cur) {
                max = cur
            }
            // 在不连续的数组元素的地方作为一个断点
            if (nums[i] >= nums[i + 1]) {
                // 中断数组中连续的元素递增，重新开始
                cur = 0
            }
        }

        cur++
        if (max < cur) {
            max = cur
        }

        return max
    }


}