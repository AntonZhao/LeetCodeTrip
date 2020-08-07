public class LC61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        k = k % length;
        if (k == 0) return head;

        // a节点比b节点早出发k个节点
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            a = a.next;
        }

        while (a.next != null) {
            a = a.next;
            b = b.next;
        }

        ListNode newHead = b.next;
        // b是新的尾巴
        b.next = null;
        a.next = head;

        return newHead;
    }
}
