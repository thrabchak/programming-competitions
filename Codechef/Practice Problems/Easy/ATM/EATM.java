import java.util.Scanner;

/**
 * Solution to Codechef problem
 * 
 * LINK: http://www.codechef.com/problems/HS08TEST
 * 
 * @author Tom Hrabchak
 *
 */
public class EATM {
	final static double FEE = 0.50;

	/**
	 * Main method
	 * 
	 * @param args null 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int withdraw = sc.nextInt();
		double balance = sc.nextDouble();
		double temp = balance - (withdraw + FEE);
		
		if(temp >= 0 && withdraw%5==0)
			System.out.printf("%.2f", temp);
		else
			System.out.printf("%.2f", balance);
		sc.close();
		
	}

}
