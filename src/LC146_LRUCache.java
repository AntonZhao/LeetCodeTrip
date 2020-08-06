import java.util.HashMap;

public class LC146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));

    }
    static class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cache = new DoubleList();
            cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);

            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }

    static class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node x = tail.prev;
            remove(x);
            return x;
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }

    // 双链表节点
    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
