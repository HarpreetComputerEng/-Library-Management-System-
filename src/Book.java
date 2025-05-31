import java.util.Scanner;

/**
 * The Book class represents a general book with properties like
 * code, title, author, genre, and quantity in stock.
 * This is intended to be used as a base class.
 */
public class Book {
    protected int bookCode;
    protected String title;
    protected String author;
    protected String genre;
    protected int quantityInStock;

    /**
     * Default constructor initializes fields to default values.
     */
    public Book() {
        this.bookCode = 0;
        this.title = "";
        this.author = "";
        this.genre = "";
        this.quantityInStock = 0;
    }

    /**
     * Provides a string representation of the book.
     *
     * @return formatted book information string.
     */
    public String toString() {
        return "Book: " + bookCode + " " + title + " " + quantityInStock +
               " Author: " + author + " Genre: " + genre;
    }

    /**
     * Updates the quantity of the book in stock.
     *
     * @param amount the number to increase or decrease the quantity by.
     * @return true if the operation is valid, false otherwise.
     */
    public boolean updateQuantity(int amount) {
        if (quantityInStock + amount < 0) {
            return false;
        }
        quantityInStock += amount;
        return true;
    }

    /**
     * Compares if two books are the same by their bookCode.
     *
     * @param book another Book object to compare with.
     * @return true if book codes match, false otherwise.
     */
    public boolean isEqual(Book book) {
        return this.bookCode == book.bookCode;
    }

    /**
     * Adds book details from user input using Scanner.
     *
     * @param scanner the Scanner object for reading input.
     * @return true if book was successfully added, false if invalid data.
     */
    public boolean addBook(Scanner scanner) {
        System.out.print("Enter the code for the book: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            scanner.nextLine();
            return false;
        }
        this.bookCode = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the title of the book: ");
        this.title = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        this.author = scanner.nextLine();

        System.out.print("Enter the quantity of the book: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            scanner.nextLine();
            return false;
        }

        int qty = scanner.nextInt();
        if (qty <= 0) {
            System.out.println("Invalid entry");
            scanner.nextLine();
            return false;
        }
        this.quantityInStock = qty;
        scanner.nextLine();

        return true;
    }

    /**
     * Prompts the user to input a book code.
     *
     * @param scanner the Scanner object to use.
     * @return true if valid book code was entered, false otherwise.
     */
    public boolean inputCode(Scanner scanner) {
        System.out.print("Enter valid book code: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid entry");
            scanner.nextLine();
            return false;
        }
        this.bookCode = scanner.nextInt();
        scanner.nextLine();
        return true;
    }

    /**
     * Getter for bookCode.
     *
     * @return the book code
     */
    public int getBookCode() {
        return bookCode;
    }

    /**
     * Getter for quantity in stock.
     *
     * @return current stock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }
}
