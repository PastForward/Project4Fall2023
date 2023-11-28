package project4fall2023;

/**
 *
 * @author Aron Kabai-Tokes
 */

/**
 * Node class that is placed within the SinglyLinkedList
 * @author Aron Kabai-Tokes
 * @param <E>   the element data
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    
    /**
     * creates a node object with data and the next node
     * @param initialData       the data to be assigned to the node
     * @param initialNext       the next linked node to be assigned to this node
     */
    public Node(E initialData, Node<E> initialNext) {
        this.data = initialData;
        this.next = initialNext;
    }
    
    /**
     * returns the data of this node
     * @return      the data
     */
    public E getData() {
        return this.data;
    }
    
    /**
     * Sets the data in this node to new data
     * @param newData       the new data to assign this node
     */
    public void setData(E newData) {
        this.data = newData;
    }
    
    /**
     * returns this node's next linked node
     * @return      the next linked node
     */
    public Node<E> getNext() {
        return this.next;
    }
    
    /**
     * changes this node's next linked node
     * @param newNext       the new node to link to
     */
    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }
}
