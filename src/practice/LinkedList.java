package practice;

import java.util.NoSuchElementException;

public class LinkedList {
    public static void main(String[] args) {
        var list = new LinkedList();

        list.addFirst(5);
        list.addLast(8);
        list.addLast(12);
        list.addLast(13);
        list.addLast(17);

        System.out.println(list);
        int item = 15;
        list.insertInSortedList(item);
        System.out.println(list);
    }

    private Node head;
    private Node tail;

    private void addFirst(int item) {
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

    private void addLast(int item) {
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

    @Override
    public String toString() {
        String result =  "{}";
        if (!isEmpty()) { // multiple nodes available, let's iterate
            StringBuilder builder = new StringBuilder();

            builder.append("{");
            String joiner = "";
            var current = head;

            while (current != null){
                builder.append(joiner);
                builder.append(current.value);
                joiner = ", ";
                current = current.next;
            }
            builder.append("}");
            result = builder.toString();
        }
        return result;
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

    private int length() {
        int len = 0;

        Node current = head;
        while (current != null){
            len++;
            current = current.next;
        }

        return len;
    }

    private void insertInSortedList(int item){
        if (head == null)
            addFirst(item);
        else if (head == tail) {
            if (item >= head.value)
                addLast(item);
            else
                addFirst(item);
        } else {
            var current = head;

            while (current != null){
                if (current == tail) {
                    addLast(item);
                    return;
                }
                else if (current.next.value >= item){
                    var newNode = new Node(item);
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
                current = current.next;
            }
        }
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
