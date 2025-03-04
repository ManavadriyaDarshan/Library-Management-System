package com.example.demoJDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("---------------------------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    BookDAO.addBook(title, author);
                    break;
                case 2:
                    BookDAO.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    UserDAO.addUser(name, contact);
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    TransactionDAO.borrowBook(userId, bookId);
                    break;
                case 5:
                    System.out.print("Enter book ID: ");
                    int returnBookId = scanner.nextInt();
                    TransactionDAO.returnBook(returnBookId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}