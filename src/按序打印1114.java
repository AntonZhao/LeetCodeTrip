import java.util.concurrent.atomic.AtomicInteger;

public class 按序打印1114 {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    static int count = 1;
    public static void main(String[] args) throws Exception {
        Thread thread= new Thread(() -> {
            while (count == 1);
            System.out.println("result");
        });
        thread.start();
        Thread.sleep(100);
        count++;
        System.out.println(count);
        thread.join();
    }
}
