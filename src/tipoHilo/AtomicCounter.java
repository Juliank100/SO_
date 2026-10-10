package tipoHilo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    static AtomicInteger counter = new AtomicInteger(0);

    public void runTest(int threads, int iters) throws InterruptedException {
        counter.set(0);
        Thread[] arr = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            arr[i] = new Thread(() -> {
                for (int j = 0; j < iters; j++) counter.incrementAndGet();
            });
            arr[i].start();
        }
        for (Thread t : arr) t.join();
        System.out.println("Correcto = " + counter.get());
    }

    public static void main(String[] args) throws InterruptedException {
        new AtomicCounter().runTest(8, 100_000);
    }
}