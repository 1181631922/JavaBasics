package link

import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Author： fanyafeng
 * Data： 2019-11-28 15:08
 * Email: fanyafeng@live.cn
 */

object Link1 {
    @JvmStatic
    fun main(args: Array<String>) {
//        1->2->3->4->5->6->3->4->5->6
        val temp6 = Node(6, null)
        val temp5 = Node(5, temp6)
        val temp4 = Node(4, temp5)
        val temp3 = Node(3, temp4)
        val temp2 = Node(2, temp3)
        val temp = Node(1, temp2)
        temp6.next = temp3


//        insertNode(temp, temp2)
//        insertNode(temp, temp3)
//        insertNode(temp, temp4)
//        insertNode(temp, temp5)
//        insertNode(temp, temp6)
//
//        printNode(temp)

//        println(hasCycle(temp).toString())

//        println("碰撞值：" + hasCycleNode(temp).data)

        var cycleLength = findCycleLength(temp)
//        println("环的长度：$cycleLength")

        println(findRepetPoint(temp, cycleLength).data)


        println(findHandleLength(temp, findRepetPoint(temp, cycleLength)))

    }

    fun <T> findHandleLength(node: Node<T>, repeatNode: Node<T>): Int {
        var temp = node
        var count = 0
        while (true) {
            count++
            temp = temp.next!!
            if (temp == repeatNode) {
                return count
            }
        }
    }

    fun <T> findRepetPoint(node: Node<T>, circleLength: Int): Node<T> {
        var front = node
        var back = node
        //前面的先走circleLength
        (0 until circleLength).forEachIndexed { index, i ->
            front = front.next!!
        }
        println(front.data)

        while (true) {
            front = front.next!!
            back = back.next!!
            if (front == back) {
                return front
            }
        }
    }

    fun <T> findCycleLength(node: Node<T>): Int {
        var circleLength = 0
        var firstNode = node
        var secondNode = node
        var hasCircle = false
        while (true) {
            if (firstNode.next == null) {
                return circleLength
            }
            if (secondNode.next == null) {
                return circleLength
            }
            if (secondNode.next!!.next == null) {
                return circleLength
            }
            if (!hasCircle) {
                firstNode = firstNode.next!!
                secondNode = secondNode.next!!.next!!
            } else {
                secondNode = secondNode.next!!
            }
            if (firstNode == secondNode) {
                hasCircle = true
                if (hasCircle && circleLength != 0) {
                    return circleLength + 1
                }
            } else {
                if (hasCircle) {
                    circleLength++
                }
            }
        }
    }


    fun <T> hasCycle(node: Node<T>): Boolean {
        var firstNode = node
        var secondNode = node
        while (true) {
            if (firstNode.next == null) {
                return false
            }
            if (secondNode.next == null) {
                return false
            }
            if (secondNode.next!!.next == null) {
                return false
            }
            firstNode = firstNode.next!!
            secondNode = secondNode.next!!.next!!
            if (firstNode == secondNode) {
                return true
            }
        }
    }

    fun <T> hasCycleNode(node: Node<T>): Node<T> {
        var firstNode = node
        var secondNode = node
        while (true) {
            if (firstNode.next == null) {
                return Node()
            }
            if (secondNode.next == null) {
                return Node()
            }
            if (secondNode.next!!.next == null) {
                return Node()
            }
            firstNode = firstNode.next!!
            secondNode = secondNode.next!!.next!!
            if (firstNode == secondNode) {
                return firstNode
            }
        }
    }

    fun <T> printNode(node: Node<T>) {
        var count = 0
        var tempNode = node
        var crashCount = 0
        var cycleNode = hasCycleNode(node)
        while (tempNode.next != null) {
            println(tempNode.data)
            tempNode = tempNode.next!!
            count++
            if (tempNode.data == cycleNode.data) {
                crashCount++
            }
            if (crashCount == 2) {
                println("链表长度：$count")
                break
            }
        }

    }

    //current和insert做了限制，都不能为空
    fun <T> insertNode(currentNode: Node<T>, insertNode: Node<T>) {

        if (currentNode.next == null) {
            currentNode.next = insertNode
        } else {
            val tempNode = currentNode.next
            insertNode(tempNode!!, insertNode)
        }
    }

    //单向链表
    class Node<T>(
            //当前data值
            var data: T? = null,
            //指向下一个的指针
            var next: Node<T>? = null) {

        override fun toString(): String {
            return "Node(data=$data, next=$next)"
        }
    }


}