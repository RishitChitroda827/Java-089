import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}

public class Guardedcalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Enter A Number : ");
                int a = Integer.parseInt(sc.next());

                System.out.println("Enter A Operator : ");
                String OP = sc.next();

                System.out.println("Enter Another Number : ");
                int b = Integer.parseInt(sc.next());

                if (OP.equals("+")) {
                    System.out.println("Result = " + (a + b));
                }

                else if (OP.equals("-")) {
                    System.out.println("Result = " + (a - b));
                }

                else if (OP.equals("*")) {
                    System.out.println("Result = " + (a * b));
                }

                else if (OP.equals("/")) {

                    if (b == 0) {
                        throw new DivideByZeroException(
                            "Cannot divide by zero"
                        );
                    }

                    System.out.println("Result = " + (a / b));
                }

                else {
                    System.out.println("Invalid Operator");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid number");

            } catch (DivideByZeroException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                System.out.println("Attempt logged.");

            }
        }

        sc.close();
    }
}