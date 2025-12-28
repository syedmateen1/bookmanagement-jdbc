package com.mateen.bookapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookDAO bookdao = new BookDAO();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Enter the choice:");
            System.out.println("1. Get all books");
            System.out.println("2.Insert a book");
            System.out.println("3. Delete a book");
            System.out.println("4.Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                bookdao.getAllBooks();
            } else if (choice == 3) {
                System.out.println("Enter book id to be deleted");
                int id = sc.nextInt();
                sc.nextLine();
                bookdao.deleteBookById(id);
            } else if (choice == 2) {
                System.out.println("Enter the book title to insert:");
                String title = sc.nextLine();
                System.out.println("Enter the author to insert:");
                String author = sc.nextLine();
                System.out.println("Enter the price to insert:");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter the published year to insert:");
                int year = sc.nextInt();
                sc.nextLine();
                bookdao.insertBook(title, author, price, year);
            }
        } while (choice != 4);
    }
}
