public class LC141_hasCycle {
    /**
     * @问题描述
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * @解法
     * 快慢指针，一个从head出发，一个从head.next出发，
     * 慢的一次一步，快的一次两步
     * 如果链表有环，两个节点会相遇，相遇则返回true
     * 另外相遇的这个地方是环的入口，神奇吧
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
