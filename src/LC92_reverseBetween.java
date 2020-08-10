public class LC92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;

        // 第一段：0 ~ m，可能不存在； 旧的第二段：m ~ n
        ListNode firstSegmentTail = null, SecondSegmentHead = head;
        while (m > 1) {
            firstSegmentTail = SecondSegmentHead;
            SecondSegmentHead = SecondSegmentHead.next;
            m--;
            n--;
        }

        // 反转 m-n+1 次，之后，prev落在反转段的最后一个，也就是反转后的反转段的第一个；
        // cur可以视作是 n + 1 ~ end 这段的头结点，可能为空
        ListNode prev = null;
        ListNode cur = SecondSegmentHead;
        while (n > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }

        // 如果 m=1 的话，就没有第一段了，所以需要判断
        if (firstSegmentTail != null) {
            firstSegmentTail.next = prev;
        } else {
            head = prev;
        }

        SecondSegmentHead.next = cur;

        return head;
    }

    public static void main(String[] args) {
        LC92_reverseBetween ll = new LC92_reverseBetween();

        ListNode head = new ListNode(1);
        ListNode _h = head;
        for (int i = 2; i <= 5; i++) {
            ListNode temp = new ListNode(i);
            _h.next = temp;
            _h = _h.next;
        }

        System.out.println(ll.reverseBetween(head, 2, 4).val);
    }
}
