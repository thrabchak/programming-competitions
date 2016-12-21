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
#include <unordered_set>

#include <gtest/gtest.h>
  using ::testing::Test;

using namespace std;

struct Answers {
  int a;  //90
  int b;  //180
};

Answers createMatrix(int n) {
  std::vector<std::vector<int>> m(n);
  Answers ans;



  return ans;
};

int assess(Answers &ans, int angle) {
  angle %= 360;

  if(angle == 0) {
    return 0;
  } else if(angle == 90) {
    return ans.a;
  } else if(angle == 180) {
    return ans.b;
  } else if(angle == 270) {
    return ans.a;
  }
 
  cout << "unknown angle: " << angle << endl;
  return -1;
}

// Hackonacci Matrix Rotations
TEST(Assess, Test1) {
  Answers ans;
  ans.a = 1;
  ans.b = 2;

  EXPECT_EQ(assess(ans, 0), 0);
  EXPECT_EQ(assess(ans, 90), 1);
  EXPECT_EQ(assess(ans, 180), 2);
  EXPECT_EQ(assess(ans, 270), 1);

  EXPECT_EQ(assess(ans, 360), 0);
  EXPECT_EQ(assess(ans, 360 + 90), 1);
  EXPECT_EQ(assess(ans, 360 + 180), 2);
  EXPECT_EQ(assess(ans, 360 + 270), 1);
}

// Hackonacci Matrix Rotations
TEST(Hackonacci, Test1) {
  int n = 3;
  Answers ans = createMatrix(n);

  EXPECT_EQ(assess(ans, 90), 10);
  EXPECT_EQ(assess(ans, 180), 6);
  EXPECT_EQ(assess(ans, 270), 10);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
