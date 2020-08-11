public class LC82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 把head拴在dummy后面，这样head也好删
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 定义两个节点，保存当前的节点和上一个节点
        // 和83题相比，增加了一个prev节点用来连接
        ListNode prev = dummyHead;
        ListNode curr = head;

        // 循环条件也和83题一致
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // 当前节点和下一个节点的值一样，出现重复
                // 当前值保存，不断next，直到值不一样，或者节点为空
                int val = curr.val;
                while (curr != null && curr.val == val) curr = curr.next;
                // 和prev进行连接
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummyHead.next;
    }
}
