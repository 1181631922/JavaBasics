package multithreading.ppt

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

/**
 * Author： fanyafeng
 * Data： 2020/7/14 17:22
 * Email: fanyafeng@live.cn
 *
 * 通过队列方式实现生产者消费者模式
 * 单向队列
 */
class ProducerConsumer {

    companion object {
        var count = 0
    }

    /**
     * 单项队列
     * 初始容量10
     */
    val blockingQueue: BlockingQueue<Int> = ArrayBlockingQueue(10)


    inner class Producer : Runnable {
        override fun run() {
            (0 until 10).forEach { _ ->
                Thread.sleep(300)
                blockingQueue.put(1)
                count++
                println(Thread.currentThread().name + "生产者，目前总共有" + count)
            }
        }
    }

    inner class Consumer : Runnable {
        override fun run() {
            (0 until 10).forEach { _ ->
                Thread.sleep(3000)
                blockingQueue.take()
                count--
                println(Thread.currentThread().name + "消费者消费，目前总共有" + count)
            }
        }

    }
}

fun main(args: Array<String>) {
    val pc = ProducerConsumer()
    Thread(pc.Producer()).start()
    Thread(pc.Consumer()).start()
}