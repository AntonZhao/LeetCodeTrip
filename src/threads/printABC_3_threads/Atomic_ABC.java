package threads.printABC_3_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_ABC {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3 * 10;

    static class RunnableA implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE - 1) {
                if (ai.get() % 3 == 0) {
                    System.out.print("A");
                    ai.getAndIncrement();
                }
            }

        }
    }

    static class RunnableB implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1) {
                    System.out.print("B");
                    ai.getAndIncrement();
                }
            }

        }
    }

    static class RunnableC implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2) {
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }

        }
    }


    public static void main(String[] args) {
        Atomic_ABC atomic_ABC = new Atomic_ABC();

        new Thread(new RunnableA()).start();
        new Thread(new RunnableB()).start();
        new Thread(new RunnableC()).start();
    }
}



