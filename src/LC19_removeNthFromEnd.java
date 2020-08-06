public class LC19_removeNthFromEnd {
    // second指针比first指针先走n步
    // second指针走到尽头，则当前first的下一个就是要删除的节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead, second = dummyHead;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummyHead.next;
    }
}
