import java.util.Scanner;
import java.util.Scanner;

/**
 * Represents a reference book in the library system.
 * Inherits from the Book class and includes an edition.
 */
public class ReferenceBook extends Book {
    private String edition; // Edition of the reference book

    /**
     * Constructs a new ReferenceBook and sets the genre to "Reference".
     */
    public ReferenceBook() {
        super();
        genre = "Reference";
    }

    /**
     * Returns a string representation of the ReferenceBook.
     *
     * @return A formatted string describing the book.
     */
    public String toString() {
        return "Book: " + bookCode + " " + title + " " + quantityInStock +
               " Author: " + author  + " Edition: " + edition+ " Genre: " + genre;
    }

    /**
     * Adds a ReferenceBook using user input from Scanner.
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

        // Edition input
        System.out.print("Enter the edition of the book: ");
        edition = scanner.nextLine();

        genre = "Reference"; // Ensure genre is correct

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
