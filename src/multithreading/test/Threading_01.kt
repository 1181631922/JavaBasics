package multithreading.test

import java.util.*
import java.util.concurrent.Executors

/**
 * Author： fanyafeng
 * Data： 2020/6/8 10:16
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {

    /**
     * Queue
     */
    val tasks = ArrayDeque<Runnable>();
    tasks.poll()


    Executors.newCachedThreadPool()

}

class RunnableImpl : Runnable {
    override fun run() {
    }
}

class RunImpl : Run {
    override fun run() {
    }

}

interface Run {
    fun run() {

    }
}