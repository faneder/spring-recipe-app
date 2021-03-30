package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

// Generic means parameterized types. The idea is to allow type (Integer, String, ..etc and user-defined types) to be a parameter to methods, classes, ad interfaces.
// Using Generic to create classes that work with different types

public class SinglyLinkedList<E> {

    // nested Node class
    // it doesn't matter to us what type for elements are stored in the list, we use Java's generics framework
    // to define our class with a formal type parameter E that represents the user's desired element type
    private static class Node<E> {

        private final E element; // reference to the element stored at the node

        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }



    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() {}

    public int getSize() {
        return size;
    }

    public E getFirst() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update method
    public void addFirst(E element) {
        head = new Node<>(element, null);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newest = new Node<>(element, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;

        E answer = head.getElement();
        head = head.getNext();
        if (size == 0) tail = null;

        return answer;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
