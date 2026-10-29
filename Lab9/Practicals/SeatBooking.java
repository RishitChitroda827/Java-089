public class SeatBooking {

    static int availableSeats = 5;
    static int successfulBookings = 0;

    static void book() {

        if (availableSeats > 0) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            availableSeats--;
            successfulBookings++;

            System.out.println(
                Thread.currentThread().getName() + " booked a seat"
            );
        } else {
            System.out.println(
                Thread.currentThread().getName() + " failed - no seats"
            );
        }
    }

    public static void main(String[] args) throws InterruptedException {

        availableSeats = 5;

        Thread[] t = new Thread[10];

        for (int i = 0; i < 10; i++) {

            t[i] = new Thread(() -> {
                book();
            }, "Customer-" + (i + 1));

            t[i].start();
        }

        for (int i = 0; i < 10; i++) {
            t[i].join();
        }

        System.out.println("\nAvailable seats: " + availableSeats);
        System.out.println("Successful bookings: " + successfulBookings);
    }
}