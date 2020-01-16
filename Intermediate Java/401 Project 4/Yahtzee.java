import java.util.*;
public class Yahtzee {
	public static void cardDisplay(String name, ScoreInterface[] scores) {
		int total = 0;
		for(int i = name.length(); i<10; i++){name = name + " ";}
		for(int i = 0; i<13; i++){
			total = total + scores[i].getScore();
		}
		String stringTotal = Integer.toString(total);
		for(int i = stringTotal.length(); i<4; i++){stringTotal = " " + stringTotal;}
		StringBuilder str = new StringBuilder();
		str.append("+----------------------+\n");
		str.append("| Name: " + name + "     |\n");
		str.append("|                      |\n");
		str.append("| " + scores[0]+ " |\n");
		str.append("| " + scores[1]+ " |\n");
		str.append("| " + scores[2]+ " |\n");
		str.append("| " + scores[3]+ " |\n");
		str.append("| " + scores[4]+ " |\n");
		str.append("| " + scores[5]+ " |\n");
		str.append("| " + scores[6]+ " |\n");
		str.append("| " + scores[7]+ " |\n");
		str.append("| " + scores[8]+ " |\n");
		str.append("| " + scores[9]+ " |\n");
		str.append("| " + scores[10]+ " |\n");
		str.append("| " + scores[11]+ " |\n");
		str.append("| " + scores[12]+ " |\n");
		str.append("| -------------------- |\n");
		str.append("|           Total:"+ stringTotal +" |\n");
		str.append("| ==================== |\n");
		str.append("+----------------------+\n");
		String cardRep = str.toString();
		for(int i = 0; i < 13; i++){
			if(!scores[i].isUsed()){
				String pattern = scores[i].getName() + ":   0";
				cardRep = cardRep.replace(pattern, scores[i].getName() + ": ___");
			}
		}
		System.out.print(cardRep);
	}

	public static void diceRoll(DieInterface[] dice) {
		String keepers;
		Scanner scanIn = new Scanner(System.in);
		for(int i = 0; i < 5; i++){dice[i].roll();}
		System.out.println("First Roll:");
		System.out.println(DieInterface.toDiceString(dice));
		System.out.print("Please enter the list of dice that you want to keep: ");
		keepers = scanIn.nextLine();
		for(int i = 1; i <= 5; i++){
			if(!(keepers.contains(Integer.toString(i)))){dice[i-1].roll();}
		}
		System.out.println("Second Roll:");
		System.out.println(DieInterface.toDiceString(dice));
		System.out.print("Please enter the list of dice that you want to keep: ");
		keepers = scanIn.nextLine();
		for(int i = 1; i <= 5; i++){
			if(!(keepers.contains(Integer.toString(i)))){dice[i-1].roll();}
		}
		System.out.println("Third Roll:");
		System.out.println(DieInterface.toDiceString(dice));
	}

	public static void categoryChooser(ArrayList<ScoreInterface> unUsedScores, DieInterface[] dice){
		Scanner scanIn = new Scanner(System.in);
		System.out.println("Here are your scores:");
		if(unUsedScores.size() > 9){
			for(int i = 0; i<9; i++){
				System.out.println(i+1 + ".  " + unUsedScores.get(i).getName() + ": " + unUsedScores.get(i).getDiceScore(dice));
			}
			for(int i = 9; i<unUsedScores.size(); i++){
				System.out.println(i+1 + ". " + unUsedScores.get(i).getName() + ": " + unUsedScores.get(i).getDiceScore(dice));
			}
		}
		else{
			for(int i = 0; i<unUsedScores.size(); i++){
				System.out.println(i+1 + ".  " + unUsedScores.get(i).getName() + ": " + unUsedScores.get(i).getDiceScore(dice));
			}
		}
		System.out.print("Which category would you like to use? (1 - "+ unUsedScores.size() +"): ");
		int chosenCategory = scanIn.nextInt();
		unUsedScores.get(chosenCategory - 1).setScore(dice);
		unUsedScores.remove(chosenCategory - 1);
	}

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		DieInterface[] dice = new DieInterface[5];
		for(int i = 0; i < 5; i++){dice[i] = new Die();}
		ScoreInterface[] scores = new ScoreInterface[13];
		String[] names = {"           Ones", "           Twos", "         Threes", "          Fours", "          Fives", "          Sixes"};
		for(int i = 0; i < 6; i++){scores[i] = new UpperSectionScore(names[i], i + 1);}
		scores[6] = new OfAKind("Three of a Kind", 3);
		scores[7] = new OfAKind(" Four of a Kind", 4);
		scores[8] = new FullHouse("     Full House");
		scores[9] = new Straight(" Small Straight", 4);
		scores[10] = new Straight(" Large Straight", 5);
		scores[11] = new Chance("         Chance");
		scores[12] = new OfAKind("        Yahtzee", 5);
		String ans = "y";
		while(ans.equals("y")) {
			for(int i = 0; i < 13; i++){scores[i].reset();}
			ArrayList<ScoreInterface> unUsedScores = new ArrayList<ScoreInterface>(13);
			for(int i = 0; i < 13; i++){unUsedScores.add(scores[i]);}
			System.out.print("Would you like to play Yahtzee? (y/n): ");
			ans = scanIn.nextLine();
			System.out.println(ans);
			if(ans.equals("y")){
				System.out.print("Please enter your name: ");
				String name = scanIn.nextLine();
				while(unUsedScores.size() != 0){
					cardDisplay(name, scores);
					diceRoll(dice);
					categoryChooser(unUsedScores, dice);
				}
				System.out.println("Here is your final score:");
				cardDisplay(name, scores);
			}
		}
		System.out.println("Thank you...");
	}
}
