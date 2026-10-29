package main;

import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show Count");
            System.out.println("3. Save Data");
            System.out.println("4. Load Data");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                try {
                    service.addStudent(name);
                    System.out.println("Student added.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                System.out.println("Total students: " + service.getCount());
            } else if (choice == 3) {
                System.out.print("Enter filename: ");
                String filename = sc.nextLine();
                try {
                    service.saveToFile(filename);
                    System.out.println("Data saved successfully.");
                } catch (Exception e) {
                    System.out.println("Error saving data: " + e.getMessage());
                }
            } else if (choice == 4) {
                System.out.print("Enter filename: ");
                String filename = sc.nextLine();
                try {
                    service.loadFromFile(filename);
                    System.out.println("Data loaded successfully.");
                } catch (Exception e) {
                    System.out.println("Error loading data: " + e.getMessage());
                }
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
