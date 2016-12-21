#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

#include <gtest/gtest.h>
  using ::testing::Test;

using namespace std;

// Drawing book 
int requiredFlips(int n, int p) {

    int leftFlips = p/2;
    int rightFlipts = (n-p)/2;

    if (n % 2 == 0)
    {
        rightFlipts = (n-p+1)/2;
    }

    return min(leftFlips, rightFlipts);
}

TEST(DrawingBook, Test1) {
  EXPECT_EQ(requiredFlips(6, 2), 1);
}
TEST(DrawingBook, Test2) {
  EXPECT_EQ(requiredFlips(5, 4), 0);
}

TEST(DrawingBook, Test3) {
  EXPECT_EQ(requiredFlips(10, 1), 0);
}
TEST(DrawingBook, Test4) {
  EXPECT_EQ(requiredFlips(10, 2), 1);
}
TEST(DrawingBook, Test5) {
  EXPECT_EQ(requiredFlips(10, 3), 1);
}
TEST(DrawingBook, Test6) {
  EXPECT_EQ(requiredFlips(10, 4), 2);
}
TEST(DrawingBook, Test7) {
  EXPECT_EQ(requiredFlips(10, 5), 2);
}
TEST(DrawingBook, Test8) {
  EXPECT_EQ(requiredFlips(10, 6), 2);
}
TEST(DrawingBook, Test9) {
  EXPECT_EQ(requiredFlips(10, 7), 2);
}
TEST(DrawingBook, Test10) {
  EXPECT_EQ(requiredFlips(10, 8), 1);
}
TEST(DrawingBook, Test11) {
  EXPECT_EQ(requiredFlips(10, 9), 1);
}
TEST(DrawingBook, Test12) {
  EXPECT_EQ(requiredFlips(10, 10), 0);
}


TEST(DrawingBook, Test13) {
  EXPECT_EQ(requiredFlips(9, 1), 0);
}
TEST(DrawingBook, Test14) {
  EXPECT_EQ(requiredFlips(9, 2), 1);
}
TEST(DrawingBook, Test15) {
  EXPECT_EQ(requiredFlips(9, 3), 1);
}
TEST(DrawingBook, Test16) {
  EXPECT_EQ(requiredFlips(9, 4), 2);
}
TEST(DrawingBook, Test17) {
  EXPECT_EQ(requiredFlips(9, 5), 2);
}
TEST(DrawingBook, Test18) {
  EXPECT_EQ(requiredFlips(9, 6), 1);
}
TEST(DrawingBook, Test19) {
  EXPECT_EQ(requiredFlips(9, 7), 1);
}
TEST(DrawingBook, Test20) {
  EXPECT_EQ(requiredFlips(9, 8), 0);
}
TEST(DrawingBook, Test21) {
  EXPECT_EQ(requiredFlips(9, 9), 0);
}

TEST(DrawingBook, Test22) {
  EXPECT_EQ(requiredFlips(1, 1), 0);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
