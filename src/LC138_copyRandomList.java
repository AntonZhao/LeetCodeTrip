import java.util.HashMap;
import java.util.Map;

public class LC138_copyRandomList {

    public Node copyRandomList_map(Node head) {
        if (head ==null) return null;

        //创建一个哈希表，key是原节点，value是新节点
        Map<Node, Node> map = new HashMap<>();
        //将原节点和新节点放入哈希表中
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        //遍历原链表，设置新节点的next和random
        p = head;
        while (p != null) {
            Node node = map.get(p);
            if (p.next != null) node.next = map.get(p.next);
            if (p.random != null) node.random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }


    public Node copyRandomList(Node head) {
        if (head ==null) return null;
        Node p = head;
        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }

        //第二步，设置新节点的随机节
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        //第三步，将两个链表分离
        Node dummy = new Node(-1);
        p = head;
        Node curr = dummy;
        while (p != null) {
            curr.next = p.next;
            curr = curr.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

