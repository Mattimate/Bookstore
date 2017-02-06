package bookingSystem;

public class BookingSystem {

	private Service service = new Service();

	public static void main(String[] args) {
		BookingSystem bookingSystem = new BookingSystem();
		bookingSystem.start();
	}

	private void start() {
		while (true) {
			menu();
		}
	}

	private void menu() {
		System.out.println("1: View Books\n2: Add book\n3: Delete Book");
		switch (Integer.parseInt(service.getUserInputs("Enter number"))) {
		case 1:
			service.viewBooks();
			break;
		case 2:
			service.addBook();
			break;
		case 3:
			String message = service.deleteBook(service.getUserInputs("Enter title"));
			System.out.println(message);
			break;
		default:
			break;
		}
	}
}
