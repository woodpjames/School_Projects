public abstract class Score implements ScoreInterface
{
	String name;
	int score = 0;
	boolean used = false;
	public String getName(){return name;}
	public int getScore(){return score;}
	public abstract int getDiceScore(DieInterface[] dice);
	public void setScore(DieInterface[] dice){
		score = getDiceScore(dice);
		used = true;
	}
	public boolean isUsed(){return used;}
	public void reset() {
		score = 0;
		used = false;
	}
	public String toString() {
		String scoreString = String.format("%3d", score);
		return name + ": " + scoreString;
	}
}
