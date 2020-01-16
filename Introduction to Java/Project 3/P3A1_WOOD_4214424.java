/* Date Made: 11/24/18, Last Mosified: 11/29/18, Programer: James Wood
This program will welcome a user, give them a Java question to awnser, and then gracefully end*/

//I imported the util package so I can utilize the Scanner class later in my program
import java.util.*;

public class P3A1_WOOD_4214424
{
	public static void main(String[] args)
	{
		//I create a scanner named prompt so I can get user data
		Scanner prompt = new Scanner(System.in);
		//I created a String variable name to store the users name and welcome them
		String name;
		//I created a String variable name to store the users answer to my questions
		String ans;

		//I print a line that welcomes the user to the program, introduces myself, and asks user thier name.
		System.out.println("Welcome to my program! You will be asked to awnser a quiz question. My name's James. What's yours?");
		//I save the users response to my question in the name variable here
		name = prompt.nextLine();
		//I say hello to the user by name here and prepare to ask them a question
		System.out.println("Hello " + name + "! Here's your question:");
		//I print the question to the user here along with answer choices
		System.out.println("Java is a portable language. This means...\n"
							+ "A. A Java program can be run on any computer that has Java Virtual Machine.\n"
							+ "B. Java can only be put on computers that are light enough to carry.\n"
							+ "C. Java is capable of working on any device.\n"
							+ "D. Java is the best programming language for everything.");
		//I print a line informing the user the correct way to enter their answer
		System.out.println("Awnser with a single uppercase character. Example: 'C'.");
		//I save the users answer here in the variable ans
		ans = prompt.nextLine();

		//Tests ans against the correct answer. If ans equals answer program prints "You're Correct!"
		if(ans.equals("A"))
		{
			System.out.println("You're Correct!");
		}
		//If the user answers the question incorrectly the program prints "Sorry. That's incorrect..."
		else if (ans.equals("B") || ans.equals("C") || ans.equals("D"))
		{
			System.out.println("Sorry. That's incorrect...");
		}

		//Thanks user for using my program and wishes them a good day
		System.out.println("Thanks for using my program! Have a good one!");
	}
}
