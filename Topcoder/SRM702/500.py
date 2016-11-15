class GridSort(object):
    
    def sort(self, n, m, grid):
        print("n:" + str(n))
        print("m:" + str(m))


        possible = "Possible"
        impossible = "Impossible"
        if n == 1 or m == 1: 
            return possible

        pattern = []
        for i in range(n):

            if i == 0:
                for j in range(1, m):
                    prev = grid[i*m+j-1]
                    curr = grid[i*m+j]
                    if  prev > curr:
                        pattern.append(1)
                    else:
                        pattern.append(0)

            print(pattern)

            vals = []
            for j in range(1, m):
                value = grid[i*m+j]
                vals.append(value)

                prev = grid[i*m+j-1]
                curr = grid[i*m+j]

                if (prev > curr and pattern[j-1] != 1) or (prev < curr and pattern[j-1] != 0):
                    return impossible

            print("vals" + str(vals))
            div = (vals[0] - 1)//m
            print(div)
            for j in range(1, len(vals)):
                if (vals[j] - 1) // m != div:
                    return impossible

        return possible

gridSort = GridSort()


assert gridSort.sort(2, 2, ( 1, 4, 3, 2)) == "Impossible"
assert gridSort.sort(2, 2, ( 1, 2, 3, 4)) == "Possible"
assert gridSort.sort(2, 2, ( 3, 4, 1, 2)) == "Possible"
assert gridSort.sort(2, 2, ( 4, 3, 1, 2)) == "Impossible"
assert gridSort.sort(1, 10, (4,5,1,2,9,8,3,10,7,6)) == "Possible"
assert gridSort.sort(3, 5, ( 10,6,8,9,7,5,1,3,4,2,15,11,13,14,12) ) == "Possible"
assert gridSort.sort(6, 2,(11,12, 2,1, 9,10, 7,8, 6,5, 3,4)) == "Impossible"
assert gridSort.sort(3, 5, ( 10,6,8,9,7,5,1,3,4,2,15,11,13,12,14) ) == "Impossible"
assert gridSort.sort(2, 3, ( 1, 2, 3, 4, 5, 6)) == "Possible"
assert gridSort.sort(2, 3, ( 2, 3, 5, 4, 5, 6)) == "Impossible"
