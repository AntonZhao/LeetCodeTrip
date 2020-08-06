public class LC876_middleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            return fast;
        } else {
            return slow;
        }
    }
}
