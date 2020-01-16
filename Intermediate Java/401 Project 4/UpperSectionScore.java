public class UpperSectionScore extends Score
{
	int number;
	public UpperSectionScore(String aName, int aNumber){
		number = aNumber;
		name = aName;
	}
	public int getDiceScore(DieInterface[] dice){
		int numOfKind = 0;
		for(int i = 0; i < dice.length; i++){
			if(dice[i].toString().contains(Integer.toString(number))){numOfKind++;}
		}
		return numOfKind * number;
	}
}
