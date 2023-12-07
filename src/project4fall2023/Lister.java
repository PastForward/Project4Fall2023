package project4fall2023;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class Lister<E extends Comparable<E>> implements Iterator<E> 
{
    private Node<E> cursor;
    
    /**
     * Constructor initializes cursor to the beginning of a Linked List
     * @param head pointer to the first node in a Linked List
     */
    public Lister(Node<E> head)
    {
        cursor = head;
    }
    
    /**
     * hasNext method returns a true if cursor is not null, false otherwise
     * meaning does cursor point to a Node?
     * @return a boolean that indicates if cursor is pointing to a Node
     */
    @Override
    public boolean hasNext()
    {
        return cursor != null;
    }
    
    /**
     * next method returns data from the Node<E> and advances cursor
     * @return data from the Node<E>
     */
    @Override
    public E next()
    {
        E answer;
        
        if (!hasNext())
            throw new NoSuchElementException("The lister is empty");
        
        // get the data
        answer = cursor.getData();
        
        // advance cursor
        cursor = cursor.getNext();
        
        return answer;
    }
    
    /**
     * remove method is not implemented
     */
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Lister has no remove method");
    }
}
