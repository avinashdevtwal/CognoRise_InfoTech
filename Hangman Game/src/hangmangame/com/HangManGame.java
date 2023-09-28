package hangmangame.com;

import java.util.Random;
import java.util.Scanner;

public class HangManGame {
	private static final String[] words = { "java", "python", "angular" };
	private static final Random random = new Random();
	private static String selectedword;
	private static char[] guessword;
	private static int incorrectguess = 0;
	private static final int maxIncorrectguess = 6;

	public static void main(String[] args) {
		System.out.println("Welcome To the HangMan Game");
		System.out.println("you have 6 chance");
		System.out.println("you have to guess correct word");
		System.out.println("**********BEST OF LUCK*************");

		selectedword = selectRandomWord();

		guessword = new char[selectedword.length()];
		initializeGuessedWord();

		Scanner scanner = new Scanner(System.in);

		while (incorrectguess < maxIncorrectguess) {

			displayGuessedWord();

			System.out.print("Enter a letter: ");
			String input = scanner.nextLine().toLowerCase();

			if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
				System.out.println("Invalid input. Please enter a single letter.");
				continue;
			}

			char guessedLetter = input.charAt(0);

			if (checkGuess(guessedLetter)) {
				System.out.println("Good guess!");
			} else {
				displayHangman();

				System.out.println("Incorrect guess ");
				incorrectguess = 1 + incorrectguess;
				System.out.println(incorrectguess);

			}

			if (isGameWon()) {
				System.out.println("Congratulations! You guessed the word: " + selectedword);
				break;
			}
		}

		if (incorrectguess >= maxIncorrectguess) {
			displayHangman();
			System.out.println("You ran out of attempts. The word was: " + selectedword);
		}
	}

	private static String selectRandomWord() {
		return words[random.nextInt(words.length)];
	}

	private static void initializeGuessedWord() {
		for (int i = 0; i < selectedword.length(); i++) {
			guessword[i] = '_';
		}
	}

	private static void displayGuessedWord() {
		System.out.println("********************************************");
		System.out.print("Word: ");
		for (char c : guessword) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	private static boolean checkGuess(char guessedLetter) {
		boolean found = false;
		for (int i = 0; i < selectedword.length(); i++) {
			if (selectedword.charAt(i) == guessedLetter) {
				guessword[i] = guessedLetter;
				found = true;
			}
		}
		return found;
	}

	private static boolean isGameWon() {
		for (char c : guessword) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}

	private static void displayHangman() {
		String[] hangmanImages = { "  +---+\n" + "  |   |\n" + "      |\n" + "      |\n" + "      |\n" + "      |",

				"  +---+\n" + "  |   |\n" + "  O   |\n" + "      |\n" + "      |\n" + "      |",
				"  +---+\n" + "  |   |\n" + "  O   |\n" + "  |   |\n" + "      |\n" + "      |",
				"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|   |\n" + "      |\n" + "      |",
				"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + "      |\n" + "      |",
				"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " /    |\n" + "      |",
				"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " / \\  |\n" + "      |" };

		System.out.println(hangmanImages[incorrectguess]);
	}
}
