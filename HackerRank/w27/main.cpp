#include <iostream>
#include <gtest/gtest.h>
  using ::testing::Test;

using namespace std;

TEST(HelloWorldTest, Hello) {
  EXPECT_TRUE(true);
}

int main(int argc, char** argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}