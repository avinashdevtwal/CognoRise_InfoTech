package libraryCatlogSystem.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class LibraryCatlog {
	Book book = new Book();
	Set<Book> b = new HashSet<>();
	Scanner sc = new Scanner(System.in);
	Validator vd = new Validator();

	public void AddBook() {
		String Id = vd.validateid(); 
		
		String bookname = vd.validateAuthorTitle("Bookname");

		String Author = vd.validateAuthorTitle("Author");

		
	
		if(book.getBookid()==(Id)) { 
			System.out.println("dublicate id");
		}else {
				b.add( new Book(Id, bookname, Author, "Available") );
		 System.out.println("book added");
		}
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
			System.out.println(book.getBookid() + "\t\t" + book.getBookTitle() + "\t\t" + book.getAuthor() + "\t\t"
					+ book.getStatus() + "\t\t");

		}
	}

	public void checkoutbook() {
		System.out.println("enter the bookname");
		String bookname = sc.next();
		for (Book book : b) {
			if (book.getBookTitle().equals(bookname) && book.getStatus().equals("Available")) {
				System.out.println("book checkout sussessfully !!");
			} else {
				System.out.println("this book not available to checkout" + book);
			}
		}

	}

	public void returnBook() {
		String bookid = vd.validateid();
		for (Book book : b) {
			if (book.getBookid().equals(bookid) && book.getStatus().equals("Not Available")) {
				System.out.println("book return sussessfully !!");
				book.setStatus("Available");
			} else {
				System.out.println("we cannot available to return" + book);
			}
		}

	}
}
