package multithreading.test

/**
 * Author： fanyafeng
 * Data： 2020/6/10 11:09
 * Email: fanyafeng@live.cn
 */
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val iterable = list.iterator()
    iterable.forEach {
        println(it)
    }


    while (iterable.hasNext()) {
        println(iterable.next())
    }
}