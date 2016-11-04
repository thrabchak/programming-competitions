"""
Problem Statement
    
You are given an undirected tree. The tree has n vertices, numbered 0 through n-1. For each valid i, there is an edge between the vertices p[i] and (i+1). Each vertex i has a nonnegative integer weight x[i].  All nonempty connected subgraphs of our tree are called its subtrees. The value of a subtree is the bitwise OR of the weights of its vertices. For example, a subtree that contains vertices with weights 1, 4, and 6 has the value (1 OR 4 OR 6) = 7.  You are given the description of the tree: the tuple (integer)s p and x. Compute and return the sum of values of all subtrees, modulo 10^9 + 7.
Definition
    
Class:
SubtreeSum
Method:
getSum
Parameters:
tuple (integer), tuple (integer)
Returns:
integer
Method signature:
def getSum(self, p, x):

Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Stack limit (MB):
256
Constraints
-
n will be between 2 and 50, inclusive.
-
p will contain exactly n-1 elements.
-
For each i, 0 <= p[i] <= i.
-
x will contain exactly n elements.
-
Each element in x will be between 0 and 1,000,000,000, inclusive.
Examples
0)

    
{0}
{1,2}
Returns: 6
This is a tree with two vertices and a single edge 0-1. This tree has three subtrees:
A subtree that only contains the vertex 0.
A subtree that only contains the vertex 1.
A subtree that contains both vertices.
The values of these three subtrees are 1, 2, and 3. Hence, the correct return value is 1+2+3 = 6.
1)

    
{0,1}
{1,2,4}
Returns: 23
This tree has six subtrees. Their values are 1, 2, 4, 3, 6, and 7, respectively. The sum of these values is 23.
2)

    
{0,0,0,0,0,0,0,0,0,0}
{1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000}
Returns: 33999993
This tree has 1034 subtrees. Each of those subtrees has value 1,000,000. Hence, the sum of values of all subtrees is 1,034,000,000. We should return 1,034,000,000 modulo (10^9 + 7) = 33,999,993.
3)

    
{0,0,1,0,2,2,3,0,0,2,1}
{4,5,6,7,0,8,9,5,1,2,3,6}
Returns: 6378

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved."""

class SubtreeSum:
    def getSum(self, p, x):
        return 0

    def getAllSubsetsAsSet(self, nodes):
        set_of_frozensets = set()
        set_of_frozensets.add(frozenset(nodes))

        for i in range(len(nodes)):
            if i == 0:
                new_set = frozenset(nodes[1:])
            elif i == len(nodes) - 1:
                new_set = frozenset(nodes[:-1])
            else:
                new_set = frozenset(nodes[:i] + nodes[i+1:])
            set_of_frozensets.add(new_set)
        return set_of_frozensets

testclass = SubtreeSum()
print(testclass.getAllSubsetsAsSet([0,1]))
