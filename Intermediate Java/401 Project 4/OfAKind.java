public class OfAKind extends Score
{
	int type;
	public OfAKind(String aName, int numSameFaces){
		name = aName;
		type = numSameFaces;
	}
	public int getDiceScore(DieInterface[] dice){
		int numOfKind = 0;
		int total = 0;
		boolean bull = false;
		for(int i = 1; i <= 6; i++){
			for(int j = 0; j < dice.length; j++){
				if(dice[j].toString().contains(Integer.toString(i))){numOfKind++;}
			}
			if(type <= numOfKind){bull = true;}
			numOfKind = 0;
		}
		if(bull){
			for(int i = 0; i < dice.length; i++){
				total = total + dice[i].getFaceValue();
			}
		}
		return total;
	}
}
