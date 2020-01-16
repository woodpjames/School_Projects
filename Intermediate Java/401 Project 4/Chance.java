public class Chance extends Score{
	int type;
	public Chance(String aName){
		name = aName;
	}
	public int getDiceScore(DieInterface[] dice){
		int total = 0;
		for(int i = 0; i < dice.length; i++){
			total = total + dice[i].getFaceValue();
		}
		return total;
	}
}
