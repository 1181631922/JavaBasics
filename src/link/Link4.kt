package link

/**
 * Author： fanyafeng
 * Data： 2019-12-06 19:17
 * Email: fanyafeng@live.cn
 */
object Link4 {
    @JvmStatic
    fun main(args: Array<String>) {
        val temp6 = Link1.Node(6, null)
        val temp5 = Link1.Node(5, temp6)
        val temp4 = Link1.Node(4, temp5)
        val temp3 = Link1.Node(3, temp4)
        val temp2 = Link1.Node(2, temp3)
        val temp = Link1.Node(1, temp2)

        println(temp.toString())

        val tempNode = reverseListNode(temp)
        println(fanzhuanList(temp).toString())

    }

    fun <T> swapLink(node: Link1.Node<T>) {

    }

    fun <T> reverseListNode(head: Link1.Node<T>?): Link1.Node<T>? {
        if (head == null || head.next == null) {
            return head
        }

        var preNode: Link1.Node<T>? = null
        var curNode = head
        var nextNode: Link1.Node<T>? = null
        while (curNode != null) {
            nextNode = curNode.next
            curNode.next = preNode
            preNode = curNode
            curNode = nextNode
        }
        return preNode

    }

    fun <T> fanzhuanList(head: Link1.Node<T>?): Link1.Node<T>? {
        if (head == null || head.next == null) {
            return head
        }

        var preNode: Link1.Node<T>? = null
        var curNode = head
        var nextNode: Link1.Node<T>? = null

        while (curNode != null) {
            nextNode=curNode.next
            curNode.next=preNode
            preNode=curNode
            curNode=nextNode
        }
        return preNode
    }

    private fun <T> rNode(head: Link1.Node<T>?): Link1.Node<T>? {
        if (null == head || null == head.next)
            return head
        val temp = head.next
        val newHead = rNode(head.next)
        temp!!.next = head
        head.next = null
        return newHead
    }
}