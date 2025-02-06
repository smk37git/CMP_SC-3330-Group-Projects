package edu.mu.library_system;

import edu.mu.library_system.book.*;

public class Main {

	public static void main(String[] args) {
		// Sebastian Main, Jase DeCota, Greg Gomez - CMP_SC-3330
		
		/** Test Case 1
		 * @parameter There are no given parameters
		 * @return should be "Unknown" due to no given parameters and the default parameter being "Unknown"
		 */
		Book book = new Book();
		System.out.println("Title: " + book.getTitle());
		
		/** Test Case 2
		 * @parameter Title = "Diary of a Wimpy Kid", Author = "Jeff Kiney", ISBN = "123", Price = "60.00"
		 * @return Only Title is selected, return will be book title aka "Diary of a Wimpy Kid"
		 */
		Book bookWithTitle = new Book("Diary of a Wimpy Kid", "Jeff Kiney", "123", 60.00);
		System.out.println("Title: " + bookWithTitle.getTitle());
		

	}

}
