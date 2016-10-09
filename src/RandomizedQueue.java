import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wolf on 09/10/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] items;

    public RandomizedQueue() {
        this.size = 0;
        this.items = (Item[]) new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (size >= items.length) {
            doubleArray();
        }
        items[size++] = item;
    }

    private void validate() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    private void doubleArray() {
        Item[] newArray = (Item[]) new Object[items.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    private void halfArray() {
        Item[] newArray = (Item[]) new Object[items.length / 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    public Item dequeue() {
        validate();
        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[size--];
        if (items.length / 4 > size) {
            halfArray();
        }
        return item;
    }

    public Item sample() {
        validate();
        return items[StdRandom.uniform(size)];
    }

    private class MyIterator implements Iterator<Item> {
        private Item[] itemsToIterate;

        private int cursor;

        private MyIterator() {
            itemsToIterate = (Item[]) new Object[items.length];
            for (int i = 0; i < items.length; i++) {
                itemsToIterate[i] = items[i];
            }
            StdRandom.shuffle(itemsToIterate);
        }

        @Override
        public boolean hasNext() {
            return cursor < itemsToIterate.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return itemsToIterate[cursor++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new MyIterator();
    }
}
