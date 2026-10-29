class Deadlock{

    static final Object laptop = new Object();
    static final Object mouse = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (laptop) {
                System.out.println("Thread 1 locked Laptop");

                try { Thread.sleep(100); }
                catch (Exception e) {}

                System.out.println("Thread 1 waiting for Mouse");
                synchronized (mouse) {
                    System.out.println("Thread 1 locked Mouse");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (mouse) {
                System.out.println("Thread 2 locked Mouse");

                try { Thread.sleep(100); }
                catch (Exception e) {}

                System.out.println("Thread 2 waiting for Laptop");
                synchronized (laptop) {
                    System.out.println("Thread 2 locked Laptop");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
