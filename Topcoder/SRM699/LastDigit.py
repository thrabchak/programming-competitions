"""Problem Statement
Limak chose a positive integer X and wrote it on a blackboard. After that, every day he erased the last digit of the current number. He stopped when he erased all digits. 

After the process was over, Limak computed the sum of all numbers that appeared on the blackboard, including the original number X. 

For example, if the original number was 509, the numbers that appeared on the blackboard were the numbers 509, 50, and 5. Their sum is 564. 

You are given a S. Limak wants you to find a number X such that the above process produces the sum S. It can be shown that for any positive S there is at most one valid X. If there is a valid X, find and return it. Otherwise, return -1.
Definition
Class: LastDigit
Method: findX
Parameters: long integer
Returns: long integer
Method signature: def findX(self, S):
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- S will be between 1 and 10^18, inclusive.
Examples
0)
5 4
Returns: 509
This is the example from the problem statement. The value X = 509 produces the sum 564, as shown above.
1)
565
Returns: -1
There is no X for which the sum would be 565.
2)
3000
Returns: 2701
You can check that 2701 + 270 + 27 + 2 = 3000.
3)
137174210616796
Returns: 123456789555123
4)
837592744927492746
Returns: -1
5)
999999999999999999
Returns: 900000000000000000
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved."""

class LastDigit(object):
  
  def findX(self, S):
    if S < 0:
      return -1

    queue = Queue()
    for d in str(S):
      i = int(d)

      

    pass