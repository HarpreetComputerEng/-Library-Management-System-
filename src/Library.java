import java.util.Scanner;

/**
 * The Library class manages a catalog of books and supports operations
 * such as adding, borrowing, and returning books, with appropriate validation.
 */
public class Library {

    private Book[] catalog;
    private int[] borrowedCounts; // Tracks borrowed quantity for each book
    private int numBooks;

    /**
     * Constructs a Library with an empty catalog of capacity 20.
     */
    public Library() {
        catalog = new Book[20];
        borrowedCounts = new int[20]; // parallel array for tracking borrowed quantity
        numBooks = 0;
    }

    /**
     * Checks whether a given book already exists in the catalog.
     *
     * @param book the book to check
     * @return index if found, otherwise -1
     */
    public int alreadyExists(Book book) {
        for (int i = 0; i < numBooks; i++) {
            if (catalog[i].isEqual(book)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds a new book to the catalog by prompting the user for book details.
     *
     * @param scanner Scanner object for reading input
     * @return true if book is added, false otherwise
     */
    public boolean addBook(Scanner scanner) {
        String type = "";
        boolean validType = false;

        while (!validType) {
            System.out.print("Do you wish to add a Fiction (f), Non-Fiction (n), or Reference (r) book? ");
            if (scanner.hasNextLine()) {
                type = scanner.nextLine().trim().toLowerCase();
                if (type.equals("f") || type.equals("n") || type.equals("r")) {
                    validType = true;
                } else {
                    System.out.println("Invalid entry");
                }
            }
        }

        Book book = null;
        if (type.equals("f")) {
            book = new FictionBook();
        } else if (type.equals("n")) {
            book = new NonFictionBook();
        } else if (type.equals("r")) {
            book = new ReferenceBook();
        }

        if (book != null && book.addBook(scanner)) {
            if (alreadyExists(book) == -1) {
                if (numBooks < catalog.length) {
                    catalog[numBooks] = book;
                    borrowedCounts[numBooks] = 0; // initially borrowed 0
                    numBooks++;
                    return true;
                } else {
                    System.out.println("Catalog is full.");
                }
            } else {
                System.out.println("Book code already exists.");
            }
        }

        return false;
    }

    /**
     * Handles the borrowing of books by verifying code and quantity.
     *
     * @param scanner Scanner object for reading input
     */
    public void borrowBook(Scanner scanner) {
        System.out.print("Enter valid book code: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Code not found in catalog...");
            System.out.println("Error...could not borrow book");
            return;
        }

        int code = scanner.nextInt();
        scanner.nextLine();

        int index = -1;
        for (int i = 0; i < numBooks; i++) {
            if (catalog[i].getBookCode() == code) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Code not found in catalog...");
            System.out.println("Error...could not borrow book");
            return;
        }

        Book foundBook = catalog[index];

        System.out.print("Enter valid quantity to borrow: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid quantity...");
            System.out.println("Error...could not borrow book");
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity < 1) {
            System.out.println("Invalid quantity...");
            System.out.println("Error...could not borrow book");
            return;
        }

        if (foundBook.getQuantityInStock() >= quantity) {
            foundBook.updateQuantity(-quantity);
            borrowedCounts[index] += quantity; // track borrowed
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Not enough copies in stock.");
            System.out.println("Error...could not borrow book");
        }
    }

    /**
     * Handles returning of books by verifying code and quantity, ensuring
     * users do not return more than borrowed.
     *
     * @param scanner Scanner object for reading input
     */
    public void returnBook(Scanner scanner) {
        System.out.print("Enter valid book code: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Code not found in catalog...");
            System.out.println("Error...could not return book");
            return;
        }

        int code = scanner.nextInt();
        scanner.nextLine();

        int index = -1;
        for (int i = 0; i < numBooks; i++) {
            if (catalog[i].getBookCode() == code) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Code not found in catalog...");
            System.out.println("Error...could not return book");
            return;
        }

        Book foundBook = catalog[index];

        System.out.print("Enter valid quantity to return: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid quantity...");
            System.out.println("Error...could not return book");
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity < 1) {
            System.out.println("Invalid quantity...");
            System.out.println("Error...could not return book");
            return;
        }

        if (quantity > borrowedCounts[index]) {
            System.out.println("Invalid return quantity... You cannot return more than you borrowed.");
            System.out.println("Error...could not return book");
            return;
        }

        foundBook.updateQuantity(quantity);
        borrowedCounts[index] -= quantity;
        System.out.println("Book returned successfully.");
    }

    /**
     * Returns a string representing the current catalog of the library.
     *
     * @return the catalog as a formatted string
     */
    public String toString() {
        if (numBooks == 0) {
            return "Library Catalog:\n(empty)\n";
        }

        StringBuilder sb = new StringBuilder("Library Catalog:\n");
        for (int i = 0; i < numBooks; i++) {
            sb.append(catalog[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
