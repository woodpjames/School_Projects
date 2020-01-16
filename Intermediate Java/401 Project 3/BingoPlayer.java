import java.util.*;
public class BingoPlayer{
	private String firstName;
	private String lastName;
	private double money;
	private BingoCard[] hand;

	public BingoPlayer(String first, String last, double amount){
		firstName = first;
		lastName = last;
		money = amount;
	}
	public String getFullName(){
		String name = firstName + " " + lastName;
		return name;
	}
	public String getFullInfo(){
		String info = firstName + " " + lastName + " ($" + money + ")";
		return info;

	}
	public String toString(){
		String[] holder;
		int cardNum = hand.length;
		String str = firstName + " " + lastName + " ($" + money + ")\n";
		if(hand == null || hand.length == 0){str = str + "No Bingo Cards";}
		else{
			for(int i = 0; i < 12; i++){
				for(int j = 0; j < cardNum; j++){
					holder = hand[j].toString().split("\n");
					if(j != 0){str = str + " " + holder[i];}
					else if(j == 0){str = str + holder[i];}
				}
				if(i<11){
					str = str + "\n";
				}
			}
		}
		return str;
	}
	public boolean isBingo(){
		boolean bull = false;
		for(int i = 0; i < hand.length; i++){
			BingoCard card = hand[i];
			for(int j = 0; j<5; j++){
				if(card.getNumber(0,j).isMarked() && card.getNumber(1,j).isMarked() && card.getNumber(2,j).isMarked() && card.getNumber(3,j).isMarked() && card.getNumber(4,j).isMarked()){
					bull = true;
				}
				if(card.getNumber(j,0).isMarked() && card.getNumber(j,1).isMarked() && card.getNumber(j,2).isMarked() && card.getNumber(j,3).isMarked() && card.getNumber(j,4).isMarked()){
					bull = true;
				}
			}
			if((card.getNumber(0,0).isMarked() && card.getNumber(1,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(3,3).isMarked() && card.getNumber(4,4).isMarked()){
				bull = true;
			}
			if((card.getNumber(4,0).isMarked() && card.getNumber(3,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(1,3).isMarked() && card.getNumber(0,4).isMarked()){
				bull = true;
			}
		}
		return bull;
	}
	public BingoCard[] getBingoCards(){
		int numOfWinningCards = 0;
		for(int i = 0; i < hand.length; i++){
			boolean bull = false;
			BingoCard card = hand[i];
			for(int j = 0; j<5; j++){
				if(card.getNumber(0,j).isMarked() && card.getNumber(1,j).isMarked() && card.getNumber(2,j).isMarked() && card.getNumber(3,j).isMarked() && card.getNumber(4,j).isMarked()){
					bull = true;
				}
				if(card.getNumber(j,0).isMarked() && card.getNumber(j,1).isMarked() && card.getNumber(j,2).isMarked() && card.getNumber(j,3).isMarked() && card.getNumber(j,4).isMarked()){
					bull = true;
				}
			}
			if((card.getNumber(0,0).isMarked() && card.getNumber(1,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(3,3).isMarked() && card.getNumber(4,4).isMarked()){
				bull = true;
			}
			if((card.getNumber(4,0).isMarked() && card.getNumber(3,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(1,3).isMarked() && card.getNumber(0,4).isMarked()){
				bull = true;
			}
			if(bull){numOfWinningCards++;}
		}
		BingoCard[] winningCards = new BingoCard[numOfWinningCards];
		int numInList = 0;
		for(int i = 0; i < hand.length; i++){
			boolean bull = false;
			BingoCard card = hand[i];
			for(int j = 0; j<5; j++){
				if(card.getNumber(0,j).isMarked() && card.getNumber(1,j).isMarked() && card.getNumber(2,j).isMarked() && card.getNumber(3,j).isMarked() && card.getNumber(4,j).isMarked()){
					bull = true;
				}
				if(card.getNumber(j,0).isMarked() && card.getNumber(j,1).isMarked() && card.getNumber(j,2).isMarked() && card.getNumber(j,3).isMarked() && card.getNumber(j,4).isMarked()){
					bull = true;
				}
			}
			if((card.getNumber(0,0).isMarked() && card.getNumber(1,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(3,3).isMarked() && card.getNumber(4,4).isMarked()){
				bull = true;
			}
			if((card.getNumber(4,0).isMarked() && card.getNumber(3,1).isMarked() && card.getNumber(2,2).isMarked()) && card.getNumber(1,3).isMarked() && card.getNumber(0,4).isMarked()){
				bull = true;
			}
			if(bull){
				winningCards[numInList] = hand[i];
			}
		}
		return winningCards;
	}

	public int remove(int amount){
		if((money - amount)>=0){
			money = money - amount;
			return amount;
		}
		else{return (int) money;}
	}
	public void add(double amount){money = money + amount;}
	public void addBingoCards(BingoCard[] cards){
		int num = cards.length;
		hand = new BingoCard[num];
		for(int i = 0; i < num; i++){
			hand[i] = cards[i];
		}
	}
	public void mark(int number){
		for(int i = 0; i<hand.length; i++){
			hand[i].mark(number);
		}
	}
	public void clear(){
		hand = null;
	}
}
