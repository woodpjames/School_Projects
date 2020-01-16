import java.util.*;
public class BingoCard {
	Random rand = new Random();
	BingoNumber[][] bingoRep = new BingoNumber[5][5];
	public BingoCard() {
		ArrayList<Integer> numbersUsed = new ArrayList<Integer>();
		int max = 0;
		int num;
		for(int column = 0; column<5; column++){
			for(int row = 0; row<5; row++){
				do{
					num = rand.nextInt(15) + 1 + max;
				}while(numbersUsed.contains(num));
				bingoRep[column][row] = new BingoNumber(num);
				numbersUsed.add(num);
			}
			max += 15;
		}
		bingoRep[2][2].mark();
	}
	public String toString() {
		String stringRep = "  B  I  N  G  O \n+--+--+--+--+--+";
		for(int row = 0; row < 5; row++){
			stringRep = stringRep + "\n|";
			for(int column = 0; column < 5; column++){
				if(column != 2 || row != 2){stringRep = stringRep + bingoRep[column][row] + "|";}
				else{stringRep = stringRep + "XX" + "|";}
			}
			stringRep = stringRep + "\n+--+--+--+--+--+";
		}
		return stringRep;
	}
	public BingoNumber getNumber(int row, int column) {
		return bingoRep[row][column];
	}
	public String toSideBySideString() {
		String stringRep = "  B  I  N  G  O    B  I  N  G  O\n+--+--+--+--+--+ +--+--+--+--+--+";
		for(int row = 0; row < 5; row++){
			stringRep = stringRep + "\n|";
			for(int column = 0; column < 5; column++){
				if(column != 2 || row != 2){stringRep = stringRep + bingoRep[column][row] + "|";}
				else{stringRep = stringRep + "XX" + "|";}
			}
			stringRep = stringRep + " |";
			for(int column = 0; column < 5; column++)
				if(column != 2 || row != 2){stringRep = stringRep + bingoRep[column][row].toNumberString() + "|";}
				else{stringRep = stringRep + "XX" + "|";}
			stringRep = stringRep + "\n+--+--+--+--+--+ +--+--+--+--+--+";
		}
		return stringRep;
	}
	public boolean mark(int number) {
		boolean bull = false;
		String numrep = "";
		if(number>=10){numrep = "" + number;}
		else{numrep = " " + number;}
		for(int row = 0; row < 5; row++){
			for(int column = 0; column < 5; column++){
				if((bingoRep[column][row].toNumberString()).equals(numrep)){
					bingoRep[column][row].mark();
					bull = true;
				}
			}
		}
		return bull;
	}
}
