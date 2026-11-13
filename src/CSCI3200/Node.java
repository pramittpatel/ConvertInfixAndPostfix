package CSCI3200;

// Generic Node class for the reference-based stack
public class Node<T> {
    private T data;
    private Node<T> next;

    // constructor to initialize node with data
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // constructor to initialize node with data and next reference
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // gets the data stored in the node
    public T getData() {
        return data;
    }

    // sets the data stored in the node
    public void setData(T data) {
        this.data = data;
    }

    // gets the reference to the next node
    public Node<T> getNext() {
        return next;
    }

    // sets the reference to the next node
    public void setNext(Node<T> next) {
        this.next = next;
    }
}