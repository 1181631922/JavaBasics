package link

import link.Link1.insertNode
import java.util.*
import kotlin.math.floor
import java.util.Arrays


/**
 * Author： fanyafeng
 * Data： 2019-11-29 17:56
 * Email: fanyafeng@live.cn
 */
object Link3 {
    @JvmStatic
    fun main(args: Array<String>) {
        //合并两个有序的单链表
        val tempOne = Link1.Node(1, null)
        val temp12 = Link1.Node(2, null)
        val temp13 = Link1.Node(3, null)
        val temp14 = Link1.Node(4, null)

        insertNode(tempOne, temp12)
        insertNode(tempOne, temp13)
        insertNode(tempOne, temp14)
//        println(tempOne)

        val tempTwo = Link1.Node(2, null)
        val temp22 = Link1.Node(3, null)
        val temp23 = Link1.Node(4, null)
        val temp24 = Link1.Node(5, null)

        insertNode(tempTwo, temp22)
        insertNode(tempTwo, temp23)
        insertNode(tempTwo, temp24)
//        println(tempTwo)

//        mergeLink(tempTwo, tempOne)

        val testArray = arrayOf(2, 3, 6, 8, 0, 34, 56, 78, 12, 34, 56, 98, 345, 673, 123, 32, 456, 90)
        mergeSortUp2Down(testArray, 0, testArray.size - 1)

        testArray.forEachIndexed { index, i ->
            println(i)
        }
    }


    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     * @param a 包含两个有序区间的数组
     * @param start 第1个有序区间的起始地址
     * @param mid 第1个有序区间的结束地址，也是第2个有序区间的起始地址
     * @param end 第2个有序区间的结束地址
     */
    fun merge(a: Array<Int>, start: Int, mid: Int, end: Int) {
        var tmp = Array<Int>(end - start + 1) { 0 } // tmp是汇总2个有序区的临时区域
        var i: Int = start // 第1个有序区的索引
        var j: Int = mid + 1 // 第2个有序区的索引
        var k = 0 // 临时区域的索引

        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++]
            else
                tmp[k++] = a[j++]
        }

        while (i <= mid)
            tmp[k++] = a[i++]

        while (j <= end)
            tmp[k++] = a[j++]

        // 将排序后的元素，全部都整合到数组a中
        for (i in 0 until k)
            a[start + i] = tmp[i]
        tmp = emptyArray() // 清空数组
    }

    /**
     * 归并排序(从上往下)
     * @param a 待排序的数组
     * @param start 数组的起始地址
     * @param end 数组的结束地址
     */
    fun mergeSortUp2Down(a: Array<Int>, start: Int, end: Int) {
        if (a.isNullOrEmpty() || start >= end) {
            return
        }

        var mid: Int = (end + start) / 2
        mergeSortUp2Down(a, start, mid) // 递归排序a[start..mid]
        mergeSortUp2Down(a, mid + 1, end) // 递归排序a[mid+1..end]

        // a[start..mid]和a[mid+1..end]是两个有序空间，
        // 将她们排序成一个有序空间a[start..end]
        merge(a, start, mid, end)
    }


    fun mergeLink(one: Link1.Node<Int>, two: Link1.Node<Int>) {
        //构建临时表，找到表头
        var head: Link1.Node<Int>? = null
        //构建当前指针
        var current: Link1.Node<Int>? = null

        var tempOne: Link1.Node<Int>? = one
        var tempTwo: Link1.Node<Int>? = two
        if (tempOne!!.data ?: 0 > tempTwo!!.data ?: 0) {
            head = tempTwo
            current = head
            tempTwo = tempTwo.next
        } else {
            head = tempOne
            current = head
            tempOne = tempOne.next
        }

        while (tempOne != null && tempTwo != null) {
            if (tempOne.data ?: 0 > tempTwo.data ?: 0) {
                current!!.next = tempTwo
                current = current.next
                tempTwo = tempTwo.next
//                println("第一个：$current")
            } else {
                current!!.next = tempOne
                current = current.next
                tempOne = tempOne.next
//                println("第二个：$current")
            }

        }

        if (tempOne != null) {
            current!!.next = tempOne
        }

        if (tempTwo != null) {
            current!!.next = tempTwo
        }

        println(head)
    }
}