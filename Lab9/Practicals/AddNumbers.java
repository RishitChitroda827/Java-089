import java.util.concurrent.atomic.AtomicLong;

public class AddNumbers{

    static long sharedTotal = 0;

    static void addWithoutSync(long value) {
        sharedTotal += value;
    }

    static synchronized void addWithSync(long value) {
        sharedTotal += value;
    }

    public static void main(String[] args) throws InterruptedException {

        int size = 10_000_000;
        int numberOfThreads = 4;

        long[] numbers = new long[size];

        // Fill array
        for (int i = 0; i < size; i++) {
            numbers[i] = 1;
        }

        long expected = 0;

        for (long number : numbers) {
            expected += number;
        }

        System.out.println("Expected result: " + expected);

        sharedTotal = 0;

        Thread[] threads = new Thread[numberOfThreads];

        long start = System.nanoTime();

        int chunk = size / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {

            int startIndex = i * chunk;
            int endIndex = (i == numberOfThreads - 1)
                    ? size
                    : startIndex + chunk;

            threads[i] = new Thread(() -> {

                for (int j = startIndex; j < endIndex; j++) {
                    addWithoutSync(numbers[j]);
                }

            });

            threads[i].start();
        }


        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.nanoTime();

        System.out.println("\nWithout synchronization:");
        System.out.println("Result: " + sharedTotal);
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

        sharedTotal = 0;

        threads = new Thread[numberOfThreads];

        start = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {

            int startIndex = i * chunk;
            int endIndex = (i == numberOfThreads - 1)
                    ? size
                    : startIndex + chunk;

            threads[i] = new Thread(() -> {

                for (int j = startIndex; j < endIndex; j++) {
                    addWithSync(numbers[j]);
                }

            });

            threads[i].start();
        }


        for (Thread thread : threads) {
            thread.join();
        }

        end = System.nanoTime();

        System.out.println("\nWith synchronized:");
        System.out.println("Result: " + sharedTotal);
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

        AtomicLong atomicTotal = new AtomicLong(0);

        threads = new Thread[numberOfThreads];

        start = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {

            int startIndex = i * chunk;
            int endIndex = (i == numberOfThreads - 1)
                    ? size
                    : startIndex + chunk;

            threads[i] = new Thread(() -> {

                for (int j = startIndex; j < endIndex; j++) {
                    atomicTotal.addAndGet(numbers[j]);
                }

            });

            threads[i].start();
        }


        for (Thread thread : threads) {
            thread.join();
        }

        end = System.nanoTime();

        System.out.println("\nWith AtomicLong:");
        System.out.println("Result: " + atomicTotal.get());
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");
    }
}