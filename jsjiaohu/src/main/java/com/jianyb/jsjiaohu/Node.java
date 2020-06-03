package com.jianyb.jsjiaohu;

public class Node<T> {
    public Node<T> prev;
    public Node<T> next;
    public T data;

    public Node(Node<T> first, Node<T> last, T data) {
        this.prev = first;
        this.next = last;
        this.data = data;
    }

}
