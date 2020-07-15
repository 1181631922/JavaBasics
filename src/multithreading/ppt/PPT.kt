package multithreading.ppt

import org.junit.Test
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

/**
 * Author： fanyafeng
 * Data： 2020/7/13 15:26
 * Email: fanyafeng@live.cn
 */
class PPT {
    @Test
    fun ppt1(){

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
    }
}