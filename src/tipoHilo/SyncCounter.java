package tipoHilo;

public class SyncCounter {
    static int counter = 0;
    static final Object lock = new Object();

    static void inc() { synchronized (lock) { counter++; } }

    public void runTest(int threads, int iters) throws InterruptedException {
        counter = 0;
        Thread[] arr = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            arr[i] = new Thread(() -> {
                for (int j = 0; j < iters; j++) inc();
            });
            arr[i].start();
        }
        for (Thread t : arr) t.join();
        System.out.println("Correcto = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        new SyncCounter().runTest(8, 100_000);
    }
}