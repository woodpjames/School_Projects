/* Proggramer: James Wood, Created: 10/27/18, Date of Last Modification: 11/8/18
This program will run a specified dice game consisting of 4 dice. The user will make an initial roll that will be tested for specific values that could indicate
a win, loss, or need to keep playing. If a value is rolled that requires the continue of play the user will roll until they match their initial rolls value or
roll a 13. Matching the initial rolls value will cause the user to win. Rolling a 13 will cause the user to lose. This version of the program will also allow
the user wheter they would like to play games automatically or manually.
*/

//This imports the java util library so that things like the Scanner and Random class can be used
import java.util.*;

public class P2A3_WOOD_4214424
{
	//This method is where the bulk of my program will take place. It will run the actual game and facillitate conversation between user and program
	public static void main(String[] args)
	{
		//Creates 4 instances of the Die class so that they can be utilized in rolling
		P2A3_WOOD_DIE_4214424 dieOne = new P2A3_WOOD_DIE_4214424();
		P2A3_WOOD_DIE_4214424 dieTwo = new P2A3_WOOD_DIE_4214424();
		P2A3_WOOD_DIE_4214424 dieThree = new P2A3_WOOD_DIE_4214424();
		P2A3_WOOD_DIE_4214424 dieFour = new P2A3_WOOD_DIE_4214424();

		//This creates a prompt scanner named prompt that will allow for user input
		Scanner prompt = new Scanner(System.in);
		//ival is an interger variable where the value of the initial roll will be stored
		int ival;
		//nval is an interger variable where a rolls after the initial roll will have there value stored
		int nval;
		//this string variable will be used to store a user response to whether they would like to continue using the program
		String cont;
		//this int varianle will be used to store a user response to whether they would like to use automatic or manual
		int MorA;
		//Stores user input to roll
		String torollornottoroll;

		//This do-while loop was created to allow the user to run the program again if they so choose
		do
		{
			//Prints a welcome to user and asks their name
			System.out.println("Welcome to my dice game! What's your name?");
			//Stores user name in name variable with the Scanner prompt
			String name = prompt.nextLine();

			//Says Hello to user using their name
			System.out.println("Hello " + name + "!");
			//Tells the user rules of the game and asks them wether they would like to play manually or automatically
			System.out.println("My name is James Wood. \nThe rules of this game are simple. You will roll a set of 4 dice. If you roll a total of 9, 11, 18, or 24 you win automatically."
			+ "\nIf you roll a total of 6, 12, 13, 17, 19, or 23 you will lose atomatically. \nIf you do not roll any of these numbers, the total"
			+ " amount that you first rolled will be your target number for all future rolls. \nYou will continue rolling dice until you roll your target roll or"
			+ " a 13.\nIf you roll the value equal to that of your first roll you win! If you roll a 13 you lose... \nYou can either play manually or allow the computer"
			+ " to play a specified amount of games for you. \nWould you like the computer to run a specified number of games automatcally or play manually?"
			+ "\nInput '1' to play manually. Input '2' to have the computer play automatically. ");

			//Sets value of MorA to the user input. Allows for manual or automatic to be chosen
			MorA = prompt.nextInt();
			prompt.nextLine();

			//If-else statement used for choosing automatic or manual
			//If statement used to for manually
			if(MorA == 1)
			{

				//Tells user how to roll dice to start game
				System.out.println("Input 'roll' to roll.");
				//Stores users response to wheter or not they would like to roll using Scanner prompt in String variable torollornottoroll
				torollornottoroll = prompt.nextLine();


				while(!(torollornottoroll.equals("roll")))
				{
					//if user does not correctly input roll initiator system tells them it is an incorrect response and how to roll correctly
					System.out.println("Invalid input. Input 'roll' when you are ready to roll.");
					//stores new variable torollornottoroll to check correct roll initializer
					torollornottoroll = prompt.nextLine();
				}

				//Makes four instances of the Die Class
				dieOne.roll();
				dieTwo.roll();
				dieThree.roll();
				dieFour.roll();
				//Stores dices rolls added values in ival
				ival = dieOne.getValue() + dieTwo.getValue() + dieThree.getValue() + dieFour.getValue();

				//Tells user total of their dice roll
				System.out.println("You rolled a total of " + ival);

				//this if, if-else, else statement checks the initial rolls value and sends them down different paths in accordance to the dice games rules
				//first if statement checks if initial roll is equal to automatically winning roll values for initial roll
				if(ival == 9 || ival == 11 || ival == 18 || ival == 24)
				{
					//informs user that they won
					System.out.println("You Win!");
				}
				//else if statement checks if initial roll is equal to an automatically losing roll values for initial roll
				else if(ival == 6 || ival == 12 || ival == 13 || ival == 17 || ival == 19|| ival == 23)
				{
					//tells user they lost
					System.out.println("You lose...");
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

						//rolls all of the dice giving them random intergers between 1-6
						dieOne.roll();
						dieTwo.roll();
						dieThree.roll();
						dieFour.roll();
						//sets nval to the total of all these dice rolls
						nval = dieOne.getValue() + dieTwo.getValue() + dieThree.getValue() + dieFour.getValue();
						//Tells user what they rolled
						System.out.println("You rolled a " + nval);
					//test values aginst 13 and initial roll
					}while(nval != 13 && nval != ival);

					//If tests new roll against 13 and tells user if they lost
					if(nval == 13){System.out.println("You lose...");}
					//Else statement tests new roll agianst old roll and tells user if they won
					else if(nval == ival){System.out.println("You win!");}
				}

				//Asks user if they would like to play again
				System.out.println("Do you want to play again? Input 'yes' to play again.");
				//Sotres response to whether user would like to play again
				cont = prompt.nextLine();
			}

			//else if statement used if user wants the computer to [lay automatcally]
			else if(MorA == 2)
			{
				//Sets total wins equal to 0
				int wins = 0;
				//Sets total losses equal to 0
				int losses = 0;

				//Asks user how many games they would like to play
				System.out.println("How many games would you like the computer to play. Enter an interger.");
				//Stores users response to how many games they would like to play in numOfGames
				int numOfGames = prompt.nextInt();

				//For loop used to play specified number of games for user
				for(int x = 0; x < numOfGames; x++)
				{
					//Rolls Dice for all Dice giving them new value
					dieOne.roll();
					dieTwo.roll();
					dieThree.roll();
					dieFour.roll();
					//Sets initial value to addative value of all dice
					ival = dieOne.getValue() + dieTwo.getValue() + dieThree.getValue() + dieFour.getValue();
					//Tells user value of total roll
					System.out.println("You rolled a total of " + ival);

					//this if, if-else, else statement checks the initial rolls value and sends them down different paths in accordance to the dice games rules
					//first if statement checks if initial roll is equal to automatically winning roll values for initial roll
					if(ival == 9 || ival == 11 || ival == 18 || ival == 24)
					{
						//Tells users they won
						System.out.println("You Win!");
						//Adds 1 to win total
						wins++;
					}
					//else if statement checks if initial roll is equal to an automatically losing roll values for initial roll
					else if(ival == 6 || ival == 12 || ival == 13 || ival == 17 || ival == 19|| ival == 23)
					{
						//Tells user they lost
						System.out.println("You lose...");
						//Adds 1 to loss total
						losses++;
					}
					//If intial roll does not automatically win this else statement goes into the second phase of the game
					else
					{
						//Informs user that the game will continue to the next phase
						System.out.println("Ok. It's not over yet!");
						//do-while loop will be used to test new rolls against initial roll and the number 13
						do
						{
							//Tells user what they can and cannot roll
							System.out.println("You need to roll a " + ival + " to win. But be careful. Don't roll a 13 or you'll lose.");
							//rolls all of the dice giving them random intergers between 1-6
							dieOne.roll();
							dieTwo.roll();
							dieThree.roll();
							dieFour.roll();
							//sets nval to the total of all these dice rolls
							nval = dieOne.getValue() + dieTwo.getValue() + dieThree.getValue() + dieFour.getValue();
							//Tells user what they rolled
							System.out.println("You rolled a " + nval);
						//test values aginst 13 and initial roll
						}while(nval != 13 && nval != ival);

						//If-else if statement chaecks if roll was equal to 13 or initial value
						//If statement checks nval against 13
						if(nval == 13)
						{
							//Tells user they lost
							System.out.println("You lose...");
							//Adds 1 to users loss total
							losses++;
						}
						//Else if statement checks nval against ival
						else if(nval == ival)
						{
							//Tells user they won
							System.out.println("You win!");
							//Adds 1 to user win total
							wins++;
						}
						//Tells user their total wins
						System.out.println("You've won " + wins + " games.");
					}
				}
				//Tells user their win to loss ratio
				System.out.println("You won " + wins + " games and lost " + losses + " games.");

				prompt.nextLine();
				//Asks user isf they would like to play again
				System.out.println("Would you like to play again? Input 'yes' if you would like to play again.");
				//Stores users response as to whether they want to play again
				cont = prompt.nextLine();
			}
			//Will never be used. Used to solve a initialization problem
			else
			{
				System.out.println("You did not type 1 or 2. The program will start over. Please try again.");
				cont = "yes";
			}
		//Tests user response to yes to see if they would like to continue
		}while(cont.equals("yes"));
	}

	//Method that is not in use of this version of the program. Was used to simmulate rolling 4 dice
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
