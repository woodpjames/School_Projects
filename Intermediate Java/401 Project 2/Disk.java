public class Disk {
	private int diskSize;
	private String diskString;
	public Disk(int aDiskSize, char aDiskChar, char aPoleChar) {
		if(aDiskSize >= 1) {diskSize = aDiskSize;}
		else {diskSize = 1;}
		diskString = "";
    	for(int i = 0; i < diskSize; i++){
        	diskString = diskString + aDiskChar;
		}
		diskString = diskString + aPoleChar;
		for(int i = 0; i < diskSize; i++){
        	diskString = diskString + aDiskChar;
		}
	}
	public Disk(int aDiskSize) {
		if(aDiskSize >= 1) {diskSize = aDiskSize;}
		else {diskSize = 1;}
		char aDiskChar = '*';
		char aPoleChar = '|';
		diskString = "";
    	for(int i = 0; i < diskSize; i++){
        	diskString = diskString + aDiskChar;
		}
		diskString = diskString + aPoleChar;
		for(int i = 0; i < diskSize; i++){
        	diskString = diskString + aDiskChar;
		}
	}
	public int getSize() {return diskSize;}
	public String toString() {return diskString;}
}
