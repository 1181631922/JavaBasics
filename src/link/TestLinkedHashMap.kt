package link

import sun.misc.LRUCache

/**
 * Author： fanyafeng
 * Data： 2019-12-03 22:09
 * Email: fanyafeng@live.cn
 */
object TestLinkedHashMap {
    @JvmStatic
    fun main(args: Array<String>) {
        testLruCache()
    }

    fun testLruCache() {
        val lruCache = LruCache<Int, String>(8)
        lruCache.apply {
            put(1, "a")
            put(2, "b")
            put(3, "c")
            put(4, "d")
            put(5, "e")
            put(6, "f")
            put(7, "g")
        }


        lruCache.put(8, "h")

        lruCache.get(2)

        lruCache.get(3)

        lruCache.put(9, "i")

        lruCache.put(10, "j")

        lruCache.get(9)

        lruCache.put(11, "k")

        lruCache.hitCount()


    }

    fun getPrint(note: String = "打印") {
        println("测试反射" + note)
    }

    fun getOrder() {
        val testMap = LinkedHashMap<Int, String>(100, 0.75F, true)
        testMap.apply {
            put(1, "a")
            put(2, "b")
            put(3, "c")
            put(4, "d")
            put(5, "e")
            put(6, "f")
            put(8, "g")
        }

        testMap[2]
        testMap[3]

        testMap.forEach { (t, u) ->
            println("key:$t,value:$u")
        }
    }
}
