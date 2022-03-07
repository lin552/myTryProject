import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RushOrder {

    int i;
    Object o = new Object();
    Lock lock = new ReentrantLock();

    AtomicInteger atomicInteger = new AtomicInteger(6000);

    public RushOrder(int i) {
        this.i = i;
    }

    public void order(){
//        i--;

//        synchronized (o) {
//            i--;
//        }

        atomicInteger.decrementAndGet();

//        lock.lock();
//        try {
//            i--;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
    }

    public static void main(String[] args) throws Exception {
        RushOrder rushOrder = new RushOrder(60000);
        rushOrder.test();

    }

    public void test() throws InterruptedException {
        for (int j = 0; j < 6; j++) {
            new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    order();
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("库存"+i);
    }
}
