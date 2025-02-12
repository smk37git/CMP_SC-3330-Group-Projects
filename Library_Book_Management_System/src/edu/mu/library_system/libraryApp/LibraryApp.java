package edu.mu.library_system.libraryApp;
import edu.mu.library_system.book.Book;
import edu.mu.library_system.library.Library;

public class LibraryApp {

	public static void main(String[] args) {
		
		//Add books and inform the user of completion
		System.out.println("Adding books...");
		Library library = new Library();
		Book book1 = new Book("Gone with the Wind", "Margaret", "1111", 9.99);
		Book book2 = new Book("French people", "William", "2222", 19.99);
		Book book3 = new Book("Java programming", "Ekin", "3333", 1.99);

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		System.out.println("Books added successfully");
		
		//Search for an ISBN and display the result
		System.out.println("Searching for book with ISBN = 1111");
		System.out.println(library.searchbyISBN("1111"));
		
		//attempt to remove a book that is in the library and one that isn't
		if (library.removeBook(book3)) {
			System.out.println(book3.getTitle() + " removed Succesfully");
		} else {
			System.out.println("Book couldn't be deleted");
		}
		
		Book fakeBook = new Book("fake book", "faker", "4444", 89.99);
		if (library.removeBook(fakeBook)) {
			System.out.println(fakeBook.getTitle() + " removed Succesfully");
		} else {
			System.out.println("Book couldn't be deleted");
		}
		
		//Display the library
		System.out.println();
		System.out.println("All Books:");
		library.displayBooks();
	}

}
