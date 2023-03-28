package library;

public class Book {

    private String title;
    private boolean borrowed;

    public Book(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean borrow() {
        if (borrowed) {
            return false;
        } else {
            borrowed = true;
            return true;
        }
    }

    public void returned() {
        borrowed = false;
    }

   


	public static void main(String[] arguments) {
		// Small test of the Book class
		Book example = new Book("The Da Vinci Code");
		System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		System.out.println("Borrowed? (should be true): " + example.isBorrowed());
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	}
}