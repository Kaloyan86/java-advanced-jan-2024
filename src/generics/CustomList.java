package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import workshop.DoublyLinkedList;

public class CustomList<T extends Comparable<T>> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    //  void add(T element)
    public void add(T element) {
        this.data.add(element);
    }

    //	T remove(int index)
    public T remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    //	boolean contains(T element)
    public boolean contains(T element) {
        return this.data.contains(element);
    }

    //	void swap(int index, int index)
    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    //	int countGreaterThan(T element)
    public int countGreaterThan(T element) {
        int count = 0;

        for (T el : this.data) {
            int res = el.compareTo(element);

            if (res > 0) {
                count++;
            }
        }

        return count;
    }

    //	T getMax()
    public T getMax() {
        checkEmpty();
        return Collections.max(this.data);
    }

    //	T getMin()
    public T getMin() {
        checkEmpty();
        return Collections.min(this.data);
    }

    public T get(int index) {
        checkIndex(index);
        return this.data.get(index);
    }

    public int size() {
        return this.data.size();
    }

    public void forEach(Consumer<T> consumer) {

        this.data.forEach(consumer::accept);
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException(
            String.format("Index %d is out of bounds for size %d", index, this.data.size()));
        }
    }
}
