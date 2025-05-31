import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class BorrowReturnTests {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();

        // Simulate adding a Fiction book with code 101 and quantity 10
        String bookInput = "f\n101\nTest Book\nTest Author\n10\n";
        InputStream in = new ByteArrayInputStream(bookInput.getBytes());
        Scanner scanner = new Scanner(in);

        boolean added = library.addBook(scanner);
        assertTrue(added, "Book should be added successfully");
    }

    @Test
    public void testBorrowBookValidQuantity() {
        // Simulate borrowing 5 copies of book code 101
        String borrowInput = "101\n5\n";
        InputStream in = new ByteArrayInputStream(borrowInput.getBytes());
        Scanner scanner = new Scanner(in);

        // Should borrow successfully without error messages
        library.borrowBook(scanner);

        // Now quantity should be 5 less, so check catalog via toString
        String catalog = library.toString();
        assertTrue(catalog.contains("Test Book"));
        assertTrue(catalog.contains("5")); // Quantity should be 5 after borrowing 5 (from 10)
    }

    @Test
    public void testBorrowBookInvalidCode() {
        // Borrow a non-existent book code 999
        String borrowInput = "999\n5\n";
        InputStream in = new ByteArrayInputStream(borrowInput.getBytes());
        Scanner scanner = new Scanner(in);

        // Borrowing should fail and print error, but no exception thrown
        library.borrowBook(scanner);
        // We can't catch output easily here without extra code, so just confirm catalog unchanged
        String catalog = library.toString();
        assertTrue(catalog.contains("Test Book"));
        assertTrue(catalog.contains("10")); // Quantity remains 10
    }

    @Test
    public void testBorrowBookInvalidQuantity() {
        // Borrow with invalid quantity (-1)
        String borrowInput = "101\n-1\n";
        InputStream in = new ByteArrayInputStream(borrowInput.getBytes());
        Scanner scanner = new Scanner(in);

        library.borrowBook(scanner);

        String catalog = library.toString();
        assertTrue(catalog.contains("10")); // Quantity remains 10
    }

    @Test
    public void testReturnBookValidQuantity() {
        // First borrow 3 copies to reduce quantity to 7
        String borrowInput = "101\n3\n";
        Scanner borrowScanner = new Scanner(new ByteArrayInputStream(borrowInput.getBytes()));
        library.borrowBook(borrowScanner);

        // Return 2 copies, quantity should increase to 9
        String returnInput = "101\n2\n";
        Scanner returnScanner = new Scanner(new ByteArrayInputStream(returnInput.getBytes()));
        library.returnBook(returnScanner);

        String catalog = library.toString();
        assertTrue(catalog.contains("9"));
    }

    @Test
    public void testReturnBookInvalidCode() {
        String returnInput = "999\n2\n";
        Scanner returnScanner = new Scanner(new ByteArrayInputStream(returnInput.getBytes()));
        library.returnBook(returnScanner);

        // Quantity remains unchanged
        String catalog = library.toString();
        assertTrue(catalog.contains("Test Book"));
        assertTrue(catalog.contains("10"));
    }

    @Test
    public void testReturnBookInvalidQuantity() {
        String returnInput = "101\n-3\n";
        Scanner returnScanner = new Scanner(new ByteArrayInputStream(returnInput.getBytes()));
        library.returnBook(returnScanner);

        String catalog = library.toString();
        assertTrue(catalog.contains("10")); // quantity remains unchanged
    }
}
