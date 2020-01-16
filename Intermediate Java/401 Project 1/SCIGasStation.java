import java.util.*;

public class SCIGasStation {
	public static void main(String[] args) {
			Scanner inscan = new Scanner(System.in);
			Random rand = new Random();
			double randomnumber = (rand.nextDouble()*10)+10;
			double total = 0.0;
			int ans;
			int gas = 0;
			int wash = 0;
			String confirm;
			double change;
			Boolean continueProgram = true;
		while(continueProgram){
			wash = 0;
			gas = 0;
			ans = welcome();
			if(ans != 3){
				if(ans == 1){
					gas = gas(ans);
				}

				else if(ans == 2){
					wash = wash();
					if(wash != 5){
						gas = gas(ans);
					}
				}
				if(wash!=5 && gas!=5){
					summary(ans, gas, wash);
					System.out.println("Confirm Your Order? (y/n)");
					confirm = inscan.nextLine();
					while(!confirm.equals("y") && !confirm.equals("n")){
						System.out.println("Invalid Response!");
						System.out.println("Confirm Your Order? (y/n)");
						confirm = inscan.nextLine();
					}

					if(confirm.equals("y")){
						System.out.printf("It took %.2f gallons to fill up your car. \n", randomnumber);
						total = calculator(ans, gas, wash, randomnumber);
						System.out.printf("Your total is $%.2f.\n", total );
						change = payment(total);
						change(change, total);
					}
				}
			}
			if(ans == 3){
				continueProgram = false;
			}
		}
	}
	public static int welcome(){
		Scanner inscan = new Scanner(System.in);
		int ans;
		System.out.println("Welcome to SCI Gas Station!!!");
		System.out.println("Please choose your service:");
		System.out.println("1) Gas only");
		System.out.println("2) Gas with car wash (10c off per gallon up to 15 gallons)");
		System.out.println("3) Exit");
		ans = inscan.nextInt();

		while(ans != 1 && ans != 2 && ans != 3) {
			System.out.println("Invalid Option!!!");
			System.out.println("Please choose your service:");
			System.out.println("1) Gas only");
			System.out.println("2) Gas with car wash (10c off per gallon up to 15 gallons)");
			System.out.println("3) Exit");
			ans = inscan.nextInt();
		}
		return ans;
	}

	public static int gas(int i){
		Scanner inscan = new Scanner(System.in);
		int gas = 0;
		if(i == 1)
		{
			System.out.println("Please select a gasoline type:");
			System.out.println("1) 87 ($2.59 per gallon)");
			System.out.println("2) 89 ($2.69 per gallon)");
			System.out.println("3) 91 ($2.84 per gallon)");
			System.out.println("4) 94 ($2.99 per gallon)");
			System.out.println("5) Cancel");
			gas = inscan.nextInt();
			while(gas != 1 && gas != 2 && gas != 3 && gas != 4 && gas != 5) {
				System.out.println("Invalid Option!!!");
				System.out.println("Please select a gasoline type:");
				System.out.println("1) 87 ($2.59 per gallon)");
				System.out.println("2) 89 ($2.69 per gallon)");
				System.out.println("3) 91 ($2.84 per gallon)");
				System.out.println("4) 94 ($2.99 per gallon)");
				System.out.println("5) Cancel");
				gas = inscan.nextInt();
			}
		}

		else if(i == 2)
		{
			System.out.println("Please select a gasoline type");
			System.out.println("1) 87 ($2.49 per gallon up to 15 gallons)");
			System.out.println("2) 89 ($2.59 per gallon up to 15 gallons)");
			System.out.println("3) 91 ($2.74 per gallon up to 15 gallons)");
			System.out.println("4) 94 ($2.89 per gallon up to 15 gallons)");
			System.out.println("5) Cancel");
			gas = inscan.nextInt();
			while(gas != 1 && gas != 2 && gas != 3 && gas != 4 && gas != 5) {
				System.out.println("Invalid Option!!!");
				System.out.println("Please select a gasoline type");
				System.out.println("1) 87 ($2.49 per gallon up to 15 gallons)");
				System.out.println("2) 89 ($2.59 per gallon up to 15 gallons)");
				System.out.println("3) 91 ($2.74 per gallon up to 15 gallons)");
				System.out.println("4) 94 ($2.89 per gallon up to 15 gallons)");
				System.out.println("5) Cancel");
				gas = inscan.nextInt();
			}
		}
		return gas;
	}

	public static int wash(){
		Scanner inscan = new Scanner(System.in);
		int wash;
		System.out.println("Please select a type of car wash:");
		System.out.println("1) Basic ($5.00)");
		System.out.println("2) Shine ($7.00)");
		System.out.println("3) Deluxe ($9.00)");
		System.out.println("4) Premium ($11.00)");
		System.out.println("5) Cancel");
		wash = inscan.nextInt();
		while(wash != 1 && wash != 2 && wash != 3 && wash != 4 && wash != 5) {
			System.out.println("Invalid Option!!!");
			System.out.println("Please select a type of car wash:");
			System.out.println("1) Basic ($5.00)");
			System.out.println("2) Shine ($7.00)");
			System.out.println("3) Deluxe ($9.00)");
			System.out.println("4) Premium ($11.00)");
			System.out.println("5) Cancel");
			wash = inscan.nextInt();
		}
		return wash;
	}

