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
  int a = 0;  // 90
  int b = 0;  // 180
};

bool hackIsOdd(unsigned long long x) {
  int m = x % 7;

  if(m == 0) {
    return true;
  } else if(m == 1) {
    return true;
  } else if(m == 2) {
    return false;
  } else if(m == 3) {
    return true;
  } else if(m == 4) {
    return false;
  } else if(m == 5) {
    return false;
  } else if(m == 6) {
    return true;
  } 

  cout << "error: " << m << endl;
  return false;
}

Answers fillAnswers(int n) {
  Answers ans;

  unsigned long long x = 0;
  unsigned long long y = 0;
  bool orig = false;

  for(int row = 1; row <= n; row++) {
    for(int col = 1; col <= n; col++) {
      // Determine if the current value is the same or different from the original value
      x = row * col;
      orig = hackIsOdd(x*x);

      // Rotate 90
      y = (row) * (n + 1 - col);
      if(orig != hackIsOdd(y*y))
        ans.a++;

      // Rotate 180
      y = (n + 1 - row) * (n + 1 - col);

      // cout <<  "---" << endl;
      // cout << "row " << row << endl;
      // cout << "col " << col << endl;
      // cout << "x " << (n + 1 - row) << endl;
      // cout << "y " << (n + 1 - col) << endl;

      if(orig != hackIsOdd(y*y))
        ans.b++;
    }
  }

  return ans;
}

int assessAngle(Answers &ans, int angle) {
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
TEST(AssessAngle, Test1) {
  Answers ans;
  ans.a = 1;
  ans.b = 2;

  EXPECT_EQ(assessAngle(ans, 0), 0);
  EXPECT_EQ(assessAngle(ans, 90), 1);
  EXPECT_EQ(assessAngle(ans, 180), 2);
  EXPECT_EQ(assessAngle(ans, 270), 1);

  EXPECT_EQ(assessAngle(ans, 360), 0);
  EXPECT_EQ(assessAngle(ans, 360 + 90), 1);
  EXPECT_EQ(assessAngle(ans, 360 + 180), 2);
  EXPECT_EQ(assessAngle(ans, 360 + 270), 1);
}
TEST(LongModulo, Test1) {
  unsigned long long x = 160000000000000;
  int y = x % 10;
  EXPECT_EQ(y, 0);
}

// Hackonacci Matrix Rotations
TEST(Hackonacci, Test1) {
  int n = 4;
  Answers ans = fillAnswers(n);

  EXPECT_EQ(assessAngle(ans, 90), 10);
  EXPECT_EQ(assessAngle(ans, 180), 6);
  EXPECT_EQ(assessAngle(ans, 270), 10);
  EXPECT_EQ(assessAngle(ans, 360), 0);
}
TEST(Hackonacci, Test2) {
  int n = 2000;
  Answers ans = fillAnswers(n);

  EXPECT_EQ(assessAngle(ans, 90), 1960244);
  EXPECT_EQ(assessAngle(ans, 180), 2449304);
  EXPECT_EQ(assessAngle(ans, 270), 1960244);
  EXPECT_EQ(assessAngle(ans, 360), 0);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
