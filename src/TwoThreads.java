import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreads {
    public static void main(String[] args) {
        TwoThreads tt = new TwoThreads(1, true, new ReentrantLock());

//        int start = 1;
//        boolean flag = true;
//        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            while (tt.start < 100) {
                if (tt.flag == true) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " --- " + tt.start);
                        tt.start++;
                        tt.flag = false;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "OddT").start();

        new Thread(() -> {
            while (tt.start < 100) {
                if (tt.flag == false) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " --- " + tt.start);
                        tt.start++;
                        tt.flag = true;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "EvenT").start();




    }

    private int start;
    private boolean flag;
    private static Lock lock;

    public TwoThreads(int start, boolean flag, Lock lock) {
        this.start = start;
        this.flag = flag;
        this.lock = lock;
    }



}
