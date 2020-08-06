public class LC24_swapPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            //要交换的两个节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            //交换两个节点，并且第二个点和prev连接
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            //下一轮循环，更新head和prev
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
