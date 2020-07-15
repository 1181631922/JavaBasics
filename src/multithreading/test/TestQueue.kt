package multithreading.test

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.LinkedBlockingQueue

/**
 * Author： fanyafeng
 * Data： 2020/6/11 09:58
 * Email: fanyafeng@live.cn
 */

fun main(args: Array<String>) {
    val queue = LinkedBlockingDeque<Int>()
    queue.offer(3)
    queue.add(5)

    queue.forEach {
        println(it.toString())
    }

    println(queue.element())

    println(queue.peek())


    queue.forEach {
        println(it.toString())
    }

    val addedQueue = LinkedBlockingDeque<Int>()
    addedQueue.add(9)
    addedQueue.add(5)
    addedQueue.add(3)

    queue.drainTo(addedQueue)

    addedQueue.forEach {
        println("添加：$it")
    }

    addedQueue.take()

    addedQueue.pop()

    addedQueue.poll()

    addedQueue.pollLast()

    addedQueue.forEach {
        println("添加-：$it")
    }

}

