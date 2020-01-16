import java.util.*;
public class BingoCage{
	Random rand = new Random();
	ArrayList<BingoBall> balls = new ArrayList<BingoBall>();
	int numDrawn;
	public BingoCage(){
		for(int i = 1; i <= 75; i++){
			balls.add(new BingoBall(i));
		}
	}
	public BingoBall draw(){
		int randNum;
		if(numDrawn < 75){
			do{
				randNum = rand.nextInt(75);
			} while(balls.get(randNum) == null);
			numDrawn++;
			BingoBall temp;
			temp = balls.get(randNum);
			balls.set(randNum, null);
			return temp;
		}
		else{return null;}
	}
	public void reset(){
		balls.clear();
		for(int i = 1; i <= 75; i++){
			balls.add(new BingoBall(i));
		}
	}
}
