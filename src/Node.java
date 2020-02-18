/*
Olivia Ringhiser
2/10/2020
Node.java
This file contains constructors,
getters, and setters for the Nodes
*/

package greenriver.dev;

import java.util.Objects;

/**
 * helper Node class
 *
 * @author Olivia Ringhiser
 * @version 1.0
 */
public class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Getter method for Node's data
     *
     * @return Node's data
     */
    public int getData() {
        return this.data;
    }

    /**
     * Getter method for the current Node's next Node
     *
     * @return the next node
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * Setter method for next
     *
     * @param next setting next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns a boolean value of whether or not the current
     * Node has one following it
     *
     * @return true if has next, otherwise false
     */
    public boolean hasNext() {
        return this.getNext() != null;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        return getData() == node.getData() &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNext());
    }
}
