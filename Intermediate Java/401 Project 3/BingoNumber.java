public class BingoNumber {
	int number;
	boolean isMarked;
	public BingoNumber(int aNumber) {
		number = aNumber;
		isMarked = false;
	}
	public int getNumber() {return number;}
	public boolean isMarked() {return isMarked;}
	public String toString() {
		if(isMarked == false) {
			String numString;
			if (number >= 10) {numString = "" + number;}
			else {numString = " " + number;}
			return numString;
		}
		else {
			String xx = "XX";
			return xx;
		}
	}
	public String toNumberString() {
		String numString;
		if (number >= 10) {numString = "" + number;}
		else {numString = " " + number;}
		return numString;
	}
	public void mark() {isMarked = true;}
}
