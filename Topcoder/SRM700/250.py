
class Xylophone:
    def countKeys(self, keys):
        noteset = set()
        for key in keys:
            note = key % 7
            noteset.add(note)
        return len(noteset)

testClass = Xylophone()
#print(testClass.countKeys({1,8,3}))
assert testClass.countKeys({7,3,2,4,1,5,6}) == 7
assert testClass.countKeys({1,8,15}) == 1
assert testClass.countKeys({11,11,11,11,11,11,11,11,11,11,11}) == 1
assert testClass.countKeys({50,10,20,30,11,30,24,38,5,2,9}) == 6

