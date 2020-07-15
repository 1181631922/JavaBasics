package multithreading.atomic

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger

/**
 * Author： fanyafeng
 * Data： 2020/6/12 16:13
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {

//    val sellTickets = ThreadSellTickets()
//    Thread(sellTickets, "张三").start()
//    Thread(sellTickets, "李四").start()
//    Thread(sellTickets, "赵五").start()
//    Thread(sellTickets, "冯六").start()
    val data = Data1(30)
    val latch = CountDownLatch(5)
    val list = mutableListOf<Int>()
    Thread(AtomicThreadSellTickets(data, list, latch), "张三").start()
    Thread(AtomicThreadSellTickets(data, list, latch), "李四").start()
    Thread(AtomicThreadSellTickets(data, list, latch), "赵五").start()
    Thread(AtomicThreadSellTickets(data, list, latch), "冯六").start()
    Thread(AtomicThreadSellTickets(data, list, latch), "王七").start()
    Thread(AtomicThreadSellTickets(data, list, latch), "徐八").start()

    latch.await()

    println(list.toList().sortedBy { it }.toString())

}

class Data1(private val count: Int) {

    @Volatile
    private var num: AtomicInteger = AtomicInteger(count)

    fun getAndDecrement(): Int {
        return num.getAndDecrement()
    }
}


class AtomicThreadSellTickets(private val data: Data1, val list: MutableList<Int>, val latch: CountDownLatch) : Runnable {


    override fun run() {
        try {
            byTicket()
        } finally {
            latch.countDown()
        }
    }

    private fun byTicket() {
        (0 until 5).forEach { _ ->
            Thread.sleep(50)
            val newNum = data.getAndDecrement()
            println(Thread.currentThread().name + "买到了第" + newNum + "张票")
            list.add(newNum)
        }
    }

}

class ThreadSellTickets : Runnable {
    var ticket = 100
    var flag = true
    override fun run() {
        while (flag) {
            buyTicket()
        }
    }

    @Synchronized
    fun buyTicket() {
        //判断票数是否小于等于零，如果是，将flag的值改为false，跳出循环，说明没票了
        if (ticket <= 0) {
            flag = false
            //没票了就跳出方法
            return
        }

        //模拟网络延时，让线程睡100ms。扩大出现错误的可能性。这里出现异常，捕获处理
        try {
            Thread.sleep(50)
        } catch (e: InterruptedException) {
            e.printStackTrace()
            println("run方法里出现了异常")
        }
        println(Thread.currentThread().name + "买到了第" + ticket + "张票")
        //每次循环票数减一
        ticket--
    }

}

class Atomic1 {
    var count = 100

    fun startCount() {
        if (count > 0) {
            println("当前线程:" + Thread.currentThread().name + ";之前的数量:" + count)
            count--
            Thread.sleep(10)
            println("当前线程:" + Thread.currentThread().name + ";之后的数量:" + count)
        }
    }
}