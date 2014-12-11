/**
 * An implementation of a minimum heap with handles
 */

public class Heap {

    private HeapElt[] array;
    int heapsize;
    int arraysize;

    /*
     * The constructor has been set up with an initial array of size 4 so that
     * your doubleHeap() method will be tested. Don't change this!
     */
    public Heap() {
	array = new HeapElt[4];
	heapsize = 0;
	arraysize = 4;
    }

    /*
     * Exchanges that values at positions pos1 and pos2 in the heap array.
     * Handles must be exchanged correctly as well.
     * 
     * Running time = O(1)
     */
    private void exchange(int pos1, int pos2) {

	HeapElt temp = array[pos2];

	array[pos2] = array[pos1];
	array[pos2].setHandle(pos2);

	array[pos1] = temp;
	array[pos1].setHandle(pos1);

    }

    /*
     * Doubles the size of the array. A new array is created, the elements in
     * the heap are copied to the new array, and the array data member is set to
     * the new array. Data member arraysize is set to the size of the new array.
     * 
     * Running time = O(n)
     */
    private void doubleHeap() {
	System.out.println("Doubling size");
	HeapElt[] newArray = new HeapElt[2 * array.length];

	for (int i = 0; i < array.length; i++)
	    newArray[i] = array[i];

	arraysize = newArray.length;
	array = newArray;
    }

    /*
     * Fixes the heap if the value at position pos may be smaller than its
     * parent. Using exchange() to swap elements will simplify your
     * implementation. Heap elements contain records that are Comparable; you
     * will need to figure out what to test and how to test it.
     * 
     * Running time = O(lg n)
     */
    @SuppressWarnings("unchecked")
    public void heapifyUp(int pos) {

	while (pos > 1
		&& array[parent(pos)].getRecord().compareTo(
			array[pos].getRecord()) > 0) {
	    exchange(parent(pos), pos);
	    pos = parent(pos);
	}

    }

    /*
     * Fixes the heap if the value at position pos may be bigger than one of its
     * children. Using exchange() to swap elements will simplify your
     * implementation. Heap elements contain records that are Comparable; you
     * will need to figure out what to test and how to test it.
     * 
     * Running time = O(lg n)
     */
    @SuppressWarnings("unchecked")
    public void heapifyDown(int pos) {
	int leftChildPos = 2 * pos;
	int rightChildPos = 2 * pos + 1;
	int smallestPos = pos;

	if (leftChildPos <= heapsize
		&& array[leftChildPos].getRecord().compareTo(
			array[pos].getRecord()) < 0)
	    smallestPos = leftChildPos;

	if (rightChildPos <= heapsize
		&& array[rightChildPos].getRecord().compareTo(
			array[smallestPos].getRecord()) < 0)
	    smallestPos = rightChildPos;

	if (smallestPos != pos) {
	    exchange(pos, smallestPos);
	    heapifyDown(smallestPos);
	}
    }

    /*
     * Insert inElt into the heap. Before doing so, make sure that there is an
     * open spot in the array for doing so. If you need more space, call
     * doubleHeap() before doing the insertion.
     * 
     * Running time = O(lg n), if no call to doubleHeap(). O(n lg n), if call to
     * doubleHeap()
     * 
     * (NOTE that there are a couple of different cases here!)
     */
    public void insert(HeapElt inElt) {
	if (heapsize >= arraysize - 1)
	    doubleHeap();

	heapsize++;
	array[heapsize] = inElt;
	array[heapsize].setHandle(heapsize);
	heapifyUp(heapsize);
    }

    /*
     * Remove the minimum element from the heap and return it. Restore the heap
     * to heap order. Assumes heap is not empty, and will cause an exception if
     * the heap is empty.
     * 
     * Running time = O(lg n)
     */
    public HeapElt removeMin() throws Exception {
	// WARNING: Will fail with empty heap!
	if (heapsize == 0)
	    throw new Exception("Cannot remove from empty heap");

	exchange(1, heapsize);
	heapsize--;
	heapifyDown(1);

	return array[heapsize + 1];
    }

    /*
     * Return the number of elements in the heap.
     * 
     * Running time = O(1)
     */
    public int getHeapsize() {

	return heapsize;

    }

    /*
     * Print out the heap for debugging purposes. It is recommended to print
     * both the key from the record and the handle.
     * 
     * Running time = O(n)
     */
    public void printHeap() {

	for (int i = 1; i < heapsize; i++) {
	    String out = i + ": key- " + array[i].getHandle() + " |  value- "
		    + array[i].getRecord();
	    System.out.println(out);
	}

    }

    /**
     * Finds the index of an element's parent.
     * 
     * Running time = O(1)
     * 
     * @param pos
     *            the position of the child
     * @return the position of the parent
     */
    private int parent(int pos) {
	return pos / 2;
    }
}