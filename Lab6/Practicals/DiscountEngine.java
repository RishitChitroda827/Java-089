import java.util.*;

public class DiscountEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> prices = Arrays.asList(
            500.0,
            1000.0,
            2000.0,
            3000.0
        );

        System.out.println("Choose Discount Rule:");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Rs. 100 Discount");

        int choice = sc.nextInt();

        DiscountRule rule;

        switch (choice) {

            case 1:
                rule = price -> price * 0.90;
                break;

            case 2:
                rule = price -> price * 0.80;
                break;

            case 3:
                rule = price -> price - 100;
                break;

            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        System.out.println("\nOriginal -> Discounted");

        for (double price : prices) {

            double discountedPrice = rule.apply(price);

            System.out.println(
                price + " -> " + discountedPrice
            );
        }

        sc.close();
    }
}