package multithreading.test

import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger

/**
 * Author： fanyafeng
 * Data： 2020/6/22 17:39
 * Email: fanyafeng@live.cn
 */
class Data(num: Int) {
    var num: AtomicInteger = AtomicInteger(num)
    fun getAndDecrement(): Int {
        return num.getAndDecrement()
    }

}

internal class MyRun(private val data: Data, // 用来记录所有卖出票的编号
                     private val list: MutableList<Int?>, private val latch: CountDownLatch) : Runnable {

    override fun run() {
        try {
            action()
        } finally {
            // 释放latch共享锁
            latch.countDown()
        }
    }

    // 进行买票操作，注意这里没有使用data.num>0作为判断条件，直到卖完线程退出。
    // 那么做会导致这两处使用了共享变量data.num，那么做多线程同步时，就要考虑更多条件。
    // 这里只for循环了5次，表示每个线程只卖5张票，并将所有卖出去编号存入list集合中。
    private fun action() {
        for (i in 0..4) {
            try {
                Thread.sleep(10)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val newNum = data.getAndDecrement()
            println("线程" + Thread.currentThread().name + "  num==" + newNum)
            list.add(newNum)
        }
    }

}

object Test {
    fun startThread(data: Data, name: String?, list: MutableList<Int?>, latch: CountDownLatch) {
        val t = Thread(MyRun(data, list, latch), name)
        t.start()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // 使用CountDownLatch来让主线程等待子线程都执行完毕时，才结束
        val latch = CountDownLatch(6)
        val start = System.currentTimeMillis()
        // 这里用并发list集合
        val list = mutableListOf<Int?>()
        val data = Data(30)
//        startThread(data, "t1", list, latch)
//        startThread(data, "t2", list, latch)
//        startThread(data, "t3", list, latch)
//        startThread(data, "t4", list, latch)
//        startThread(data, "t5", list, latch)
//        startThread(data, "t6", list, latch)
        Thread(MyRun(data, list, latch), "T1").start()
        Thread(MyRun(data, list, latch), "T2").start()
        Thread(MyRun(data, list, latch), "T3").start()
        Thread(MyRun(data, list, latch), "T4").start()
        Thread(MyRun(data, list, latch), "T5").start()
        Thread(MyRun(data, list, latch), "T6").start()

        try {
            latch.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        // 处理一下list集合，进行排序和翻转
//        Collections.sort(list)
//        Collections.reverse(list)
        println(list.toList().sortedBy { it }.reversed().toString())
        val time = System.currentTimeMillis() - start
        // 输出一共花费的时间
        println("\n主线程结束 time==$time")
    }
}