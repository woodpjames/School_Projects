// James Wood, Creation Date 9/12/18, Last Modification 9/23/18, This Program Will Convert Richtors to Energy Output in Either Tons of TNT or Joules

import java.util.Scanner;						//Allows For the Use of Scanner
import java.lang.Math;							//Allows for more complex math functions to be used. Exponentials for this program

public class P1A2_Wood_4214424						//Class begins and names the program
{
	public static void main (String[] args)				//Main Method acts as a Starting Point for the Program
	{
		String user;						//Variable for users name
		Double magnitude;					// Creates double for user input of magnitude
		Double joules;						//Creates double for 'joules' value
		Double tnt;						//Creates double for 'tnt' value
		Boolean ask = true;					//Makes 'ask' boolean and assigns it true. Used for while loop asking user if they would like to continue


		Scanner keyboard = new Scanner(System.in);		//Assigns 'keyboard' as a command for opening prompt

		System.out.println("Hi! What's your name?");		//Prints line asking name of user
		user = keyboard.nextLine();				//Makes a prompt appear and assigns value of typed response to 'user' variable


		System.out.println("Welcome " + user 			//Makes an output welcoming the user by name using the 'user' variable
		+ ". My name is James Wood. This program will tell " 
		+ "you the amount of energy produced by an Earthquake" 
		+ " of an entered magnitude.");

		while(ask)
		{
			System.out.println("Enter a magnitude from"	//Produces Statement asking User to Enter Magnitude
			+ " 0.0 to 10.0 Richtors.");

			magnitude = keyboard.nextDouble();		//Makes a prompt that assigns a value to the double magnitude

			joules = Math.pow(10,(1.5*magnitude)+4.8);	//Sets the value of 'joules' through math calculation
			tnt = (joules*Math.pow(10,-9))*.239;		//Sets the value of 'tnt' through math calculation

			System.out.println("For a magnitude " 		//Statement that tells the user how many joules and tons of TNT specified Earthquake made
			+ magnitude + " earthquake there is"
			+ " a realease of " 
			+ joules + " joules. About " 
			+ tnt + " tons of TNT!");

			System.out.println("Would You like"		//Statement asks user whether they would like to run program again
			+ " to run the program again? "
			+ "Enter 'True' for yes and"
			+ " 'False' for no.");

			ask = keyboard.nextBoolean();			//Makes a prompt that sets the value of Boolean 
		}
	}
}
