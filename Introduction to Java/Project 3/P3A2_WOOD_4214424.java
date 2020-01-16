/* Date Made: 11/24/18, Last Mosified: 11/29/18, Programer: James Wood
This program will welcome a user, give them 3 Java questions to awnser, and then gracefully end*/

//Imports the Util package so that I can use the random and Scanner class later in my program
import java.util.*;

public class P3A2_WOOD_4214424
{
	public static void main(String[] args)
	{
		//Creates 3 instances of the class P3A2_WOOD_4214424_Question assigning Q1, Q2, Q3 questions, answer choices, and correct answers
		P3A2_WOOD_4214424_Question Q1 = new P3A2_WOOD_4214424_Question("Java is a portable language. This means...", "A. A Java program can be run on any computer that has Java Virtual Machine.", "B. Java can only be put on computers that are light enough to carry.", "C. Java is capable of working on any device.", "D. Java is the best programming language for everything.", "A");
		P3A2_WOOD_4214424_Question Q2 = new P3A2_WOOD_4214424_Question("How do you start a single line comment", "A. ||", "B. &&", "C. %%", "D. //", "D");
		P3A2_WOOD_4214424_Question Q3 = new P3A2_WOOD_4214424_Question("What does an ! mean in logical programming?", "A. And", "B. Or", "C. Not", "D. Also", "C");

		//Here I put the three questions into an array questions so that they may be called randomly by the program
		P3A2_WOOD_4214424_Question[] questions = {Q1, Q2, Q3};

		//Creates a new random rand that will be used to call questions in the array randomly
		Random rand = new Random();
		//Creates a scanner that accepts user input named prompt
		Scanner prompt = new Scanner(System.in);

		//Creates a P3A2_WOOD_4214424_Question refrence variable that will be used to refrence different questions in the array
		P3A2_WOOD_4214424_Question questionInUse;
		//Name will save the name of the user so that I can personalize their welcome message
		String name;
		//Response will save the user response to the "would you like to continue" question so they can exit the program if they would like to
		String response;
		//Ans will save the users answer to the question so it can be tested against the correct answer
		String ans;
		//Creates and initializes an int variable that will be assigned a random number 0-9 so that my program can call questions at random
		int randNum = rand.nextInt(3);
		//Creates and initializes an int variable that saves the number of answers the user has gotten correct
		int wins = 0;
		//Creates and initializes an int variable that saves the number of answers the user has gotten incorrect
		int losses = 0;

		//I print a line that welcomes the user to the program, introduces myself, and asks user thier name.
		System.out.println("Welcome to my program! You will be asked to awnser a quiz questions. My name's James. What's yours?");
		//I save the users response to my question in the name variable here
		name = prompt.nextLine();
		//I say hello to the user by name here and prepare to ask them a question
		System.out.println("Hello " + name + "! Let's Begin!");

		//I create a do-while loop here that runs as long as the user does not ask to quit the program
		do{
			//sets the questionInUse variable equal to a random object in my questions array refrence address
			questionInUse = questions[randNum];
			//The next 5 lines print out the question and answer choices to the question
			System.out.println(questionInUse.getQ());
			System.out.println(questionInUse.getA1());
			System.out.println(questionInUse.getA2());
			System.out.println(questionInUse.getA3());
			System.out.println(questionInUse.getA4());
			//Tells the user how to correctly input their answer
			System.out.println("Awnser with a single uppercase character. Example: 'C'.");
			//Saves users answer to the response variable
			response = prompt.nextLine();

			//Tests ans against the correct answer. And enters if statement if it is
			if(response.equals(questionInUse.getCA()))
			{
				//Adds 1 to the total numer of question the user has gotten right
				wins++;
				//Prints the number of questions the user has gotten right and wrong
				System.out.println("Correct! You have got " + wins + " questions right and " + losses + " questions wrong.");
			}
			//Enters else statement if answer was wrong
			else
			{
				//Adds 1 to the total numer of question the user has gotten wrong
				losses++;
				//Prints the number of questions the user has gotten right and wrong
				System.out.println("Incorrect... You have got " + wins + " question(s) right and " + losses + " question(s) wrong.");
			}

			//Asks user if they would like to exit the program and tells them how to correctly enter their response
			System.out.println("Would you like to exit the program. Enter 'yes' to exit.");
			//Saves users response to the ans variable
			ans = prompt.nextLine();

			//Changes the value of randNum to a new random number
			randNum = rand.nextInt(3);
		}while(!(ans.equals("yes")));

		//Thanks user for using my program and wishes them a good day
		System.out.println("Thanks for using my program! Have a good one!");
	}
}
