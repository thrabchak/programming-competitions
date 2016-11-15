class TestTaking(object):
    def findMax(self, a, b, c):
        totalQuestions = a

        falseResponses = a-b
        trueResponses = b

        actuallyTrue = c
        actuallyFalse = a-c

        return min(actuallyTrue, trueResponses) + min(actuallyFalse, falseResponses)

testTaking = TestTaking()

#print(testTaking.findMax(3, 1, 2) )

assert testTaking.findMax(3, 1, 2) == 2        
assert testTaking.findMax(3, 2, 1) == 2
assert testTaking.findMax(5, 5, 0) == 0
assert testTaking.findMax(10, 8, 8) == 10
assert testTaking.findMax(7, 0, 2) == 5

        
