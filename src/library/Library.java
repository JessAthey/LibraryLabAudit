package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
	private List<Book> books;
	private String address;
	
	public Library(String address) {
		this.books = new ArrayList<>();
		this.address = address;
	}
	
	public void returnBook(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title)) {
				if(book.isBorrowed()) {
					book.returned();
					System.out.println("Thanks for returning: " + title);
					return;
				} else {
					System.out.println("This book is not borrowed. ");
					return;
				}
			}
		} System.out.println("Sorry, we do not have: " + title);
	}
	
	public void printAvailableBooks() {
		if(books.isEmpty()) {
			System.out.println("No books in catalog.");
			return;
		}
		System.out.println("Available books: ");
		for(Book book : books) {
			if(!book.isBorrowed()) {
				System.out.println(book.getTitle());
			}
		}
	}
	
	public void borrowBook(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title)) {
				if(!book.isBorrowed()) {
					book.borrow();
					System.out.println("You succesfully borrowed: " + title);
					return;
				} else {
					System.out.println("Sorry this book is already checked out!");
					return;
				}
			}
		}
		System.out.println("Sorry, we do not have the book: " + title);
	}
	
	public void printAddress() {
		System.out.println("Library Address: " + address);
	}
	
	public static void printOpeningHours() {
		System.out.println("Library hours: 9am - 5pm");
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}