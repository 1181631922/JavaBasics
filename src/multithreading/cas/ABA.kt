package multithreading.cas

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicStampedReference

/**
 * Author： fanyafeng
 * Data： 2020/7/14 18:38
 * Email: fanyafeng@live.cn
 */
class ABA {
    // 普通的原子类，存在ABA问题
    var a1 = AtomicInteger(10)

    // 带有时间戳的原子类，不存在ABA问题，第二个参数就是默认时间戳，这里指定为0
    var a2 = AtomicStampedReference(10, 0)
    fun test() {
        Thread1().start()
        Thread2().start()
        Thread3().start()
        Thread4().start()
    }

    internal inner class Thread1 : Thread() {
        override fun run() {
            a1.compareAndSet(10, 11)
            a1.compareAndSet(11, 10)
        }
    }

    internal inner class Thread2 : Thread() {
        override fun run() {
            try {
                sleep(200) // 睡0.2秒，给线程1时间做ABA操作
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("AtomicInteger原子操作：" + a1.compareAndSet(10, 11))
        }
    }

    internal inner class Thread3 : Thread() {
        override fun run() {
            try {
                sleep(500) // 睡0.5秒，保证线程4先执行
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            var stamp = a2.stamp
            a2.compareAndSet(10, 11, stamp, stamp + 1)
            stamp = a2.stamp
            a2.compareAndSet(11, 10, stamp, stamp + 1)
        }
    }

    internal inner class Thread4 : Thread() {
        override fun run() {
            val stamp = a2.stamp
            try {
                sleep(1000) // 睡一秒，给线程3时间做ABA操作
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println("AtomicStampedReference原子操作:" + a2.compareAndSet(10, 11, stamp, stamp + 1))
        }
    }
}

fun main(args: Array<String>) {
    val a = ABA()
    a.test()
}