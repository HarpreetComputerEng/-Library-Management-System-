import java.util.Scanner;

import java.util.Scanner;

/**
 * Represents a non-fiction book in the library system.
 * Inherits from the Book class and includes a field of study.
 */
public class NonFictionBook extends Book {
    private String field; // Field of study for the non-fiction book

    /**
     * Constructs a new NonFictionBook and sets the genre to "Non-Fiction".
     */
    public NonFictionBook() {
        super();
        genre = "Non-Fiction";
    }

    /**
     * Returns a string representation of the NonFictionBook.
     *
     * @return A formatted string describing the book.
     */
    public String toString() {
        return "Book: " + bookCode + " " + title + " " + quantityInStock +
               " Author: " + author  + " Field of Study: " + field+ " Genre: " + genre;
    }

    /**
     * Adds a NonFictionBook using user input from Scanner.
     * Includes validation for integer inputs and ensures quantity is positive.
     *
     * @param scanner Scanner object to read user input
     * @return true if book was added successfully
     */
    public boolean addBook(Scanner scanner) {
        // Input and validate book code
        System.out.print("Enter the code for the book: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            System.out.print("Enter the code for the book: ");
            scanner.next(); // clear invalid input
        }
        bookCode = scanner.nextInt();
        scanner.nextLine(); // clear newline

        // Title input
        System.out.print("Enter the title of the book: ");
        title = scanner.nextLine();

        // Author input
        System.out.print("Enter the author of the book: ");
        author = scanner.nextLine();

        // Field of study input
        System.out.print("Enter the field of study: ");
        field = scanner.nextLine();

        genre = "Non-Fiction"; // Ensure genre is correct

        // Quantity input with validation
        System.out.print("Enter the quantity of the book: ");
        int quantity = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (quantity > 0) break;
                else {
                    System.out.println("Invalid entry");
                    System.out.print("Enter the quantity of the book: ");
                }
            } else {
                System.out.println("Invalid entry");
                System.out.print("Enter the quantity of the book: ");
                scanner.nextLine(); // clear invalid input
            }
        }

        quantityInStock = quantity; // Set the validated quantity
        return true;
    }
}
