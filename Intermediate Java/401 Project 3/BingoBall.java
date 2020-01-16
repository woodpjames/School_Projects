public class BingoBall{
	public int ballNum;
	public BingoBall(int number){
		ballNum = number;
	}
	public int getNumber(){
		return ballNum;
	}
	public String toString(){
		String ballStr = "" + ballNum;
		return ballStr;
	}
}
