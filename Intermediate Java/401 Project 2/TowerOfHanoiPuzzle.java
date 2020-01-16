import java.lang.Math;
import java.util.*;
public class TowerOfHanoiPuzzle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int playOrExit;
		int numOfDisks;
		char readyToPlay;
		boolean stay = true;
		int movesSoFar;
		int moveFrom;
		int moveTo;
		int minMoves;
		boolean gameComplete = false;
		do{
			do{
				System.out.println("Welcome to Tower of Hanoi Puzzle\nTake a pick:\n1) Play a Tower of Hanoi Puzzle\n2) Exit");
				playOrExit = scan.nextInt();
			} while(playOrExit!=1 && playOrExit!=2);
			if(playOrExit == 1) {
				do{
					System.out.print("How many disks would you like to play (between 1 and 64):");
					numOfDisks = scan.nextInt();
				} while(numOfDisks>64 || numOfDisks<1);
				TowerOfHanoi toh = new TowerOfHanoi(numOfDisks);
				System.out.println(toh.toString());
				minMoves = (int) Math.pow(2, numOfDisks)-1;
				do{
					System.out.println("The goal is to move all " + numOfDisks + " disks from pole 1 to pole 3\n"
					+ "The least number of moves for " + numOfDisks + " disks is " + minMoves + ".\n"
					+ "Are you ready to play? (y/n):");
					readyToPlay = scan.next().charAt(0);
				}while(readyToPlay!='y' && readyToPlay!='n');
				if(readyToPlay == 'y') {
					movesSoFar = 0;
					gameComplete = false;
					while(!gameComplete) {
						do{
							System.out.println(toh.toString());
							System.out.println("Number of Moves: " + movesSoFar + "\n"
							+ "Enter <from><space><to> to move a disk:");
							moveFrom = scan.nextInt();
							moveTo = scan.nextInt();
							movesSoFar++;
						}while((moveFrom!=1&&moveFrom!=2&&moveFrom!=3)||(moveTo!=1&&moveTo!=2&&moveTo!=3));
						if((toh.peekTopDisk(moveTo)==null)||(toh.peekTopDisk(moveFrom).getSize() < toh.peekTopDisk(moveTo).getSize())) {
							toh.move(moveFrom, moveTo);
						}
						else{
							System.out.println("You cannot move the top disk from pole " + moveFrom + " to pole "
							+ moveTo + "." + "\n"
							+ "The top disk of pole" + moveFrom + "is larger than the top disk of pole " + moveTo + ".");
						}
						if(toh.peekTopDisk(1) == null && toh.peekTopDisk(2) == null){
							System.out.println(toh.toString());
							minMoves = (int) Math.pow(2, numOfDisks)-1;
							gameComplete = true;
							System.out.println("Congratulation!!!" + "\n" + "Number of Moves: " + movesSoFar
							+ "\nThe least number of moves for " + numOfDisks + " disks is " + minMoves + ".\n");
						}
					}
				}
			}
			else{stay = false;}
		} while(stay == true);
	}
}
