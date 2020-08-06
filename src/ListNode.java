import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

//        ListNode mm = mergeList(head, head2);
        ListNode mm = Merge(head, head2);
        while (mm != null) {
            System.out.println(mm.val);
            mm = mm.next;
        }


    }


    public static ListNode Merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                cur.next = l1 == null ? l2 : l1;
                break;
            }
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return head.next;
    }

    public static ListNode reverseNode(ListNode head) {
        ListNode reHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode reCur = cur;
            cur = cur.next;
            reCur.next = reHead;
            reHead = reCur;
        }
        return reHead;
    }


}
