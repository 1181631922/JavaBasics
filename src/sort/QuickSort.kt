package sort

/**
 * Author： fanyafeng
 * Data： 2019-12-06 11:00
 * Email: fanyafeng@live.cn
 */
object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val tempList = mutableListOf(2, 3, 6, 8, 0, 34, 56, 78, 12, 34, 56, 98, 345, 673, 123, 32, 456, 90)
        sort(tempList, 0, tempList.size - 1)
        tempList.forEachIndexed { index, i ->
            println(i)
        }
    }

    fun swap(list: MutableList<Int>, index1: Int, index2: Int) {
        val end = list.size - 1
        val start = 0
        if (index1 < start || index1 > end)
            return
        if (index2 < start || index2 > end)
            return
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp

    }


    fun quickSort(list: MutableList<Int>, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        var i = start - 1
        val temp = list[end]
        for (j in start until end) {
            if (list[j] <= temp) {
                i++
                swap(list, i, j)
            }
        }
        swap(list, i + 1, end)
        quickSort(list, start, i)
        quickSort(list, i + 2, end)

    }

    fun sort(list: MutableList<Int>, start: Int, end: Int) {
        if (start >= end) {
            return
        }

        var i = start - 1
        val temp = list[end]
        for (j in start until end) {
            if (list[j] <= temp) {
                i++
                swap(list, i, j)
            }
        }
        swap(list, i + 1, end)
        sort(list, start, i)
        sort(list, i + 2, end)
    }
}
