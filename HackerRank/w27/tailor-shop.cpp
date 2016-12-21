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

// Tailor Shop
int minButtons(int n, int p, vector<int> &v) {
  vector<int> buttonVector(150015000,-1);
  long int totalButtons = 0;

  for(int i = 0; i < n; i++) {
    long int numButtonsInGroup = v[i] / p;
    if(v[i] % p != 0)
      numButtonsInGroup++;

    if(buttonVector[numButtonsInGroup] != -1) {
      //size is in map - follow trail
      while(buttonVector[++numButtonsInGroup] != -1);
    }

    buttonVector[numButtonsInGroup] = numButtonsInGroup+1;
    totalButtons += numButtonsInGroup;
  }

  return totalButtons;
}

TEST(TailorShop, Test1) {
  int n = 3;
  int p = 2;
  vector<int> v;
  v.push_back(4);
  v.push_back(6);
  v.push_back(6);
  EXPECT_EQ(minButtons(n, p, v), 9);
}
TEST(TailorShop, Test2) {
  int n = 2;
  int p = 3;
  std::vector<int> v;
  v.push_back(4);
  v.push_back(5);
  EXPECT_EQ(minButtons(n, p, v), 5);
}

TEST(TailorShop, Test3) {
  int n = 2;
  int p = 3;
  vector<int> v;
  v.push_back(4);
  v.push_back(6);
  EXPECT_EQ(minButtons(n, p, v), 5);
}
TEST(TailorShop, Test4) {
  int n = 2;
  int p = 3;
  vector<int> v;
  v.push_back(4);
  v.push_back(7);
  EXPECT_EQ(minButtons(n, p, v), 5);
}
TEST(TailorShop, Test5) {
  int n = 2;
  int p = 3;
  vector<int> v;
  v.push_back(4);
  v.push_back(2);
  EXPECT_EQ(minButtons(n, p, v), 3);
}
TEST(TailorShop, Test6) {
  int n = 5;
  int p = 3;
  vector<int> v;
  v.push_back(1); //1
  v.push_back(2); //3
  v.push_back(3); //6
  v.push_back(4); //10
  v.push_back(5); //15
  EXPECT_EQ(minButtons(n, p, v), 15);
}
TEST(TailorShop, Test7) {
  int n = 2;
  int p = 3;
  vector<int> v;
  v.push_back(4);
  v.push_back(5);
  EXPECT_EQ(minButtons(n, p, v), 5);
}

//Long tests
TEST(TailorShop, Test8) {
  int n = 10000;
  int p = 1;
  vector<int> v(10000, 10000);
  EXPECT_EQ(minButtons(n, p, v), 149995000);
}
TEST(TailorShop, Test9) {
  int n = 10000;
  int p = 10000;
  vector<int> v(10000, 10000);
  EXPECT_EQ(minButtons(n, p, v), 50005000);
}
TEST(TailorShop, Test10) {
  int n = 5000;
  int p = 1;
  vector<int> v(5000, 5000);
  EXPECT_EQ(minButtons(n, p, v), 37497500);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
