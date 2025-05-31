import java.util.Scanner;

/**
 * Represents a Fiction book in the library system.
 */
public class FictionBook extends Book {

    /**
     * Constructs a new FictionBook and sets the genre to "Fiction".
     */
    public FictionBook() {
        super();
        genre = "Fiction";
    }

    /**
     * Returns a string representation of the FictionBook.
     *
     * @return A string describing the book.
     */
    public String toString() {
        return "Book: " + bookCode + " " + title + " " + quantityInStock +
               " Author: " + author + " Genre: " + genre;
    }

    /**
     * Adds a FictionBook to the system using user input.
     *
     * @param scanner Scanner object to read user input.
     * @return true if book was added successfully, false otherwise.
     */
    public boolean addBook(Scanner scanner) {
        System.out.print("Enter the code for the book: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            System.out.print("Enter the code for the book: ");
            scanner.next(); // Clear the invalid input
        }
        bookCode = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        System.out.print("Enter the title of the book: ");
        title = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        author = scanner.nextLine();

        genre = "Fiction";

        System.out.print("Enter the quantity of the book: ");
        int quantity = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                if (quantity > 0) {
                    break;  // valid positive integer, exit loop
                } else {
                    System.out.println("Invalid entry");
                    System.out.print("Enter the quantity of the book: ");
                }
            } else {
                System.out.println("Invalid entry");
                System.out.print("Enter the quantity of the book: ");
                scanner.nextLine(); // clear invalid input
            }
        }

        quantityInStock = quantity; // ✅ use the value already read

        return true;
    }
}