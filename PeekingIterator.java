import java.util.Iterator;

/*
 * TC: O(1) for peek, next, hasNext
 * SC: O(1)
 */
public class PeekingIterator implements Iterator<Integer> {

    // keeps track of the next element peeked
    Integer top;

    // underlying iterator
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        top = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        // if there is already a peeked element, 
        // keep returning that
        if(top != null) {
            return top;
        }
        // else get the next element, store it 
        // and return
        top = iterator.next();
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        // if there is a peeked element,
        // set it to null and return that
        if(top != null) {
            Integer temp = top;
            top = null;
            return temp;
        }
        // else just return the next element
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        // if there is a peeked element,
        // return true
        if(top != null) {
            return true;
        }
        // else call underlying hasNext
        return iterator.hasNext();
    }
}