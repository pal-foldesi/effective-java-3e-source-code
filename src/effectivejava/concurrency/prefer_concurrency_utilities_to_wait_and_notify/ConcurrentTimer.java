package effectivejava.concurrency.prefer_concurrency_utilities_to_wait_and_notify;
import java.util.concurrent.*;

// Simple framework for timing concurrent execution
public class ConcurrentTimer {
    private ConcurrentTimer() { } // Noninstantiable

    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // Tell timer we're done
                }
            });
        }

        ready.await();     // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await();      // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}
