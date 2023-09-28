package libraryCatlogSystem.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class LibraryCatlog {
	Book book = new Book();
	ArrayList<Book> b = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	Validator vd = new Validator();

	public void AddBook(String bookid, String bookname, String author) {
		System.out.println(bookid);

		for (Book book : b) {

			if (book.getBookTitle().equals(bookname) || (book.getBookid().equals(bookid))) {
				System.out.println("dublicate entry");
				return;
			}
		}
		Book newbook = new Book(bookid, bookname, author, "Available");
		b.add(newbook);
		System.out.println("book added");

	}

	public void serchbook(String booknames) {
		for (Book book : b) {
			if (book.getBookTitle().equals(booknames) || book.getAuthor().equals(booknames)) {
				System.out.println(book);

			} else {
				System.out.println("book not available ");
			}

		}
	}

	public void displayBooks() {
		System.out.println("bookId\tbookTitle\tauthor\tbookstatus\t");

		for (Book book : b) {
			System.out.println("book");
			System.out.println(book.getBookid() + "\t\t" + book.getBookTitle() + "\t\t" + book.getAuthor() + "\t\t"
					+ book.getStatus() + "\t\t");

		}
	}

	public void checkoutbook() {
		System.out.println("enter the bookname");
		String bookname = sc.next();
		for (Book book : b) {
			if (book.getBookTitle().equals(bookname)) {
				if (book.isCheckout()) {
					System.out.println("book already checkout");
				} else {
					book.setCheckout(true);
					System.out.println("book checkout succesfully" + book);
				}
				return;
			}
		}
		System.out.println("bbok not fount in store");
	}

	public void checkinbook(String input) {
		
		String title = vd.validateAuthorTitle(input);
		for (Book book : b) {
			if (book.getBookTitle().equals(title)||(book.getAuthor().equals(title))) {
				if (book.isCheckout()) {

					System.out.println("book checked in sussessfully !!");
					book.setCheckout(false);
				} else {
					System.out.println("this book is not currently checked out" );
				}
				return;
			}

		}
		System.out.println("book not found in this store");
	}
}