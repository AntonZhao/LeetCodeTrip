public class LC92_reverseBetween {
    // 迭代
    public static ListNode reverseBetween(ListNode head, int m, int n) {
       if (head == null) return null;

       ListNode cur = head, prev = null;
       // 移动两个指针，到达开始节点的前一个。
       while (m > 1) {
           prev = cur;
           cur = cur.next;
           m--;
           n--;
       }
       // tail是翻转段的最后一个，con是第一段的最后一个
       ListNode con = prev, tail = cur;

       ListNode third = null;
       while (n > 0) {
           third = cur.next;
           cur.next = prev;
           prev = cur;
           cur = third;
           n--;
       }

       if (con != null) {
           con.next = prev;
       } else {
           head = prev;
       }

       tail.next = cur;
       return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode _h = head;
        for (int i = 2; i <= 5; i++) {
            ListNode temp = new ListNode(i);
            _h.next = temp;
            _h = _h.next;
        }

        System.out.println(reverseBetween(head, 2, 4).val);
    }
}
