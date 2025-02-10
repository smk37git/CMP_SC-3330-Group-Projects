package edu.mu.library_system.book;

public class Book {

	// Define Attributes
	private String title;
	private String author;
	private String ISBN;
	private double price;
	
	// Default Constructor
	// This constructor will assign default values to the private attributes to initialize them
	public Book() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.ISBN = "Unknown";
		this.price = 0.0;
	}
	
	// Parameterized Constructor to set all the attributes
	public Book(String title, String author, String ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
	}
	
	// Copy Constructor
	public Book(Book copiedBook) {
		this.title = copiedBook.title;
		this.author = copiedBook.author;
		this.ISBN = copiedBook.ISBN;
		this.price = copiedBook.price;
	}
	
	// Getters and Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// Boolean to see if book ISBN is equal to another book
	public boolean equalsBook(Object book) {
		if (ISBN == getISBN()) {
			return false;
		}
		return true;
	}
	
	
	//To String 
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", price=" + price + "]";
	}

	
}
