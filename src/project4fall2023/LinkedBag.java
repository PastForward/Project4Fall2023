package project2fall2023;

/**
 *  The LinkedBag Class
 * @author Aron Kabai-Tokes
 * @param <E>
 */
public class LinkedBag<E extends Comparable<E>> {
    private Node<E> head;
    private Node<E> tail;
    private int numElements;
    
    /**
    * Constructs an empty SinglyLinkedList with head and tail initialized to 
    * null and sets the number of elements to 0.
    */
    public LinkedBag() {
        this.head = null;
        this.tail = null;
        numElements = 0;
    }
    
    /**
    * Returns the number of elements in the data structure.
    *
    * @return the number of elements in the data structure
    */
    public int getSize() {
        return this.numElements;
    }
    
    /**
     * adds an element to the list, maintaining order
     * @param newElement    the element to append
     */
    public void add(E newElement) {
        Node<E> cursor = head;
        Node<E> previous = head;
        boolean found = false;
        
        if (tail == null) {
            head = new Node<>(newElement, null);
            tail = head;
        } else {
            while (cursor != null && !found) { 
                if (cursor.getData().compareTo(newElement) < 0) {
                    previous = cursor;
                    cursor = cursor.getNext();
                } else {
                    found = true;
                    break;
                }
            }
            
            if (found) {
                // if the cursor is the head, ensure the head is replaced properly
                if (cursor == head) {
//                    Node<E> newNode = new Node<E>(newElement, head);
                    head = new Node<>(newElement, head);
                } else {
                    // set the previous link to the one after
                    previous.setNext(new Node<> (newElement, cursor));
                }
                
            
                // if it wasn't found, its most likely last,
                // so set it as the tail
            } else {
                tail.setNext(new Node<> (newElement, null));
                tail = tail.getNext();
            }
        }
        numElements++;
    }
    
    /**
     * finds if the data matches any node
     * @param target    the target data to match against
     * @return          true if it has been found, false otherwise
     */
    public boolean exists(E target) {
        Node<E> cursor = head;
        
        while(cursor != null) {
            if (cursor.getData().equals(target))
                return true;
            cursor = cursor.getNext();
        }
        
        return false;
    }
    
    /**
     * Counts the number of times a target data is found within the list
     * @param target    the data match against
     * @return          the number of times the target data was found
     */
    public int countOccurences(E target) {
        Node<E> cursor = head;
        int count = 0;
        
        while(cursor != null) {
            if (cursor.getData().equals(target)) {
                count++;
            }
            cursor = cursor.getNext();
            
        }
        return count;
    }
    
    /**
     * Removes a node if it matches the target. Will only remove the first
     * node that matches the target
     * @param target    the target data to match against
     * @return          true if item was removed, false otherwise
     */
    public boolean remove(E target) {
        Node<E> cursor = head;
        Node<E> previous = head;
        
        
        if (head.getData().equals(target)) {
            // if there is only one item in the list, set tail to null as well
            if (tail.equals(head))
                tail = null;
            head = head.getNext();
            
            numElements--;
            return true;
        }
        
        while(cursor != null) {
            // found the target to remove
            if (cursor.getData().equals(target)) {
                previous.setNext(cursor.getNext());
                numElements--;
                return true;
            }
            previous = cursor;
            cursor = cursor.getNext();
        }
        
        return false;
    }
    
/**
* the iteratorPrototype method "copies" the linked list and passes the
* copied linked list to a new Lister<E>
*
* @return a Lister<E> using a copy of the linked list
*/
    // This shouldn't need to be here.
    // TODO: FIX THIS!!!
    @SuppressWarnings("unchecked")
    public Lister<E> iterator() {
        // declare variables
        Node headOfListToReturn; // beginning of new "copied" list
        Node cursorOfListToCopy; // active node of list to copy
        Node lastNodeOfListToReturn; // end of new "copied" list
        // establish the copied list
        headOfListToReturn = null;
        if (head != null) {
            // create the head of the new list
            headOfListToReturn = new Node(head.getData(), null);
            // use lastNodeOfListToReturn as a pointer to the last node in the copied list
            lastNodeOfListToReturn = headOfListToReturn;
            // use currentCursor as the pointer to the existing list
            cursorOfListToCopy = head.getNext();
            // if we have a node...
            while (cursorOfListToCopy != null) {
                // create a new node from the end of the new list
                lastNodeOfListToReturn.setNext(new
                Node(cursorOfListToCopy.getData(), null));
                // move lastNodeOfListToReturn to the new last node
                lastNodeOfListToReturn = lastNodeOfListToReturn.getNext();
                // move the cursorOfListToCopy to the next node
                cursorOfListToCopy = cursorOfListToCopy.getNext();
            }
        }
    return new Lister(headOfListToReturn);
    }
}
