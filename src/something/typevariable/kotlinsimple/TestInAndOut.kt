package something.typevariable.kotlinsimple

/**
 * Author： fanyafeng
 * Data： 2020/3/30 16:21
 * Email: fanyafeng@live.cn
 */
interface TestInAndOut<in E, out T> {
    fun fun1(t: E): T


}