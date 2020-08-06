public class LC21_mergeTwoLists {
    /**
     * leetcode-21 合并两个有序链表 【简单】
     * 不一次过就去死吧
     * 优秀题解：
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }

        return res.next;
    }
}
