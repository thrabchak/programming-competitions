import java.util.Scanner;
 
class LAPIN {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for(int i=0; i<num;i++){
		if (test(in.next()))
			System.out.println("YES");
		else
			System.out.println("NO"); 
		}
		in.close();
	}
	
	public static boolean test(String str){
		int arr[] = new int[26];
		int arr2[] = new int[26];
		str=str.toLowerCase();
		int i;
		char temp;
		for ( i=0; i<(str.length()/2);i++){
			temp = str.charAt(i);
			arr[temp-97]++;
		}
		if (str.length()%2!=0){
			i++;
		}
		for ( ; i<str.length();i++){
			temp = str.charAt(i);
			arr2[temp-97]++;
			}
		for (i=0; i<26;i++){
			if ( arr[i]!= arr2[i])
				return false;
			}
				return true;
		}
} 