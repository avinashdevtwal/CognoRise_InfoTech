package calculator.com;

import java.util.Scanner;

public class Calculator {

	public void addition(double a, double b) throws Exception {
		try {
			System.out.println("adition of " + a + "+" + b + " is=" + (a + b));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

	public void substraction(double a, double b) {
		System.out.println("substraction of " + a + "-" + b + " is=" + (a - b));

	}

	public void multiplication(double a, double b) {
		System.out.println("multiplication of " + a + "*" + b + " is=" + (a * b));

	}

	public void division(double a, double b) throws Exception {
		try {
			System.out.println("division of " + a + "/" + b + " is=" + (a / b));

		} catch (ArithmeticException e) {
			System.out.println("we cannot divisible by zero");
		}

	}

}
