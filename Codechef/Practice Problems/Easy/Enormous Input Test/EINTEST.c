#include <stdio.h>

/**
Thomas Hrabchak
6/2/13

Link: http://www.codechef.com/problems/INTEST 

The purpose of this problem is to verify whether the method you are using to read input data is sufficiently fast to handle problems branded with the enormous Input/Output warning. You are expected to be able to process at least 2.5MB of input data per second at runtime.
Input
The input begins with two positive integers n k (n, k<=10^7). The next n lines of input contain one positive integer ti, not greater than 109, each.
Output
Write a single integer to output, denoting how many integers ti are divisible by k.
Example
Input:
7 3
1
51
966369
7
9
999996
11

Output:
4


*/

int main(void)
{
	int n;
	int k;
	int i; 
	int x;
	int sum = 0;

	scanf("%d", &n);
	scanf("%d", &k);

	for(i = 0; i < n; i++){
		scanf("%d", &x);
		if((x % k) == 0){
			sum++;
		}	
	}
	
	printf("%d\n",sum);

	return 0;
}

