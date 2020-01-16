import java.util.*;

public class DiskTester
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		Scanner inScan = new Scanner(System.in);
		int NUM_TRIES = 3;

		System.out.println("Test the constructor Disk(int)");
		System.out.println("==============================");

		for(int count = 0; count < NUM_TRIES; count++)
		{
			int diskSize = rand.nextInt(10) + 1;
			Disk aDisk = new Disk(diskSize);
			System.out.println("Constructing a Disk using the following statement:");
			System.out.println("  Disk aDisk = new Disk(" + diskSize + ");");
			Tester.checkInt(aDisk.getSize(), diskSize, "aDisk", "getSize()");
			Tester.checkToString(aDisk.toString(), "aDisk", inScan);
		}

		System.out.println("Test the constructor Disk(int, char, char)");
		System.out.println("==========================================");

		for(int count = 0; count < NUM_TRIES; count++)
		{
			int diskSize = rand.nextInt(10) + 1;
			char aDiskChar = (char) ('a' + rand.nextInt(26));
			char aPoleChar = (char) ('A' + rand.nextInt(26));
			Disk aDisk = new Disk(diskSize, aDiskChar, aPoleChar);
			System.out.println("Constructing a Disk using the following statement:");
			System.out.println("  Disk aDisk = new Disk(" + diskSize + ", '" + aDiskChar + "', '" + aPoleChar + "');");
			Tester.checkInt(aDisk.getSize(), diskSize, "aDisk", "getSize()");
			Tester.checkToString(aDisk.toString(), "aDisk", inScan);
		}

		System.out.println("Test constructing disks with negative values");
		System.out.println("============================================");

		for(int count = 0; count < NUM_TRIES; count++)
		{
			int diskSize = -rand.nextInt(10);
			Disk aDisk = new Disk(diskSize);
			System.out.println("Constructing a Disk using the following statement:");
			System.out.println("  Disk aDisk = new Disk(" + diskSize + ");");
			diskSize = 1;
			Tester.checkInt(aDisk.getSize(), diskSize, "aDisk", "getSize()");
			Tester.checkToString(aDisk.toString(), "aDisk", inScan);
		}

	}
}
