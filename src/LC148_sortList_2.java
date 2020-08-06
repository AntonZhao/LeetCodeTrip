public class LC148_sortList_2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 第一步：求链表的长度
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }

        // 第二步：假装归并，分别 1,2,4,8
        for (int step = 1; step < n; step *= 2) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);
                curr = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    /*
        从当前开始算，走step个，断开，返回后面的头
     */
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    /*
        把left和right合并放在prev后面
     */
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }


}
