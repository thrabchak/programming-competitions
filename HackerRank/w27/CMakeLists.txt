cmake_minimum_required(VERSION 3.6.2)

project(w27)

set(CMAKE_CXX_FLAGS "-g -Wall")

add_subdirectory(../../googletest ${CMAKE_BINARY_DIR}/googletest)

option(BUILD_GTEST "Builds the googletest subproject" ON)
option(BUILD_GMOCK "Builds the googlemock subproject" OFF)

add_executable(unitTests main.cpp)

target_link_libraries(unitTests gtest)
