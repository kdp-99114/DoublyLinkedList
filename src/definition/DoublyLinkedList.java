package definition;

import adt.ListADT;

public class DoublyLinkedList<E> implements ListADT<E> {
    @Override
    public boolean add(Object item) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int search(Object item) {
        return 0;
    }

    @Override
    public void sort() {

    }

    private static class Node<E> {
    }

}
