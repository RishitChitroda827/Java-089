class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {

    String[] items = {"Laptop", "Mouse", "Keyboard"};
    int[] stock = {5, 10, 3};

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than 0"
            );
        }

        int index = -1;

        // Find item
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }

        // Item not found
        if (index == -1) {
            System.out.println("Item not found: " + item);
            return;
        }

        // Check stock
        if (qty > stock[index]) {

            int shortfall = qty - stock[index];

            throw new OutOfStockException(shortfall);
        }

        // Reduce stock
        stock[index] = stock[index] - qty;

        System.out.println("Issued " + qty + " " + item);
    }
}

public class Stockissue{

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        String[] requestItems = {
            "Laptop",
            "Mouse",
            "Keyboard",
            "Laptop"
        };

        int[] requestQty = {
            2,
            20,
            0,
            2
        };

        for (int i = 0; i < requestItems.length; i++) {

            try {

                warehouse.issue(
                    requestItems[i],
                    requestQty[i]
                );

            } catch (OutOfStockException e) {

                System.out.println(
                    "Out of stock: " +
                    requestItems[i] +
                    ", Shortfall = " +
                    e.getShortfall()
                );

            } catch (InvalidQuantityException e) {

                System.out.println(
                    "Invalid quantity for " +
                    requestItems[i] +
                    ": " +
                    e.getMessage()
                );
            }
        }

        System.out.println("All requests processed.");
    }
}