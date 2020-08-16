package exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，奇偶依次打印
 * 使用锁实现
 */
public class TwoThreadLock {
    private int start = 1;
    private boolean flag = false;
    private static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        TwoThreadLock twoThreadLock = new TwoThreadLock();

        Thread t1 = new Thread(new OuNum(twoThreadLock));
        t1.setName("t1");

        Thread t2 = new Thread(new JiNum(twoThreadLock));
        t2.setName("t2");

        t1.start();
        t2.start();



    }

    public static class OuNum implements Runnable {

        private TwoThreadLock number;

        public OuNum(TwoThreadLock number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
                if (number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = false;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }


        }
    }

    public static class JiNum implements Runnable {

        private TwoThreadLock number;

        public JiNum(TwoThreadLock number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
                if (!number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = true;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }


        }
    }

}
