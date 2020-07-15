package myqueue

import org.junit.Test
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.PriorityBlockingQueue

/**
 * Author： fanyafeng
 * Data： 2020/6/23 14:09
 * Email: fanyafeng@live.cn
 */

class TestQueue1 {

    @Test
    fun testPriorityQueue(){
        val queue1 = PriorityQueue<Int>()
        queue1.add(0)
        println(queue1.toString())
        queue1.offer(1)
        println(queue1.toString())
        (3 until 11).forEach {
            queue1.add(it)
        }
        println(queue1.toString())
        println("10个数了----------------")
        /**
         * 查看队首的元素
         * 只是查看，并不对队列进行操作
         */
        println(queue1.element())
        println(queue1.toString())
        /**
         * 取出队首的元素并且删除
         * 将队列的队首删除
         */
        println(queue1.poll())
        println(queue1.toString())
        /**
         * 查看队首的元素
         * 只是查看
         */
        println(queue1.peek())
        println(queue1.toString())
    }

    @Test
    fun testPriorityBlockingQueue(){

    }


    @Test
    fun testLinkedBlockingQueue() {
        val queue1 = LinkedBlockingQueue<Int>()
        queue1.add(0)
        println(queue1.toString())
        queue1.offer(1)
        println(queue1.toString())
        queue1.put(2)
        println(queue1.toString())
        /**
         * 最大值：Int.MAX_VALUE
         */
        println(queue1.remainingCapacity())
        (3 until 11).forEach {
            queue1.put(it)
        }
        println(queue1.toString())
        println("10个数了----------------")
        /**
         * 查看队首的元素
         * 只是查看，并不对队列进行操作
         */
        println(queue1.element())
        println(queue1.toString())
        /**
         * 取出队首的元素并且删除
         * 将队列的队首删除
         */
        println(queue1.poll())
        println(queue1.toString())
        /**
         * 查看队首的元素
         * 只是查看
         */
        println(queue1.peek())
        println(queue1.toString())
        /**
         * 取出队首的元素并且删除
         * 将队列的队首删除
         */
        println(queue1.take())
        println(queue1.toString())


    }

    @Test
    fun test2() {

    }

}

