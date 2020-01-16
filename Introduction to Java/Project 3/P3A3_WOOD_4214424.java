/* Date Made: 11/24/18, Last Mosified: 11/30/18, Programer: James Wood
This program will welcome a user, give them 10 Java questions to awnser, gracefully end the program wheneve they wish to,
and tell them the number of question they have gotten right and wrong. Make sure to save data in the line after the final question.*/

//Imports the Util package so that I can use the random and Scanner class later in my program
import java.util.*;
//Imports the IO package so that I can get questions from a file and assign them to objects
import java.io.*;

public class P3A3_WOOD_4214424
{
	public static void main(String[] args) throws IOException
	{
		//Creates a new random rand that will be used to call questions in the array randomly
		Random rand = new Random();
		//Creates a scanner that accepts user input named prompt
		Scanner prompt = new Scanner(System.in);
		//Creates a P3A2_WOOD_4214424_Question refrence variable that will be used to refrence different questions in the array
		P3A3_WOOD_4214424_Question questionInUse;
		//Creates a String variable fileName that will allow user to enter speciic file to pull questions from
		String fileName;
		//Name will save the name of the user so that I can personalize their welcome message
		String name;
		//Response will save the user response to the "would you like to continue" question so they can exit the program if they would like to
		String response;
		//Ans will save the users answer to the question so it can be tested against the correct answer. Its initialized with "no" so the program will run atleast once
		String ans = "no";
		//Creates and initializes an int variable that will be assigned a random number 0-9 so that my program can call questions at random
		int randNum = rand.nextInt(10);
		//Creates and initializes an int variable that saves the number of answers the user has gotten correct
		int wins = 0;
		//Creates and initializes an int variable that saves the number of answers the user has gotten incorrect
		int losses = 0;
		//Creates a variable counter so that the program will end after the 10 questions have been asked
		int counter = 0;

		//I print a line that welcomes the user to the program, introduces myself, and asks user thier name.
		System.out.println("Welcome to my program! You will be asked to awnser a quiz questions. My name's James. What's yours?");
		//I save the users response to my question in the name variable here
		name = prompt.nextLine();
		//I say hello to the user by name here and ask them what file they would like to use to pull questions from
		System.out.println("Hello " + name + "! What file would you like to pull your questions from?");
		//Saves the name of the file the user would like to use in the variable fileName
		fileName = prompt.nextLine();
		//Creates a new file named myFile and saves the data of the file the user specified to it
		File myFile = new File(fileName);
		//Creates a scanner that reads lines from the the file myFile named inputFile
		Scanner inputFile = new Scanner(myFile);
		//Prints a line that tells the user they are about to start answering questions
		System.out.println("OK! Let's get started! \n");

		//Creates an ArrayList that hold the questions I create
		ArrayList<P3A3_WOOD_4214424_Question> questions = new ArrayList<P3A3_WOOD_4214424_Question>();
		//Adds questions to ArrayList until there are no more questions in the file
		while(inputFile.hasNext())
		{
			//Adds new quesion object from inputFile
			questions.add(new P3A3_WOOD_4214424_Question(inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine()));
			//Accepts the space that occurs between questions
			inputFile.nextLine();
		}

		//I create a while loop here that runs as long as the user does not ask to quit the program and the questions are not used up
		while(!ans.equals("yes") && counter < questions.size())
		{
			//sets the questionInUse variable equal to a random object in my questions array refrence address
			questionInUse = questions.get(randNum);
			//Creates a while loop that tests if the question has been used before so that it can get a new random question from the array if this ones already been used
			//If questionInUse has a value of true for "Used" the while loop is entered
			while(questionInUse.getUsed())
			{
				//Assigns new randow so that a random member of question array can be used
				randNum = rand.nextInt(10);
				//Assigns a new member of the array to questionInUse
				questionInUse = questions.get(randNum);
			}
			//Sets the question being asked in the array to 'Used' so that it will not be used again
			questions.get(randNum).setUsed(true);
			//Adds 1 to the counter so that the number of questions asked is updated
			counter++;
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

			//if else statement used to see if all questions have been answered of not
			//if all questions have not been answered the system asks the user if they would like to keep answereing questions and assigns new randNum
			if (counter < 10)
			{
				//Asks user if they would like to exit the program and tells them how to correctly enter their response
				System.out.println("Would you like to exit the program. Enter 'yes' to exit.");
				//Saves users response to the ans variable
				ans = prompt.nextLine();
				//assigns new randow so that a random member of question array can be used
				randNum = rand.nextInt(10);
			}
			else
			{
				//Tells user they have answered all the questions and wishes them luck
				System.out.println("You've awnsered all 10 of my questions! I hope they have helped you study!");
			}
		}
		//Thanks user for using my program and wishes them a good day
		System.out.println("Thanks for using my program! Have a good one!");
	}
}
