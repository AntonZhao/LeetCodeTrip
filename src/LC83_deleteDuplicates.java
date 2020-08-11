public class LC83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode node = curr.next;
                curr.next = node.next;
                node.next = null; // 清除野指针
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
