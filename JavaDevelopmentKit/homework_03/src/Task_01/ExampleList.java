package Task_01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExampleList<E> implements Iterable<E>{

    private Object[] array;
    private int size;
    private Iterator<E> iterator;

    public ExampleList(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
        this.iterator = new MyListIterator();
    }

    public ExampleList() {
        this(null);
    }

    public void add(E element) {
        if (size == array.length) {
            Object[] newArr = new Object[array.length * 2];
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
        }
        array[size++] = element;
    }

    public void remove(int index) {
        if (size == 0) throw new NoSuchElementException();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        for (Object element :
                array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return (E) array[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return iterator;
    }
}