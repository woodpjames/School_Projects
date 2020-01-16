public class TowerOfHanoi {
	private Pole[] poles = new Pole[3];
	public TowerOfHanoi() {
		poles[0] = new Pole(7);
		poles[1] = new Pole(7);
		poles[2] = new Pole(7);
		for(int i=0; i<7; i++){
			int x = 7-i;
			Disk disk = new Disk(x);
			poles[0].addDisk(disk);
		}
	}
	public TowerOfHanoi(int aNumberOfDisks) {
		if(aNumberOfDisks<1){aNumberOfDisks = 1;}
		poles[0] = new Pole(aNumberOfDisks);
		poles[1] = new Pole(aNumberOfDisks);
		poles[2] = new Pole(aNumberOfDisks);
		for(int i=0; i<aNumberOfDisks; i++){
			int x = aNumberOfDisks-i;
			poles[0].addDisk(new Disk(x));
		}
	}

	public Disk peekTopDisk(int aPoleNumber) {
		aPoleNumber = aPoleNumber - 1;
		Disk x = null;
		if(aPoleNumber!=0 && aPoleNumber!=1 && aPoleNumber!=2){
			return x;
		}
		else if(poles[aPoleNumber].getNumberOfDisks() == 0) {
			return x;
		}
		else {
			x = poles[aPoleNumber].peekTopDisk();
			return x;
		}

	}
	public int getNumberOfDisks(int aPoleNumber) {
		aPoleNumber = aPoleNumber - 1;
		if(aPoleNumber!=0 && aPoleNumber!=1 && aPoleNumber!=2){
			return -1;
		}
		else {
			return poles[aPoleNumber].getNumberOfDisks();
		}
	}
	public String toString() {
		String toh = "";
		String[] p1 = poles[0].toString().split("\n");
		String[] p2 = poles[1].toString().split("\n");
		String[] p3 = poles[2].toString().split("\n");
		for(int i=0; i < poles[0].getMaxDiskSize(); i++){
			toh = toh + " ";
		}
		toh = toh + "1";
		for(int i=0; i < 2*poles[0].getMaxDiskSize()+1; i++){
			toh = toh + " ";
		}
		toh = toh + "2";
		for(int i=0; i < 2*poles[0].getMaxDiskSize()+1; i++){
			toh = toh + " ";
		}
		toh = toh + "3\n";
		for(int i = 0; i < p1.length; i++){
			if(i+1 == p1.length) {
				toh = toh + p1[i] + "=" + p2[i] + "=" + p3[i];
			}
			else {
				toh = toh + p1[i] + " " + p2[i] + " " + p3[i] + "\n";
			}
		}
		return toh;
	}

	public boolean move(int fromPole, int toPole) {
		Disk x;
		fromPole = fromPole - 1;
		toPole = toPole - 1;
		if(poles[toPole].getNumberOfDisks() == poles[toPole].getMaxNumberOfDisks()){
			return false;
		}
		else{
			x = poles[fromPole].removeDisk();
		}
		if(x == null){
			return false;
		}
		else{
			return poles[toPole].addDisk(x);
		}
	}
	public void reset() {
		int max = poles[0].getMaxNumberOfDisks();
		boolean bull = true;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < poles[i].getMaxNumberOfDisks(); j++) {
				poles[i].removeDisk();
			}
		}
		for(int i=0; i<max; i++){
			int x = max-i;
			Disk disk = new Disk(x);
			poles[0].addDisk(disk);
		}
	}
}
