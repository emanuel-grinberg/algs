package coursera.homework2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wolf on 08/10/16.
 */

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Node previous, next;
        private Item item;
    }

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    private void validateItem(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private void validateItem() {
        if (size == 0) throw new NoSuchElementException();
    }

    public void addLast(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        validateItem();
        Item itemToReturtn = first.item;
        if (size > 1) {
            first = first.next;
            first.previous = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return itemToReturtn;
    }

    public Item removeLast() {
        validateItem();
        Item itemToReturtn = last.item;
        if (size > 1) {
            last = last.previous;
            last.next = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return itemToReturtn;
    }

    private class MyIterator implements Iterator<Item> {
        private Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item itemToReturn = cursor.item;
            cursor = cursor.next;
            return itemToReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    public static void main(String[] args) {
        Deque<String> items = new Deque<>();
        items.addFirst("1");
        items.removeLast();
        items.addFirst("2");
        items.removeFirst();
        items.addFirst("3");
        items.addLast("4");
        items.addLast("5");
        items.addLast("6");
        items.removeFirst();
        items.removeLast();
        items.removeFirst();
        items.removeLast();
        items.addFirst(null);

        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}