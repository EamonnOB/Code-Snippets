import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
	
		int guess=0, numOfGuess=5;
		String input = "";
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		int num = r.nextInt((100-1) + 1) + 1;
		boolean won = false;
		while(!won && numOfGuess>0) {
			System.out.println("Guess the number between 1 and 100. You have " + numOfGuess + " guess(es) left");
			System.out.print("Your guess:\t");
			input = in.nextLine();
			if(input.matches("[0-9]+")) {
				guess = Integer.parseInt(input);
				if(guess>0 && guess<=100) {
					if(guess == num) {
						System.out.println("Well done! The number was indeed " + num);
						won = true;
					}
					else if(guess < num) {
						numOfGuess -= 1;
						if(numOfGuess>0)
							System.out.println("Number is higher!");
					}
					else {
						numOfGuess -= 1;
						if(numOfGuess>0)
							System.out.println("Number is lower!");
					}
				}
				else
					System.out.println("Guess must be between 1 and 100");
			}
			else
				System.out.println("Input must be a number");
		}
		if(!won)
			System.out.println("Oh, hard luck! You're out of guesses. The number was actually " + num);
		
	}
	
}
