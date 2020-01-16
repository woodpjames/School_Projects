import java.util.*;
import java.io.*;

public class Bingo {
	// Finds First Alphabetical String in list (for sorting)
	public static int findSmallest(BingoPlayer[] array, int startIndex, int endIndex){
		BingoPlayer smallest = array[startIndex];
		int index = startIndex;
		for(int i = startIndex + 1; i <= endIndex; i++){
			if((array[i].getFullName()).compareTo(smallest.getFullName()) < 0){
				smallest = array[i];
				index = i;
			}
		}
		return index;
	}
	// Swaps to indices (for sorting)
	public static void swap(BingoPlayer[] array, int first, int second){
		BingoPlayer temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	// Sorts the BingoPlayer class aplpabetically
	public static void selectionSort(BingoPlayer[] array){
		int size = array.length;
		for(int i = 0; i < size - 2; i++){
			int indexOfSmallest = findSmallest(array, i, size - 1);
			swap(array, i, indexOfSmallest);
		}
	}

	// The following method tells the user the status of the game and prints out all playing players cards and info
	public static void gameInfo(ArrayList<BingoPlayer> playingPlayers, double houseMoney, double potMoney, ArrayList<BingoBall> ballsDrawn){
		System.out.print("House: " + houseMoney + "\nPot: " + potMoney + "\nBalls: [");
		for(int i = 0; i < (ballsDrawn.size()-1); i++){
			System.out.print(ballsDrawn.get(i) + ",");
		}
		if(ballsDrawn.size() != 0){
			System.out.print(ballsDrawn.get(ballsDrawn.size()-1));
		}
		System.out.println("]");
		for(int i = 0; i < playingPlayers.size(); i++){
			System.out.print((i+1) + ". ");
			System.out.println(playingPlayers.get(i));
		}
	}

	// Draws Bingo Ball and checks for winner
	public static boolean drawBall(BingoCage bingoCage, ArrayList<BingoBall> ballsDrawn, ArrayList<BingoPlayer> playingPlayers, double potMoney){
		Scanner scanIn = new Scanner(System.in);
		BingoBall ball = bingoCage.draw();
		ballsDrawn.add(ball);
		for(int i = 0; i<playingPlayers.size(); i++){
			playingPlayers.get(i).mark(ball.getNumber());
		}
		for(int i = 0; i<playingPlayers.size(); i++){
			if(playingPlayers.get(i).isBingo()){
				BingoCard[] winningCards = playingPlayers.get(i).getBingoCards();
				System.out.println(playingPlayers.get(i).getFullName() + " says this card is a winning card");
				System.out.println(winningCards[0].toSideBySideString());
				System.out.println("These are balls that have been drawn so far in this round:");
				System.out.println(ballsDrawn);
				System.out.println("Is it a winning card? (y/n):");
				scanIn.nextLine();
				playingPlayers.get(i).add(potMoney);
				return false;
			}
		}
		return true;
	}

	// Main method
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// General Game Information
		ArrayList<BingoPlayer> playingPlayers = new ArrayList<BingoPlayer>();
		ArrayList<BingoBall> ballsDrawn = new ArrayList<BingoBall>();
		BingoCage bingoCage = new BingoCage();
		Scanner scanIn = new Scanner(System.in);
		int costOfCard = 1;
		double potMoney = 0;

		// Gets Information From the File about the game
		File file = new File(".\\players.txt");
		Scanner scanFile = new Scanner(file);
		double houseMoney = scanFile.nextDouble();
		int numOfPlayers = scanFile.nextInt();
		scanFile.nextLine();
		BingoPlayer[] players = new BingoPlayer[numOfPlayers];
		for(int i = 0; i < numOfPlayers; i++){
			String[] playerInfo = scanFile.nextLine().split(",");
			String firstName = playerInfo[0];
			String lastName = playerInfo[1];
			Double playerMoney = Double.parseDouble(playerInfo[2]);
			players[i] = new BingoPlayer(firstName, lastName, playerMoney);
		}
		scanFile.close();

		// Sorts players by name
		selectionSort(players);

		// Starts rounds of games
		System.out.println("\n******************************\n* Welcome to SCI Bingo House *\n******************************\nThese are all available players:");
		boolean playasWannaPlay = true;
		while(playasWannaPlay){
			playasWannaPlay = false;

			// Goes Through Start Game Information
			playingPlayers.clear();
			ballsDrawn.clear();
			bingoCage.reset();
			for(int i = 0; i < players.length; i++){
				System.out.print((i+1) + ". ");
				System.out.println(players[i].getFullInfo());
			}
			for(int i = 0; i < players.length; i++){
				boolean valAns = true;
				do{
					valAns =  true;
					System.out.println(players[i].getFullName() +  ", would you like to play this round?");
					String ans = scanIn.nextLine();
					if(ans.equals("y")){
						System.out.print("How many Bingo card would you like to buy? (1 - 4):");
						int numOfCards = scanIn.nextInt();
						if(numOfCards >= 1 && numOfCards <= 4){
							if(players[i].remove(numOfCards*costOfCard) == numOfCards*costOfCard){
								playasWannaPlay = true;
								potMoney = potMoney + .5*numOfCards*costOfCard;
								houseMoney = houseMoney + .5*numOfCards*costOfCard;
								scanIn.nextLine();
								BingoCard[] cardsAdding = new BingoCard[numOfCards];
								for(int j = 0; j < numOfCards; j++){
									cardsAdding[j] = new BingoCard();
								}
								players[i].addBingoCards(cardsAdding);
								playingPlayers.add(players[i]);
							}
							else{
								System.out.println("You do not have enough money to buy this many cards. Please only buy as many cards as you can afford.");
								valAns = false;
							}
						}
						else{
							System.out.println("Invalid number of cards selected. Please choose between 1 and 4 cards after choosing to play.");
							valAns = false;
							scanIn.nextLine();
						}
					}
					else if(!ans.equals("n")){
						System.out.println("Incorrect Response. Please enter 'y' or 'n'.");
						valAns = false;
					}
				} while(!valAns);
			}

			// This section of code is the main game
			if(playasWannaPlay){
				gameInfo(playingPlayers, houseMoney, potMoney, ballsDrawn);
				boolean bull = true;
				while(bull){
					System.out.println("There is no winning card yet.");
					System.out.print("1) Draw a ball, 2) Draw balls until Bingo:");
					int choose = scanIn.nextInt();
					if(choose == 1){
						bull = drawBall(bingoCage, ballsDrawn, playingPlayers, potMoney);
						if(bull){
							gameInfo(playingPlayers, houseMoney, potMoney, ballsDrawn);
						}
					}
					else if(choose == 2){
						while(bull){
							bull = drawBall(bingoCage, ballsDrawn, playingPlayers, potMoney);
							gameInfo(playingPlayers, houseMoney, potMoney, ballsDrawn);
						}
					}
				}
				System.out.println("This round is over.");
				scanIn.nextLine();
				potMoney = 0;
			}
		}
		System.out.println("Thank you!!!");
		// Stores new game info into text file
		FileWriter writer = new FileWriter(file, false);
		writer.write(Double.toString(houseMoney));
		writer.write("\r\n");
		writer.write(Integer.toString(numOfPlayers));
		writer.write("\r\n");
		for(int i = 0; i<players.length-1; i++){
			writer.write(players[i].getFullInfo().replace(" ", ",").replace("(", "").replace(")", "").replace("$",""));
			writer.write("\r\n");
		}
		writer.write(players[players.length-1].getFullInfo().replace(" ", ",").replace("(", "").replace(")", "").replace("$",""));
		writer.close();
	}
}
