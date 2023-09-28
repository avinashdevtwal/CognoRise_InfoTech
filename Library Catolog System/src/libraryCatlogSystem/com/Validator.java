package libraryCatlogSystem.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
	private static Pattern Id_pattern = Pattern.compile("^\\d{1,4}$");
	private static Pattern AuthorTitle_pattern = Pattern.compile("^[a-zA-Z]+$");
	Book book;
	Scanner sc = new Scanner(System.in);
	Set<Book> books = new HashSet<>();

	public String validateid() {
		String bookid;
		
		
		
		while (true) {
			System.out.println("Enter BookID");
			bookid = sc.nextLine();
 
			
				
				
			
			if (!Id_pattern.matcher(bookid).matches()) {
				System.out.println("sorry !! please enter valid book id");

			} else {
				
				return bookid;

			}

			}

	}

	public String validateAuthorTitle(String input) {
		String result;
		while (true) {
			if (input == "Bookname") {
				System.out.println("Enter Bookname");
			} else {
				System.out.println("Enter Author");

			}
			result = sc.nextLine();
			if (!AuthorTitle_pattern.matcher(result).matches()) {
				System.out.println("sorry !! please enter valid  " + input);
			} else {
				break;
			}
		}
		return result;

	}

}
