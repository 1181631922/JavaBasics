package multithreading.ppt

import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

/**
 * Author： fanyafeng
 * Data： 2020/7/15 10:06
 * Email: fanyafeng@live.cn
 */


fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    val onlineShopping: Callable<FuturePattern.KitchenWare> = Callable<FuturePattern.KitchenWare> {
        println("第一步：下单")
        println("第一步：等待送货")
        Thread.sleep(5000)
        println("第一步：快递送到")
        FuturePattern.KitchenWare()
    }

    val task = FutureTask(onlineShopping)
    Thread(task).start()

    /**
     * 第二步 购买食材
     */
    Thread.sleep(2000)
    val ingredient = FuturePattern.Ingredient()
    println("第二步：食材到位")

    /**
     * 第三步 用厨具烹饪食材
     */
    if (!task.isDone) {
        println("第三步：厨具还没送到，可以等，也可以取消订单")
    }

    /**
     * Waits if necessary for the computation to complete, and then
     * retrieves its result.
     */
    val result = task.get()
    println("第三步：厨具到位，开始做饭")
    FuturePattern().cook(result, ingredient)

    println("总共用时：" + (System.currentTimeMillis() - startTime) + "ms")

}