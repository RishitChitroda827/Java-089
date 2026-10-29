class Buffer {
    int[] a = new int[3];
    int count = 0;
    int next = 1;

    synchronized void produce() throws InterruptedException {
        while (count == 3)
            wait();

        while (count < 3 && next <= 10) {
            a[count] = next;
            System.out.println("Produced: " + next);
            count++;
            next++;
        }

        if (count == 3 || next > 10) {
            System.out.println("Buffer full/ready");
            notify();
            wait();
        }
    }

    synchronized void consume() throws InterruptedException {
        while (count == 0)
            wait();

        for (int i = 0; i < count; i++) {
            System.out.println("Consumed: " + a[i]);
        }

        count = 0;
        System.out.println("Buffer empty");

        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        Thread p = new Thread(() -> {
            try {
                while (b.next <= 10)
                    b.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread c = new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++)
                    b.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        p.start();
        c.start();
    }
}