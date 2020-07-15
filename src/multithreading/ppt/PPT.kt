package multithreading.ppt

import org.junit.Test
import java.util.concurrent.*

/**
 * Author： fanyafeng
 * Data： 2020/7/13 15:26
 * Email: fanyafeng@live.cn
 */
class PPT {
    @Test
    fun ppt1() {
        val cyclicBarrier = CyclicBarrier(3)

    }

    @Test
    fun ppt2() {
        val countDownLatch = CountDownLatch(4)
        countDownLatch.await()
        countDownLatch.countDown()
        countDownLatch.count
    }

    @Test
    fun ppt9() {
        class CountTaskTmp(var start: Int, var end: Int) : RecursiveAction() {
            val MAX = 20

            override fun compute() {
                if ((end - start) < MAX) {
                    (start until end).forEach {
                        Thread.sleep(200)
                        println(Thread.currentThread().name + "i的值：" + it)
                    }
                } else {
                    val middle = (start + end) / 2
                    val left = CountTaskTmp(start, middle)
                    val right = CountTaskTmp(middle, end)

                    left.fork()
                    right.fork()
                }
            }
        }

        val forkJoinPool = ForkJoinPool()
        val task = CountTaskTmp(0, 30)
        forkJoinPool.submit(task)
        forkJoinPool.shutdown()
        while (!forkJoinPool.awaitTermination(2, TimeUnit.SECONDS)) {

        }
        println("任务完成")
    }


    @Test
    fun ppt10() {
        class CountTaskTmp(var start: Int, var end: Int) : RecursiveTask<Int>() {

            val THRESHOLD = 2


            override fun compute(): Int {
                var sum = 0
                val canCompute = (end - start) <= THRESHOLD
                if (canCompute) {
                    for (i in start..end) sum += i
                } else {
                    val mid = (start + end) / 2
                    val leftTask = CountTaskTmp(start, mid);
                    val rightTask = CountTaskTmp(mid + 1, end)

                    leftTask.fork()
                    rightTask.fork()

                    val leftResult = leftTask.join()
                    val rightResult = rightTask.join()

                    sum = leftResult + rightResult
                }

                return sum
            }
        }

        val forkJoinPool = ForkJoinPool()
        val task = CountTaskTmp(1, 4)
        val r = forkJoinPool.submit(task)
        println(r.get())


        val r1 = forkJoinPool.invoke(task)
        println(r1)
        forkJoinPool.shutdown()
    }
}