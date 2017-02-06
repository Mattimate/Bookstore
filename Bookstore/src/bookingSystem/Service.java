package bookingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modal.Book;

public class Service {
	private Scanner scan = new Scanner(System.in);
	private Map<String, Book> bookStorage = new HashMap<String, Book>();

	public Service() {
		// HARD DATA
		bookStorage.put("ScaryBook", new Book("ScaryBook", "Matt", "Horror"));
		bookStorage.put("FunnyBook", new Book("FunnyBook", "Tom", "Comedy"));
	}

	public void viewBooks() {
		System.out.println("1: View all books\n2: View book via title");
		switch (Integer.parseInt(getUserInputs("Enter Number"))) {
		case 1:
			System.out.println(bookStorage.toString());
			break;
		default:
			System.out.println(bookStorage.get(getUserInputs("Enter title")));
			break;
		}
	}

	public void addBook() {
		String title = getUserInputs("Enter title");
		String author = getUserInputs("Enter author");
		String genre = getUserInputs("Enter genre");

		addToMap(new Book(title, author, genre));
	}

	private void addToMap(Book book) {
		bookStorage.put(book.getTitle(), book);
		System.out.println("Book: " + book.getTitle() + " has been added\n");
	}

	public String deleteBook(String title) {
		if (bookStorage.containsKey(title)) {
			bookStorage.remove(title);
			return "Book: " + title + " has been removed\n";
		}
		return "Book: " + title + " not found\n";
	}

	public String getUserInputs(String message) {
		System.out.println("\n" + message);
		return scan.nextLine();
	}
}
