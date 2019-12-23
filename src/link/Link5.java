package link;

import org.junit.Test;

/**
 * Author： fanyafeng
 * Data： 2019-12-07 20:50
 * Email: fanyafeng@live.cn
 */
public class Link5 {

    @Test
    public void main() {
        Link1.Node<Integer> temp6 = new Link1.Node(6, null);
        Link1.Node<Integer> temp5 = new Link1.Node(5, temp6);
        Link1.Node<Integer> temp4 = new Link1.Node(4, temp5);
        Link1.Node<Integer> temp3 = new Link1.Node(3, temp4);
        Link1.Node<Integer> temp2 = new Link1.Node(2, temp3);
        Link1.Node<Integer> temp = new Link1.Node(1, temp2);
        System.out.println(rNode(temp).toString());
    }

    private <T> Link1.Node<T> rNode(Link1.Node<T> head) {
        if (null == head || null == head.getNext())
            return head;
        Link1.Node<T> temp = head.getNext();
        Link1.Node<T> newHead = rNode(head.getNext());
        temp.setNext(head);
        head.setNext(null);
        return newHead;
    }
}
