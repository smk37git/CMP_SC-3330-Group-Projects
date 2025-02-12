package edu.mu.library_system.library;

import edu.mu.library_system.book.Book;

public class Library {

	//attributes
	private Book[] books = new Book[5];
	private int count;
	
	//methods
	
	//adds a book to the array, returns true if successful.
	public Boolean addBook(Book book) {
		int a;
		for (a = 0; a < books.length; a++) {
			if (books[a] == null) {
				books[a] = book;
				count++;
				return true;
			}
		}
		return false;
	}
	
	//removes a specified book from the array, returns true if successful
	public Boolean removeBook(Book book) {
		int b;
		for (b = 0; b < books.length; b++) {
			if (books[b] == book) {
				books[b] = null;
				count--;
				return true;
			}
		}
		return false;
	}
	
	//searches array for a book with specified ISBN, returns it if it exists (null otherwise)
	public Book searchbyISBN(String ISBN) {
		int c;
		for (c = 0; c < books.length; c++) {
			if (books[c].getISBN() == ISBN) {
				return books[c];
			}
		}
		return null;
	}
	
	//prints out all books in the current array
	public void displayBooks() {
		int d;
		for (d = 0; d < books.length; d++) {
			if (books[d] != null) {
				System.out.println(d+1 + ". " + books[d].toString());
			}
		}
	}
}
