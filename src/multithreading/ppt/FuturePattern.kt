package multithreading.ppt

/**
 * Author： fanyafeng
 * Data： 2020/7/15 10:06
 * Email: fanyafeng@live.cn
 */
class FuturePattern {


    class OnlineShopping : Thread() {
        var kitchenWare: KitchenWare? = null

        override fun run() {
            println("第一步：下单")
            println("第一步：等待送达")
            sleep(5000)
            println("第一步：快递送到")
            kitchenWare = KitchenWare()
        }
    }

    fun cook(kitchenWare: KitchenWare, ingredient: Ingredient) {
        println("最后一步：开始做饭")
    }

    /**
     * 厨具
     */
    class KitchenWare()

    /**
     * 食材
     */
    class Ingredient()
}

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()

    /**
     * 网购厨具
     */
    val onlineThread = FuturePattern.OnlineShopping()
    onlineThread.start()
    /**
     * Waits for this thread to die.
     */
    onlineThread.join()

    /**
     * 去超市购买食材
     */
    Thread.sleep(2000)
    val ingredient = FuturePattern.Ingredient()
    println("第二步：食材到位")

    /**
     * 开始做饭
     */
    println("第三步：开始展现厨艺")
    onlineThread.kitchenWare?.let {
        FuturePattern().cook(it, ingredient)
    }
    if (onlineThread.kitchenWare == null) {
        println("第三步：失败，奈何厨具未送达")
    }
    println("总共用时：" + (System.currentTimeMillis() - startTime) + "ms")


}