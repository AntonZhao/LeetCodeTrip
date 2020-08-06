import java.util.HashMap;
import java.util.HashSet;

public class LC25_reverseKGroup {

    /**
     * leetcode-25 K 个一组翻转链表 【困难】
     * 确实很难，不看答案我做不出来，太考验细节了，理顺了都好说
     * 优秀题解：
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 1. 先往后找k个，如果不够直接break
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            // 2. 从pre.next开始反转，反转前需要记录这一段后面的节点，然后再切断联系，转完之后再连上
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            // 3. 设置新的pre和end
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
