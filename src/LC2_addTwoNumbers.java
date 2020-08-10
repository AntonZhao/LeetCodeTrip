public class LC2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2;
            sum += flag ? 1 : 0;
            flag = sum > 9;

            ListNode temp = new ListNode(sum % 10);
            head.next = temp;
            head = temp;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag) {
            head.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
