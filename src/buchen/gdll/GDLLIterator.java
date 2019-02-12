/*
 * Interface for a Generic Doubly Linked List's iterator
 */
package buchen.gdll;

/**
 *
 * @author ayeletbuchen
 * @version 1
 * @since 7 November 2018
 * @param <T> generic data type
 */
public interface GDLLIterator<T extends Comparable<? super T>> {

    /**
     * Reset the current node to head
     */
    public void reset();
    
    /**
     * Check if there is a node that comes right after the current node
     * @return true or false - has next or does not have next
     */
    public boolean hasNext();
    
    /**
     * Check if there is a node previous to the current node
     * @return true or false - has previous or does not have previous
     */
    public boolean hasPrevious();

    /**
     * Move current to the next node on the list
     * @return T value of the current node 
     * (before current is changed to the next node)
     */
    public T next();

    /**
     * Move current to the previous node on the list
     * @return T value of the current node
     * (before current is changed to the previous node)
     */
    public T previous();

}
