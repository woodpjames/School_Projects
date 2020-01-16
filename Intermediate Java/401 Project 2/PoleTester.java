import java.util.*;

public class PoleTester
{
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		Random rand = new Random();
		int NUM_TRIES = 3;

		System.out.println("Test the constructor Pole(int)");
		System.out.println("==============================");

		for(int count = 0; count < NUM_TRIES; count++)
		{
			int numDisks = rand.nextInt(10) + 1;
			Pole aPole = new Pole(numDisks);
			System.out.println("Constructing a Pole using the following statement:");
			System.out.println("  Pole aPole = new Pole(" + numDisks + ");");
			Tester.checkInt(aPole.getMaxNumberOfDisks(), numDisks, "aPole", "getMaxNumberOfDisks()");
			Tester.checkInt(aPole.getMaxDiskSize(), numDisks, "aPole", "getMaxDiskSize()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");
			Tester.checkNull(aPole.peekTopDisk(), "aPole", "peekTopDisk()");
			Tester.checkToString(aPole.toString(), "aPole", inScan);

			Disk[] disks = new Disk[numDisks];
			for(int i = 0; i < numDisks; i++)
			{
				disks[i] = new Disk(1);
				System.out.println("Adding a disk");
				Tester.checkTrue(aPole.addDisk(disks[i]), "aPole", "addDisk()");
				Tester.checkInt(aPole.getNumberOfDisks(), i + 1, "aPole", "getNumberOfDisks()");
			}
			System.out.println("Adding a disk (pole is filled)");
			Tester.checkFalse(aPole.addDisk(new Disk(1)), "aPole", "addDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), numDisks, "aPole", "getNumberOfDisks()");

			for(int i = numDisks - 1; i >= 0; i--)
			{
				System.out.println("Removing a disk");
				Tester.check(aPole.removeDisk(), disks[i], "aPole", "removeDisk()");
				Tester.checkInt(aPole.getNumberOfDisks(), i, "aPole", "getNumberOfDisks()");
			}
			System.out.println("Removing a disk (pole is empty)");
			Tester.checkNull(aPole.removeDisk(), "aPole", "removeDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");

			System.out.println("Adding a disk that is too large");
			Tester.checkFalse(aPole.addDisk(new Disk(numDisks + 1)), "aPole", "addDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");

			System.out.println();
		}

		System.out.println("Test the constructor Pole(int, int)");
		System.out.println("===================================");

		for(int count = 0; count < NUM_TRIES; count++)
		{
			int numDisks = rand.nextInt(10) + 1;
			int maxSize = rand.nextInt(10) + 1;
			Pole aPole = new Pole(numDisks, maxSize);
			System.out.println("Constructing a Pole using the following statement:");
			System.out.println("  Pole aPole = new Pole(" + numDisks + "," + maxSize + ");");
			Tester.checkInt(aPole.getMaxNumberOfDisks(), numDisks, "aPole", "getMaxNumberOfDisks()");
			Tester.checkInt(aPole.getMaxDiskSize(), maxSize, "aPole", "getMaxDiskSize()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");
			Tester.checkNull(aPole.peekTopDisk(), "aPole", "peekTopDisk()");
			Tester.checkToString(aPole.toString(), "aPole", inScan);

			Disk[] disks = new Disk[numDisks];
			for(int i = 0; i < numDisks; i++)
			{
				disks[i] = new Disk(rand.nextInt(maxSize) + 1);
				System.out.println("Adding a disk");
				Tester.checkTrue(aPole.addDisk(disks[i]), "aPole", "addDisk()");
				Tester.checkInt(aPole.getNumberOfDisks(), i + 1, "aPole", "getNumberOfDisks()");
			}
			System.out.println("Adding a disk (pole is filled)");
			Tester.checkFalse(aPole.addDisk(new Disk(1)), "aPole", "addDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), numDisks, "aPole", "getNumberOfDisks()");

			for(int i = numDisks - 1; i >= 0; i--)
			{
				System.out.println("Removing a disk");
				Tester.check(aPole.removeDisk(), disks[i], "aPole", "removeDisk()");
				Tester.checkInt(aPole.getNumberOfDisks(), i, "aPole", "getNumberOfDisks()");
			}
			System.out.println("Removing a disk (pole is empty)");
			Tester.checkNull(aPole.removeDisk(), "aPole", "removeDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");

			System.out.println("Adding a disk that is too large");
			Tester.checkFalse(aPole.addDisk(new Disk(maxSize + 1)), "aPole", "addDisk()");
			Tester.checkInt(aPole.getNumberOfDisks(), 0, "aPole", "getNumberOfDisks()");

			System.out.println();
		}
	}
}
