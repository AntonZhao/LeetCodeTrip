public class LC328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        // 用 head 和 odd 保存奇链表的头和尾指针
        // 用 evenHead 和 even 保存偶链表的头和尾指针
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
