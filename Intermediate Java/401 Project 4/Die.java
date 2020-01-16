import java.util.*;
public class Die implements DieInterface {
	Random rand = new Random();
	int faceValue;
	public Die(){
		faceValue = rand.nextInt(6) + 1;
	}
	public int roll(){
		faceValue = rand.nextInt(6) + 1;
		return faceValue;
	}
	public int getFaceValue(){
		return faceValue;
	}
	public String toString(){
		return "Die: " + Integer.toString(faceValue);
	}
}
