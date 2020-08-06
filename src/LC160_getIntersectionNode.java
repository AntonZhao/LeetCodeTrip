public class LC160_getIntersectionNode {
    // 链表A： a+c, 链表B : b+c.
    // 若相交，a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。
    // 若不相交，a +b = b+a 。因此相遇处是NULL
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        LC160_getIntersectionNode ll = new LC160_getIntersectionNode();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        ListNode b = new ListNode(10);

        System.out.println(ll.getIntersectionNode(a, b));
    }
}
