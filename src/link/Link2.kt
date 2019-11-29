package link

import link.Link1.insertNode

/**
 * Author： fanyafeng
 * Data： 2019-11-29 16:29
 * Email: fanyafeng@live.cn
 */
object Link2 {
    @JvmStatic
    fun main(args: Array<String>) {
        //查找单链表倒数第k个元素
        val temp = Link1.Node(1, null)
        val temp2 = Link1.Node(2, null)
        val temp3 = Link1.Node(3, null)
        val temp4 = Link1.Node(4, null)
        val temp5 = Link1.Node(5, null)
        val temp6 = Link1.Node(6, null)

        insertNode(temp, temp2)
        insertNode(temp, temp3)
        insertNode(temp, temp4)
        insertNode(temp, temp5)
        insertNode(temp, temp6)

//        println(temp)
//        println(findSomeNode(temp, 2))
//        printNode(temp)

        println(findMiddleNode(temp))
    }

    //如果是偶数的话可能是两个
    fun <T> findMiddleNode(node: Link1.Node<T>): List<Link1.Node<T>> {
        var tempList = mutableListOf<Link1.Node<T>>()
        var slowNode = node
        var fastNode = node

        while (true) {
            if (fastNode.next == null) {
                //奇数，返回中间一个
                tempList.add(slowNode)
                return tempList
            }
            if (fastNode.next!!.next == null) {
                tempList.add(slowNode)
                tempList.add(slowNode.next!!)
                return tempList
            }

            slowNode = slowNode.next!!
            fastNode = fastNode.next!!.next!!
        }
    }

    fun <T> printNode(node: Link1.Node<T>) {
        var temp = node
        println(temp.data)
        while (temp.next != null) {
            temp = temp.next!!
            println(temp.data)
        }

    }


    //假设求倒数第2个元素
    fun <T> findSomeNode(node: Link1.Node<T>, count: Int): Link1.Node<T> {
        var slowNode = node
        var fastNode = node
        (0 until count).forEachIndexed { index, i ->
            fastNode = fastNode.next!!
        }

        while (true) {
            slowNode = slowNode.next!!
            if (fastNode.next == null) {
                return slowNode
            } else {
                fastNode = fastNode.next!!
            }
        }
    }
}