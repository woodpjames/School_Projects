public class Straight extends Score{
	int type;
	public Straight(String aName, int numConsecutiveFaces){
		type = numConsecutiveFaces;
		name = aName;
	}
	public int getDiceScore(DieInterface[] dice){
		int total = 0;
		int highestRun = 0;
		int currentRun = 0;
		String stringRep = "";
		for(int i = 0; i < dice.length; i++){
			stringRep = stringRep + Integer.toString(dice[i].getFaceValue()) + " ";
		}
		for(int i = 1; i <= 6; i++){
			boolean bull = true;
			int n = i;
			while(bull && n<=6){
				if(stringRep.contains(Integer.toString(n))){
					currentRun++;
					n++;
				}
				else{bull = false;}
			}
			if(currentRun > highestRun){highestRun = currentRun;}
			currentRun = 0;
		}
		if(highestRun >= type){
			for(int i = 0; i < dice.length; i++){
				total = total + dice[i].getFaceValue();
			}
		}
		return total;
	}
}
