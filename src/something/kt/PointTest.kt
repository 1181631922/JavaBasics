package something.kt

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Author： fanyafeng
 * Data： 2020-02-26 09:46
 * Email: fanyafeng@live.cn
 */
object PointTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var a = 10
        val b = "sss"
        val c: Long = 20
        println("测试test")
        Point.sum2(Point(y = 6))
        Point.instance(3)

        val newPoint = Point(3, 4) + Point(6, 7)
    }


}

@GAImageLoadFrame
class Point @JvmOverloads constructor(var x: Int = 3, var y: Int = 0) {
    fun sum() = x + y

    fun sum1(): Int {
//        checkNotNull()
        return x + y
    }

    operator fun plus(point: Point): Point {
        return Point(point.x + this.x, point.y + this.y)
    }

    companion object {
        val a = 3

        fun sum2(point: Point): Int {
            val temp = point.x + point.y
            println(temp)
            return temp
        }

        fun instance(s: Any) {
            when (s) {
                is Int -> {
                    println("int类型")
                }
                is Double -> {
                    println("double类型")
                }
            }
        }
    }
}