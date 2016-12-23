cmake_minimum_required(VERSION 3.6.2)

project(w27)

set(CMAKE_CXX_FLAGS "-g -Wall")
set (CMAKE_CXX_STANDARD 11)

add_subdirectory(../../googletest ${CMAKE_BINARY_DIR}/googletest)

option(BUILD_GTEST "Builds the googletest subproject" ON)
option(BUILD_GMOCK "Builds the googlemock subproject" OFF)

add_executable(drawingBook drawing-book.cpp)
target_link_libraries(drawingBook gtest)

add_executable(tailorShop tailor-shop.cpp)
target_link_libraries(tailorShop gtest)

add_executable(hackonacciMatrixRotations hackonacci-matrix-rotations.cpp)
target_link_libraries(hackonacciMatrixRotations gtest)

add_executable(zeroMoveNim zero-move-nim.cpp)
target_link_libraries(zeroMoveNim gtest)
