package heap;

/**
 * A generic class for heap elements that include handles
 */

public class HeapElt {

    @SuppressWarnings("rawtypes")
    protected Comparable record;

    protected int handle = 0;

    public void setRecord(@SuppressWarnings("rawtypes") Comparable inRec) {
	record = inRec;
    }

    @SuppressWarnings("rawtypes")
    public Comparable getRecord() {
	return record;
    }

    public void setHandle(int inHandle) {
	handle = inHandle;
    }

    public int getHandle() {
	return handle;
    }

}