# 📚 Library Management System – Java Console Application

## 👨‍💻 Author Info

- **Name**: Harpreet Singh  
- **Assignment**: 01 – Library Management System  
- **Due Date**: [Enter your due date if required]  
- **Course**: CST8130 - Data Structures  
- **Instructor**: James Mwangi, PhD  
- **College**: Algonquin College, Ottawa, ON  
- **GitHub**: [HarpreetComputerEng](https://github.com/HarpreetComputerEng)

---

## 📌 Overview

This Java console application simulates a basic **Library Management System** that allows users to:

- Add books to a catalog
- Display the current library collection
- Borrow and return books
- Exit the system

It features object-oriented principles like inheritance, composition, encapsulation, and dynamic memory allocation using arrays. All functionality is accessed through a user-friendly text-based menu in the terminal.

---

## 💡 Key Features

- ➕ **Add Book**: Dynamically adds a new book to the catalog using `Scanner` input.
- 📄 **Display Catalog**: Lists all books currently in the library (with type-specific information).
- 📚 **Borrow Books**: Allows users to borrow available copies of books.
- 🔁 **Return Books**: Handles return logic and quantity adjustment.
- ❌ **Exit Program**: Safely exits the system and closes the input stream.

---

## 🧩 Class Summary

### `Assign1.java`

- Contains the `main()` method which manages the user interface and menu.
- Loops the main menu until the user chooses to exit.
- Invokes methods from the `Library` class based on user input.
- Includes robust input validation and informative error messages.

### Method: `displayMenu()`

```java
public static void displayMenu() {
    System.out.println("Please select one of the following:\n");
    System.out.println("1: Add Book to Library");
    System.out.println("2: Display Current Library Catalog");
    System.out.println("3: Borrow Book(s)");
    System.out.println("4: Return Book(s)");
    System.out.println("5: To Exit\n");
    System.out.print("> ");
}