	public static void summary(int i, int g, int w){
		System.out.println("You order is as follows:");
		if(i == 1){
			if(g == 1){System.out.println("1. A full tank of gas 87 ($2.59 per gallon)");}
			else if(g == 2){System.out.println("1. A full tank of gas 89 ($2.69 per gallon)");}
			else if(g == 3){System.out.println("1. A full tank of gas 91 ($2.84 per gallon)");}
			else if(g == 4){System.out.println("1. A full tank of gas 93 ($2.99 per gallon)");}
			else if(g == 5){}
		}

		else if(i == 2){
			if(g == 1){System.out.println("1. A full tank of gas 87 ($2.49 per gallon up to 15 gallons)");}
			else if(g == 2){System.out.println("1. A full tank of gas 89 ($2.59 per gallon up to 15 gallons)");}
			else if(g == 3){System.out.println("1. A full tank of gas 91 ($2.74 per gallon up to 15 gallons)");}
			else if(g == 4){System.out.println("1. A full tank of gas 94 ($2.89 per gallon up to 15 gallons)");}
			else if(g == 5){}

			if (w == 1){System.out.println("2. Basic ($5.00)");}
			else if (w == 2){System.out.println("2. Shine ($7.00)");}
			else if (w == 3){System.out.println("2. Deluxe car wash ($9.0)");}
			else if (w == 4){System.out.println("2. Premium ($11.00)");}
			else if (w == 5){}
		}
	}

	public static double calculator(int ans, int gas, int wash, double randomnumber){
		double total = 0.0;
		double price = 0.0;
		if(wash == 0)
		{
			if(gas == 1){price = 2.59;}
			else if(gas == 2){price = 2.69;}
			else if(gas == 3){price = 2.84;}
			else if(gas == 4){price = 2.99;}
			total = randomnumber * price;
		}
		else if(wash > 0){
			if(randomnumber <= 15.0){
				if(gas == 1){price = 2.49;}
				else if(gas == 2){price = 2.59;}
				else if(gas == 3){price = 2.74;}
				else if(gas == 4){price = 2.89;}
				total = randomnumber * price;
			}
			else if(randomnumber > 15.0){
				if(gas == 1){price = 2.49;}
				else if(gas == 2){price = 2.59;}
				else if(gas == 3){price = 2.74;}
				else if(gas == 4){price = 2.89;}
				total = 15.0 * price;
				price = price + .10;
				total = total + ((randomnumber - 15.0)*price);
			}
		}

		if(wash==1){total = total + 5.00;}
		else if(wash==2){total = total + 7.00;}
		else if(wash==3){total = total + 9.00;}
		else if(wash==4){total = total + 11.00;}
		return total;
	}

	public static double payment(double total){
		Scanner inscan = new Scanner(System.in);
		int numberOfBills;
		String typeOfBills;
		double originalTotal = total;
		System.out.println("Please enter a payment amount in the following format:");
		System.out.println("<amount><space><type>");
		System.out.println("Where <amount> is an integer");
		System.out.println("      <space> is a blank space");
		System.out.println("      <type> is either 20s, 10s, 5s, or 1s");
		System.out.println("You may enter as many times as you like. Each entry will be");
		System.out.println("added to your total until sufficient funds have been obtained.");
		while(total > 0){
			System.out.print("Enter your payment:");
			numberOfBills = inscan.nextInt();
			typeOfBills = inscan.nextLine();
			double previousTotal = total;
			if(typeOfBills.equals(" 20s")){
				total = (double) total - (20*numberOfBills);
			}
			else if(typeOfBills.equals(" 10s")){
				total = (double) total - (10*numberOfBills);
			}
			else if(typeOfBills.equals(" 5s")){
				total = (double) total - (5*numberOfBills);
			}
			else if(typeOfBills.equals(" 1s")){
				total = (double) total - (numberOfBills);
			}
			System.out.printf("	You have added %.2f to your total. \n", (previousTotal - total));
			System.out.printf("	You have paid $%.2f out of %.2f. \n", (originalTotal - total), originalTotal);
			if(total>0){System.out.printf("	You still owe %.2f.\n", total);}
		}
		total = total * -1;
		return total;
	}

	public static void change(double change, double total){
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int one = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		double amount = change;

		twenty = (int) amount/20;
		amount = amount - 20*twenty;
		ten = (int) amount/10;
		amount = amount - 10*ten;
		five = (int) amount/5;
		amount = amount - 5*five;
		one = (int) amount/1;
		amount = amount - 1*one;
		quarter = (int) (amount*100) / 25;
		amount = amount - .25*quarter;
		dime = (int) (amount*100) / 10;
		amount = amount - .10*dime;
		nickel = (int) (amount*100) / 5;
		amount = amount - .05*nickel;
		penny = (int) (amount* 100) / 1;
		amount = amount - .01*penny;

		System.out.printf("Your change is %.2f. \n", change);
		if(twenty > 0){
			if(twenty==1){System.out.println(twenty + " twenty-dollar bill.");}
			else{System.out.println(twenty + " twenty-dollar bills.");}
		}
		if(ten > 0){
			if(ten==1){System.out.println(ten + " ten-dollar bill.");}
			else{System.out.println(ten + " ten-dollar bills.");}
		}
		if(five > 0){
			if(five==1){System.out.println(five + " five-dollar bill.");}
			else{System.out.println(five + " five-dollar bills.");}
		}
		if(one > 0){
			if(one==1){System.out.println(one + " one-dollar bill.");}
			else{System.out.println(one + " one-dollar bills.");}
		}
		if(quarter > 0){
			if(quarter==1){System.out.println(quarter + " quarter.");}
			else{System.out.println(quarter + " quarters.");}
		}
		if(dime > 0){
			if(dime==1){System.out.println(dime + " dime.");}
			else{System.out.println(dime + " dimes.");}

		}
		if(nickel > 0){
			if(nickel==1){System.out.println(nickel + " nickel.");}
			else{System.out.println(nickel + " nickels.");}

		}
		if(penny > 0){
			if(penny==1){System.out.println(penny + " penny.");}
			else{System.out.println(penny + " pennies.");}
		}
		System.out.println("Thank you for shopping at SCI gas station");
	}
}
