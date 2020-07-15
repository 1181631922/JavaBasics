package multithreading.ppt

import multithreading.ppt.CyclicBarrierTest.Companion.THREAD_NUM
import java.util.concurrent.CyclicBarrier

/**
 * Author： fanyafeng
 * Data： 2020/7/15 13:57
 * Email: fanyafeng@live.cn
 */
class CyclicBarrierTest {
    companion object {
        const val THREAD_NUM = 5
    }

    class Worker(private val cyclicBarrier: CyclicBarrier) : Runnable {
        override fun run() {
            println("worker waiting")
            cyclicBarrier.await()
            println(Thread.currentThread().id)

        }
    }
}

fun main(args: Array<String>) {
    val cb = CyclicBarrier(THREAD_NUM, Runnable {
        println("construct Runnable")
    })

    (0 until THREAD_NUM).forEach { _ ->
        Thread(CyclicBarrierTest.Worker(cb)).start()
    }
}