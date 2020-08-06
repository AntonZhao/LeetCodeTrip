public class LC234_isPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            //快指针走两步
            fast = fast.next.next;
            //慢指针走一步，且翻转前面
            ListNode slow_next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slow_next;
        }
        //根据fast是否为空判断链表的长度是奇数还是偶数，如果是偶数，fast为空；反之fast就是链表的最后一个节点
        //如果是奇数，next指针需要跳到和prev对称的位置。
        if (fast != null){
            slow = slow.next;
        }

        while(slow != null) {
            if (slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
