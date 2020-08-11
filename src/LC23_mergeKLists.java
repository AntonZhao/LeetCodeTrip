import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23_mergeKLists {
    /**
     * leetcode-23 合并k个排序列表【困难】
     * 利用归并排序分成两部分有序数组的机制，可以统计逆序对
     * 优秀题解：
     */

    /**
     * 1. 使用小根堆对 1 进行优化，每次 O(logK) 比较 K个指针求 min, 时间复杂度：O(NlogK)
     */
    public ListNode mergeKLists_1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        for (ListNode node : lists) {
            if (node != null) minHeap.add(node);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (!minHeap.isEmpty()) {
            head.next = minHeap.poll();
            head = head.next;
            if (head.next != null)
                minHeap.add(head.next);
        }

        return dummyHead.next;
    }

    /**
     * 2. 两两合并，时间复杂度：O(NlogK)
     */
    public ListNode mergeKLists_2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge2Lists_iteration(l1, l2);
    }


    /**
     * 合并两个链表 --- 递归
     */
    public ListNode merge2Lists_recursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge2Lists_recursion(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists_recursion(l1, l2.next);
        return l2;
    }

    /**
     * 合并两个链表 --- 迭代
     */
    public ListNode merge2Lists_iteration(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }


}
