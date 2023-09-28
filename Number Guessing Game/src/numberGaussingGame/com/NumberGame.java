package numberGaussingGame.com;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		System.out.println("****************Welcome to Number Game Quizz********************************* ");
		System.out.println("there is one number you find between 0-100 .");
		System.out.println("you have 5 attempt to guess.");
		System.out.println("you should be guess number in minimum step to find that number. ");
		System.out.println("!!!best of luck !!! ");
		System.out.println("*************************************************************************");
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int random = r.nextInt(100);
		// System.out.println(random);
		int count = 1;
		int i = 0;
		while (i <= 5) {
try {
			System.out.println("Enter the number=");
			int input = sc.nextInt();

			if (input > random) {
				System.out.println(input + " is more than guess number");
				count++;
				i++;
			} else if (input < random) {
				System.out.println(input + " is less than guess number");

				count++;
				i++;
			} else if (random == input) {
				System.out.println("Congratulation !! your guess is correct you take (" + count + " ) step to guess");
				break;
			}
			if (i == 5) {
				System.out.println("Sorry !! you excide your limit the number is =" + random);
				break;
			}
		}catch(Exception e) { 
			System.out.println("invalid input,start again");
	 sc.nextLine();
		}
		
	}

}}
