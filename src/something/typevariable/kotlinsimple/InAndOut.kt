package something.typevariable.kotlinsimple

/**
 * Author： fanyafeng
 * Data： 2020/4/1 16:31
 * Email: fanyafeng@live.cn
 */
class InAndOut<in T, out E> {
    private var e: E? = null

    fun name(x: T): E? {
        return e
    }

    private fun myName(x: E): T? {
        return null
    }

}