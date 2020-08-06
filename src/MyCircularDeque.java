public class MyCircularDeque {
    private int[] items;
    private int size;
    private int front = 0;
    public int last = 0;
    private int capacity;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.items = new int[k];
        this.capacity = k;
        System.out.println("容量大小为" + k);
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true。
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = (front - 1 + capacity) % capacity;
        items[front] = value;
        size++;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true。
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        items[last] = value;
        last = (last + 1) % capacity;
        size++;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true。
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        last = (last - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return items[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return items[(last - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == last && size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return front == last && size == capacity;
    }


    public static void main(String[] args) {
        MyCircularDeque m = new MyCircularDeque(3);
        m.insertLast(1);
        m.insertLast(2);
        System.out.println(m.last);
        m.insertFront(3);
        System.out.println(m.getRear());
    }

}
