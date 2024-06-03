package com.denisvlem.linked;


public class Node<T> {

    private T value;

    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T value() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> addNext(Node<T> next) {
        this.next = next;
        return next;
    }
}
