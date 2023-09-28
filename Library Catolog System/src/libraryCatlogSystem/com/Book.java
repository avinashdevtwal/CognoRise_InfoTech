package libraryCatlogSystem.com;

public class Book {
	private String bookid;
	private String bookTitle;
	private String author;
	private String status;
private  boolean checkout;
	public Book(String id, String bookTitle, String author, String status) {
		super();
		this.bookid = id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.status = status;
	}

	public Book() {
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookTitle=" + bookTitle + ", author=" + author + ", status=" + status
				+ "]";
	}

	

}
