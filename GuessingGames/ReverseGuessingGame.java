import java.util.Random;
import javax.swing.JOptionPane;

public class ReverseGuessingGame {

	public static void main(String[] args) {

		Object[] options = {5,7,9};
		Object[] options2 = {"Higher","Lower"};
		int numOfGuess=0, guess=0, num=0;
		String input = "";
		boolean validInput = false;
		while(!validInput) {
			input = JOptionPane.showInputDialog(null, "Pick a number between 1 and 100\nand the computer will try and guess it", "Message", JOptionPane.QUESTION_MESSAGE);
			if(input == null)
				validInput = true;
			else if(input.matches("[0-9]+")) {
				num = Integer.parseInt(input);
				if(num>0 && num<=100)
					validInput = true;
				else
					JOptionPane.showMessageDialog(null, "Number must be between 1 and 100");
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid input");
		}
		if(input != null) {
		
			int option = JOptionPane.showOptionDialog(null, "How many guesses will the computer have?", "Message", 1, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
			if(option == 0) 
				numOfGuess = 5;
			else if(option == 1)
				numOfGuess = 7;
			else if(option == 2)
				numOfGuess = 9;
			
			boolean won = false;
			Random r = new Random();
			int max = 101, min = 1;
			while(!won && numOfGuess>0) {
			
				guess = r.nextInt(max-min) + min;
				numOfGuess -= 1;
				JOptionPane.showMessageDialog(null, "The computer guessed the number " + guess + "\nThe computer has " + numOfGuess + " guess(es) left");
				if(guess != num) {
			
					if(numOfGuess > 0) {
				
						int highOrLow = JOptionPane.showOptionDialog(null, "\nIs your number higher or lower?", "Message", 1, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
						if(highOrLow == 0 && guess<num)
							min = guess;
						else if(highOrLow == 1 && guess>num) 
							max = guess;
						else {
							JOptionPane.showMessageDialog(null, "You're not playing fairly, game over!");
							won = true;
						}
				
					}
					else
						JOptionPane.showMessageDialog(null, "The computer is out of guesses. You win!");
				
				}
			
				else {
					JOptionPane.showMessageDialog(null, "The computer guessed your number correctly!");
					won = true;
				}
			
			}
			
		}
	
	}
	
}
