import java.util.Scanner;

/**
 * Solution to Codechef problem
 * 
 * LINK: http://www.codechef.com/problems/TEST
 * 
 * @author Tom Hrabchak
 *
 */
public class ELifeTheUniverse {

	/**
	 * Main method
	 * 
	 * @param args null
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		int i;
		
		while(isRunning){
			i = sc.nextInt();
			if(i==42)
				isRunning = false;
			else
				System.out.println(i);
			
		}
		sc.close();

	}

}
