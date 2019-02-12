package buchen.gdll;


/**
 * 
 * @param <T> generic data type
 */
public interface DLLInterface<T extends Comparable <? super T>> 
{
    /**
     * @return int size of the list 
     */
    public int size();
    
    /**
     * insert a node with T Value val
     * @param val:  T - value to insert
     */
    public void insert(T val);
    
    /**
     * insert a node with T value val in position ord
     * @param ord
     * @param val
     * @return boolean - success or failure (if ord makes no sense)
     */
    public boolean insert(int ord, T val);
    
    /**
     * remove the node with T value val
     * @param val T value of the node to remove
     * @return boolean - success or failure (if no such value in the list)
     */
    public boolean removeVal(T val);
    
    /**
     * remove node in position ord
     * @param ord: int - position of the node to be removed
     * @return value of the node in position ord (null if no such position)
     */
    public T removeOrd(int ord);
    
    /**
     * return the value of the node in position ord
     * @param ord: int - ordinal position of the node whose value is returned
     * @return value of the node in position ord (null if no such position)
     */
    public T get(int ord);
    
    /**
     * set the value of the node in position ord to T value val
     * @param ord - position of the node to modify
     * @param val - T value used to replace the current value of node ord
     * @return boolean success or failure (no such position)
     */
    public boolean set(int ord, T val);
    
    /**
     * ascertain whether the list contains T value val
     * @param val T value to check
     * @return boolean yes or no
     */
    public boolean contains(T val);
    
    /**
     * ascertain whether the list is empty or not
     * @return boolean yes or no
     */
    public boolean isEmpty();
    
    /**
     * @return an iterator of the list
     */
    public GDLLIterator<T> iterator();
}
