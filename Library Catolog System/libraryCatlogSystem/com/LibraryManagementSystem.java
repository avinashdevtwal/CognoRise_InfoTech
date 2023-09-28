package libraryCatlogSystem.com;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class LibraryManagementSystem {
	static Scanner sc = new Scanner(System.in);
	static LibraryCatlog cl = new LibraryCatlog();

	public static void main(String[] args) {
		do {
			 System.out.println("Welcome to Library Management System");
			System.out.println(" 1. for add book");
			System.out.println(" 2. for serch book");
			System.out.println(" 3. for display book");
			System.out.println(" 4. for checkout book");
			System.out.println(" 5. for return book");
System.out.println("Enter your choice !");
			int no = sc.nextInt();

			if (no == 1) {
				cl.AddBook();

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
				cl.returnBook();
			}

		}while(true);
	}
}
