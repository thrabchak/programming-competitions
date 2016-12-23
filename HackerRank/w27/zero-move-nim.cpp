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

char isWinningGame(std::vector<int> piles) {
  int n = piles.size();
  return 'W';
}

TEST(ZeroMoveNim, Test1) {
  std::vector<int> piles {1, 2};
  EXPECT_EQ(isWinningGame(piles), 'W');

  piles = {2, 2};
  EXPECT_EQ(isWinningGame(piles), 'L');
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
