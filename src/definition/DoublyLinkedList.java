package definition;

import adt.ListADT;

public class DoublyLinkedList<E> implements ListADT<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    private boolean addFirst(E item) {
        Node<E> node = new Node<E>(item, head, tail);
        head = node;
        tail = node;
        size++;
        return true;
    }

    private boolean addAfter(Node<E> node, E item) {
        Node<E> newNode = null;
        if (node.next == null) {
            newNode = new Node<>(item, node, tail);
            node.next = newNode;
            tail = newNode;
        } else {
            newNode = new Node<>(item, node, node.getNext());
            node.next = newNode;
        }
        size++;
        return true;
    }

    public boolean add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }

    @Override
    public boolean add(E item) {
        return add(size, item);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int search(E item) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        Node<E> temp = head;
        for (int i = 0; i < size && temp != null; i++) {
            E data = temp.getData();
            sb.append(data);
            sb.append((i < size - 1) ? "," : "");
            temp = temp.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }
    }

}
