import java.util.Scanner;

public class Tester
{
	public static <T> void check(T value, T reference, String objectName, String methodName)
	{
		System.out.print("Checking the " + methodName + " method: ");
		if(value.equals(reference))
			System.out.println("PASS");
		else
		{
			System.out.println("FAILED");
			System.out.print("The " + objectName + "." + methodName + " method should return " + reference);
			System.out.println(" but your " + objectName + "." + methodName + " method returns " + value + ".");
			System.out.println("Fix this error first and try again.");
			System.exit(0);
		}
	}

	public static void checkTrue(boolean p, String objectName, String methodName)
	{
		check(new Boolean(p), new Boolean(true), objectName, methodName);
	}

	public static void checkFalse(boolean p, String objectName, String methodName)
	{
		check(new Boolean(p), new Boolean(false), objectName, methodName);
	}

	public static void checkInt(int num, int reference, String objectName, String methodName)
	{
		check(new Integer(num), new Integer(reference), objectName, methodName);
	}

	public static <T> void checkNull(T anObject, String objectName, String methodName)
	{
		System.out.print("Checking the " + methodName + " method: ");
		if(anObject == null)
			System.out.println("PASS");
		else
		{
			System.out.println("FAILED");
			System.out.print("The " + objectName + "." + methodName + " method should return null");
			System.out.println(" but your " + objectName + "." + methodName + " method returns " + anObject + ".");
			System.out.println("Fix this error first and try again.");
			System.exit(0);
		}
	}

	public static boolean getYN(Scanner aScanner)
	{
		String yn;

		while(true)
		{
			yn = aScanner.nextLine();
			if(yn.equals("y") || yn.equals("Y") || yn.equals("n") || yn.equals("N"))
				break;
			System.out.print("Invalid input....Enter only y or n: ");
		}

		if(yn.equals("y") || yn.equals("Y"))
			return true;
		else
			return false;
	}

	public static void checkToString(String aString, String objectName, Scanner aScanner)
	{
		System.out.println("Checking the toString() method:");
		System.out.println("The " + objectName + ".toString() return the following String:");
		System.out.println(aString);
		System.out.print("Does it look okay to you? (y/n): ");
		if(!getYN(aScanner))
		{
			System.out.println("Fix the toString() method first and try again.");
			System.exit(0);
		}
	}
}
