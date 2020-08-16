import java.util.HashSet;
import java.util.Set;

public class LC142_detectCycle {
    /**
     * 1. 快指针和慢指针出发
     * 2. 快指针走到环入口处，走了 n，此时慢指针走了 n/2
     * 3. 慢指针再走 n/2，快指针走了 n；此时，慢指针在入环处，快指针距离入环处 n；
     * 4. 假设 快指针 距离入环处 b；慢指针走b，到达距离入环处b的地方；快指针走了2b，算上刚才剩下的b，也到了距离入环处b的地方。两者相遇
     * 5. 基于上面的假设，可知 环的长度 = n + b，也就是说快慢指针此时距离入环处的距离是 n
     * 6. n就是从head到入环处的地方，再让两个指针一起走，就到了入环处
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public ListNode detectCycle_map(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
