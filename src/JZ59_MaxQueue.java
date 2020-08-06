import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class JZ59_MaxQueue {
    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.push_back(1);
        mq.push_back(10);
        mq.push_back(12);
        mq.push_back(111);
        mq.push_back(11);
        mq.push_back(31);
        mq.push_back(51);

        System.out.println(mq.max_value());
        mq.pop_front();
        System.out.println(mq.max_value());
        mq.pop_front();
        System.out.println(mq.max_value());
        mq.pop_front();
        System.out.println(mq.max_value());
        mq.pop_front();
        System.out.println(mq.max_value());
        mq.pop_front();
    }
    static class MaxQueue {
        private Queue<Integer> dataQueue;
        private Deque<Integer> maxQueue;
        public MaxQueue() {
            dataQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.size() > 0 ? maxQueue.peek() : -1;
        }

        public void push_back(int value) {
            dataQueue.offer(value);
            while(maxQueue.size() > 0 && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int pop_front() {
            if (dataQueue.size() == 0) return -1;
            int temp = dataQueue.poll();
            if (temp == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return temp;
        }
    }
}

