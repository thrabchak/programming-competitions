class XMarksTheSpot:
    def countArea(self, board):
        boards = getAllBoards(board)
        total = 0
        for b in boards:
            total += getPossibleSquares(b)
        return total

def getAllBoards(board):
    """Takes in a seed board and returns a list of all possible complete boards, with no '?' tiles"""
    for row_i in len(board):
        for col_i in len(board[0]):
            if board[row_i][col_i] == '?':
                b1 = list(board)
                b1[row_i][col_i] = '.'
                b2 = list(board)
                b2[row_i][col_i] = "O"
                return [getAllBoards(b1)] + [getAllBoards(b2)]
    return [board]

def getPossibleSquares(board):
    t = findTop(board)
    b = findBottom(board)
    l = findLeft(board)
    r = findRight(board)

    return getNumTiles(t, b, l, r)

def getNumTiles(t, b, l, r):
    return (b-t+1)*(r-l+1)

def findTop(board):
    row_i = 0
    for row in board:
        for tile in row:
            if tile == 'O':
                return row_i
        row_i += 1
    return 0

def findBottom(board):
    botMost = 0

    row_i = 0
    for row in board:
        for tile in row:
            if tile == 'O':
                botMost = row_i
        row_i += 1

    if botMost == 0:
        return len(board)-1
    return botMost

def findLeft(board):
    leftMost = 51

    row_i = 0
    for row in board:
        col_i = 0
        for tile in row:
            if tile == 'O':
                if col_i < leftMost:
                    leftMost = col_i
            col_i += 1
        row_i += 1

    if leftMost == 51:
        return 0
    return leftMost

def findRight(board):
    rightMost = 0

    row_i = 0
    for row in board:
        col_i = 0
        for tile in row:
            if tile == 'O':
                rightMost = col_i
            col_i += 1
        row_i += 1

    if rightMost == 0:
        return len(board[0])-1
    return rightMost

testBoard = {
"..",
".O"
}
print(findTop(testBoard))
assert(findRight(testBoard) == 1)
assert(findLeft(testBoard) == 1)
assert(findTop(testBoard) == 1)
assert(findBottom(testBoard) == 1)

testBoard = {
"OO",
".O"
}
assert(findRight(testBoard) == 1)
assert(findLeft(testBoard) == 0)
assert(findTop(testBoard) == 0)
assert(findBottom(testBoard) == 1)

testBoard = {
"...",
".O.",
"..."
}
assert(findRight(testBoard) == 1)
assert(findLeft(testBoard) == 1)
assert(findTop(testBoard) == 1)
assert(findBottom(testBoard) == 1)

testClass = XMarksTheSpot()
assert testClass.countArea({
"?.",
".O"
}) == 5
