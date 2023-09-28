package libraryCatlogSystem.com;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class LibraryManagementSystem {
	static Scanner sc = new Scanner(System.in);
	static LibraryCatlog cl = new LibraryCatlog();
	static Validator vd = new Validator();

	public static void main(String[] args) {

		do {
			try {
				System.out.println("Welcome to Library Management System");
				System.out.println(" 1. for add book");
				System.out.println(" 2. for serch book");
				System.out.println(" 3. for display book");
				System.out.println(" 4. for checkout book");
				System.out.println(" 5. for return book");
				System.out.println("Enter your choice !");
				int no = sc.nextInt();

				if (no == 1) {

					String bookid = vd.validateid();

					String bookname = vd.validateAuthorTitle("Bookname");
					System.out.println(bookname);
					String Author = vd.validateAuthorTitle("Author");
					System.out.println(Author);

					cl.AddBook(bookid, bookname, Author);

				} else if (no == 2) {
					System.out.println("enter book for serch");
					String bookname = sc.next();

					cl.serchbook(bookname);

				} else if (no == 3) {
					System.out.println("display all book");
					cl.displayBooks();
				} else if (no == 4) {

					cl.checkoutbook();
				} else if (no == 5) {
					System.out.println("Enter the book name ");
					String input = sc.next();
					cl.checkinbook(input);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			sc.nextLine();
		} while (true);

	}
}
