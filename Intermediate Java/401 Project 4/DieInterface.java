public interface DieInterface
{
	public static String[] dieFaces =
		{"+---+\n|   |\n| o |\n|   |\n+---+",
		 "+---+\n|o  |\n|   |\n|  o|\n+---+",
		 "+---+\n|o  |\n| o |\n|  o|\n+---+",
		 "+---+\n|o o|\n|   |\n|o o|\n+---+",
		 "+---+\n|o o|\n| o |\n|o o|\n+---+",
		 "+---+\n|o o|\n|o o|\n|o o|\n+---+"};

	public static String toDieString(DieInterface aDie)
	{
		return dieFaces[aDie.getFaceValue() - 1];
	}

	// Do not modify above this line

	public static String toDiceString(DieInterface[] dice) {
		StringBuilder result = new StringBuilder();
		// Add your code here
		int numOfDies = dice.length;
		for(int i=0; i<5; i++){
			for(int j=0; j<numOfDies; j++){
				result.append(dieFaces[dice[j].getFaceValue() - 1].split("\n")[i] + " ");
			}
			if(i!=4){result.append("\n");}
		}
		return result.toString();
	}
	// Do not modify below this line
    public int roll();
	public int getFaceValue();
}
