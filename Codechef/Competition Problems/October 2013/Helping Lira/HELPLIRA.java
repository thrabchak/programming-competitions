import java.util.Scanner;

/*
 * Solution to Codechef Problem
 * 
 * Link: http://www.codechef.com/OCT13/problems/HELPLIRA
 * 
 * @author Tom Hrabchak
 * 
 */
class HELPLIRA {

	/**
	 * Main method
	 * 
	 * @param args null 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		double biggestValue = -1;
		int biggestI = -1;
		double smallestValue = -1;
		int smallestI = -1;
		
		for(int i = 1; i <= numLines; i++){	
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			
			double area = Math.abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2);
			
			//smallest
			if(smallestValue == -1 || area <= smallestValue){
				smallestI = i;
				smallestValue = area;
			}
			//biggest
			if(biggestValue == -1 || area >= biggestValue){
				biggestI = i;
				biggestValue = area;
			}
		}
		
		System.out.println(smallestI + " " + biggestI);
		
		sc.close();	
	}

}
