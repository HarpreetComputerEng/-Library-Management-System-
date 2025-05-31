import java.util.Scanner;
import java.util.ArrayList;


/**
 * Main class to run the Library Management System.
 * Contains the main method and menu interaction logic.
 */
public class Assign1 {

    /**
     * Displays the main menu to the user.
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:\n");
        System.out.println("1: Add Book to Library");
        System.out.println("2: Display Current Library Catalog");
        System.out.println("3: Borrow Book(s)");
        System.out.println("4: Return Book(s)");
        System.out.println("5: To Exit\n");
        System.out.print("> ");
    }

    /**
     * Main method to run the Library Management System.
     * Displays menu repeatedly until user exits.
     * Handles user inputs and calls Library methods.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            displayMenu();

            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value entered");
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Book
                    library.addBook(scanner);
                    break;

                case 2:
                    // Display Library Catalog
                    if (library.toString().contains("empty")) {
                        System.out.println("Library Catalog:\n");
                    } else {
                        System.out.print(library.toString());
                    }
                    break;

                case 3:
                    if (library.toString().contains("empty")) {
                        System.out.println("Error...could not borrow book");
                    } else {
                        library.borrowBook(scanner);
                    }
                    break;

                case 4:
                    if (library.toString().contains("empty")) {
                        System.out.println("Error...could not return book");
                    } else {
                        library.returnBook(scanner);
                    }
                    break;


                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Incorrect value entered");
            }
        }
    }
}
