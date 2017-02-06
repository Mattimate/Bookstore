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
		bookStorage.put("FunnyBook", new Book("FuunyBook", "Tom", "Comedy"));
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

	public void addBooks() {
		String title = getUserInputs("Enter title");
		String author = getUserInputs("Enter author");
		String genre = getUserInputs("Enter genre");

		bookStorage.put(title, new Book(title, author, genre));
		System.out.println("Book: " + title + " has been added");
	}

	public void deleteBooks(String title) {
		bookStorage.remove(title);
		System.out.println("Book: " + title + " has been removed");
	}

	public String getUserInputs(String message) {
		System.out.println("\n" + message);
		return scan.nextLine();
	}
}
