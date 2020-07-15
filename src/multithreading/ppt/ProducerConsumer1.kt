package multithreading.ppt

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 * Author： fanyafeng
 * Data： 2020/7/14 17:43
 * Email: fanyafeng@live.cn
 * 可重入锁，递归锁去实现
 */
class ProducerConsumer1 {

    companion object {
        var count = 0
        const val FULL = 5
        const val EMPTY = 0
    }

    /**
     * 初始化锁对象
     */
    private val lock = ReentrantLock()

    /**
     * 缓冲区两个状态
     */
    private val notFull: Condition = lock.newCondition()
    private val notEmpty: Condition = lock.newCondition()


    inner class Producer : Runnable {
        override fun run() {
            (0 until 10).forEach { _ ->
                Thread.sleep(300)
                lock.lock()
                try {
                    while (count == FULL) {
                        notFull.await()
                    }
                    count++
                    println(Thread.currentThread().name + "生产者生产，目前总共有" + count)
                    /**
                     * 唤醒状态
                     */
                    notEmpty.signal()
                } finally {
                    lock.unlock()
                }
            }
        }
    }

    inner class Consumer : Runnable {
        override fun run() {
            (0 until 10).forEach { _ ->
                Thread.sleep(3000)
                lock.lock()
                try {
                    while (count == EMPTY) {
                        notEmpty.await()
                    }
                    count--
                    println(Thread.currentThread().name + "消费者消费，目前总共有" + count)
                    notFull.signal()
                } finally {
                    lock.unlock()
                }
            }
        }

    }


}

fun main(args: Array<String>) {
    val pc = ProducerConsumer1()
    Thread(pc.Producer()).start()
    Thread(pc.Consumer()).start()
}