/* Proggramer: James Wood, Created: 10/27/18, Date of Last Modification: 11/8/18
This program will run a specified dice game consisting of 4 dice. The user will make an initial roll that will be tested for specific values that could indicate
a win, loss, or need to keep playing. If a value is rolled that requires the continue of play the user will roll until they match their initial rolls value or
roll a 13. Matching the initial rolls value will cause the user to win. Rolling a 13 will cause the user to lose.
*/

//This imports the java util library so that things like the Scanner and Random class can be used
import java.util.*;
//
public class P2A3_WOOD_DIE_4214424
{
	//Creates a parameter value for the object
	private int value;

	//This is the constructor for the class
	public P2A3_WOOD_DIE_4214424()
	{
		//Creates a Random class called rand
		Random rand = new Random();
		//sets value equal to a random from 1-6 using Random rand
		value = rand.nextInt(6)+1;
	}

	//This is the mutator method. It allows the user to roll the dice and change its value
	public void roll()
	{
		//creates a random class called rand
		Random rand = new Random();
		//sets value equal to a random using Random rand
		value = rand.nextInt(6) +1;
	}

	//This is an accesor method used to get the value of the dice
	public int getValue()
	{
		//This returns the value of the dice back to main
		return value;
	}
}
