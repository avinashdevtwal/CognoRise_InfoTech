package calculator.com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) throws Exception {
		Calculator c = new Calculator();
		Scanner sc = new Scanner(System.in);
		boolean flag=false;
		while(true) {
			try {
			System.out.println("Use Calucator");
			System.out.println("1.additon");
			System.out.println("2.Substraction");
			System.out.println("3.Multiplication");
			System.out.println("4.Division");
			
				
					int no = sc.nextInt();
					
						
					System.out.println("Enter fist number");
				double a = sc.nextDouble();
				
				System.out.println("Enter second number");
				double b = sc.nextDouble();
				
		
				switch (no) {

				case (1):

					c.addition(a, b);
					break;
				case (2):
					c.substraction(a, b);
					break;
				case (3):
					c.multiplication(a, b);
					break;
				case (4):
					c.division(a, b);
					break;
               default: 
	System.out.println("invalid input");
				}
				
				}catch(Exception e) { 
				System.out.println("invalid value !!! enter again");
			};
			sc.nextLine();
			}
		
	}
}
