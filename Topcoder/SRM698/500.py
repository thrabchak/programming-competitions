"""
Problem Statement
    
A string S is called a square if there is some string T such that S = T + T. For example, the strings "", aabaab" and "xxxx" are squares, but "a", "aabb" and "aabbaa" are not.  You are given a string s. Find the longest square string that can be obtained from s by erasing some (possibly none, possibly all) of its characters. In other words, we are looking for the longest square that occurs in s as a subsequence. Return the length of that square.  Note that the answer is well-defined, as the square "" (the empty string) will always occur in s as a subsequence.
Definition
    
Class:
RepeatStringEasy
Method:
maximalLength
Parameters:
string
Returns:
integer
Method signature:
def maximalLength(self, s):

Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
s will contain between 1 and 50 characters, inclusive.
-
Each character in s will be a lowercase English letter ('a'-'z').
Examples
0)

    
"frankfurt"
Returns: 4
The longest square that occurs in "frankfurt" is "frfr". Its length is 4.
1)

    
"single"
Returns: 0
The letters in the string "single" are all distinct. Hence, the only square that occurs in this string is "". The length of this square is zero.
2)

    
"singing"
Returns: 6

3)

    
"aababbababbabbbbabbabb"
Returns: 18

4)

    
"x"
Returns: 0

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.


    def maximalLength2(self, s):
        if self.isSquare(s):
            return len(s)
        else:
            sub_list = []
            for i in range(len(s)):
                new_str = ""
                if i == 0:
                    new_str = s[1:]
                elif i == len(s) - 1:
                    new_str = s[:-1]
                else:
                    new_str = s[:i] + s[i+1:]
                val = self.maximalLength(new_str)
                if val == len(s) - 1:
                    return val
                sub_list.append(val)
            return max(sub_list)
        return 0

"""
from collections import deque

class RepeatStringEasy:

    def maximalLength(self, s):
        queue = deque()
        queue.append(s)
        while len(queue) > 0:
            test_string = queue.popleft()
            if self.isSquare(test_string):
                return len(test_string)
            else:
                for i in range(len(test_string)):
                    new_str = ""
                    if i == 0:
                        new_str = test_string[1:]
                    elif i == len(test_string) - 1:
                        new_str = test_string[:-1]
                    else:
                        new_str = test_string[:i] + test_string[i+1:]
                    queue.append(new_str)
        return 0

    def isSquare(self, s):
        if len(s) % 2 == 1:
            return False
        for i in range(len(s)//2):
            if s[i] != s[len(s)//2+i]:
                return False
        return True

testclass = RepeatStringEasy()

assert testclass.isSquare("")
assert False == testclass.isSquare("a")
assert testclass.isSquare("abab")
assert True == testclass.isSquare("aa")
assert False == testclass.isSquare("ababa")


assert( testclass.maximalLength("frankfurt") == 4)
assert( testclass.maximalLength("single") == 0)
assert( testclass.maximalLength("x") == 0)

assert( testclass.maximalLength("singing") == 6)

assert( testclass.maximalLength("aababbababbabbbbabbabb") == 18)



