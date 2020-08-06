import java.util.LinkedList;
import java.util.PriorityQueue;

public class MedianFinder295 {
    //当前大顶堆和小顶堆的元素个数之和
    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder295() {
        count = 0;
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) != 0)
            return (double)maxHeap.peek();
        else
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }

    public static void main(String[] args) {
        MedianFinder295 obj = new MedianFinder295();
        for (int i = 0; i < 6; i++) {
            obj.addNum(i);
            System.out.println(obj.findMedian());
        }

    }
}
