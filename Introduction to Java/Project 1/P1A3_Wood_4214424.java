// James Wood, Creation Date 9/12/18, Last Modification 9/26/18, This Program Will Convert Richtors to Energy Output in Either Tons of TNT or Joules

//Allows For the Use of Scanner
import java.util.Scanner;

//Allows for more complex math functions to be used. Exponentials for this program
import java.lang.Math;

//Class begins and names the program
public class P1A3_Wood_4214424
{
	//Main Method acts as a Starting Point for the Program
	public static void main (String[] args)
	{
		String user;						//Variable for users name
		float magnitude;					//Creates double for user input of magnitude
		double joules;						//Creates double for 'joules' value
		double tnt;							//Creates double for 'tnt' value
		boolean cont = true;				//Makes 'cont' boolean and assigns it true. Used for while loop asking user if they would like to continue
		int which;							//Variable that asks what conversion user would like to convert to

		//Assigns 'keyboard' as a command for opening prompt
		Scanner keyboard = new Scanner(System.in);

		//Prints line asking name of user
		System.out.println("Hi! What's your name?");
		//Makes a prompt appear and assigns value of typed response to 'user' variable
		user = keyboard.nextLine();

		//Makes an output welcoming the user by name using the 'user' variable
		System.out.println("Welcome " + user
		+ ". My name is James Wood. This program will tell "
		+ "you the amount of energy produced by an Earthquake"
		+ " of an entered magnitude.");

		//while loop will continue to run while user still want to continue running program
		while(cont)
		{
			//Do while loop makes sure a valid entry is made. If it isn't it makes the user enter the value again
			do
			{
					//Asks user what they would like to convert to
					System.out.println("Would you like to convert to Joules or Tons of TNT? (Enter 1 for joules or 2 for TNT)");
					//Prompts users response and stores it under which variable
					which = keyboard.nextInt();

					//If statement tells user there entry is invalid if it is
					if(which != 1 && which != 2)
					{
						//Tells user entry is invalid
						System.out.println("Invalid Selection. Please enter 1 for joules or 2 for TNT.");
					}
			} while (which != 1 && which != 2);

			//Do while loop makes sure a valid entry is made. If it isn't it makes the user enter the value again
			do
			{
					//Produces Statement asking User to Enter Magnitude
					System.out.println("Enter a magnitude from 0 to 10 Richtors.");

					//Makes a prompt that assigns a value to the double magnitude
					magnitude = keyboard.nextFloat();

					//If statement tells user there entry is invalid if it is
					if(magnitude < 0 || magnitude > 10)
					{
						//Tells user entry is invalid
						System.out.println("Invalid magnitude. Please enter value between 0 and 10.");
					}
			} while(magnitude < 0 || magnitude > 10);

			//Sets the value of 'joules' through math calculation
			joules = Math.pow(10,(1.5*magnitude)+4.8);
			//Sets the value of 'tnt' through math calculation
			tnt = (joules*Math.pow(10,-9))*.239;

			//If statement. If 1 is entered magnitude will be converted to Jouels
			if(which == 1)
			{
					//Statement that tells the user how many joules and tons of TNT specified Earthquake made
					System.out.println("For a magnitude " + magnitude + " earthquake there is" + " a realease of " + joules + " joules!");
			}

			//Else if statement. If 2 is entered magnitude will be converted to Tons of TNT.
			else if(which == 2)
			{
					//Statement that tells the user how many joules and tons of TNT specified Earthquake made
					System.out.println("For a magnitude " + magnitude + " earthquake there is a realease of " + tnt + " tons of TNT!");
			}

			//Statement asks user whether they would like to run program again
			System.out.println("Would You like to run the program again? Enter 'True' for yes and 'False' for no.");

			//Makes a prompt that sets the value of Boolean cont
			cont = keyboard.nextBoolean();
		}

		 //Thanks user for using my program
		System.out.println("Thank You for Using My Program. I Hope You Have Found It Useful");
	}
}
