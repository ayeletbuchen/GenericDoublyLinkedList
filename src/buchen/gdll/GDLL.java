/*
 * Generic Doubly Linked List
 */
package buchen.gdll;

/**
 *
 * @author ayeletbuchen
 * @version 1
 * @since 7 November 2018
 * @param <T>
 */
public class GDLL<T extends Comparable<? super T>> implements DLLInterface<T> {

    //<editor-fold defaultstate="collapsed" desc="Node">
    private class Node<T extends Comparable<? super T>> {

        private T value;
        private Node next, prev;

        public Node(T val)
        {
            value = val;
        }

        public void setValue(T val)
        {
            value = val;
        }

        public T getValue()
        {
            return value;
        }

        public void setNext(Node nxt)
        {
            next = nxt;
        }

        public Node getNext()
        {
            return next;
        }

        public void setPrevious(Node pre)
        {
            prev = pre;
        }

        public Node getPrevious()
        {
            return prev;
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Iterator">
    private class Iterator<T extends Comparable<? super T>> implements GDLLIterator<T> {

        private Node tracker;

        public Iterator()
        {
            tracker = head;
        }

        @Override
        public boolean hasNext()
        {
            checkTracker();
            boolean result = false;
            if (tracker != null)
            {
                result = tracker.next != null;
            }
            return result;
        }

        @Override
        public boolean hasPrevious()
        {
            checkTracker();
            boolean result = false;
            if (tracker != null)
            {
                result = tracker.prev != null;
            }
            return result;
        }

        @Override
        public T next()
        {
            checkTracker();
            T retval = null;
            if (tracker != null)
            {
                retval = (T) tracker.value;
                if (tracker.next != null)
                {
                    tracker = tracker.next;
                }
            }
            return retval;
        }

        @Override
        public T previous()
        {
            checkTracker();
            T retval = null;
            if (tracker != null)
            {
                retval = (T) tracker.value;
                if (tracker.prev != null)
                {
                    tracker = tracker.prev;
                }
            }
            return retval;
        }

        @Override
        public void reset()
        {
            tracker = head;
        }

        /**
         * Check if tracker points to a node that was removed from the list. If
         * it does, change tracker to the previous node. If tracker points to a
         * node that used to be the head and has since been removed, change
         * tracker to the new head.
         */
        private void checkTracker()
        {
            if (tracker != null)
            {
                if (head == null || (tracker.prev == null && tracker != head))
                {
                    reset();
                }
                else if (tracker.prev != null && tracker.prev.next != tracker)
                {
                    tracker = tracker.prev;
                }
            }
        }
    }
    //</editor-fold>

    private int size;
    private Node head;
    private Node tail;
    private Node curr;

    public GDLL()
    {
        size = 0;
        head = null;
        tail = null;
        curr = null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void insert(T val)
    {
        if (head == null)
        {
            initializeList(val);
        }
        else
        {
            insertTail(val);
        }
        ++size;
    }

    @Override
    public boolean insert(int ord, T val)
    {
        boolean inserted = false;
        if (ord <= size && ord >= 0)
        {
            if (size == 0)
            {
                initializeList(val);
            }
            else if (ord == size)
            {
                insertTail(val);
            }
            else
            {
                curr = findByOrd(ord);
                insertNode(val);
            }
            inserted = true;
            ++size;
        }
        return inserted;
    }

    @Override
    public boolean removeVal(T val)
    {
        boolean removed = false;

        if (size > 0 && contains(val))
        {
            if (size == 1)
            {
                deleteList();
            }

            else
            {
                curr = head;
                while (curr.value.compareTo(val) != 0)
                {
                    curr = curr.next;
                }
                removeNode();
            }
            removed = true;
            --size;
        }
        return removed;
    }

    @Override
    public T removeOrd(int ord)
    {
        T retval = null;
        if (ord < size && ord >= 0)
        {
            if (size == 1)
            {
                retval = (T) head.value;
                deleteList();
            }
            else
            {
                curr = findByOrd(ord);
                retval = (T) curr.value;
                removeNode();
            }
            --size;
        }
        return retval;
    }

    @Override
    public T get(int ord)
    {
        T retval = null;
        if (ord < size && ord >= 0)
        {
            curr = findByOrd(ord);
            retval = (T) curr.value;
        }

        return retval;
    }

    @Override
    public boolean set(int ord, T val)
    {
        boolean set = false;
        if (ord < size && ord >= 0)
        {
            curr = findByOrd(ord);
            curr.value = val;
            set = true;
        }
        return set;
    }

    @Override
    public boolean contains(T val)
    {
        boolean found = false;
        curr = head;

        while (curr != null && !found)
        {
            if (curr.value.compareTo(val) == 0)
            {
                found = true;
            }
            else
            {
                curr = curr.next;
            }
        }
        return found;
    }

    @Override
    public boolean isEmpty()
    {
        boolean empty = false;
        if (size == 0)
        {
            empty = true;
        }
        return empty;
    }

    @Override
    public GDLLIterator<T> iterator()
    {
        return new Iterator();
    }

    private Node findByOrd(int ord)
    {
        curr = head;

        for (int ix = 0; ix < ord; ++ix)
        {
            curr = curr.next;
        }

        return curr;
    }

    private void initializeList(T val)
    {
        Node node = new Node(val);
        head = node;
        head.next = null;
        head.prev = null;
        tail = node;
        curr = node;
    }

    private void insertNode(T val)
    {
        Node node = new Node(val);
        node.next = curr;
        node.prev = curr.prev;
        if (curr != head)
        {
            curr.prev.next = node;
        }
        curr.prev = node;

        if (curr == head)
        {
            head = node;
        }
    }

    private void insertTail(T val)
    {
        Node node = new Node(val);
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    private void deleteList()
    {
        head.prev = null;
        head.next = null;
        head = null;
        tail = null;
    }

    private void removeNode()
    {
        if (curr == head)
        {
            removeHead();
        }
        else if (curr == tail)
        {
            removeTail();
        }
        else
        {
            removeMiddleNode();
        }
    }

    private void removeHead()
    {
        head = curr.next;
        curr.next = null;
        curr = head;
        head.prev = null;
    }

    private void removeTail()
    {
        tail = curr.prev;
        curr.prev.next = null;
        tail.next = null;
    }

    private void removeMiddleNode()
    {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}
