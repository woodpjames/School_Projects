/* Proggramer: James Wood, Created: 10/27/18, Date of Last Modification: 11/7/18
This program will run a specified dice game consisting of 4 dice. The user will make an initial roll that will be tested for specific values that could indicate
a win, loss, or need to keep playing. If a value is rolled that requires the continue of play the user will roll until they match their initial rolls value or
roll a 13. Matching the initial rolls value will cause the user to win. Rolling a 13 will cause the user to lose.
*/

//This imports the java util library so that things like the Scanner and Random class can be used
import java.util.*;

public class P2A2_WOOD_4214424
{
	//This method is where the bulk of my program will take place. It will run the actual game and facillitate conversation between user and program
	public static void main(String[] args)
	{
		//This creates a prompt scanner named prompt that will allow for user input
		Scanner prompt = new Scanner(System.in);
		//ival is an interger variable where the value of the initial roll will be stored
		int ival;
		//nval is an interger variable where a rolls after the initial roll will have there value stored
		int nval;
		//this string variable will be used to store a user response to whether they would like to continue using the program
		String cont;

		//This do-while loop was created to allow the user to run the program again if they so choose
		do {
			//Prints a welcome to user and asks their name
			System.out.println("Welcome to my dice game! What's your name?");
			//Stores user name in name variable with the Scanner prompt
			String name = prompt.nextLine();

			//Says Hello to user using their name
			System.out.println("Hello " + name + "!");
			//Tells the user rules of the game
			System.out.println("My name is James Wood. \nThe rules of this game are simple. You will roll a set of 4 dice. If you roll a total of 9, 11, 18, or 24 you win automatically."
			+ "\nIf you roll a total of 6, 12, 13, 17, 19, or 23 you will lose atomatically. \nIf you do not roll any of these numbers, the total"
			+ " amount that you first rolled will be your target number for all future rolls. \nYou will continue rolling dice until you roll your target roll or"
			+ " a 13.\nIf you roll the value equal to that of your first roll you win! If you roll a 13 you lose...");

			//Tells user how to roll dice to start game
			System.out.println("Input 'roll' to roll.");
			//Stores users response to wheter or not they would like to roll using Scanner prompt in String variable torollornottoroll
			String torollornottoroll = prompt.nextLine();

			//this while loop ensures that the user typed the correct response in order to roll by checking equivalency of words using .equals
			while(!(torollornottoroll.equals("roll")))
			{
				//if user does not correctly input roll initiator system tells them it is an incorrect response and how to roll correctly
				System.out.println("Invalid input. Input 'roll' when you are ready to roll.");
				//stores new variable torollornottoroll to check correct roll initializer
				torollornottoroll = prompt.nextLine();
			}

			//sets the the initial roll value using the roll method
			ival = roll();
			//informs the user what they rolled
			System.out.println("You rolled a total of " + ival);

			//this if, if-else, else statement checks the initial rolls value and sends them down different paths in accordance to the dice games rules
			//first if statement checks if initial roll is equal to automatically winning roll values for initial roll
			if(ival == 9 || ival == 11 || ival == 18 || ival == 24)
			{
				//informs user that they won
				System.out.println("You Win!");
				//asks user if they would like to play again
				System.out.println("Do you want to play again? Input 'yes' to play again.");
				//stores users response to play again question in cont variable
				cont = prompt.nextLine();
			}
			//else if statement checks if initial roll is equal to an automatically losing roll values for initial roll
			else if(ival == 6 || ival == 12 || ival == 13 || ival == 17 || ival == 19|| ival == 23)
			{
				//tells user they lost
				System.out.println("You lose...");
				//Asks user if they would like to play again
				System.out.println("Do you want to play again? Input 'yes' to play again.");
				//stores users response to play again quaestion in cont variable
				cont = prompt.nextLine();
			}
			//If intial roll does not automatically win this else statement goes into the second phase of the game
			else
			{
				//Informs user that the game will continue to the next phase
				System.out.println("Ok. It's not over yet!");
				//do-while loop will be used to test new rolls against initial roll and the number 13
				do
				{
					//Tells user what they need to roll in order to win or lose
					System.out.println("You need to roll a " + ival + " to win. But be careful. Don't roll a 13 or you'll lose.");
					//Tells user how to initiate roll
					System.out.println("Input 'roll' when you're ready to roll.");
					//saves users response to torollornottoroll
					torollornottoroll = prompt.nextLine();

					//this while loop ensures that the user typed the correct response in order to roll by checking equivalency of words using .equals
					while(!(torollornottoroll.equals("roll")))
					{
						//if user does not correctly input roll initiator system tells them it is an incorrect response and how to roll correctly
						System.out.println("Invalid input. Input 'roll' when you are ready to roll.");
						//stores new variable torollornottoroll to check correct roll initializer
						torollornottoroll = prompt.nextLine();
					}

					//sets the new roll value using the roll method
					nval = roll();
					//tells user what they rolled
					System.out.println("You rolled a total of " + nval);
				//test values aginst 13 and initial roll
				}while(nval != 13 && nval != ival);

				//if-else statement tests if the new roll value is 13 or equal to the initial value
				//if statement test value against 13 to see if user lost
				if(nval == 13)
				{
					//tells user they lost
					System.out.println("You lose...");
				}
				//else if statement test if initial roll is equal to new roll to see if user won
				else if(nval == ival)
				{
					//tells user they won
					System.out.println("You win!");
				}

				//Asks user if they would like to play again
				System.out.println("Do you want to play again? Input 'yes' to play again.");
				//saves user response to cont variable using Scanner prompt
				cont = prompt.nextLine();
			}
		//tests user input saved in cont value against 'yes' to see if user would like to play again
		}while(cont.equals("yes"));
	}
	//this method models rolling 4 dice
	public static int roll()
	{
		//Creates a random object named rand so that dice can be randomized
		Random rand = new Random();
		//creates 4 instances of randomization giving back a value from 1-6 and stores them in n1-n4
		int n1 = rand.nextInt(6) +1;
		int n2 = rand.nextInt(6) +1;
		int n3 = rand.nextInt(6) +1;
		int n4 = rand.nextInt(6) +1;
		//adds all dice values together to get the value of roll and stores them in n
		int n = n1 + n2 + n3 + n4;
		//returns roll value
		return n;
	}
}
