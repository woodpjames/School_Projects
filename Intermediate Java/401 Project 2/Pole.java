
public class Pole {
	private Disk[] disks;
	private int numberOfDisks = 0;
	private int maxNumberOfDisks;
	private int maxDiskSize;
	private char poleChar;

	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize, char aPoleChar) {
		if(aMaxNumberOfDisk<1){aMaxNumberOfDisk=1;}
		if(aMaxDiskSize<1){aMaxDiskSize=1;}
		maxNumberOfDisks = aMaxNumberOfDisk;
		maxDiskSize = aMaxDiskSize;
		poleChar = aPoleChar;
		disks = new Disk[maxNumberOfDisks];
		}
	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize) {
		if(aMaxNumberOfDisk<1){aMaxNumberOfDisk=1;}
		if(aMaxDiskSize<1){aMaxDiskSize=1;}
		maxNumberOfDisks = aMaxNumberOfDisk;
		maxDiskSize = aMaxDiskSize;
		poleChar = '|';
		disks = new Disk[maxNumberOfDisks];
	}
	public Pole(int aMaxNumberOfDisk) {
		if(aMaxNumberOfDisk<1){aMaxNumberOfDisk=1;}
		maxNumberOfDisks = aMaxNumberOfDisk;
		maxDiskSize = aMaxNumberOfDisk;
		poleChar = '|';
		disks = new Disk[maxNumberOfDisks];
	}

	public int getMaxNumberOfDisks() {return maxNumberOfDisks;}
	public int getMaxDiskSize() {return maxDiskSize;}
	public int getNumberOfDisks() {return numberOfDisks;}
	public Disk peekTopDisk() {
		int x = -1;
		for(int i = 0; i < maxNumberOfDisks; i++){
			if(disks[i] != null){
				x = i;
			}
		}
		if(x == -1){
			return null;
		}
		else{
			return disks[x];
		}
	}
	public String toString() {
		String pole = "";
    	for(int i = 0; i < maxDiskSize; i++){
        	pole = pole + " ";
		}
		pole = pole + poleChar;
		for(int i = 0; i < maxDiskSize; i++){
        	pole = pole + " ";
		}
		pole = pole + "\n";
		for(int i=0; i<maxNumberOfDisks; i++){
			int x = (maxNumberOfDisks - i) -1;
			if(disks[x] == null){
				for(int y = 0; y < maxDiskSize; y++){
		        	pole = pole + " ";
				}
				pole = pole + poleChar;
				for(int y = 0; y < maxDiskSize; y++){
		        	pole = pole + " ";
				}
				pole = pole + "\n";
			}
			else{
				int diskSize = disks[x].getSize();
				for(int y = 0; y < (maxDiskSize - diskSize); y++){
					pole = pole + " ";
				}
				pole = pole + disks[x].toString();
				for(int y = 0; y < (maxDiskSize - diskSize); y++){
					pole = pole + " ";
				}
				pole = pole + "\n";
			}
		}
		for(int i=0; i<maxDiskSize; i++){
			pole = pole + "==";
		}
		pole = pole + "=";
		return pole;
	}

	public boolean addDisk(Disk aDisk) {
		if(numberOfDisks >= maxNumberOfDisks){
			return false;
		}
		else if(maxDiskSize<aDisk.getSize()){
			return false;
		}
		else{
			int x=0;
			for(int i=(maxNumberOfDisks-1); i>=0; i--){
				if(disks[i] == null){
					x = i;
				}
			}
			disks[x] = aDisk;
			numberOfDisks++;
			return true;
		}
	}
	public Disk removeDisk() {
		int x = -1;
		for(int i = 0; i<maxNumberOfDisks; i++){
			if(disks[i] != null){
				x = i;
			}
		}
		if(x != -1){
			Disk z = disks[x];
			disks[x] = null;
			numberOfDisks--;
			return z;
		}
		else{
			return null;
		}
	}
}
