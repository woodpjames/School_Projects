public class FullHouse extends Score
{
	public FullHouse(String aName){
		name = aName;
	}
	public int getDiceScore(DieInterface[] dice){
		int total = 0;
		if(twoOfAKind(dice) && threeOfAKind(dice)){
			for(int i = 0; i < dice.length; i++){
				total = total + dice[i].getFaceValue();
			}
		}
		return total;
	}
	public static boolean twoOfAKind(DieInterface[] dice){
		boolean bull = false;
		int numOfKind = 0;
		for(int i = 1; i <= 6; i++){
			for(int j = 0; j < dice.length; j++){
				if(dice[j].toString().contains(Integer.toString(i))){numOfKind++;}
			}
			if(numOfKind == 2){bull = true;}
			numOfKind = 0;
		}
		return bull;
	}
	public static boolean threeOfAKind(DieInterface[] dice){
		boolean bull = false;
		int numOfKind = 0;
		for(int i = 1; i <= 6; i++){
			for(int j = 0; j < dice.length; j++){
				if(dice[j].toString().contains(Integer.toString(i))){numOfKind++;}
			}
			if(numOfKind == 3){bull = true;}
			numOfKind = 0;
		}
		return bull;
	}
}
