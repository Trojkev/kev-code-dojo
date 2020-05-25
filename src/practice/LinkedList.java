package practice;

import java.util.NoSuchElementException;

class LinkedList {
    private class Node {
        int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    void addFirst(int item) {
        if (head == null)
            head = tail = new Node(item);
        else {
            var first = new Node(item);
            first.next = head;
            head = first;
        }
    }

    void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        var second = head.next;
        head.next = null;
        head = second;
    }

    void addLast(int item) {
        if (head == null) // List contains no nodes
            head = tail = new Node(item);
        else { // we create a new node, set tail to point to it, and set it as tail
            var last = new Node(item);
            tail.next = last;
            tail = last;
        }
    }

    void removeLast() {
        if (isEmpty()) // there is no nodes available
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }

        var current = head;
        while (current != null) {
            if (current.next == tail) {// last node (tail)
                current.next = null;
                tail = current; // update the current node to be the tail and exit
                break;
            }
            current = current.next; // move to the next node
        }
    }

    void deleteNode(int val){
        if (isEmpty()) // there are no available nodes
            throw new NoSuchElementException();

        if (head.value == val) { // remove head,.. if head is the sam as tail, remove both
            if (head == tail)
                head = tail = null;
            else
                head = head.next;
        } else { // iterate the linked list and remove the first node that matches the value
            Node node = head;
            while (node.next != null){

                if (node.next.value == val){
                    if (node.next == tail){
                        node.next = null;
                        tail = node;
                        break;
                    }
                    node.next = node.next.next;
                }
                else
                    node = node.next;
            }
        }
    }

    void print() {
        if (!isEmpty()) { // multiple nodes available, let's iterate
            var current = head;
            do {
                System.out.println(current.value);
                current = current.next;
            }
            while (current != null);
        }
    }

    private int indexOf(int item) {
        var current = head;
        int index = 0;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private boolean isEmpty() {
        return head == null;
    }
}
