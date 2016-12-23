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

struct Bucket {
  int start;
  int end;
};

class BucketContainer {
public:
  BucketContainer() {};
  ~BucketContainer() {};

  int insert(int x) {
    std::list<Bucket>::iterator it;
    bool existingBucket = false;

    for (it = bucketList.begin(); it != bucketList.end(); ++it) {
      if(x < (*it).start - 1) {
        break;
      } else if(x == (*it).start - 1) {
        existingBucket = true;
        break;
      } else if(x <= (*it).end + 1) {
        existingBucket = true;
        break;
      }
    }

    if(!existingBucket) {
      Bucket b;
      b.start = x;
      b.end = x;
      bucketList.insert(it, b);
      return x;
    } else {
      if((*it).start - 1 == x) {
        (*it).start--;
        return x;
      } else {
        (*it).end++;
        int retval = (*it).end;

        std::list<Bucket>::iterator n = next(it);
        if(n != bucketList.end() && (*n).start - 1 <= (*it).end) {
          (*n).start = (*it).start;
          bucketList.erase(it);
        }
        return retval;
      }
    }
    return -1;// Should have returned by now
  };

  int size() {
    return bucketList.size();
  };

  list<Bucket> bucketList;
};

// Tailor Shop
int minButtons(int n, int p, vector<int> &v) {
  BucketContainer container;
  long int totalButtons = 0;

  for(int i = 0; i < n; i++) {
    int numButtonsInGroup = v[i] / p;
    if(v[i] % p != 0)
      numButtonsInGroup++;
    
    totalButtons += container.insert(numButtonsInGroup);
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

// Long tests
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
TEST(TailorShop, Test11) {
  int n = 100000;
  int p = 1;
  vector<int> v(100000, 100000);
  EXPECT_EQ(minButtons(n, p, v), 2115048112);
}
TEST(TailorShop, Test12) {
  int n = 100000;
  int p = 2;
  vector<int> v(100000, 100000);
  EXPECT_EQ(minButtons(n, p, v), 1410015408);
}

// Bucket container tests
TEST(BucketContainer, Test1) {
  BucketContainer c;

  // Insert distinct numbers
  EXPECT_EQ(c.insert(3), 3);
  EXPECT_EQ(c.insert(1), 1);
  EXPECT_EQ(c.insert(5), 5);
  EXPECT_EQ(c.size(), 3);


  EXPECT_EQ(c.insert(2), 2);
  EXPECT_EQ(c.size(), 2);

  EXPECT_EQ(c.insert(4), 4);
  EXPECT_EQ(c.size(), 1);

  // Insert duplicates
  EXPECT_EQ(c.insert(1), 6);
  EXPECT_EQ(c.size(), 1);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
