// James Wood, Creation Date 9/12/18, Last Modification 9/19/18, This Program Will Convert Richtors to Energy Output in Either Tons of TNT or Joules

import java.util.Scanner;						//

public class P1A1_Wood_4214424						//Class begins and names the program
{
	public static void main (String[] args)				//Main Method acts as a Starting Point for the Program
	{
		String user;		//Variable for users name	//Creates Variable that will store user name

		Scanner keyboard = new Scanner(System.in);		//Assigns 'keyboard' as a command for opening prompt

		System.out.println("Hi! What's your name?");		//Prints line asking name of user
		user = keyboard.nextLine();				//Makes a prompt appear and assigns value of typed response to 'user' variable

		System.out.println("Welcome " + user 			//Makes an output welcoming the user by name using the 'user' variable
		+ ". My name is James Wood. This program will tell " 
		+ "you the amount of energy produced by an Earthquake" 
		+ " of an entered magnitude.");
									
	}
}									//Braces Close the Argument and Program 
